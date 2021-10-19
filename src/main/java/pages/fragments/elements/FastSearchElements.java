package pages.fragments.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FastSearchElements {

    @FindBy(id = "qsmakeBuy")
    private WebElement mark;

    @FindBy(id = "qsmodelBuy")
    private WebElement model;

    @FindBy(css = "#qsmilwrp .form-control.form-control--m.form-control--combobox.ui-combobox-hidden")
    private WebElement km;

    @FindBy(id = "")
    WebElement city;

    public WebElement getMark() {
        return mark;
    }

    public void setMark(WebElement mark) {
        this.mark = mark;
    }

    public WebElement getModel() {
        return model;
    }

    public void setModel(WebElement model) {
        this.model = model;
    }

    public WebElement getKm() {
        return km;
    }

    public void setKm(WebElement km) {
        this.km = km;
    }
}
