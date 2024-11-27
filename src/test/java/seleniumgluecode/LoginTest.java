package seleniumgluecode;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTest extends TestBase {

    @Given("^que el usuario abre el aplicativo por primera vez accediendo al login$")
    public void que_el_usuario_abre_el_aplicativo_por_primera_vez_accediendo_al_login() throws Throwable {//driver.findElement(By.name("email")).sendKeys("miemail@gmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.emailLocator));
        String tituloPagina = driver.getTitle();
        Assert.assertEquals("el titulo no es: Sign in | MailAmericas" + " - Se recibio este titulo: "+tituloPagina,
                "Sign in | MailAmericas", tituloPagina);
    }

    @When("^digita usuario \"([^\"]*)\" y clave \"([^\"]*)\" validos$")
    public void digita_usuario_y_clave_validos(String email, String pass) throws Throwable {
        driver.findElement(loginPage.emailLocator).sendKeys(email);
        driver.findElement(loginPage.passlLocator).sendKeys(pass);
    }

    @When("^dar click en el boton login$")
    public void dar_click_en_el_boton_login() throws Throwable {
        driver.findElement(loginPage.enviarLocator).click();
    }

    @Then("^se abre pantalla home dashboard del aplicativo con accesos segun su perfil$")
    public void se_abre_pantalla_home_dashboard_del_aplicativo_con_accesos_segun_su_perfil() throws Throwable {
        String tituloPagina = driver.getTitle();
        Assert.assertEquals("el titulo no es: Packages | MailAmericas" + " - Se recibio este titulo: "+tituloPagina,
                "Packages | MailAmericas", tituloPagina);
    }


}
