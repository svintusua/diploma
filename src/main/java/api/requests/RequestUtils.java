package api.requests;

import base.Base;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class RequestUtils {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    RestAssuredConfig cfg;
    public static Map<String, String> cookieMap = new HashMap<>();

    public URI generateURI(String path) {
        try {
            URI uri = new URI(Base.url + path);
            return uri;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public URI generateURI(String path, String parameters) {
        try {
            URI uri = new URI(Base.url + path + "?" + parameters);
            return uri;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public RequestUtils() {
        SSLConfig sslConfig = SSLConfig.sslConfig().allowAllHostnames().relaxedHTTPSValidation();
        cfg = RestAssured.config().sslConfig(sslConfig);
    }


}
