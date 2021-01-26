package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.ByteArrayInputStream;

public class HomePage extends BasePage {

    Logger log = Logger.getLogger(BasePage.class);

    @FindBy(xpath = "//*[@class='_381y5orjSo _21NjfY1k45']")
    WebElement upperMenu;

    @FindBy(xpath = "//*[contains(text(),'Поиск у нас и во всех магазинах')]/parent::*/button")
    WebElement informWindow;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть главную страницу")
    public HomePage openHome() {
        driver.manage().window().maximize();
        log.info("Макс размер браузера");
        driver.get("https://market.yandex.ru/");
        log.info("Выполнен переход по ссылке");
        Assert.assertTrue(this.driver.getCurrentUrl().contains("https://market.yandex"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Поиск у нас и во всех магазинах')]")));
        Allure.addAttachment("OpenHomePage", new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES)));
        return this;
    }

    @Step("Закрыть подсказку")
    public HomePage closeInform() {
        try {
            informWindow.click();
            log.info("Информ окно закрыто");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'Поиск у нас и во всех магазинах')]")));
            Allure.addAttachment("CloseInform", new ByteArrayInputStream(((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES)));
        } catch (NoSuchElementException ignored) {
            log.info("Информ окно не появилось");
            Allure.addAttachment("CloseInform", new ByteArrayInputStream(((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES)));
        }
        return this;
    }

    @Step("Выбор категории")
    public void selectTypeMenu(String menu) {
        upperMenu.findElement
                (By.xpath(".//*[contains(text(),'" + menu + "')]")).click();
        log.info("выбрана категория " + menu);
        Allure.addAttachment("SelectCategory", new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES)));
    }
}
