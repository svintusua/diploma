package api.requests;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class GetRequests extends RequestUtils {

    Logger logger = LoggerFactory.getLogger(GetRequests.class);

    @Step("Посылаем GET запрос на сервер: {path}")
    public Response getRequest(String path) {
        Response response = given().filter(new AllureRestAssured()).config(cfg).accept("*/*").cookies(cookieMap).get(generateURI(path));
        logger.info("URL: " + generateURI(path).toString());
        logger.info("HTTP STATUS: " + response.getStatusCode());
        logger.info("RESPONSE: " + response.asString());
        if (response.path("success").equals(true)) {
            return response;
        } else if (response.path("success").equals(false) && response.path("code").toString().equals("EXCEPTION")) {
            throw new IllegalStateException("Запрос по URL: " + generateURI(path) + " возвратил EXCEPTION");
        } else {
            throw new IllegalStateException("Ответ от сервера не пришел: " + generateURI(path));
        }
    }
}
