package utilBeans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPageElements {
    WebDriver driver;

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

    }

    public void clickSubmit() {
        signUpButton.submit();
    }

    public void getUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void getEmail(String email) {
        emailField.sendKeys(email);
    }

    public void getPassword(String password) {
        passwordField.sendKeys(password + "!" + "A");
    }

}
