package ua.goit.command;

import ua.goit.model.entity.User;
import ua.goit.model.util.UserApi;
import ua.goit.view.View;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class CreateUser implements Command{
    View view;
    HttpClient httpClient;
    UserApi userApi;

    public CreateUser(View view) {
        this.view = view;
        httpClient = HttpClient.newBuilder().build();
        userApi = new UserApi();
    }

    @Override
    public void process() {
        User user = new User();
        view.write("Please enter the username");
        user.setUserName(view.read());
        view.write("Please enter the first name");
        user.setFirstName(view.read());
        view.write("Please enter the last name");
        user.setLastName(view.read());
        view.write("Please enter the email");
        user.setEmail(view.read());
        view.write("Please enter the password");
        user.setPassword(view.read());
        view.write("Please enter the phone number");
        user.setPassword(view.read());

        try {
            HttpResponse<String> responseOfCreate = httpClient.send(userApi.prepareCreateRequest(user),
                    HttpResponse.BodyHandlers.ofString());
            if(responseOfCreate.statusCode() == 200) {
                System.out.println("The User was created successful");
            }else{
                System.out.println(responseOfCreate.statusCode() + responseOfCreate.body());
            }
        }catch (IOException | InterruptedException io){
            io.printStackTrace();
        }
    }

    @Override
    public String commandName() {
        return "user -create";
    }
}
