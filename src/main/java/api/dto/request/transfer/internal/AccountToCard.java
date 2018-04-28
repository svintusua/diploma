package api.dto.request.transfer.internal;

import java.math.BigDecimal;

public class AccountToCard {

    private BigDecimal beneficiaryAmount;
    private String beneficiaryCurrency;
    private String beneficiaryVirtualCardNum;
    private BigDecimal payerAmount;
    private String payerCurrency;
    private String payerAccountNum;

    public AccountToCard(BigDecimal beneficiaryAmount, String beneficiaryCurrency, String beneficiaryVirtualCardNum, BigDecimal payerAmount, String payerCurrency, String payerAccountNum) {
        this.beneficiaryAmount = beneficiaryAmount;
        this.beneficiaryCurrency = beneficiaryCurrency;
        this.beneficiaryVirtualCardNum = beneficiaryVirtualCardNum;
        this.payerAmount = payerAmount;
        this.payerCurrency = payerCurrency;
        this.payerAccountNum = payerAccountNum;
    }
}
