package ua.goit.model.util;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    public File uploadFile(String filePath) {
        File fileToUpload = new File(filePath);
        File uploadedFile = new File("src/main/resources/" + fileToUpload.getName());
        System.out.println("LOG: the file " + uploadedFile.getPath() + " is created");
        try(FileInputStream fileInputStream = new FileInputStream(fileToUpload);
            FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile)) {
            byte[] buffer = new byte[fileInputStream.available()];
            for (int i = 0; i < buffer.length; i++) {
                fileOutputStream.write(buffer, 0, buffer.length);
            }
            System.out.println("LOG: the file is uploaded" + new Gson().toJson(uploadedFile));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return uploadedFile;
    }
}
