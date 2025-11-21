#language: pt

Funcionalidade: Cadastro de usuário
    Eu usuário da web
    Quero me cadastrar no site da qazando
    Para acessar o site quando necessário

   Contexto: Acessar o site
   Dado que eu estou no site da qazando na página de cadastro


   @Cadastro_invalidos
   Esquema do Cenário: Validar cadastro: "<name>"
     Quando preencho meu nome "<nome>", email "<email>" e senha "<senha>"
     E clico em registrar
     Então vejo a mensagem "<mensagem>" de dados inválidos

     Exemplos:
       | name                            | nome       | email               | senha    | mensagem                                        |
       | Nome vazio                      |             | teste@email.com    | 123456   | O campo nome deve ser prenchido                 |
       | Email inválido (despadronizado) | João Silva | testeemail.com      | 123456   | O campo e-mail deve ser prenchido corretamente  |
       | Email vazio                     | Maria Lima  |                    | 123456   | O campo e-mail deve ser prenchido corretamente  |
       | Senha vazia                     | Pedro Costa | pedro@email.com    |          | O campo senha deve ter pelo menos 6 dígitos     |
       | Senha com menos de 6 dígitos    | Ana Souza   | ana@email.com      | 12345    | O campo senha deve ter pelo menos 6 dígitos     |


     @cadastro_sucesso
     Esquema do Cenário: cadastro com sucesso: "<testenome>"
       Quando preencho meu nome "<nome>", email "<email>" e senha "<senha>"
       E clico em registrar
       Então vejo a mensagem de cadastro com sucesso

       Exemplos:
         | nome              | email                     | senha         | testenome    |
         | João Almeida      | joao.almeida@gmail.com    | senha123      | Caso 1       |
         | Maria Fernandes   | maria.fernandes@outlook.pt| M@ria2025     | Caso 2       |
         | Pedro Silva       | pedro_silva@yahoo.com     | P3dr0#abc     | Caso 3       |
         | Ana Carvalho      | ana.carvalho@empresa.co   | Ana@2024!     | Caso 4       |
         | Tiago Sousa       | tiago.sousa@mail.com      | T1ag0s2025    | Caso 5       |
         | Carla Mendes      | carla.mendes@proton.me    | C@rl@M123     | Caso 6       |
         | Ricardo Costa     | ricardo.costa@icloud.com  | R1c@rd0C      | Caso 7       |
