package api.requests;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequests extends RequestUtils {

    Logger logger = LoggerFactory.getLogger(PostRequests.class);

    public Response postRequestForAuthorization(String path, String body) {
        return postRequestForAuthorization(path, body, new HashMap<>());
    }

    @Step("Посылаем POST запрос для авторизации на сервер: {path}")
    public Response postRequestForAuthorization(String path, String body, Map<String, String> cookies) {
        Response response = given().filter(new AllureRestAssured()).config(cfg).cookies(cookies).contentType("application/x-www-form-urlencoded")
                .accept("application/json").with().body(body).post(generateURI(path));
        Assert.assertEquals(response.getStatusCode(), 200, "Статус отввета отличается от \"200\"");
        logger.info("URL: " + generateURI(path).toString());
        logger.info("HTTP STATUS: " + response.getStatusCode());
        logger.info("RESPONSE: " + response.asString());
        return response;
    }

    @Step("Посылаем POST запрос на сервер: {path}")
    public Response postRequest(String path, Object body) {
        Response response = given().filter(new AllureRestAssured()).config(cfg).cookies(cookieMap).contentType("application/json").with().body(gson.toJson(body)).post(generateURI(path));
        logger.info("URL: " + generateURI(path).toString());
        logger.info("HTTP STATUS: " + response.getStatusCode());
        logger.info("RESPONSE: " + response.asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Статус отввета отличается от \"200\"");
        if (response.path("success").equals(true)) {
            return response;
        } else if (response.path("success").equals(false) && response.path("code").toString().equals("EXCEPTION")) {
            throw new IllegalStateException("Запрос по URL: " + generateURI(path) + " возвратил EXCEPTION");
        } else {
            throw new IllegalStateException("Ответ от сервера не пришел: " + generateURI(path));
        }
    }
}
