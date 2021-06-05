package ua.goit.model.util;

import java.net.http.HttpRequest;

public interface Api {
    HttpRequest prepareCreateRequest();
    HttpRequest prepareGetRequest();
    HttpRequest prepareDeleteRequest();

}
