# Opdracht 1
In deze opdracht gaan we de __Repositories__ veranderen zodat deze reactive communiceren met de
database. 

### Branch

Doe een checkout op branch __assignment-1-start__:
```
git checkout assignment-1-start
```

### Pom.xml
Voor een reactive connectie met de database is een reactive database driver nodig. Gelukkig is er voor
MongoDb een spring starter: __spring-boot-starter-data-mongodb-reactive__. Vervang de huidige
MongoDb starter met de reactive variant.

### Repositories
Nu we beschikking hebben over een reactive database driver moeten we er nog voor zorgen dat deze ook
goed benut wordt. Hiervoor moeten we de repositories aanpassen. Zorg dat repositories 'reactive' 
worden en pas waar nodig de return types van de Services en Controllers aan.



