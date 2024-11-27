package seleniumgluecode;

import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.openqa.selenium.*;
import runner.browser_manager.DriverManager;
import runner.browser_manager.DriverManagerFactory;
import runner.browser_manager.DriverType;
;

import java.io.File;
import java.io.IOException;

public class Hooks {


    private static WebDriver driver;
    private DriverManager driverManager;
    static String urlTakingQa2 = "https://qa2.tracking.mailamericas.com/";

    @Before
    public void setUp(){
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(urlTakingQa2);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            try {
                TakesScreenshot camera = (TakesScreenshot) driver;
                File capturaPantalla = camera.getScreenshotAs(OutputType.FILE);
                //se escoge la opcion de Files (www.google.io)
                Files.move(capturaPantalla, new File("resources/CapturasPantalla/"+scenario.getName()+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    //Este metodo se puede llamar para que cree una captura de pantalla en ese punto donde se llama la función
    static void capturaDePantalla(String nomImage){
        try {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File capturaPantalla = camera.getScreenshotAs(OutputType.FILE);
            //se escoge la opcion de Files (www.google.io)
            Files.move(capturaPantalla, new File("resources/CapturasPantalla/"+nomImage));
        }catch (IOException e){
             e.printStackTrace();
        }
    }

}
