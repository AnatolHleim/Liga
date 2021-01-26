import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.CategoryPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SubCategoryPage;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.List;



public class TestFilterPrice extends BaseTestClass {
    HomePage homePage;
    SubCategoryPage subCategoryPage;
    CategoryPage categoryPage;
    ProductPage productPage;

    @Before()
    public void setup(){
        homePage = new HomePage(driver);
        subCategoryPage = new SubCategoryPage(driver);
        categoryPage = new CategoryPage(driver);
        productPage = new ProductPage(driver);

    }

    @Test
    @Description("Выбираем первый товар по фильтру и проверяем соответствие по наименованию")
    public void test1()  {
        homePage.openHome()
                .closeInform()
                .selectTypeMenu("Электроника");
        subCategoryPage.selectInnerCategory("Телевизоры");
        categoryPage.setMaxPrice("20000")
                    .selectBrand("Samsung")
                    .selectBrand("LG")
                    .clickToSnippetTitle();
        List<String> names = Collections.singletonList(productPage.getTextProductName());
        System.out.println(names);
        Allure.addAttachment("NameProductScreenShot", new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES)));
        Assert.assertTrue(names.stream().anyMatch(name -> name.contains("LG") || name.contains("Samsung")));
    }

    @Test
    @Description("Выбираем первый товар по фильтру и проверяем соответствие по цене")
    public void test2()  {
        homePage.openHome()
                .closeInform()
                .selectTypeMenu("Электроника");
        subCategoryPage.selectInnerCategory("Телевизоры");
        categoryPage.setMaxPrice("20000")
                .selectBrand("Samsung")
                .selectBrand("LG")
                .clickToSnippetTitle();
        List<Integer> prices = Collections.singletonList(Integer.parseInt(productPage.getTextProductPrice().split(",")[0].replaceAll("[^\\d.]", "")));
        System.out.println(prices);
        Allure.addAttachment("PriceProductScreenShot", new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES)));
        Assert.assertTrue(prices.stream().allMatch(price -> price > 20000 || price == 20000));
    }
}