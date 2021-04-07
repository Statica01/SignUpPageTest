package utilBeans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPageElements {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "create-account")
    private WebElement signUpButton;

    @FindBy(id = "new_username")
    private WebElement usernameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "new_password")
    private WebElement passwordField;

    public SignUpPageElements(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void getUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void getEmail(String email) {
        emailField.sendKeys(email);
    }

    public void getPassword(String password) {
        passwordField.sendKeys(password + "3A!");
    }

    public void submitButton() {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).submit();
    }
}


