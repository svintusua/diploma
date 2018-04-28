
package api.dto.response.product.card;


import java.math.BigDecimal;

public class Balance {

    private BigDecimal amount;
    private String currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
