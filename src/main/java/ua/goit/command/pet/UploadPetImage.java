package ua.goit.command.pet;

import ua.goit.client.HttpClientUtil;
import ua.goit.client.PetstoreHttpClient;
import ua.goit.command.Command;
import ua.goit.view.View;

import java.io.*;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class UploadPetImage implements Command {
    View view;
    HttpClient httpClient;
    HttpClientUtil httpClientUtil;

    public UploadPetImage(View view) {
        this.view = view;
        httpClient = HttpClient.newBuilder().build();
        httpClientUtil = new HttpClientUtil();
    }

    @Override
    public void process() throws FileNotFoundException {
        view.write("Enter id of pet, which should be updated");
        String id = view.read();
        view.write("Enter tag:");
        String tag = view.read();
        view.write("Enter image path:");
        String imagePath = view.read();
        FileReader fr = new FileReader(imagePath);
        File f = new File(imagePath);
        uploadImage(id, tag, f);
    }

    @Override
    public String commandName() {
        return "pet -img-upload";
    }

    public void uploadImage(String id, String additionalData, File imagePath) {
        String endpoint = PetstoreHttpClient.getPetEndPoint();
        HttpResponse<String> responseOfCreate = null;
        try {
            responseOfCreate = httpClient.send(httpClientUtil.prepareUploadAnImageForPet(
                endpoint + "/" + id + "/uploadImage",
                additionalData,
                imagePath
                ),
                HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        if (responseOfCreate.statusCode() == 200) {
            System.out.println("The Pet " + id + " was successfully updated \n" + responseOfCreate.body());
        } else {
            System.out.println(responseOfCreate.statusCode() + responseOfCreate.body());
        }
    }
}
