package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import support.Utils;


import static support.commands.*;

public class CadastroPage extends Utils {
    LoginPage loginPage = new LoginPage();

    private By inputname = By.id("user");
    private By inputEmail = By.id("email");
    private By inputPassword = By.id("password");
    private By submit = By.id("btnRegister");
    private By registerArea1 = By.className("fa-lock");

    public void acessite(){
        loginPage.enterQazando();
        clickElement(registerArea1);
    }

    public void fillCredencials(String name, String email, String password){
         fillField(inputname, name);
         fillField(inputEmail, email);
         fillField(inputPassword, password);
    }

    public void ScroolDown() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver; // o selenium permite rodar códigos Js direto no navegador, e aqui trasnformamos o driver em um executor Js para mandar comandos JS
        jse.executeScript("window.scrollTo(0,10000)"); // 0 é o eixo horizontal, significa que não irá mover na horizontal e 10000 é o eixo  vertical, faz a página rolar para baixo, garantindo que o campo esteja visível
        Thread.sleep(2000);
    }


    public void submitRegister(){
        clickElement(submit);
    }

    public void messageSucess(){
       checkMessage(By.id("swal2-title"), "Cadastro realizado!");
    }

    public void messageError(String message){
      checkMessage(By.className("errorLabel"), message);
    }
}

//primeiro passo a se fazer ao iniciar o POM
// Page Objects Model, é criar o construtor que é o cara que vai receber o driver
