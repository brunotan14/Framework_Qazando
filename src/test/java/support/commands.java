package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import run.RunCucumberTest;
import java.time.Duration;

public class commands extends RunCucumberTest {
    public static void waitElementBeClickable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tempo));
        wait.until(ExpectedConditions.elementToBeClickable(element));  // Ou mude para presenceOfElementLocated se preferir
    }

    public static void waitElementBePresent(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tempo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));  // Ou mude para presenceOfElementLocated se preferir
    }

    public static void clickElement(By element){
        System.out.println("###################################");
        try {
            System.out.println("******** Vai clicar no elemento" + element);
            waitElementBePresent(element, 10);
            getDriver().findElement(element).click();
            System.out.println("******** Clicou no elemento" + element);
        } catch(Exception error){
            System.out.println("********** Erro ao clicar no elemento.");
            System.out.println(error);
        }
        System.out.println("######################################");
    }


    public static void fillField(By element, String value){
        System.out.println("###################################");
        try {
            System.out.println("******** Vai preencher o campo" + element);
            waitElementBePresent(element, 10);
            getDriver().findElement(element).sendKeys(value);
            System.out.println("******** preenceu o campo" + element);
        } catch(Exception error){
            System.out.println("********** Erro ao preencher o campo" + element);
            System.out.println(error);
        }
        System.out.println("######################################");
    }

    public static void checkMessage(By element,String expectedMessage){
        String actualMessage = "";
        try{
            System.out.println("******* Procurando pela mensagem");
            waitElementBePresent(element, 15);
            actualMessage = getDriver().findElement(element).getText();
            Assert.assertEquals(expectedMessage, actualMessage);
            System.out.println("******* Mensagem:" + expectedMessage + " validada com sucesso!");
        } catch(Exception error){
            System.out.println("******** Aconteceu um erro ao validar mensagem");
            System.out.println("******** Mensagem esperada: " + expectedMessage);
            System.out.println("******** Mensagem atual:" + actualMessage);
            System.out.println(error);
            error.printStackTrace();


            // ⚠️ Importante: relança o erro, para o @After tirar o print
            throw new AssertionError("Falha ao validar mensagem: " + expectedMessage, error);

        }
    }


}
