import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testy {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().deleteAllCookies();
        this.webDriver.navigate().to("https://www.mediaexpert.pl/");
    }

    @Test
    public void mediaExpertTest() {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='spark-button is-primary is-default icon-left']")));
        this.webDriver.findElement(By.cssSelector("[class='spark-button is-primary is-default icon-left']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("TV, Audio i RTV")));
        this.webDriver.findElement(By.linkText("TV, Audio i RTV")).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div/ul[@class='category']")));
        /*wait.until(ExpectedConditions.elementToBeClickable(By.className("icon close-icon icon-close")));
        this.webDriver.switchTo()
                .frame(this.webDriver.findElement(By.className("icon close-icon icon-close")));
        this.webDriver.findElement(By.className("icon close-icon icon-close")).click();
        this.webDriver.switchTo().defaultContent();*/
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
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div/a[@title='Telewizory LED - RODZAJ TELEWIZORA: LCD']")));
        this.webDriver.findElement(By.xpath(".//div/a[@title='Telewizory LED - RODZAJ TELEWIZORA: LCD']")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@uid='47352167']")));
        Assertions.assertThat(this.webDriver.findElements(By.xpath("//div[@uid='47352167']")).size()).isEqualTo(3);
    }

    @After
    public void tearDown() {
        this.webDriver.close();
        this.webDriver.quit();
    }
}
