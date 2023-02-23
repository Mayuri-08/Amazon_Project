package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchResult() {
        return searchResult;
    }

    @FindBy(xpath = "//input[@type=\"text\"]")
    WebElement searchBox;

    @FindBy(xpath = "//span[@class=\"a-color-state a-text-bold\"]")
    WebElement searchResult;

    public WebElement getSearchMinPrice() {
        return searchMinPrice;
    }

    public WebElement getSearchMaxPrice() {
        return searchMaxPrice;
    }

    public WebElement getGoButton() {
        return goButton;
    }

    @FindBy(xpath = "//input[@placeholder=\"Min\"]")
    WebElement searchMinPrice;

    @FindBy(xpath = "//input[@placeholder=\"Max\"]")
    WebElement searchMaxPrice;
    @FindBy(xpath = "//input[@class=\"a-button-input\"]")
    WebElement goButton;

    public WebElement getSelectFeature() {

        return SelectFeature;
    }

    @FindBy(xpath = "//select[@name=\"s\"]")
    WebElement SelectFeature;

    public WebElement getViewResult() {
        return viewResult;
    }

    @FindBy(xpath = "//span[@class=\"a-size-medium-plus a-color-base a-text-normal\"]")
    WebElement viewResult;

    public WebElement getSelectOs() {
        return selectOs;
    }

    public WebElement getSelectDisplay() {
        return selectDisplay;
    }

    public WebElement getSelectTech() {
        return selectTech;
    }

    @FindBy(xpath = "//span[text()='Android 12.0']")
    WebElement selectOs;

    @FindBy(xpath = "//span[text()='AMOLED']")
    WebElement selectDisplay;

    @FindBy(xpath = "//span[text()='5G']")
    WebElement selectTech;

    public WebElement getSearchItem() {
        return searchItem;
    }

    @FindBy(xpath = "//span[@class=\"a-color-state a-text-bold\"]")
    WebElement searchItem;

    public WebElement getSearchAll() {
        return searchAll;
    }

    @FindBy(xpath = "//i[@class=\"hm-icon nav-sprite\"]")
    WebElement searchAll;

    public WebElement getSearchSellers() {
        return searchSellers;
    }

    @FindBy(xpath = "//a[text()=\"Best Sellers\"]")
    WebElement searchSellers;

    public WebElement getSearchBooks() {
        return searchBooks;
    }

    @FindBy(xpath = "//a[text()=\"Books\"][2]")
    WebElement searchBooks;

    public WebElement getSearchBestseller() {
        return searchBestseller;
    }

    @FindBy(xpath = "//h1[text()=\"Bestsellers in Books\"]")
    WebElement searchBestseller;


}


