package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@itemscope]/following-sibling::div")
    WebElement productName;

    @FindBy(xpath = "//*[contains(@data-zone-data,'default-offer')]//span[not(@*)]")
    WebElement productPrice;

    public String getTextProductName() {
        return wait.until(ExpectedConditions.visibilityOf(productName)).getText();
    }

    public String getTextProductPrice() {
        return wait.until(ExpectedConditions.visibilityOf(productPrice)).getText();
    }
}


