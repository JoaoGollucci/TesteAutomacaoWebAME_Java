package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TesteAutoAme_EmailBranco {

    WebDriver navegador;
    Random rand = new Random();
    int id = rand.nextInt(9999);

    @Before
    public  void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize(); //Maximizar a tela
        //Parametrização para abrir o navegador chrome
        navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //Adicionando um delay de espera
        navegador.get("http://automationpractice.com/index.php"); //Abrir URL
    }

    @Test
    public void emailBranco(){

        navegador.findElement(By.xpath("//a[@class='login']")).click();
        navegador.findElement(By.xpath("//button[@id='SubmitLogin']")).click();

        //Validar mensagem de erro"
        String validar = navegador.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
        assertEquals("An email address required.", validar);

    }

    @After
    public void tearDown(){
        navegador.quit();
    }
}
