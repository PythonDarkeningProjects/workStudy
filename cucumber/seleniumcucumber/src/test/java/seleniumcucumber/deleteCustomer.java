package seleniumcucumber;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.After;

public class deleteCustomer {

    private Alert alert;
    private final WebDriver driver;

    public deleteCustomer() {
        System.setProperty("webdriver.chrome.driver", "/home/hiperezr/selenium/chromedriver");
        // adding headless mode to Chrome
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("/usr/bin/google-chrome");
        chromeOptions.addArguments("--headless");
        // instantiating the variable
        driver = new ChromeDriver(chromeOptions);
    }

    @Given("I am on Guru site")
    public void i_am_on_guru_site(){
        driver.get("http://demo.guru99.com/test/delete_customer.php");
    }
    @When("I enter a customer id \"(.*)\"$")
    public void i_enter_a_customer_id(String customer){
        // Sent a custom customer
        WebElement element = driver.findElement(By.name("cusid"));
        element.sendKeys(customer);
        // Click the submit button
        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.submit();
    }

    @Then("An alert will appears")
    public void the_alert_must_be_accepted(){
        this.alert = driver.switchTo().alert();
    }

    @And("The alert should shows \"(.*)\"$")
    public void the_alert_should_shows(String expectedMessage){
        String message = alert.getText();
        Assert.assertEquals("The POP UP is different", expectedMessage, message);
    }

    @And("I perform the action \"(.*)\"$")
    public void i_submit_ok_button(String action){
        if (action.equals("OK")) {
            alert.accept();
        }
        else {
            alert.dismiss();
        }
    }

    @After()
    public void closeBrowser(){
        driver.quit();
    }
}