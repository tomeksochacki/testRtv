package pages.fragments.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchMarkDetailsElements {

    @FindBy(css = "[data-se='header-nav-link-toggle__hdinf']")
    private WebElement infoButton;

    @FindBy(css = "[data-se='header-nav-link__hdinfmd']")
    private WebElement allMarkAndModel;

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
