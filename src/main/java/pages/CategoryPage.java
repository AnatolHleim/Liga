package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public CategoryPage selectBrand(String brand) {
        blockBrand.findElement(By.xpath(".//span[text()='" + brand + "']//parent::div")).click();
        wait.until(ExpectedConditions.visibilityOf(informMessageAboutSearch));
        log.info("Выбран брэнд " + brand);
        return this;
    }

    public CategoryPage setMaxPrice(String price) {
        minPrice.click();
        minPrice.sendKeys(price);
        wait.until(ExpectedConditions.visibilityOf(informMessageAboutSearch));
        log.info("Установлена макс цена " + price);
        return this;
    }

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
    }
}
