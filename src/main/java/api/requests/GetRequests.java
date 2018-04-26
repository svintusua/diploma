package api.requests;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.allure.annotations.Step;

import static io.restassured.RestAssured.given;

public class GetRequests extends RequestUtils {

    Logger logger = LoggerFactory.getLogger(GetRequests.class);

    @Step("Посылаем GET запрос на сервер: {path}")
    public Response getRequest(String path) {
        Response response = given().config(cfg).accept("*/*").cookies(cookieMap).get(generateURI(path));
    }

}
