
package api.dto.response.product.card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {

    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
