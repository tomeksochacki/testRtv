package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.fragments.elements.PopupElemets;
import pages.fragments.elements.SearchMarkDetailsElements;

public class SearchPage {

    WebDriver driver;
    WebDriverWait webDriverWait;
    SearchMarkDetailsElements searchMarkDetailsElements;
    PopupElemets popupElemets;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        searchMarkDetailsElements = new SearchMarkDetailsElements();
        popupElemets = new PopupElemets();
        PageFactory.initElements(driver, searchMarkDetailsElements);
        PageFactory.initElements(driver, popupElemets);
        webDriverWait = new WebDriverWait(this.driver, 10);
    }

    public SearchPage closePopUp(){
        webDriverWait.until(ExpectedConditions.visibilityOf(popupElemets.getClosePopup()));
        popupElemets.getClosePopup().click();
        return this;
    }

    public SearchPage searchCarList() {
        searchMarkDetailsElements.getInfoButton().click();
        searchMarkDetailsElements.getAllMarkAndModel().sendKeys(Keys.TAB);
        searchMarkDetailsElements.getAllMarkAndModel().sendKeys(Keys.ENTER);
        return this;
    }

    public SearchPage selectMark(String mark){
        for (int i = 0; i<searchMarkDetailsElements.getCarList().size(); i++){
            if (searchMarkDetailsElements.getCarList().get(i).getText().contains(mark)){
                searchMarkDetailsElements.getCarList().get(i).click();
                break;
            }
        }
        return this;
    }

    public SearchPage selectModel(String model){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(searchMarkDetailsElements.getModelList()));
        for (int i = 0; i<searchMarkDetailsElements.getModelList().size(); i++){
            if (searchMarkDetailsElements.getModelList().get(i).getText().contains(model)){
                searchMarkDetailsElements.getModelList().get(i).click();
                break;
            }
        }
        return this;
    }

    public String getMarkAndModel(){
        webDriverWait.until(ExpectedConditions.visibilityOf(searchMarkDetailsElements.getCarNameAndSerie()));
        return searchMarkDetailsElements.getCarNameAndSerie().getText();
    }
}
