package steps;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginPage;
import run.RunCucumberTest;
import support.ScreenshotUtils;

public class Login_steps extends RunCucumberTest {
      LoginPage driver = new LoginPage(); //funciona como uma importação do arquivo da Page, crio um objeto para poder utilizar os métodos da page

      @Dado("que eu estou no site da qazando")
       public void acessQazando(){ driver.enterQazando(); }

      @E("acesso a área de login")
        public void loginacess(){ driver.LoginAcess();}

      @Quando("eu preencho minhas credenciais {string} {string}")
        public void enterInformations(String user, String senha){
          driver.enterinformations(user, senha);
      }

      @E("clico em Login")
      public void submittlogin(){
          driver.loginsubmit();
      }

      @Então("vejo mensagem de login realizado com sucesso")
        public void SucessLogin(){
           driver.LoginSucessCheck();
      }

      @Então("vejo mensagem {string} de error")
      public void checkError(String message){
            driver.LoginErrorCheck(message);
      }

      @After
     public void TakeScreenshot(Scenario scenario){
          System.out.println("===============================");
          System.out.println("******** TakeScreenshot: " + scenario.getName());
          System.out.println("******** TakeScreenshot: " + scenario.getStatus());
          System.out.println("******** TakeScreenshot: " + scenario.getSourceTagNames());
          System.out.println("=================================");

          if(scenario.isFailed()){
              ScreenshotUtils.addScreenshot(scenario);
          }
      }
}
