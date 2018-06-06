
package api.dto.response.product.account.accumulation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
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
