package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static stepdefs.ServiceHooks.*;

public class StepDefinitions {

    @Given("^I am on the .*page on URL \"([^\"]*)\"$")
    public void i_am_on_the_page_on_URL(String url) {
        driver.get(url);
    }

    @When("^I Navigate to .*(\\d+).* content in the popular news$")
    public void iNavigateToNthPopularNews(int n) {
        home.openNthNews(n);
    }


    @Then("^I should see the browser title is the same with the news title$")
    public void iShouldSeeBrowserTitleIsSameWithNewsTitle() {
        Assert.assertEquals(news.getNewsTitle(), news.getBrowserTitle(), "I CAN'T see the browser title is the same with the news title");
    }

    @And("^I should see the content has an author$")
    public void iShouldSeeTheContentHasAnAuthor()  {
        Assert.assertTrue(news.newsHasAuthor());
    }

    @And("^I should see the news has an image$")
    public void iShouldSeeTheNewsHasAnImage() throws Throwable {
        Assert.assertTrue(news.newsHasImage());

    }
}
