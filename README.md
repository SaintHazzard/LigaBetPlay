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


Instalacion de docker

1. sudo apt update

2. sudo apt install apt-transport-https ca-certificates curl software-properties-common

3. curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg

4. echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

5. sudo apt update

sudo apt install docker-ce

6. docker --version

7. sudo curl -L "https://github.com/docker/compose/releases/download/$(curl -s https://api.github.com/repos/docker/compose/releases/latest | grep -Po '"tag_name": "\K[0-9.]+')" /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose

8. docker-compose --version

9. sudo usermod -aG docker $USER


Verificación final

docker --version
docker-compose --version
