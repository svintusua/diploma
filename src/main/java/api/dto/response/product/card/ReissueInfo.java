
package api.dto.response.product.card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReissueInfo {

    private Boolean avaliable;
    private Boolean free;
    private String term;
    private Request request;

    public Boolean getAvaliable() {
        return avaliable;
    }

    public Boolean getFree() {
        return free;
    }

    public String getTerm() {
        return term;
    }

    public Request getRequest() {
        return request;
    }
}
