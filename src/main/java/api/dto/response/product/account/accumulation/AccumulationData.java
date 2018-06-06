
package api.dto.response.product.account.accumulation;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccumulationData {

    private String accNum;
    private String accName;
    private Balance balance;
    private Status status;
    private String bic;
    private String productCode;
    private BigDecimal percent;
    private BigDecimal deptAmount;
    private String deptPayDate;
    private String conditionAccumulationUrl;
    private Boolean digitalSign;
    private String openDate;
    private String contractName;
    private String bsc;
    private String idExt;
    @JsonProperty("@type")
    private String type;

    public String getAccNum() {
        return accNum;
    }

    public String getAccName() {
        return accName;
    }

    public Balance getBalance() {
        return balance;
    }

    public Status getStatus() {
        return status;
    }

    public String getBic() {
        return bic;
    }

    public String getProductCode() {
        return productCode;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public BigDecimal getDeptAmount() {
        return deptAmount;
    }

    public String getDeptPayDate() {
        return deptPayDate;
    }

    public String getConditionAccumulationUrl() {
        return conditionAccumulationUrl;
    }

    public Boolean getDigitalSign() {
        return digitalSign;
    }

    public String getOpenDate() {
        return openDate;
    }

    public String getContractName() {
        return contractName;
    }

    public String getBsc() {
        return bsc;
    }

    public String getIdExt() {
        return idExt;
    }

    public String getType() {
        return type;
    }
}
