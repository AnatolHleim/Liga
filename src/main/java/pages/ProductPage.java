package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.ByteArrayInputStream;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@itemscope]/following-sibling::div")
    WebElement productName;

    @FindBy(xpath = "//*[contains(@data-zone-data,'default-offer')]//span[not(@*)]")
    WebElement productPrice;

    @Step("Название продукта отображено")
    public String getTextProductName() {
        Allure.addAttachment("ProductCardBrand", new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES)));
        return wait.until(ExpectedConditions.visibilityOf(productName)).getText();

    }

    @Step("Стоимость продукта отображена")
    public String getTextProductPrice() {
        Allure.addAttachment("ProductCardPrice", new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES)));
        return wait.until(ExpectedConditions.visibilityOf(productPrice)).getText();
    }
}


