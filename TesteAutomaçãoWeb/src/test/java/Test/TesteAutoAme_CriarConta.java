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
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TesteAutoAme_CriarConta {

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
    public void criarConta(){

        navegador.findElement(By.xpath("//a[@class='login']")).click();
        navegador.findElement(By.xpath("//input[@id='email_create']")).sendKeys("teste"+Integer.toString(id)+"@ame.com.br");
        navegador.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

        navegador.findElement(By.xpath("//input[@id='id_gender1']")).click();
        navegador.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Teste");
        navegador.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Teste");
        navegador.findElement(By.xpath("//input[@id='passwd']")).sendKeys("teste123");

        Select dia = new Select(navegador.findElement(By.xpath("//select[@id='days']")));
        dia.selectByValue("11");
        Select mes = new Select(navegador.findElement(By.xpath("//select[@id='months']")));
        mes.selectByValue("6");
        Select ano = new Select(navegador.findElement(By.xpath("//select[@id='years']")));
        ano.selectByValue("1995");

        navegador.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Teste");
        navegador.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Teste");
        navegador.findElement(By.xpath("//input[@id='address1']")).sendKeys("Rua Teste, 42");
        navegador.findElement(By.xpath("//input[@id='city']")).sendKeys("Cidade Teste");

        Select estado = new Select(navegador.findElement(By.xpath("//select[@id='id_state']")));
        estado.selectByValue("1");

        navegador.findElement(By.xpath("//input[@id='postcode']")).sendKeys("12345");

        Select pais = new Select(navegador.findElement(By.xpath("//select[@id='id_country']")));
        pais.selectByValue("21");

        navegador.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("999999999");
        navegador.findElement(By.xpath("//input[@id='alias']")).sendKeys("Teste");

        navegador.findElement(By.xpath("//button[@id='submitAccount']")).click();

        //Validar que acessou a página "MY ACCOUNT"
        String validar = navegador.findElement(By.xpath("//h1")).getText();
        assertEquals("MY ACCOUNT", validar);

    }

    @After
    public void tearDown(){
       navegador.quit();
    }
}
