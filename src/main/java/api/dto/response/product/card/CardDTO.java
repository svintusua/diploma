
package api.dto.response.product.card;

import java.util.List;

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
