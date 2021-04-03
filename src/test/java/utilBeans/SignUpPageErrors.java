package utilBeans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPageErrors {

    public String errorTooLongUsername(WebDriver driver) {

        try {
            return new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//span[@class='invalid-error']"))).getAttribute("innerHTML");
        } catch (Exception e) {
            return null;
        }
    }

    public String takenUsername(WebDriver driver) {

        try {

            return new WebDriverWait(driver, 10).until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("span.invalid-error"))).getAttribute("innerHTML");
        } catch (Exception e) {
            return null;
        }
    }

    public WebElement errorEmail(WebDriver driver) {

        try {

            return (new WebDriverWait(driver, 9)).until(ExpectedConditions.visibilityOfElementLocated(By
                    .xpath("/html/body/div[2]/div[1]/div/main/div[2]/div/form/fieldset/div[1]/div/span")));
        } catch (Exception e) {
            return null;
        }
    }
}
