package api.card;

import api.dto.response.product.card.CardDTO;
import api.paths.product.CardPaths;
import api.requests.Authorization;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testUser.TestUser;

@Feature("Карты")
public class CardTests extends Authorization {

    @Story("Smoke тесты")
    @Test(description = "GET //webbank/webapi-2.1//card-webapi/product/card/")
    public void getCards() {
        TestUser testUser = new TestUser("основной");
        login(testUser);
        CardDTO card = GET_REQUEST.getRequest(CardPaths.CARD).as(CardDTO.class);
        CARD_STEPS.checkCard(card, testUser);
    }
}
