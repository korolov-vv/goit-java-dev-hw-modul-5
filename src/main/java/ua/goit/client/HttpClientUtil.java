package ua.goit.client;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;

public class HttpClientUtil<T> {
    Gson gson = new Gson();
    public HttpRequest prepareCreateRequest(T entity, String endpoint) {
        return HttpRequest.newBuilder()
                .header("Content-type", "application/json; charset=UTF-8")
                .uri(URI.create(PetstoreHttpClient.getURL() + endpoint))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(entity)))
                .build();
    }

    public HttpRequest prepareGetRequest(String endpoint, String parametr) {
        return HttpRequest.newBuilder()
                .uri(URI.create(PetstoreHttpClient.getURL() + endpoint + "/" + parametr))
                .GET()
                .build();
    }

    public HttpRequest prepareUpdateRequest(String endpoint, String parametr, T entity) {
        return HttpRequest.newBuilder()
                .header("Content-type", "application/json; charset=UTF-8")
                .uri(URI.create(PetstoreHttpClient.getURL() + endpoint + "/" + parametr))
                .method("PUT", HttpRequest.BodyPublishers.ofString(gson.toJson(entity)))
                .build();
    }

    public HttpRequest prepareDeleteRequest(String endpoint, String parametr) {
        return HttpRequest.newBuilder()
                .header("Content-type", "application/json")
                .uri(URI.create(PetstoreHttpClient.getURL() + endpoint +parametr))
                .DELETE()
                .build();
    }

    public HttpRequest prepareCreateUserWithArrayRequest(List<T> entities, String endpoint) {
        return HttpRequest.newBuilder()
                .header("Content-type", "application/json; charset=UTF-8")
                .uri(URI.create(PetstoreHttpClient.getURL() + endpoint))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(entities)))
                .build();
    }

    public HttpRequest prepareLoginUserRequest(String login, String password) {
        return HttpRequest.newBuilder()
                .header("Content-type", "application/json; charset=UTF-8")
                .uri(URI.create(PetstoreHttpClient.getURL() + PetstoreHttpClient.getUserEndPoint() +
                        "/login?username=" + "&password=" + password))
                .GET()
                .build();
    }

    public HttpRequest prepareLogOutRequest() {
        return HttpRequest.newBuilder()
                .header("Content-type", "application/json; charset=UTF-8")
                .uri(URI.create(PetstoreHttpClient.getURL() + PetstoreHttpClient.getUserEndPoint() + "/logout"))
                .GET()
                .build();
    }
}
