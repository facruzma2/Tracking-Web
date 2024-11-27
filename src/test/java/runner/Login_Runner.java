package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/InicioSesion/Login.feature",
        glue = ("seleniumgluecode"),
        plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:resources/cucumber-report/tk_Login.html"},
        tags = {"@smoke"}
)
public class Login_Runner {
}
