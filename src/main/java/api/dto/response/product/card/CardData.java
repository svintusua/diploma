
package api.dto.response.product.card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardData {

    private String cardId;
    private String maskCardNum;
    private String virtualCardNum;
    private TariffPlan tariffPlan;
    private String bic;
    private String cardType;
    private String paySystem;
    private Balance balance;
    private Status status;
    private String externalId;
    private String designCode;
    private String designFileName;
    private String cardExpDate;
    private Boolean main;
    private String bankName;
    private String bsc;
    private String startDate;
    private String lastTransactionDate;
    private String type;
    private String prodGroup;
    private String cardPC;
    private String idExt;
    private String holderName;
    private Boolean applePayAllowed;
    private String mbCardDesignFull;
    private String mbHalfCardDesign;
    private String mbDesignBckgrd;
    private Boolean overdue;
    private String accNum;
    private String accName;
    private String paySystemPC;
    private Boolean resident;
    private Boolean pinChangeAvailable;
    private ReissueInfo reissueInfo;

    public String getCardId() {
        return cardId;
    }

    public String getMaskCardNum() {
        return maskCardNum;
    }

    public String getVirtualCardNum() {
        return virtualCardNum;
    }

    public TariffPlan getTariffPlan() {
        return tariffPlan;
    }

    public String getBic() {
        return bic;
    }

    public String getCardType() {
        return cardType;
    }

    public String getPaySystem() {
        return paySystem;
    }

    public Balance getBalance() {
        return balance;
    }

    public Status getStatus() {
        return status;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getDesignCode() {
        return designCode;
    }

    public String getDesignFileName() {
        return designFileName;
    }

    public String getCardExpDate() {
        return cardExpDate;
    }

    public Boolean getMain() {
        return main;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBsc() {
        return bsc;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getLastTransactionDate() {
        return lastTransactionDate;
    }

    public String getType() {
        return type;
    }

    public String getProdGroup() {
        return prodGroup;
    }

    public String getCardPC() {
        return cardPC;
    }

    public String getIdExt() {
        return idExt;
    }

    public String getHolderName() {
        return holderName;
    }

    public Boolean getApplePayAllowed() {
        return applePayAllowed;
    }

    public String getMbCardDesignFull() {
        return mbCardDesignFull;
    }

    public String getMbHalfCardDesign() {
        return mbHalfCardDesign;
    }

    public String getMbDesignBckgrd() {
        return mbDesignBckgrd;
    }

    public Boolean getOverdue() {
        return overdue;
    }

    public String getAccNum() {
        return accNum;
    }

    public String getAccName() {
        return accName;
    }

    public String getPaySystemPC() {
        return paySystemPC;
    }

    public Boolean getResident() {
        return resident;
    }

    public Boolean getPinChangeAvailable() {
        return pinChangeAvailable;
    }

    public ReissueInfo getReissueInfo() {
        return reissueInfo;
    }
}
