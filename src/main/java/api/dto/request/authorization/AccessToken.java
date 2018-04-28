package api.dto.request.authorization;

public class AccessToken {

    private String clientId = "test_oauth2m2m";
    private String clientSecret = "password";
    private String grantType = "urn:roox:params:oauth:grant-type:m2m";
    private String realm = "/customer";
    private String service = "dispatcher";

    @Override
    public String toString() {
        return "client_id=" + clientId +
                "&client_secret=" + clientSecret +
                "&grant_type=" + grantType +
                "&realm=" + realm +
                "&service=" + service;
    }
}
