package api.steps.account.accumulation;

import api.dto.response.product.account.accumulation.AccumulationDTO;
import api.dto.response.product.account.accumulation.AccumulationData;
import api.propreties.Properties;
import io.qameta.allure.Step;

public class AccumulationSteps {

    @Step("Поиск накопительного счета по параметрам")
    public AccumulationData findAccumulation(AccumulationDTO accumulation, Properties properties) {
        boolean founded = true;
        AccumulationData foundedAccumulation = new AccumulationData();
        for (AccumulationData data : accumulation.getData()) {
            if (properties.getAmount() != null
                    && properties.getAmount().compareTo(data.getBalance().getAmount()) != -1) founded = false;
            if (properties.getCurrency() != null
                    && !properties.getCurrency().equals(data.getBalance().getCurrency())) founded = false;
            if (properties.getBsc() != null
                    && !properties.getBsc().equals(data.getBsc())) founded = false;
            if (properties.getAccName() != null
                    && !properties.getAccName().equals(data.getAccName())) founded = false;
            if (!properties.getCode().equals(data.getStatus().getCode())) founded = false;
            if (founded) {
                foundedAccumulation = data;
                break;
            }
        }
        return foundedAccumulation;
    }
}
