package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    Logger log = Logger.getLogger(BasePage.class);

    @FindBy(xpath = "//*[@class='_381y5orjSo _21NjfY1k45']")
    WebElement upperMenu;

    @FindBy(xpath = "//*[contains(text(),'Поиск у нас и во всех магазинах')]/parent::*/button")
    WebElement informWindow;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage openHome() {
        driver.manage().window().maximize();
        log.info("Макс размер браузера");
        driver.get("https://market.yandex.ru/");
        log.info("Выполнен переход по ссылке");
        return this;
    }

    public HomePage closeInform() {
        try {
            informWindow.click();
            log.info("Информ окно закрыто");
        } catch (NoSuchElementException ignored) {
            log.info("Информ окно не появилось");
        }
        return this;
    }

    public void selectTypeMenu(String menu) {
        upperMenu.findElement
                (By.xpath(".//*[contains(text(),'" + menu + "')]")).click();
        log.info("выбрана категория " + menu);
    }
}
