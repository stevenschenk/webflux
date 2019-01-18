# Opdracht 2
In deze opdracht gaan we de Controllers en Services veranderen zodat deze
de Mono en Flux types gaan gebruiken. 

### Branch

Mocht de vorige opdracht niet gelukt zijn, doe dan een checkout op 
branch __assignment-1-start__:
```
git checkout assignment-2-start
```

Anders werk verder met je bestaande code.


### Services
In Spring Webflux kunnen we vanaf de database een stream opzetten naar de controllers. Hiervoor
moeten uiteraard de Services herschreven worden. Zorg dat de Services ook de Flux en 
Mono types returnen. 

### Controllers
Spring Webflux kan omgaan met Flux en Mono als return types. Dit zorgt ervoor dat de stream
pas echt gebruikt gaat worden op het moment dat het nodig is. Het enigste wat je hiervoor hoeft
te doen is de return types van de Controller methods aanpassen.

### Error handling
De sensor die de metingen doet geeft af en toe incomplete data terug. Dit zorgt ervoor
dat de endpoints niet werken als er incomplete data in de database is. Dit is natuurlijk niet 
wat we willen. Zorg dat de endpoints gewoon blijven werken als de data uit de database niet 
helemaal klopt. Entries die niet kloppen mogen overgeslagen worden. 

### Testing
De code is gewijzigd dus dit zal waarschijnlijk invloed hebben op de tests. Pas waar nodig de
tests aan en run de tests:

```
mvn test
```


Wanneer dit allemaal werkt kan je verder met [opdracht 3](https://git.quintor.nl/SG-QuintorAcademy/webflux-hands-on/tree/assignment-3-start)






