package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import run.RunCucumberTest;

import static support.commands.*;


public class LoginPage extends RunCucumberTest {
    private String URL = "https://www.automationpratice.com.br/";
    private By inputName = By.id("user");
    private By inputPassword = By.id("password");
    private By loginacess = By.className("fa-user");
    private By loginsubmitt = By.id("btnLogin");

    public void enterQazando(){
        String browser = System.getProperty("browser"); // passagme do browser no modo headless como parametro
        getDriver(browser).get(URL);
    }
    public void LoginAcess(){
      clickElement(loginacess);
    }

    public void enterinformations(String usuario, String senha){
       fillField(inputName, usuario);
       fillField(inputPassword, senha);
    }

    public void Scrooll() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver; // o selenium permite rodar códigos Js direto no navegador, e aqui trasnformamos o driver em um executor Js para mandar comandos JS
        jse.executeScript("window.scrollTo(0,10000)"); // 0 é o eixo horizontal, significa que não irá mover na horizontal e 10000 é o eixo  vertical, faz a página rolar para baixo, garantindo que o campo esteja visível
        Thread.sleep(2000);
    }
    public void loginsubmit(){
        clickElement(loginsubmitt);
    }

    public void LoginSucessCheck(){
          checkMessage(By.id("swal2-title"), "Login realizado");
    }
    public void LoginErrorCheck(String message){
       checkMessage(By.className("invalid_input"), message);
    }
}
