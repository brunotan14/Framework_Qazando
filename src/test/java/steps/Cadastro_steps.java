package steps;


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import run.RunCucumberTest;
import pages.CadastroPage;
import support.ScreenshotUtils;

public class Cadastro_steps extends RunCucumberTest {
    CadastroPage cadastroPage = new CadastroPage(); // criação de um objeto das pages para utilizar os métodos dela.


    @Dado("que eu estou no site da qazando na página de cadastro")
    public void acessQazando(){ cadastroPage.acessite(); }

    @Quando("preencho meu nome {string}, email {string} e senha {string}")
    public void fillcredencials(String user, String email, String password){
           cadastroPage.fillCredencials(user, email, password);
    }

    @E("clico em registrar")
     public void submitRegister() throws InterruptedException {
        cadastroPage.ScroolDown();
        cadastroPage.submitRegister();
    }

    @Então("vejo a mensagem de cadastro com sucesso")
    public void CheckRegister(){
        cadastroPage.messageSucess();
    }

    @Então("vejo a mensagem {string} de dados inválidos")
    public void ErroMessage(String message){
        cadastroPage.messageError(message);
    }

    @After //sempre que terminar um cenário, seja com sucesso ou erro, vai chamar esse after
    public void takeScreenshot(Scenario scenario) {
        System.out.println("===========================");
        System.out.println("Teste que falhou: " + scenario.getName() );
        System.out.println("Status: " + scenario.getStatus());
        System.out.println("Tags que foram testadas: " + scenario.getSourceTagNames());
        System.out.println("===========================");

        if(scenario.isFailed()){
            //tirar print da tela
            ScreenshotUtils.addScreenshot(scenario);
        }
    }
}
