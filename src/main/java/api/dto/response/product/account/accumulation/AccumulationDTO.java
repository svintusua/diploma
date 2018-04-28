
package api.dto.response.product.account.accumulation;

import java.util.List;

public class AccumulationDTO {

    private Boolean success;
    private List<AccumulationData> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public List<AccumulationData> getData() {
        return data;
    }
}
