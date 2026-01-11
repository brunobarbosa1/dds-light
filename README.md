# Diálogos Diários de Segurança (DDS) – Light

 Os Diálogos Diários de Segurança (DDS) são práticas essenciais que reforçam, todos os dias, o compromisso com a vida, a prevenção de acidentes e a integridade das pessoas. 
 
 Esta API foi desenvolvida para registrar e organizar os DDS's semanais, garantindo assim melhor preparação para os palestrantes. 

 ## Características

 - Gestão de DDS's: Listar, Criar, Atualizar, Cancelar, Concluir e Deletar.
 - Controle de Acesso: Registro e Login de usuários autenticados.
- Arquitetura em Camadas: Seguindo os príncipios de Arquitetura em camadas para melhor organização e manutenção do código.
- Controle de versão do Banco de Dados: Aproveitando o Flyway para para migrações do banco de dados consistentes e rastreáveis.
- Conteinerização: Construído com Docker para facilidar a escalabilidade
- Java moderno: Desenvolvido com Java 17, ultilizando os recursos mais recentes da linguagem.

## Conjunto de tecnologias

- Java 17
- Spring Boot: JPA, Security, Web
- Bean Validation
- PostgreSQL
- Flyway 
- JWT

## Estrutura do Projeto

```
├── main
│   ├── java
│   │   └── com.light.dds_light
│   │       ├── config      // Segurança da aplicação
│   │       ├── controller  // Camada de apresentação     
│   │       ├── dto         // Transferências de Dados 
│   │       └── mappers     
|   |       |__ service     // Regra de negócios
|   |       |__ entities    // Entidades do Banco de Dados
|   |       |__ repository  // Persistência do Banco de dados
|   |       |__ exceptions  // Tratamento de excessões
│   └── resources
│       ├── db/migration     # Flyway migrations
│       └── application.yml  # Configuração
└── test
    └── java                 # Em desenvolvimento
```


## Começando

### Pré-requisítos
[Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

[Docker](https://docs.docker.com/desktop/setup/install/windows-install/)

[Maven](https://maven.apache.org/download.cgi)

### Instalação

1. Clone o repositório
```
git clone https://github.com/brunobarbosa1/dds-light.git
cd dds_light
```

2. Suba o banco de dados com o Docker
```
docker compose up -d
```

3. Acesse a documentação da API
```
http://localhost:8080/swagger-ui/index.html
```

## Pontos de extremidade da API

## Usuário

- POST /dds/auth/register : Registra um usuário
- POST /dds/auth/login : Autentica o usuário 

Obs: Apenas usuários autenticados consomem a API.


## DDS

- GET /api/dds : Lista os DDS's
- POST /api/dds : Registra um DDS
- PUT /api/dds/{id}/atualizar : Atualiza um DDS
- PUT /api/dds/{id}/cancelar : Cancela um DDS
- PUT /api/dds/{id}/concluir : Conclui um DDS
- GET /api/dds/{id} : Buscar um DDS por id
- DELETE /api/dds/{id} : Deletar um DDS por id


### Contribuíndo

Contribuições são bem-vindas! Por favor, siga estes passos:

1. Faça um fork do repositório.

2. Criar uma ramificação de funcionalidade:`git checkout -b feature-name`
3. Confirme as alterações: `git commit -m 'Add new feature'`

4. Enviar para o branch: `git push origin feature-name`
5. Envie uma solicitação de pull request.




