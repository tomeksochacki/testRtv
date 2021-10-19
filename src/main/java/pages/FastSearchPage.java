package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.fragments.elements.FastSearchElements;
import pages.fragments.elements.PopupElemets;

public class FastSearchPage {

    WebDriver webDriver;
    WebDriverWait webDriverWait;
    FastSearchElements fastSearchElements;
    PopupElemets popupElemets;

    public FastSearchPage(WebDriver driver){
        popupElemets = new PopupElemets();
        fastSearchElements = new FastSearchElements();
        PageFactory.initElements(driver, popupElemets);
        webDriverWait = new WebDriverWait(driver, 10);
    }

    public FastSearchPage closePopupScreen(){
        popupElemets.getClosePopup().click();
        return this;
    }

    public FastSearchPage selectMark(String mark){
        new Select(fastSearchElements.getMark()).selectByVisibleText(mark);
        return this;
    }

    public FastSearchPage selectModel(String model){
        new Select(fastSearchElements.getModel()).selectByVisibleText(model);
        return this;
    }


}
