# Webflux
Hand-on sessie over de migratie naar Spring Webflux

##### Readers

## Prerequisites
```
* Java 11
* Docker
* Git
* Maven
```

## Structuur 
De opdrachten staan in de Readme van elke branch. Elke opdracht heeft een begin
(__assignment-#-start__) en eind (__assignment-#-done__) situatie. In elke **__start__**-branch
staat de opdracht en in de (**__eind__**)-branch staat de uitwerking. De opdrachten lopen in elkaar over dus
de eind situatie van opdracht 1 is hetzelfde als de begin situatie van opdracht 2. Je kan dus elke keer op je
eigen uitwerking verder werken maar wanneer je er niet uitkomt is het ook altijd mogelijk om verder te
werken vanaf de volgende start branch.

## Setup

#### MongoDb draaien
De applicatie maakt gebruik van een Mongo database. Het makkelijkste is om deze te draaien in [Docker](https://www.docker.com/get-started).

Haal de MongoDb image binnen:
```
docker pull mongo
```

Run de image:
```
docker run --name mongodb -p27018:27017 -d mongo
```

Als er geen problemen zijn opgetreden draait er nu een MongoDb op port __27017__.

#### Repositories clonen

 
Clone de dummysensor repository:

__SSH__

```
git clone quintorgit@git.quintor.nl:SG-QuintorAcademy/webflux-hands-on-dummy-sensor.git
```

__HTTPS__
```
git clone https://git.quintor.nl/SG-QuintorAcademy/webflux-hands-on-dummy-sensor.git
```

Clone de webflux-assignment repository:

__SSH__

```
git clone quintorgit@git.quintor.nl:SG-QuintorAcademy/webflux-hands-on.git
```

__HTTPS__
```
git clone https://git.quintor.nl/SG-QuintorAcademy/webflux-hands-on.git
```

#### Applicatie draaien
Je kan nu de applicaties draaien met Maven.

```
mvn spring-boot:run
```

Open een browser en ga naar `http://localhost:8080/temperature/live`. Als het goed is
krijg je nu een JSON object terug. Je kan ook de error melding `Unprocessable temperature unit in resource`
krijgen. Maak je geen zorgen dit is nu nog expected behaviour. 

Aan de dummy sensor applicatie hoef je voor de rest niks te doen. Zorg dat deze blijft draaien.

Wanneer dit allemaal werkt kan je verder met [opdracht 1](https://git.quintor.nl/SG-QuintorAcademy/webflux-hands-on/tree/assignment-1-start)
