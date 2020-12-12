## Projeto API spring-boot  
Sistema para calcular a distancia entre duas cidades  

## Banco de dados  
Postgres  
#### Sql dos paises, estados e cidades  
https://github.com/chinnonsantos/sql-paises-estados-cidades  

#### Distancias entre as cidades
CREATE EXTENSION cube;  
CREATE EXTENSION earthdistance;  
  
#### Calculo de distancia por cube  
select earth_distance(
ll_to_earth(-21.95840072631836,-47.98820114135742),
ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;  
Obs: Retorna em metros  

#### Calculo de distancias por earthdisntance   
select ((select lat_lon from cidade where id = id1) <@> (select lat_lon from cidade where id=id2)) as distance;  
Obs: Retorna a distancia em milhas.  

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

#### cities
http://localhost:8080/cities/all  
http://localhost:8080/cities/page?page={int}  
http://localhost:8080/cities/{int}  

#### Distances
http://localhost:8080/distances/by-points?from={city1_id}&to={city2_id}  
http://localhost:8080/distances/by-cube?from={city1_id}&to={city2_id}
  
