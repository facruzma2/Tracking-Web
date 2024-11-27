package seleniumgluecode;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.CreateuserPage;
import pom.LoginPage;
import java.time.Duration;
import java.util.Random;


public class TestBase {
    Duration segundos = Duration.ofSeconds(30);
    protected WebDriver driver = Hooks.getDriver();
    //private WebDriver driver = Hooks.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,segundos);
    //Se instacian los objetos de las paginas
    protected LoginPage loginPage = new LoginPage(driver);
    protected CreateuserPage createuserPage = new CreateuserPage(driver);
    //se llama o inicializa el contexto para utilizarlo en todos los escenarios
    protected static ScenarioContext scenarioContext = new ScenarioContext();

    public static String generateRandomLetters(int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            randomString.append(alphabet.charAt(index));
        }

        return randomString.toString();
    }
}
