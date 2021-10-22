package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.fragments.elements.FastSearchElements;
import pages.fragments.elements.PopupElemets;

public class FastSearchPage {

    WebDriver driver;
    WebDriverWait webDriverWait;
    FastSearchElements fastSearchElements;
    PopupElemets popupElemets;

    public FastSearchPage(WebDriver driver) {
        this.driver = driver;
        popupElemets = new PopupElemets();
        fastSearchElements = new FastSearchElements();
        PageFactory.initElements(driver, popupElemets);
        PageFactory.initElements(driver, fastSearchElements);
        webDriverWait = new WebDriverWait(driver, 10);
    }

    public FastSearchPage closePopupScreen() {
        webDriverWait.until(ExpectedConditions.visibilityOf(popupElemets.getClosePopup()));
        popupElemets.getClosePopup().click();
        return this;
    }

    public FastSearchPage selectMark(String mark) {
        new Select(fastSearchElements.getMark()).selectByVisibleText(mark);
        return this;
    }

    public FastSearchPage selectModel(String model) {
        new Select(fastSearchElements.getModel()).selectByVisibleText(model);
        return this;
    }

    public FastSearchPage selectKm(String km) {
        new Select(fastSearchElements.getKm()).selectByVisibleText(km);
        return this;
    }

    public FastSearchPage selectCity(String city) {
        fastSearchElements.getCity().sendKeys(city);
        fastSearchElements.getCity().sendKeys(Keys.TAB);
        return this;
    }

    public FastSearchPage search() {
        fastSearchElements.getSearchButton().click();
        return this;
    }


}
