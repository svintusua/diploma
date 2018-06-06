
package api.dto.response.product.card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDTO {

    private Boolean success;
    private List<CardData> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public List<CardData> getData() {
        return data;
    }
}
