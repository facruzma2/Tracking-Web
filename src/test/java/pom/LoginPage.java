package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {
    public WebDriver driver;
    public WebDriverWait wait;
    Duration segundos = Duration.ofSeconds(30);


    //localizadores
    public By emailLocator = By.name("email");
    public By passlLocator = By.name("password");
    public By enviarLocator = By.xpath("//button[contains(.,'Sign In')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,segundos);

    }


}
