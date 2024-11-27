package seleniumgluecode;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateuserTest extends TestBase {



    @Given("^desde el menu principal accede a configuracion y usuarios$")
    public void desde_el_menu_principal_accede_a_configuracion_y_usuarios() throws Throwable {
        driver.findElement(createuserPage.menuLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(createuserPage.configurationLocator));
        driver.findElement(createuserPage.configurationLocator).click();
        //si no es vacio, si el elemento si esta devuelve tru
        boolean isPresent = !driver.findElements(createuserPage.usersLocator).isEmpty();
        Assert.assertTrue("El elemento Users no esta presente en el DOM con el xpath"+createuserPage.usersLocator, isPresent);
        driver.get("https://qa2.tracking.mailamericas.com/users");
    }

    @When("^se da clic en el boton crear usuario$")
    public void se_da_clic_en_el_boton_crear_usuario() throws Throwable {
        driver.findElement(createuserPage.createuserLocator).click();
    }

    @When("^se llena el formulario email \"([^\"]*)\" y clave \"([^\"]*)\"$")
    public void se_llena_el_formulario_email_y_clave(String usu, String pass) throws Throwable {
        String randomLetters = generateRandomLetters(3);
        String emailact = usu+randomLetters+"@theegg.io";
        scenarioContext.setEmail(emailact);
        System.out.println("usuario Aduanas "+emailact);
        driver.findElement(createuserPage.firstnamecreateLocator).sendKeys("aduanas"+randomLetters);
        driver.findElement(createuserPage.lastnamecreateLocator).sendKeys("rol"+randomLetters);
        driver.findElement(createuserPage.emailcreateLocator).sendKeys(emailact);
        driver.findElement(createuserPage.passcreateLocator).sendKeys(pass);

    }

    @When("^se selecciona custom provider con provider serices de aduanas$")
    public void se_selecciona_custom_provider_con_provider_serices_de_aduanas() throws Throwable {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(createuserPage.rolLocator));
        driver.findElement(createuserPage.customproviderLocator).click();
        driver.findElement(createuserPage.proveedorselectLocator).click();
        driver.findElement(createuserPage.proveedorselectLocator).sendKeys(Keys.ENTER);
        driver.findElement(createuserPage.serviceproviderSelectLoctor).click();
        WebElement serviceProvider = wait.until(ExpectedConditions.elementToBeClickable(createuserPage.serviceproviderSelectLoctor));
        try {
            Thread.sleep(2000);
           // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", serviceProvider);
            serviceProvider.click();
            serviceProvider.click();

        } catch (Exception e) {
            // Si el clic es interceptado, usar JavaScript para hacer clic
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(createuserPage.serviceproviderSelectLoctor));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
        serviceProvider.sendKeys(Keys.ARROW_DOWN);
        serviceProvider.sendKeys(Keys.ENTER);
    }

    @When("^se dar click en submit$")
    public void se_dar_click_en_submit() throws Throwable {
        Thread.sleep(5000);
        WebElement debugBar = driver.findElement(By.className("phpdebugbar-header"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", debugBar);
        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

        driver.findElement(createuserPage.btnsubmituserLocator).click();
    }


    @Then("^se crea el usuario de rol aduanas con acceso a tracking$")
    public void se_crea_el_usuario_de_rol_aduanas_con_acceso_a_tracking() throws Throwable {
        WebElement textLocator = driver.findElement(createuserPage.textcratesuccesLocator);
        String text = textLocator.getText();
        System.out.println(text);
        Assert.assertEquals("Se Creo el Usuario Correctamente - Mensaje: "+text,"User created", text);
    }

    @Given("^digita usuario \"([^\"]*)\" y clave \"([^\"]*)\" validos rol aduanas$")
    public void digita_usuario_y_clave_validos_rol_aduanas(String usu, String pass) throws Throwable {
        String email = scenarioContext.getEmail();
        System.out.println("obtengo email:"+email);
        driver.findElement(createuserPage.emailcreateLocator).sendKeys(email);
        driver.findElement(createuserPage.passcreateLocator).sendKeys(pass);
        Thread.sleep(3000);
    }

    @Then("^el usuario visualiza los paquetes con ruta de aduanas$")
    public void el_usuario_visualiza_los_paquetes_con_ruta_de_aduanas() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^solo tiene acceso a administrar eventos AD de aduanas$")
    public void solo_tiene_acceso_a_administrar_eventos_AD_de_aduanas() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
