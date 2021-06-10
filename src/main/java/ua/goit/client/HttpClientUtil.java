package ua.goit.client;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public HttpRequest prepareUpdateWithData(String endpoint, String parametr, T entity) {
        return HttpRequest.newBuilder()
                .header("Content-type", "application/json; charset=UTF-8")
                .uri(URI.create(PetstoreHttpClient.getURL() + endpoint + "/" + parametr))
                .method("PUT", HttpRequest.BodyPublishers.ofString(gson.toJson(entity)))
                .build();
    }

    public HttpRequest prepareDeleteRequest(String endpoint, String parameter) {
        return HttpRequest.newBuilder()
                .header("Content-type", "application/json")
                .uri(URI.create(PetstoreHttpClient.getURL() + endpoint + "/" + parameter))
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

    public HttpRequest prepareUpdateWithData(String endpoint, String id, String newName, String updatedStatus) {
        return HttpRequest.newBuilder()
                .header("Content-type", "application/x-www-form-urlencoded")
                .uri(URI.create(PetstoreHttpClient.getURL() + endpoint + "/" + id))
                .POST(HttpRequest.BodyPublishers.ofString("name=" + newName + "&status=" + updatedStatus))
                .build();
    }

    public HttpRequest prepareUploadAnImageForPet(String endpoint, String additionalMetaData, String filePath) {
        String newFilePath = Arrays.stream(filePath.split(""))
                .peek((c) -> {
                    if(c.equals("\\")) {
                        c.replace('\\', '/');
                    }
                })
                .collect(Collectors.joining());
        String[] st = newFilePath.split("/");
        String fileName = Arrays.asList(st).get(st.length - 1);
        return HttpRequest.newBuilder()
                .header("Content-type", "multipart/form-data")
                .uri(URI.create(PetstoreHttpClient.getURL() + endpoint))
                .POST(HttpRequest.BodyPublishers.ofString("additionalMetadata=" + additionalMetaData))
                .POST(HttpRequest.BodyPublishers.ofString(
                        "file=@" + fileName + ";type=image/png"))
                .build();
    }
}
