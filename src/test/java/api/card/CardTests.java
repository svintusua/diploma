package api.card;

import api.dto.response.product.card.CardDTO;
import api.paths.product.CardPaths;
import api.requests.Authorization;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import testUser.TestUser;

@Features("Пояс карты")
public class CardTests extends Authorization {

    @Stories("Smoke тесты")
    @Test
    @Title("GET //webbank/webapi-2.1//card-webapi/product/card/")
    public void getCards() {
        TestUser testUser = new TestUser("основной");
        login(testUser);
        CardDTO card = GET_REQUEST.getRequest(CardPaths.CARD).as(CardDTO.class);
        CARD_STEPS.checkCard(card, testUser);
    }
}
