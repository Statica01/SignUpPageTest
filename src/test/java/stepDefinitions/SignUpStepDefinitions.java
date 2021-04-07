package stepDefinitions;

import drivers.DriverCreator;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilBeans.SignUpPageElements;
import utilBeans.SignUpPageErrors;
import utilBeans.SignUpTextUtils;

public class SignUpStepDefinitions {

    private WebDriver driver;
    private SignUpPageElements signUpPageElements;
    SignUpPageErrors signUpPageErrors = new SignUpPageErrors();
    SignUpTextUtils signUpTextUtils = new SignUpTextUtils();

    @Given("I open up {string} as browser")
    public void i_have_used_as_browser(String browser) {

        DriverCreator creator = new DriverCreator();
        driver = creator.createDriverBrowser(browser);
        signUpPageElements = PageFactory.initElements(driver, SignUpPageElements.class);
    }

    @And("Navigate to Sign up page")
    public void navigate_to_sign_up_page() {

        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();
        System.out.println("Before ... Opening SignUp page");
    }

    @And("I enter {string} into the email form field")
    public void i_enter_email_into_the_email_form_field(String email) {

        if (email.equals("")) {
            signUpPageElements.getEmail(email);

        } else {
            signUpPageElements.getEmail(email + signUpTextUtils.generateRandomInt() + "@mail.com");
        }
    }

    @And("enter {string} into the username form field")
    public void enter_username_into_the_username_form_field(String username) {
        //set username longer than 102 characters
        String signUpUsernameBeans = signUpTextUtils.generateRandomString(102);

        switch (username) {
            case "username" -> signUpPageElements.getUsername(username + signUpTextUtils.generateRandomInt());
            case "tooLongUsername" -> signUpPageElements.getUsername(username + signUpUsernameBeans);
            case "takenUsername" -> signUpPageElements.getUsername(username);
        }
    }

    @And("enter {string} into the password form field")
    public void enter_password_into_the_password_form_field(String password) {

        signUpPageElements.getPassword(password);
    }

    @When("I click on the signUp button")
    public void i_click_on_the_signUp_button() {

        signUpPageElements.submitButton();

    }

    @Then("I should either fail or successfully be signed up")
    public void i_should_either_fail_or_successfully_be_signed_up() {

        String successPath = driver.getTitle();

        if (successPath.equals("Success | Mailchimp")) {
            Assert.assertEquals("Success | Mailchimp", successPath);
            System.out.println("Success");

        } else if (signUpPageErrors.errorEmail(driver) != null) {

            System.out.println("no-email-error");
            Assert.assertEquals("Please enter a value", signUpPageErrors.errorEmail(driver).getText());

        } else if (signUpPageErrors.errorTooLongUsername(driver).equals("Enter a value less than 100 characters long")) {

            System.out.println("too-Long-Username");
            Assert.assertEquals("Enter a value less than 100 characters long", signUpPageErrors.errorTooLongUsername(driver));

        } else if (signUpPageErrors.takenUsername(driver) != null) {

            System.out.println("taken-username");
            Assert.assertEquals("Another user with this username already exists. Maybe it's your evil twin. Spooky.", signUpPageErrors.takenUsername(driver));

        } else {
            System.out.println("some-other-error");
        }
    }

    @After
    public void exit() {

        System.out.println("After List is done ...");
        driver.quit();
    }

}

