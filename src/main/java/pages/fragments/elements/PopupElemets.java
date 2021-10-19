package pages.fragments.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopupElemets {

    @FindBy(id = "gdpr-consent-accept-button")
    private WebElement closePopupButton;

    public WebElement getClosePopup() {
        return closePopupButton;
    }

    public void setClosePopup(WebElement closePopup) {
        this.closePopupButton = closePopup;
    }
}
