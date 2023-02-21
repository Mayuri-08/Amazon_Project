package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.HomePage;
import utils.BrowserManager;
import utils.QaProps;


public class StepDefinitions {
    private WebDriver driver;
    HomePage homePage;
    String url;
    public StepDefinitions(BrowserManager browserManager){
        this.driver = browserManager.getDriver();


    }
    @Given("the user navigates to home page")
    public void the_user_navigates_to_home_page() {
        homePage = new HomePage(driver);
        url = QaProps.getValue("url");
        driver.get(url);
        }

    @When("the user enters with the product")
    public void the_user_enters_with_the_product() {
       // homePage = new HomePage(driver);
        homePage.getSearchBox().sendKeys("mobiles");
        homePage.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("the user is able to view for a product")
    public void the_user_is_able_to_view_for_a_product() {
        String text = homePage.getSearchResult().getText();
        Assert.assertEquals(text,"\"mobiles\"");
    }

    @And("the user enters min Price")
    public void the_User_Enters_Min_Price() {
        homePage.getSearchMinPrice().sendKeys("20000");
    }

    @And("the user enters max Price")
    public void the_User_Enters_Max_Price() {
        homePage.getSearchMaxPrice().sendKeys("25000");
    }

    @Then("the user is able to view a product according to the range")
    public void the_User_Is_Able_To_View_A_Product_According_To_The_Range() {
        homePage.getGoButton().click();
    }

    @And("the user selects from the drop down feature")
    public void the_User_Selects_From_The_Drop_Down_Feature() {
        Select dropDown = new Select (homePage.getSelectFeature());
        dropDown.selectByIndex(3);
        dropDown.selectByVisibleText("Newest Arrivals");
    }

    @Then("the user is able to view a product as per selected feature")
    public void the_User_Is_Able_To_View_A_Product_As_Per_Selected_Feature() {
        String text = homePage.getViewResult().getText();
        Assert.assertEquals(text,"RESULTS");

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
    @Then("the item should be applied")
    public void theItemShouldBeApplied() {
       // String attribute = homePage.getSearchItem().getText();
      //  Assert.assertEquals(text,"\"t-shirt adidas\"");
      //  Assert.assertEquals(text,"\"t-shirt adidas\"");


    }


}
