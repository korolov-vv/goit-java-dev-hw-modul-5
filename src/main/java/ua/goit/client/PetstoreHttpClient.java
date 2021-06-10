package ua.goit.client;

public class PetstoreHttpClient {
    private static final String URL = "https://petstore.swagger.io/v2";
    private static final String PET_END_POINT = "/pet";
    private static final String STORE_END_POINT = "/store";
    private static final String USER_END_POINT = "/user";
    private static final String USER_WITH_ARRAY = "/createWithArray";
    private static final String PETS_BY_STATUS = "/findByStatus";

    public static String getURL() {
        return URL;
    }

    public static String getPetEndPoint() {
        return PET_END_POINT;
    }

    public static String getStoreEndPoint() {
        return STORE_END_POINT;
    }

    public static String getUserEndPoint() {
        return USER_END_POINT;
    }

    public static String getUserWithArray() {
        return USER_WITH_ARRAY;
    }

    public static String getPetsByStatus() {
        return PETS_BY_STATUS;
    }
}
