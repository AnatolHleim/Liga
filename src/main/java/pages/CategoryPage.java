package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.ByteArrayInputStream;

public class CategoryPage extends BasePage {
    Logger log = Logger.getLogger(CategoryPage.class);

    @FindBy(xpath = "//input[@name='Цена от']")
    WebElement minPrice;

    @FindBy(xpath = "//*[text()='Производитель']/parent::*//ul")
    WebElement blockBrand;

    @FindBy(xpath = "//div[contains(text(),'Найдено')]")
    WebElement informMessageAboutSearch;

    @FindBy(xpath = "//*[@data-zone-name='title']/a")
    WebElement titleSnippetList;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Выбрать brand")
    public CategoryPage selectBrand(String brand) {
        blockBrand.findElement(By.xpath(".//span[text()='" + brand + "']//parent::div")).click();
        wait.until(ExpectedConditions.visibilityOf(informMessageAboutSearch));
        log.info("Выбран брэнд " + brand);
        Allure.addAttachment("SelectBrand", new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES)));
        return this;
    }

    @Step("Установить минимальную цену")
    public CategoryPage setMinPrice(String price) {
        minPrice.click();
        minPrice.sendKeys(price);
        wait.until(ExpectedConditions.visibilityOf(informMessageAboutSearch));
        log.info("Установлена мин цена " + price);
        Allure.addAttachment("SetPrice", new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES)));
        return this;
    }

    @Step("Переключиться на открытую вкладку товара")
    public void clickToSnippetTitle() {
        titleSnippetList.click();
        String currentTabHandle = driver.getWindowHandle();
        String newTabHandle = driver.getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(currentTabHandle))
                .findFirst()
                .get();
        driver.switchTo().window(newTabHandle);
        log.info("Выполнен переход на открытую по ссылке вкладку");
        Allure.addAttachment("SetPrice", new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES)));
    }
}
