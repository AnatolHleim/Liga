package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubCategoryPage extends BasePage {

    Logger log = Logger.getLogger(SubCategoryPage.class);

    @FindBy(xpath = "//div[@data-tid='cb168a42']")
    WebElement leftMenu;

    public SubCategoryPage(WebDriver driver) {
        super(driver);
    }


    public void selectInnerCategory(String name) {
        leftMenu.findElement(By.xpath(".//*[text()='" + name + "']")).click();
        log.info("Выбрана подкатегория " + name);

    }
}
