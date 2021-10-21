package pages.fragments.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchMarkDetailsElements {

    @FindBy(css = "[data-se='header-nav-link-toggle__hdinf']")
    private WebElement infoButton;

    @FindBy(css = "[data-se='header-nav-link__hdinfmd']")
    private WebElement allMarkAndModel;

    @FindBy(css = ".CardInfo___3YfD_F .btn--link")
    private List<WebElement> carList;

    @FindBy(css = ".CardInfo___2mHZKr .btn--link")
    private List<WebElement> modelList;

    public List<WebElement> getModelList() {
        return modelList;
    }

    public void setModelList(List<WebElement> modelList) {
        this.modelList = modelList;
    }

    public List<WebElement> getCarList() {
        return carList;
    }

    public void setCarList(List<WebElement> carList) {
        this.carList = carList;
    }

    public WebElement getAllMarkAndModel() {
        return allMarkAndModel;
    }

    public void setAllMarkAndModel(WebElement allMarkAndModel) {
        this.allMarkAndModel = allMarkAndModel;
    }

    public WebElement getInfoButton() {
        return infoButton;
    }

    public void setInfoButton(WebElement infoButton) {
        this.infoButton = infoButton;
    }
}
