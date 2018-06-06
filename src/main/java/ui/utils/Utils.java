package ui.utils;

import base.Base;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.qameta.allure.Attachment;
import org.json.JSONArray;

import java.util.Map;

public class Utils extends Base {

    @Attachment(value = "{attachName}", type = "text/plain")
    public static Map<String, String> saveUserInfo(String attachName, Map<String, String> message) {
        return message;
    }

    @Attachment(value = "Лог запросов со статусом != 200", type = "application/json")
    public static String attachJson(JSONArray jsonArray) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(jsonArray);
    }

}
