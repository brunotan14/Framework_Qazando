#language: pt

  @login
  Funcionalidade: Login de usuários
    Eu como cliente
    Quero acessar o site da qazando
    Para realizar uma compra

   Contexto: Acessar site
     Dado que eu estou no site da qazando
     E acesso a área de login

    @Login_sucess
    Cenário: Login com sucesso
      Quando eu preencho minhas credenciais "user@gmail.com" "user123456"
      E clico em Login
      Então vejo mensagem de login realizado com sucesso


   @login_credenciais_inválidas
   Esquema do Cenário: Validar Login: "<nome>"
     Quando eu preencho minhas credenciais "<email>" "<senha>"
     E clico em Login
     Então vejo mensagem "<message>" de error

   Exemplos:
     | email          | senha     | message          | nome                            |
     |                | 123456    | E-mail inválido. | Login campo email vazio         |
     | 123@.com       | 123456    | E-mail inválido. | Login campo email despadronizado|
     |user@gmail.com  |           | Senha inválida.  | Login campo senha vazio.        |
     |user@hotmail.com| 123       | Senha inválida.  | Login campo senha menor que 6   |
     |                |           | E-mail inválido. | Login campos vazios             |

