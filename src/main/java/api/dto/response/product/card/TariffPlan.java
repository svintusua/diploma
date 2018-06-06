package api.dto.response.product.card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TariffPlan {

    private String name;
    private String tariffInfoURL;

    public String getName() {
        return name;
    }

    public String getTariffInfoURL() {
        return tariffInfoURL;
    }
}
