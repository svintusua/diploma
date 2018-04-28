package api.dto.request.authorization;

import java.io.UnsupportedEncodingException;

import static java.net.URLEncoder.encode;

public class AccessTokenNext {

    private String clientId = "test_oauth2m2m";
    private String clientSecret = "password";
    private String grantType = "urn:roox:params:oauth:grant-type:m2m";
    private String realm = "/customer";
    private String service = "dispatcher";
    private String eventId = "next";
    private String execution;
    private String password;
    private String username;

    public AccessTokenNext(String execution, String password, String username) {
        try {
            this.execution = encode(execution, "UTF-8");
            this.password = encode(password, "UTF-8");
            this.username = encode(username, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "client_id=" + clientId +
                "&client_secret=" + clientSecret +
                "&grant_type=" + grantType +
                "&realm=" + realm +
                "&service=" + service +
                "&_eventId=" + eventId +
                "&execution=" + execution +
                "&password=" + password +
                "&username=" + username;
    }
}
