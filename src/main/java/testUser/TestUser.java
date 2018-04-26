package testUser;

import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import ui.utils.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestUser {

    protected String username;
    protected String password;
    protected String fio;

    public TestUser(String role) {
        readFileSuperUsers(role);
    }

    @Step("Выбрать пользователя c ролью: {0}")
    public void readFileSuperUsers(String role) {
        String line;
        String[] sSpl;
        ArrayList<String> loginArray = new ArrayList<String>();
        ArrayList<String> passwordArray = new ArrayList<String>();
        ArrayList<String> fioArray = new ArrayList<String>();
        Map<String, String> userInfo = new HashMap<String, String>();
        try {
            String curDir = new File("").getAbsolutePath();
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(curDir + "\\src\\main\\resources\\testUsers.csv"));
                while ((line = br.readLine()) != null) {
                    if (line.contains(role)) {
                        sSpl = line.split(";");
                        loginArray.add(sSpl[2]);
                        passwordArray.add(sSpl[3]);
                        fioArray.add(sSpl[4]);
                    }
                }
            } finally {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertNotEquals(loginArray.size(), 0, "Пользователь с необходимой ролью не найден");
        this.username = loginArray.get(0);
        userInfo.put("username", username);
        this.password = passwordArray.get(0);
        userInfo.put("password", password);
        this.fio = fioArray.get(0);
        userInfo.put("fio", fio);
        Utils.saveUserInfo("Информация о полученном пользователе", userInfo);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFio() {
        return fio;
    }
}
