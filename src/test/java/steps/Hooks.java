package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserManager;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Hooks {

    private BrowserManager browserManager;
    public Hooks(BrowserManager browserManager){
        this.browserManager = browserManager;


    }
    @Before
    public void setUp(){
        browserManager.setDriver();


    }
   // @After
   // public void tearDown(){
     //   browserManager.getDriver().quit();

   // }
}
