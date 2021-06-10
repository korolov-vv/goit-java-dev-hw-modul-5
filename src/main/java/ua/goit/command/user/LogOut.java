package ua.goit.command.user;

import ua.goit.client.HttpClientUtil;
import ua.goit.command.Command;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class LogOut implements Command {
    HttpClient httpClient;
    HttpClientUtil httpClientUtil;

    public LogOut() {
        httpClient = HttpClient.newBuilder().build();
        httpClientUtil = new HttpClientUtil();
    }

    @Override
    public void process() {
        logOut();
    }

    @Override
    public String commandName() {
        return "user -logout";
    }

    public void logOut() {
        try {
            HttpResponse<String> responseOfGet = httpClient.send(httpClientUtil.prepareLogOutRequest(),
                    HttpResponse.BodyHandlers.ofString());
            if(responseOfGet.statusCode() == 200) {
                System.out.println(responseOfGet.body());
            }else{
                System.out.println(responseOfGet.statusCode() + responseOfGet.body());
            }
        }catch (IOException | InterruptedException io){
            io.printStackTrace();
        }
    }
}
