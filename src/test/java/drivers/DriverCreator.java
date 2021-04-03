package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverCreator {

    private WebDriver driver;

    public WebDriver createDriverBrowser(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("Chrome-browser");
        } else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Selenium\\msedgedriver.exe");
            driver = new EdgeDriver();
            System.out.println("Edge-browser");
        } else {
            System.out.println("can't find browser type, do you have the browser installed?");
        }

        return driver;
    }
}
