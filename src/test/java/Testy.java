import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Testy {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().deleteAllCookies();
        //this.webDriver.navigate().to("https://www.mediaexpert.pl/");
    }

    /*@Test
    public void mediaExpertTest() {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='spark-button is-primary is-default icon-left']")));
        this.webDriver.findElement(By.cssSelector("[class='spark-button is-primary is-default icon-left']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("TV, Audio i RTV")));
        this.webDriver.findElement(By.linkText("TV, Audio i RTV")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div/ul[@class='category']")));
        *//*wait.until(ExpectedConditions.elementToBeClickable(By.className("icon close-icon icon-close")));
        this.webDriver.switchTo()
                .frame(this.webDriver.findElement(By.className("icon close-icon icon-close")));
        this.webDriver.findElement(By.className("icon close-icon icon-close")).click();
        this.webDriver.switchTo().defaultContent();*//*
        this.webDriver.findElement(By.xpath("//div/img[@alt='Telewizory']")).click();
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class='offer-box']")));
        } catch (StaleElementReferenceException e) {
            System.out.printf("e");
        }
        Assertions.assertThat(this.webDriver.findElements(By.cssSelector("[class='offer-box']")).size()).isEqualTo(30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(),  '30 produktów')]")));
        this.webDriver.findElement(By.xpath("//span[contains(text(),  '30 produktów')]")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//span[contains(text(),  '30 produktów')]")));
        this.webDriver.findElement(By.xpath(".//span[contains(text(),  '30 produktów')]")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='sidebar']")));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'LCD')]")));
        JavascriptExecutor js = (JavascriptExecutor) this.webDriver;
        js.executeScript("window.scrollBy(0,250)", "");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'LCD')]")));
        this.webDriver.findElement(By.xpath("//a[contains(text(),'LCD')]")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class='list-items']")));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[class='offer-box']")));
        Assertions.assertThat(this.webDriver.findElements(By.cssSelector("[class='offer-box']")).size()).isEqualTo(3);
    }*/

   /* @Test
    public void selectMethod(){
        this.webDriver.navigate().to("http://how2html.pl/select-html/");
        new Select(this.webDriver.findElement(By.id("dessert"))).selectByIndex(2);
    }*/

    /*@Test
    public void dropDownProduct(){
        this.webDriver.navigate().to("https://www.samsung.com/pl/tvs/all-tvs/");
        WebDriverWait wait = new WebDriverWait(this.webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='truste-consent-content']")));
        this.webDriver.findElement(By.cssSelector("[id='truste-consent-button']")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("pf-finder-v2__filters-bar-select")));
        this.webDriver.findElement(By.className("pf-finder-v2__filters-bar-select")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[style='max-height: 288px; transition: max-height 0.2s cubic-bezier(0.4, 0, 0.2, 1) 0s;']")));
        Random random = new Random();
        int randomNumber = random.nextInt(this.webDriver.findElements(By.cssSelector("[style='max-height: 288px; transition: max-height 0.2s cubic-bezier(0.4, 0, 0.2, 1) 0s;'] li")).size());
        this.webDriver.findElements(By.cssSelector("[style='max-height: 288px; transition: max-height 0.2s cubic-bezier(0.4, 0, 0.2, 1) 0s;'] li")).get(randomNumber).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".product-card-v2__item .product-card-v2__name-link")));
        //Assertions.assertThat(this.webDriver.findElements(By.cssSelector(".product-card-v2__item .product-card-v2__name-link")).get(0).getText()).contains("98” QLED Q950R");
        //System.out.println(this.webDriver.findElements(By.cssSelector(".product-card-v2__item .product-card-v2__name-link")).get(0).getText());
        Assertions.assertThat(this.webDriver.findElements(By.cssSelector(".product-card-v2__item .product-card-v2__name-link")).size()).isEqualTo(8);
    }*/

    @Test
    public void testyDragAndDrop() {
        this.webDriver.navigate().to("https://marcojakob.github.io/dart-dnd/basic/");
        Actions actions = new Actions(this.webDriver);
        List<WebElement> list = this.webDriver.findElements(By.className("document"));
        WebElement trash = this.webDriver.findElement(By.className("trash"));
        for (int i = 0; i<list.size(); i++){
            actions.dragAndDrop(list.get(i), trash).perform();
        }
        Assertions.assertThat(this.webDriver.findElement(By.cssSelector(".trash.full")).isEnabled()).isEqualTo(true);
        File file = ((TakesScreenshot)this.webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("C:\\Desktop\\testphoto.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*@After
    public void tearDown() {
        this.webDriver.close();
        this.webDriver.quit();
    }*/
}
