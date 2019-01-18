package seleniumcucumber;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Facebookfeatures {

    private final WebDriver driver;

    public Facebookfeatures() {
        System.setProperty("webdriver.chrome.driver", "/home/hiperezr/selenium/chromedriver");
        // adding headless mode to Chrome
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("/usr/bin/google-chrome");
        chromeOptions.addArguments("--headless");
        // instantiating the variable
        driver = new ChromeDriver(chromeOptions);
    }

    @Given("^I am on the Facebook page$")
    public void i_am_on_the_facebook_page() {
        driver.get("https://www.facebook.com");
    }

    @When("^I put my email \"(.*)\"$")
    public void i_put_my_email(String email) {
        WebElement email_field = driver.findElement(By.id("email"));
        // Enter something to search for
        email_field.sendKeys(email);
    }

    @And("^I put my password \"(.*)\"$")
    public void i_put_my_password(String password) {
        WebElement password_field = driver.findElement(By.id("pass"));
        // Enter something to search for
        password_field.sendKeys(password);
        // Now submit the form.
        // WebDriver will find the form for us from the element
        password_field.submit();
    }

    @Then("^The page title should start with the following \"(.*)\"$")
    public void the_page_title_should_start_with(String titleStartsWith) {
        // Google's search is rendered dynamically with JavaScript
        // Wait for the page to load timeout after ten seconds
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(titleStartsWith);
            }
        });
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}