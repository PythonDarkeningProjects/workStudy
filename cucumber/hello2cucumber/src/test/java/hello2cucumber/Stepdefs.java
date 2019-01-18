package hello2cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;


class IsItDecember {
    static String IsItDecember(String month){
        if (month.equals("december")) {
            return "merrychristmas";
        }
        return "nope";
    }
}

public class Stepdefs {
    private String month;
    private String currentMonth;

    @Given("^This month is \"([^\"]*)\"$")
    public void this_month_is(String month) {
        this.month = month;
    }

    @When("^The folks ask if this month is December$")
    public void the_folks_ask_if_this_month_is_december(){
        currentMonth = IsItDecember.IsItDecember(month);
    }

    @Then("^I have to said \"([^\"]*)\"$")
    public void i_have_to_said(String expectedMonth) {
        assertEquals(currentMonth, expectedMonth);
    }
}