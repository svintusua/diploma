package api.steps.card;

import api.dto.response.product.card.CardDTO;
import api.dto.response.product.card.CardData;
import api.propreties.Properties;
import api.requests.PostRequests;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import testUser.TestUser;

public class CardSteps {

    Logger logger = LoggerFactory.getLogger(PostRequests.class);

    public void checkCard(CardDTO card, TestUser testUser) {
        checkCard(card, testUser.getFio());
    }

    @Step("Проверка CardDTO на обязательные поля и принадлженость клиенту: {fio}")
    public void checkCard(CardDTO card, String fio) {
        for (CardData cardData : card.getData()) {
            Assert.assertNotNull(cardData.getBankName(), "Отсутствует BankName");
            Assert.assertNotNull(cardData.getBalance(), "Отсутствует Balance");
            Assert.assertNotNull(cardData.getBsc(), "Отсутствует Bsc");
            Assert.assertNotNull(cardData.getType(), "Отсутствует Type");
            Assert.assertNotNull(cardData.getPinChangeAvailable(), "Отсутствует PinChangeAvailable");
            Assert.assertNotNull(cardData.getCardId(), "Отсутствует CardId");
            Assert.assertNotNull(cardData.getReissueInfo(), "Отсутствует ReissueInfo");
            Assert.assertNotNull(cardData.getAccNum(), "Отсутствует AccNum");
            Assert.assertNotNull(cardData.getApplePayAllowed(), "Отсутствует ApplePayAllowed");
            Assert.assertEquals(cardData.getAccName(), fio, "Карта не принадлежит пользователю");
        }
        logger.info("Проверка CardDTO прошла успешно");
    }

    @Step("Поиск карты по параметрам")
    public CardData findCard(CardDTO card, Properties properties) {
        boolean founded = true;
        CardData foundedCard = new CardData();
        for (CardData cardData : card.getData()) {
            if (properties.getAmount() != null
                    && properties.getAmount().compareTo(cardData.getBalance().getAmount()) != -1) founded = false;
            if (properties.getCurrency() != null
                    && !properties.getCurrency().equals(cardData.getBalance().getCurrency())) founded = false;
            if (properties.getBsc() != null
                    && !properties.getBsc().equals(cardData.getBsc())) founded = false;
            if (!properties.getCode().equals(cardData.getStatus().getCode())) founded = false;
            if (founded) {
                foundedCard = cardData;
                break;
            }
        }
        return foundedCard;
    }
}
