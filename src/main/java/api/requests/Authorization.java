package api.requests;

import api.dto.request.authorization.AccessToken;
import api.dto.request.authorization.AccessTokenNext;
import api.paths.generalPaths.GeneralPaths;
import base.Base;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import testUser.TestUser;

import java.util.HashMap;
import java.util.Map;

public class Authorization extends Base {

    Logger logger = LoggerFactory.getLogger(Authorization.class);

    public void login(TestUser testUser) {
        login(testUser.getUsername(), testUser.getPassword());
    }

    @Step("Авторизация пользователем: {0}")
    public void login(String user, String password) {
        Response response = POST_REQUEST.postRequestForAuthorization(GeneralPaths.ACCESS_TOKEN, new AccessToken().toString());
        Map<String, String> cookies = new HashMap<>(response.cookies());
        response = POST_REQUEST.postRequestForAuthorization(GeneralPaths.ACCESS_TOKEN, new AccessTokenNext(response.path("execution"), password, user).toString(), cookies);
        Assert.assertNotNull(response.path("access_token"), "Не удалось авторизоваться!");
        logger.info("accessToken ПОЛУЧЕН");
        RequestUtils.cookieMap.put("at", response.path("access_token"));
    }
}
