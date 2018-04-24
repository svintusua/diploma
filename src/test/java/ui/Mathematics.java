package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

@Stories("Математика")
public class Mathematics {

    @Test
    @Title("2*2=4")
    public void mathematicsFirst() {
        Assert.assertEquals(4, 2 * 2, "Выражение не верно");
    }


    @Test
    @Title("2*2=4")
    public void mathematicsSecond() {
        Assert.assertEquals(5, 2 * 2, "Выражение не верно");
    }
}
