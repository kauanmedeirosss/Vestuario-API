# 1. Inicialização do projeto
* Como foi configurado no spring initialzr:
    - spring web
    - Lombok
![img.png](imagens_descricao_ou_passo_a_passo/img.png)  
* Como ficou o main + package:
![img_1.png](imagens_descricao_ou_passo_a_passo/img_1.png)

## 1.1 Tecnologias:
* IDE: IntelliJ
* SGBD: MySQL
* Requisições: Insomnia

## 1.2 + Depencências (e o que são)
![img.png](imagens_descricao_ou_passo_a_passo/img_2.png)
* Spring Data JPA: Integração entre entidades e banco de dados
* Validation: Responsável pela validação dos campos da requisição e é utilizado nas classes DTO
* MySQL Driver: Responsável pela integração com o banco de dados
* Flyway Migration: Ferramenta de controle de migrações de bancos de dados

# 2. Descrição da estrutura
## 2.1 Entidade
Temos a entidade Vestimenta que tem:
* Na classe:
  - @Entity especificando seu nome, por isso singular
  - @Table especificando o nome da tabela, por isso no plural
  - as demais são do lombock, que cria de forma automátizada getters, setters e afins
* Nos atributos:
  - @Id indica que é o atributo identificador (chave primária) da classe
  - @GeneratedValue especifica que o banco irá criar o id automaticamente, com especificação da estratégia identidade, que cria ids de forma sequencial
  - @Enumerated especificando que o enum é tipo String

## 2.2 Repository
Não foi feito um service, o repository está sendo injetado diretamente no controller via @Autowired

## 2.3 DTO
* CadastroVestimentaDTO: recebe todos os dados com exceção do Id.  
  Seu mapeamento foi feito via construtor presente na própria entidade Vestimenta

# 3. Migrations
Para realizar ações no banco de dados será usado o Flyway