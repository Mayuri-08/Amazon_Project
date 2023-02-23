package steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;

import java.util.HashMap;


public class StepDefinitions {
    private WebDriver driver;
    HomePage homePage;
    String url;
    HashMap<String, String> data;
    Scenario scenario;
    public StepDefinitions(BrowserManager browserManager) {
        this.driver = browserManager.getDriver();
    }
        @Before(order = 1)
        public void before(Scenario scenario){
            this.scenario = scenario;

        }


    @Given("the user navigates to home page")
    public void the_user_navigates_to_home_page() {
        homePage = new HomePage(driver);
        url = QaProps.getValue("url");
        driver.get(url);
       // data = TestDataReader.getData(scenario.getName());
        }

    @When("the user enters with the product")
    public void the_user_enters_with_the_product() {
       // homePage = new HomePage(driver);
        homePage.getSearchBox().sendKeys("mobiles");
        homePage.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("the user is able to view for a product")
    public void the_user_is_able_to_view_for_a_product() {
        data = TestDataReader.getData(scenario.getName());
        String text = homePage.getSearchResult().getText();
        Assert.assertEquals(text, data.get("Status"));
    }

    @And("the user enters min Price")
    public void the_User_Enters_Min_Price() {
        data = TestDataReader.getData(scenario.getName());
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(homePage.getSearchMinPrice()));
        homePage.getSearchMinPrice().sendKeys(data.get("Input1"));
    }

    @And("the user enters max Price")
    public void the_User_Enters_Max_Price() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(homePage.getSearchMaxPrice()));
        homePage.getSearchMaxPrice().sendKeys(data.get("Input2"));
        homePage.getGoButton().click();
    }
    @Then("the user is able to view a product in  selected price range")
    public void theUserIsAbleToViewAProductInSelectedPriceRange() {
        data = TestDataReader.getData(scenario.getName());
        String text = homePage.getViewResult().getText();
        Assert.assertEquals(text,data.get("Status"));
    }


    @And("the user selects from the drop down feature")
    public void the_User_Selects_From_The_Drop_Down_Feature() {
        Select dropDown = new Select (homePage.getSelectFeature());
        dropDown.selectByIndex(3);
        dropDown.selectByVisibleText("Newest Arrivals");
    }

    @Then("the user is able to view a product as per selected feature")
    public void the_User_Is_Able_To_View_A_Product_As_Per_Selected_Feature() {
        data = TestDataReader.getData(scenario.getName());
        String text = homePage.getViewResult().getText();
        Assert.assertEquals(text,data.get("Status"));

    }

    @And("the user selects a OS feature")
    public void the_User_Selects_A_OS_Feature() {
          homePage.getSelectOs().click();
    }

    @And("the user selects display type")
    public void the_User_Selects_Display_Type() {
        homePage.getSelectDisplay().click();
    }

    @And("the user selects cellular technology")
    public void the_User_Selects_Cellular_Technology() {
        homePage.getSelectTech().click();
    }
    @Then("the user is able to view products from the applied categories")
    public void theUserIsAbleToViewProductsFromTheAppliedCategories() {
        data = TestDataReader.getData(scenario.getName());
        String text = homePage.getSearchResult().getText();
        Assert.assertEquals(text, data.get("Status"));
    }


    @When("user searches for {string}")
    public void userSearchesFor(String arg0) {
        homePage.getSearchBox().sendKeys(arg0);
        homePage.getSearchBox().sendKeys(Keys.ENTER);
    }
    @And("user selects the  {string}")
    public void userSelectsThe(String arg0) {
        homePage.getSearchBox().sendKeys(arg0);
        homePage.getSearchBox().sendKeys(Keys.ENTER);

    }


    @Then("it should display all the related searches {string}")
    public void itShouldDisplayAllTheRelatedSearches(String arg0) {
        String text = homePage.getSearchItem().getText();
        Assert.assertTrue(text.contains(arg0));
    }


    @When("the user navigates to all section")
    public void theUserNavigatesToAllSection() {
        homePage.getSearchAll().click();

    }

    @Then("the user clicks on the books section")
    public void theUserClicksOnTheBooksSection() throws InterruptedException {
        Thread.sleep(1000);
        homePage.getSearchSellers().click();
        homePage.getSearchBooks().click();

    }

    @And("the user should be able to view the bestseller books")
    public void theUserShouldBeAbleToViewTheBestsellerBooks() {
       String text =  homePage.getSearchBestseller().getText();
        Assert.assertEquals(text,data.get("Status"));
    }
}
