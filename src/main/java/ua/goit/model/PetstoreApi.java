package ua.goit.model;

import lombok.Getter;

@Getter
public class PetstoreApi {
    private static final String URL = "https://petstore.swagger.io/";
    private static final String PET_END_POINT = "/pet";
    private static final String STORE_END_POINT = "/store";
    private static final String USER_END_POINT = "/user";
}
