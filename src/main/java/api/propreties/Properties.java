package api.propreties;

import java.math.BigDecimal;

public class Properties {

    private String currency = "RUR";
    private BigDecimal amount = new BigDecimal(100);
    private String code = "NORMAL";
    private String bsc = "3C";
    private String accName;

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCode() {
        return code;
    }

    public String getBsc() {
        return bsc;
    }

    public String getAccName() {
        return accName;
    }

    public Properties setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Properties setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Properties setCode(String code) {
        this.code = code;
        return this;
    }

    public Properties setBsc(String bsc) {
        this.bsc = bsc;
        return this;
    }

    public Properties setAccName(String accName) {
        this.accName = accName;
        return this;
    }
}
