package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import utils.BrowserManager;



public class StepDefinitions {
    private WebDriver driver;
    HomePage homePage;
    public StepDefinitions(BrowserManager browserManager){
        this.driver = browserManager.getDriver();


    }
    @Given("the user navigates to home page.")
    public void the_user_navigates_to_home_page() {
        driver.get("https://www.amazon.in/");



    }
    @When("the user enters with the product.")
    public void the_user_enters_with_the_product()  {
        // Write code here that turns the phrase above into concrete actions
        homePage = new HomePage(driver);
        homePage.getSearchBox().sendKeys("mobiles");
        homePage.getSearchBox().sendKeys(Keys.ENTER);



    }
    @Then("the user  is able to view for a product.")
    public void the_user_is_able_to_view_for_a_product() throws InterruptedException {
        Write code here that turns the phrase above into concrete actions
       String text = homePage.getSearchResult().getText();
       Assert.assertEquals(text,"\"mobiles\"");


    }

}
