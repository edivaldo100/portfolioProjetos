# Portfólio Projetos
Sistema para gerenciar os dados do portfólio de projetos de uma empresa. Entenda como portfólio de projetos o conjunto de projetos da empresa, tanto em andamento como em análise de viabilidade

### Prerequisitos

* NPM
* Angular 8
* NodeJs
* Java 16
* Mavem
* PostgreSQL


### Instalação

1. Clone the repo
   ```sh
   git clone https://github.com/edivaldo100/portfolioProjetos.git
   ```
2. Acessar pasta frontEnd
   ```sh
   cd frontend
   ```
3. Install NPM packages
   ```sh
   npm install
   ```
4. Start serve
   ```sh
   ng serve
   ```
5. Acessar pasta BackEnd em outro terminal
   ```sh
   cd backend
   ```
6. Install packages
   ```sh
   mvn clean install
   ```
7. Start serve
   ```sh
   mvn spring-boot:run
   ```

### Detalhe

Os serviços estão expostos em serviço web service REST.

É possível associar um funcionário/membro qualquer já cadastrado a um projeto qualquer já cadastrado.
ex: com curl
   ```sh
    curl --location 'http://localhost:8080/membro' \
--header 'Content-Type: application/json' \
--data '{
    "idprojeto": 1,
    "idpessoa": 2
}'
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100    69    0    28  100    41   1141   1671 --:--:-- --:--:-- --:--:--  2875{"idprojeto":1,"idpessoa":2}

   ```
   
 ou
 
 usando swagger
 
 http://localhost:8080/swagger-ui.html#/
 
 usando
 http://localhost:8080/swagger-ui.html#!/membro-controller/salvarUsingPOST
    ```sh
 {
  "idpessoa": 0,
  "idprojeto": 0
}

   ```
   
