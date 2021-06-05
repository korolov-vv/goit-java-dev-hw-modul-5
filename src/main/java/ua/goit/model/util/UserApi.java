package ua.goit.model.util;

import com.google.gson.Gson;
import ua.goit.model.PetstoreApi;
import ua.goit.model.entity.User;

import java.net.URI;
import java.net.http.HttpRequest;

public class UserApi{
    Gson gson = new Gson();
    public HttpRequest prepareCreateRequest(User user) {
        return HttpRequest.newBuilder()
                .header("Content-type", "application/json; charset=UTF-8")
                .uri(URI.create(PetstoreApi.getURL() + PetstoreApi.getUserEndPoint()))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(user)))
                .build();
    }

    public HttpRequest prepareGetRequest() {
        return null;
    }

    public HttpRequest prepareDeleteRequest() {
        return null;
    }
}
