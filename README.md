## Projeto API spring-boot  
Sistema para calcular a distancia entre duas cidades  

## Banco de dados  
Postgres  
#### Sql dos paises, estados e cidades  
https://github.com/chinnonsantos/sql-paises-estados-cidades  

  
## Docker  
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres  
  
## Rotas  
#### Countries
http://localhost:8080/countries/all
http://localhost:8080/countries/page?page={int}  
http://localhost:8080/countries/{int}  
  
#### States  
http://localhost:8080/states/all
http://localhost:8080/states/page?page={int}  
http://localhost:8080/states/{int}  
  
