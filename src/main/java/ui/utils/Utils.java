package ui.utils;

import base.Base;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.Map;

public class Utils extends Base {

    @Attachment(value = "{0}", type = "text/plain")
    public static Map<String, String> saveUserInfo(String attachName, Map<String, String> message) {
        return message;
    }

}
