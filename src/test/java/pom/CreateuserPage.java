package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CreateuserPage {
    public WebDriver driver;
    public WebDriverWait wait;
    Duration segundos = Duration.ofSeconds(30);


    //localizadores
    public By menuLocator = By.xpath("(//a[contains(.,'Menu')])[1]");
    public By configurationLocator = By.xpath("//a[contains(.,'Configuration')]");
    public By usersLocator = By.xpath("//*[@id=\"page-wrapper\"]/div[1]/nav/div/div/nav/ul/li[6]/ul/li[29]/a");
    public By createuserLocator = By.xpath("//a[contains(.,'Create User')]");
    public By emailcreateLocator = By.name("email");
    public By firstnamecreateLocator = By.name("first_name");
    public By lastnamecreateLocator = By.name("last_name");
    public By passcreateLocator = By.name("password");
    public By rolLocator = By.id("roles");
    public By customproviderLocator = By.xpath("//label[contains(.,'Customs Provider')]");
    public By proveedorselectLocator = By.xpath("//*[@id=\"customs_provider_id_div\"]/span/span[1]/span");
    public By btnsubmituserLocator = By.id("submit");
    public By serviceproviderSelectLoctor = By.xpath("//*[@id=\"provider_service_customs_provider_id_div\"]/span/span[1]/span");
    public By textcratesuccesLocator = By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div");

    public CreateuserPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,segundos);

    }

}

