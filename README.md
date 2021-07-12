# CursoAluraSpringBoot
Projeto API REST de estudo utilizando Java com o framework Spring Boot

- Banco em H2 em memória
- CRUD básico para o modelo/entidade Topico
- Implementação de consulta paginada e ordenada
- Utilização de cache para consultas (provedor em memória, não utilizar em Produção)  
- Utilização de autenticação e autorização via JWT

### Como rodar em produção

Primeiro é necessário realizar o build do projeto

##### Comando para build do artefato:

    mvn clean package

Será gerado um **.jar** dentro da pasta **target**

Para executar a aplicação é necessário configurar as seguintes variáveis de ambiente<br>
>FORUM_DATABASE_URL;FORUM_DATABASE_USERNAME;
FORUM_DATABASE_PASSWORD;FORUM_JWT_SECRET;
 
Isso pode ser configurado no ambiente que está rodando a aplicação ou passado junto ao comando de execução.<br>

##### Comando de execução:<br>


    java -jar -DFORUM_DATABASE_URL=jdbc:h2:mem:alura-forum -DFORUM_DATABASE_USERNAME=sa -DFORUM_DATABASE_PASSWORD= -DFORUM_JWT_SECRET=9874asdfartwrtawe323423sdfar2rwr23rfdsf23rfw -Dspring.profiles.active=prod forum.jar
<br>

####Documentação Postman
https://documenter.getpostman.com/view/9114358/Tzm8DuuA
