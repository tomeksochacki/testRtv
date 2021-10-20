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

    @FindBy(id = "ambit-search-location")
    private WebElement city;

    @FindBy(id="qssub")
    private WebElement searchButton;

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

    public WebElement getCity() {
        return city;
    }

    public void setCity(WebElement city) {
        this.city = city;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(WebElement searchButton) {
        this.searchButton = searchButton;
    }
}
