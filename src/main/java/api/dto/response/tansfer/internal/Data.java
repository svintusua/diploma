
package api.dto.response.tansfer.internal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    private String idDigital;
    private boolean templatable;
    private boolean receiptable;

    public String getIdDigital() {
        return idDigital;
    }

    public boolean getTemplatable() {
        return templatable;
    }

    public boolean getReceiptable() {
        return receiptable;
    }
}
