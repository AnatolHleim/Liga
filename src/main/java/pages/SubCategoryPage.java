package pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.ByteArrayInputStream;

public class SubCategoryPage extends BasePage {

    Logger log = Logger.getLogger(SubCategoryPage.class);

    @FindBy(xpath = "//div[@data-tid='cb168a42']")
    WebElement leftMenu;

    public SubCategoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Выбор подкатегории")
    public void selectInnerCategory(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(leftMenu.findElement(By.xpath(".//*[text()='" + name + "']")))).click();
        log.info("Выбрана подкатегория " + name);
        Allure.addAttachment("SelectSubCategory", new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES)));

    }
}
