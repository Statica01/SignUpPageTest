package stepDefinitions;

import drivers.DriverCreator;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilBeans.SignUpPageElements;
import utilBeans.SignUpTextUtils;

import java.util.concurrent.TimeUnit;

public class SignUpStepDefinitions {


    public static long implicitWait = 10;
    private WebDriver driver;
    private SignUpPageElements signUpPageElements;

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

    @When("I enter {string} into the email form field")
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
        driver.manage().timeouts().implicitlyWait(SignUpStepDefinitions.implicitWait, TimeUnit.SECONDS);
    }

    @When("I click on the signUp button")
    public void i_click_on_the_signUp_button() {

        signUpPageElements.clickSubmit();
    }

    @Then("I should either fail or successfully be signed up")
    public void i_should_either_fail_or_successfully_be_signed_up() {
    }

    @After
    public void exit() {

        System.out.println("After List is done ...");
        driver.quit();
    }
}

