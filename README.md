# 🧪 Projeto de Automação de Testes Funcionais — Automation Practice

Este projeto tem como objetivo automatizar testes funcionais no site [Automation Practice](https://www.automationpratice.com.br/), simulando fluxos de **cadastro de utilizadores** e **login**, aplicando boas práticas de automação, organização de código e metodologia **BDD (Behavior Driven Development)**.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia             | Descrição |
|------------------------|------------|
| **Java 24**            | Linguagem principal de desenvolvimento |
| **Selenium WebDriver** | Framework de automação de aplicações web |
| **Cucumber**           | Ferramenta que implementa o padrão BDD |
| **Gherkin**            | Linguagem usada para descrever os cenários de teste |
| **JUnit**              | Executor dos testes automatizados |
| **Maven**              | Gerenciador de dependências e build |
| **IntelliJ IDEA**      | IDE utilizada para desenvolvimento e execução dos testes |

---

## 🧱 Estrutura do Projeto

Test_Selenium/
│
├── src/
│ └── test/
│ ├── java/
│ │ ├── pages/ # Páginas do sistema mapeadas (Page Object Model)
│ │ │ ├── CadastroPage.java
│ │ │ └── LoginPage.java
│ │ │
│ │ ├── run/ # Configurações de execução e runners do Cucumber
│ │ │ ├── RunBase.java
│ │ │ └── RunCucumberTest.java
│ │ │
│ │ ├── steps/ # Implementações dos passos (Step Definitions)
│ │ │ ├── Cadastro_steps.java
│ │ │ └── Login_steps.java
│ │ │
│ │ └── support/ # Classes de suporte e comandos reutilizáveis
│ │ ├── commands/
│ │ └── Utils.java
│ │
│ └── resources/
│ └── features/ # Cenários de teste escritos em Gherkin
│ ├── cadastro.feature
│ └── login.feature
│
├── pom.xml # Configuração Maven (dependências)
├── .gitignore
└── README.md


---

## 🧩 Metodologia BDD (Behavior Driven Development)

A metodologia **BDD** foi utilizada para criar testes legíveis e compreensíveis por toda a equipa (QA, devs e negócio), seguindo o formato:

Dado (Given) → Pré-condições do cenário
Quando (When) → Ações realizadas pelo utilizador
Então (Then) → Resultados esperados

---

## 📘 Exemplo — Cenários de Cadastro

```gherkin
Funcionalidade: Cadastro de utilizadores

  Esquema do Cenário: Validar cadastro com dados inválidos "<name>"
    Quando preencho meu nome "<nome>", email "<email>" e senha "<senha>"
    E clico em registrar
    Então vejo a mensagem "<mensagem>"

    Exemplos:
      | name                  | nome       | email             | senha   | mensagem                                      |
      | Nome vazio            |             | teste@email.com   | 123456  | O campo nome deve ser prenchido              |
      | Email inválido        | João Silva  | testeemail.com    | 123456  | O campo e-mail deve ser prenchido corretamente |
      | Senha curta           | Maria Lima  | maria@teste.com   | 12345   | O campo senha deve ter pelo menos 6 dígitos  |

🟢 Cenários de Cadastro com Sucesso
Funcionalidade: Cadastro com sucesso

  Esquema do Cenário: cadastro bem-sucedido
    Quando preencho meu nome "<nome>", email "<email>" e senha "<senha>"
    E clico em registrar
    Então vejo a mensagem de cadastro com sucesso

    Exemplos:
      | nome          | email                      | senha       |
      | João Almeida  | joao.almeida@gmail.com     | senha123    |
      | Ana Souza     | ana.souza@outlook.pt       | Ana@2025    |
      | Tiago Mendes  | tiago.mendes@empresa.co    | Tiago#123   |

🔐 Cenários de Login
🚫 Login Inválido

Login com e-mail incorreto

Login com senha incorreta

Login com campos vazios

✅ Login com Sucesso
Funcionalidade: Login do utilizador

  Cenário: Login com sucesso
    Dado que estou na página de login
    Quando insiro um email e senha válidos
    E clico em entrar
    Então devo ser redirecionado para a página inicial

⚙️ Execução dos Testes
💻 Via IntelliJ IDEA

Abrir o projeto no IntelliJ.

Executar o ficheiro RunCucumberTest.java.

Verificar o resultado no console ou no relatório HTML.

🧩 Via Maven (Terminal)
Para visualizar as execuções: mvn test -Dtest=RunCucumberTest -Dbrowser=chrome  
Para rodar no modo Headless: mvn test -Dtest=RunCucumberTest -Dbrowser=chrome-ci

Caso prefira testar as execuções no firefox, só trocar o chrome pelo firefox.


📊 Relatórios de Teste

Após a execução dos testes, o relatório HTML é gerado automaticamente na pasta:
mvn test cluecumber:report-reporting

target/cucumber-reports/index.html(onde o relátorio é gerado)

🔍 Como abrir o relatório no IntelliJ:

Navegar até target/cucumber-reports/index.html

Clicar com o botão direito → Open in Browser → Chrome (ou outro navegador)

🧱 Padrão de Projeto — Page Object Model (POM)

O projeto segue o padrão Page Object Model, que facilita a manutenção e reutilização de código.
Cada página do site possui uma classe própria que mapeia os elementos e ações.

Exemplo simplificado:

public class LoginPage {
    private By campoEmail = By.id("email");
    private By campoSenha = By.id("passwd");
    private By botaoLogin = By.id("SubmitLogin");

    public void preencherEmail(String email) {
        getDriver().findElement(campoEmail).sendKeys(email);
    }

    public void preencherSenha(String senha) {
        getDriver().findElement(campoSenha).sendKeys(senha);
    }

    public void clicarLogin() {
        getDriver().findElement(botaoLogin).click();
    }
}

🧠 Boas Práticas Implementadas

Utilização de esperas explícitas (WebDriverWait)

Tratamento de exceções com logs informativos

Métodos reutilizáveis em Utils.java

Estrutura modular e escalável

Separação clara entre camadas (pages, steps, support)

Uso de Cucumber Tags para organizar execuções (ex: @cadastro, @login)

🧾 Comandos ùteis
Comando	Função
mvn clean	Limpa os relatórios e builds antigos
mvn test	Executa todos os cenários configurados
mvn test -Dcucumber.filter.tags="@cadastro"	Executa apenas os testes marcados com a tag @cadastro
🧰 Dependências Principais (pom.xml)
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.21.0</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.15.0</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>7.15.0</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.vintage</groupId>
        <artifactId>junit-vintage-engine</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>

👨‍💻 Autor

Bruno Nathan — QA | Analista de Testes 
🔗 Projeto desenvolvido para fins educacionais e de prática em automação de testes com BDD.
💬 Tecnologias: Java · Selenium · Cucumber · Gherkin · Maven · Github Actions