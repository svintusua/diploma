package api.steps.transfer.internal;

import api.dto.response.tansfer.internal.TransferInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class InternalSteps {

    Logger logger = LoggerFactory.getLogger(InternalSteps.class);

    @Step("Проверка TransferInfoDTO на обязательные поля и возможность повторения")
    public void checkTransferInfo(TransferInfoDTO transferInfo) {
        Assert.assertNotNull(transferInfo.getData().getIdDigital(), "Отсутствует idDigital");
        Assert.assertEquals(transferInfo.getData().getReceiptable(), true,
                "Отсутсвует возможность повторения операции");
        Assert.assertEquals(transferInfo.getData().getTemplatable(), true,
                "Отсутсвует возможность создания шаблона операции");
        logger.info("Проверка TransferInfoDTO прошла успешно");
    }
}
