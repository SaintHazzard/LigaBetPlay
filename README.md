# Proyecto LIGABETPLAY

## Requisitos

- Docker
- Docker Compose
- Java 11 o superior
- Maven

## Configuración

1. Clona el repositorio:

  `git clone https://github.com/SaintHazzard/LigaBetPlay`
  `cd LigaBetPlay`

2. Dar permiso de ejecucion al script

  `chmod +x init-scripts/init.sh`

3. Levanta la base de datos con Docker Compose:

  `docker-compose up`

4. Ejecutar la aplicacion

  `./mvnw spring-boot:run`
