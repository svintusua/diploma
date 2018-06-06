package api.transfer;

import api.dto.request.transfer.internal.AccountToCard;
import api.dto.response.product.account.accumulation.AccumulationDTO;
import api.dto.response.product.account.accumulation.AccumulationData;
import api.dto.response.product.card.CardDTO;
import api.dto.response.product.card.CardData;
import api.dto.response.tansfer.internal.TransferInfoDTO;
import api.paths.product.AccountPaths;
import api.paths.product.CardPaths;
import api.paths.transfer.InternalPaths;
import api.propreties.Properties;
import api.requests.Authorization;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testUser.TestUser;

import java.math.BigDecimal;


@Feature("Переводы")//аннотация для отчета
public class TransferTests extends Authorization {

    @Story("Critical тесты")//аннотация для отчета
    @Test(description = "Перевод между своими продуктами (Моя копилка RUR - ГО RUR )")//аннотация для отчета
    public void transferBetweenMy() {
        BigDecimal amount = new BigDecimal(1);
        TestUser testUser = new TestUser("основной");
        login(testUser);
        CardDTO cards = GET_REQUEST.getRequest(CardPaths.CARD).as(CardDTO.class);
        CardData cardData = CARD_STEPS.findCard(cards, new Properties());
        AccumulationDTO accumulationDTO = GET_REQUEST.getRequest(AccountPaths.ACCUMULATION_LIST).as(AccumulationDTO.class);
        AccumulationData accumulationData = ACCUMULATION_STEPS.findAccumulation(accumulationDTO,
                new Properties().setAmount(new BigDecimal(100)).setAccName("Моя копилка"));
        TransferInfoDTO transferInfo = POST_REQUEST.postRequest(InternalPaths.ACCOUNT_TO_CARD,
                new AccountToCard(amount, cardData.getBalance().getCurrency(), cardData.getVirtualCardNum(),
                        amount, accumulationData.getBalance().getCurrency(), accumulationData.getAccNum())).as(TransferInfoDTO.class);
        INTERNAL_STEPS.checkTransferInfo(transferInfo);
    }
}
