package Test;

import static org.junit.Assert.*; //Importação estática, tira a necessiddade de "apontar" para a classe

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TesteAutoAme {

    WebDriver navegador;

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
    public void criarConta(){

        navegador.findElement(By.xpath("//a[@class='login']")).click();

        //navegador.findElement(By.name("vivo_login_username")).sendKeys("034.011.518-19");

        //navegador.findElement(By.name("vivo_login_password")).sendKeys("110695");

    }

    @After
    public void tearDown(){
       //navegador.quit();
    }
}
