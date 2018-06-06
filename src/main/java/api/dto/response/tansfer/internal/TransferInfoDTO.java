
package api.dto.response.tansfer.internal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferInfoDTO {

    private Boolean success;
    private Data data;

    public Boolean getSuccess() {
        return success;
    }

    public Data getData() {
        return data;
    }
}
