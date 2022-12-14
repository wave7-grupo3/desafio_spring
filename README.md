# :ballot_box_with_check: Challenge Spring

<p align="right">
  <img src="https://img.shields.io/badge/Project completed-black?style=for-the-badge">
</p>

<p align="left">
  <img src="https://img.shields.io/badge/Version: English-black?style=for-the-badge">
</p>

## API desafio_spring
Development of a REST API of an online product sales platform, implementing a product search engine that, based on the options the customer determines, returns the product(s) that match them.

### Skills
Apply the content provided so far during BOOTCAMP MeLi (Git, Java and Spring).
Build an API for online sales management, relating products, shopping cart and customers.

MSC
  - Structure the API according to best practices following the MSC architecture and some SOLID principles:
    - Model: Responsible for modeling the entities.
    - Repository: This is the data persistence layer. Responsible for managing JSON files, simulating a database.
    - Service: Layer where we manage the business rules.
    - Controller: Responsible for receiving requests and sending responses.
    - Advisor: Responsible for managing the application's exceptions. 
    - DTO: Used to decouple the data presentation to the object model.

Technologies
  - The challenge was performed using Java 11 with Spring Boot, adding the dependencies: 
    - Spring Boot DevTools.
    - Spring Boot Web.
    - Lombok.


### What was developed
The `/articles` route was developed to list, filter and search all products in the sales platform according to the customer's preference. The implemented filters were: search by category, free shipping and customer ratings.
Also in the product scope, the `/insert-articles-request` route was implemented, responsible for registering a new product.

To divide the responsibilities, the `/purchase-request` route was created to create a new purchase ticket, according to the products selected by the customer, and the `/purchase` route to list the purchase ticket with the subtotal of the purchase.

Another implemented route is directed to the final purchase order, the `/shoppingCart` route, which involves adding up all the tickets, returning to the customer all the orders grouped with the total purchase.

Finally, the `/customer` route was developed to list the customers on the online sales platform. The `/customer-profile?uf=mg` route has the function of filtering the customers' information according to their state.

The routes used were idealized to make the application more dynamic and functional for the target audience.


### API Documentation
The tool chosen to document the API was Postman. This choice was due to the ease of sharing endpoint information in real time, since when updating the application locally, other team members receive this update instantly.

:warning: Access the documentation [here](https://documenter.getpostman.com/view/23644142/2s83ziPiu8).


## How to access the project
:warning: Access the challenge repository [here](https://github.com/wave7-grupo3/desafio_spring)

Open the terminal and type the information in the sequence:
- Perform the clone of the project: 
  - SSH: `git clone git@github.com:wave7-grupo3/desafio_spring.git`
  - HTTPS: `git clone https://github.com/wave7-grupo3/desafio_spring.git`

- Have the environment configured to view java projects.


## Authors
- GitHub - [Amanda Zotelli](https://github.com/amdzotelli)
- GitHub - [Carolina Hakamada](https://github.com/carolhakamada)
- GitHub - [Gabriel Morais](https://github.com/gabrielmorais-meli)
- GitHub - [Ingrid Paulino](https://github.com/IngridPaulino)
- GitHub - [Mariana Saraiva](https://github.com/marianasaraivameli)
- GitHub - [Ros??lia Padoin](https://github.com/rosalia-oliveira)


</br>
<p align="left">
  <img src="https://img.shields.io/badge/Vers??o: Portugu??s-black?style=for-the-badge">
</p>

## API desafio_spring
Desenvolvimento de uma API REST de uma plataforma de vendas de produtos online, implementando um motor de busca de produtos que, a
partir das op????es que o cliente determina, devolve o(s) produto(s) que lhes corresponde.

### Habilidades
Aplicar os conte??dos fornecidos at?? o momento durante o BOOTCAMP MeLi (Git, Java e Spring).
Construir uma API para gerenciamento de vendas online, relacionando os produtos, carrinho de compras e clientes.

MSC
  - Estruturar a API conforme as boas pr??ticas seguindo a arquitetura MSC e alguns princ??pios do SOLID:
    - Model: Repons??vel por modelar as entidades.
    - Repository: ?? a camada de persist??nca de dados. Respons??vel por gerenciar os arquivos JSONs, simulando um banco de dados.
    - Service: Camada onde gerenciamos as regras de n??gocio.
    - Controller: Respons??vel por receber as requisi????es e enviar as respostas.
    - Advisor: Respons??vel por gerenciar as exce????es da aplica????o. 
    - DTO: Utilizados para desacoplar a apresenta????o de dados para o modelo de objetos.

Tecnologias
  - O desafio foi realizado utilizando Java 11 com Spring Boot, somando as depend??ncias: 
    - Spring Boot DevTools.
    - Spring Boot Web.
    - Lombok. 


### O que foi desenvolvido
Foi desenvolvida a rota `/articles` para listar, filtrar e pesquisar todos os produtos da plataforma de vendas conforme a prefer??ncia do cliente. Os filtros implementados foram: pesquisa por categoria, frete gr??tis e avalia????o dos clientes.
Ainda no escopo dos produtos, foi implementada a rota `/insert-articles-request`, respons??vel por cadastrar um novo produto.

Para dividir as responsabilidades, foi criada a rota `/purchase-request` para criar um novo ticket de compra, de acordo com os produtos selecionados pelo cliente e a rota `/purchase` para listar o ticket de compra com o subtotal da compra.

Outra rota implementada est?? direcionada ao pedido final de compra, a rota `/shoppingCart`, que envolve a soma de todos os tickets, retornando ao cliente todos os pedidos agrupados com o total da compra.

Por fim, foi desenvolvida a rota `/customer` com intuito de listar os clientes da plataforma de vendas online. J?? a rota `/customer-profile?uf=mg` tem a fun????o de filtrar as informa????es dos clientes de acordo com o seu estado.

As rotas utilizadas foram idealizadas para deixar a aplica????o mais din??mica e funcional para o p??blico alvo.


### Documenta????o da API
A ferramenta escolhida para documentar a API foi o Postman. Esta escolha se deu pela facilidade em compartilhar as informa????es dos endpoints em tempo real, uma vez que ao atualizar a aplica????o localmente, os demais membros da equipe recebem essa atualiza????o instantaneamente.

:warning: Acesse a documenta????o [aqui](https://documenter.getpostman.com/view/23644142/2s83ziPiu8).


## Como acessar o projeto
:warning: Acessar o reposit??rio do desafio [aqui](https://github.com/wave7-grupo3/desafio_spring)

Abrir o terminal e digitar as informa????es na sequ??ncia:
- Realizar o clone do projeto: 
  - SSH: `git clone git@github.com:wave7-grupo3/desafio_spring.git`
  - HTTPS: `git clone https://github.com/wave7-grupo3/desafio_spring.git`

- Ter o ambiente configurado para vizualiza????o de projetos java.


## Autores
- GitHub - [Amanda Zotelli](https://github.com/amdzotelli)
- GitHub - [Carolina Hakamada](https://github.com/carolhakamada)
- GitHub - [Gabriel Morais](https://github.com/gabrielmorais-meli)
- GitHub - [Ingrid Paulino](https://github.com/IngridPaulino)
- GitHub - [Mariana Saraiva](https://github.com/marianasaraivameli)
- GitHub - [Ros??lia Padoin](https://github.com/rosalia-oliveira)


