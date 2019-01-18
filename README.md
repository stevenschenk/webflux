# Opdracht 3
In deze opdracht gaan we server-sent events gebruiken voor het terug geven van de live data.

### Branch

Mocht de vorige opdracht niet gelukt zijn, doe dan een checkout op 
branch __assignment-3-start__:
```
git checkout assignment-3-start
```

Anders werk verder met je bestaande code.


### Live stream
Als je altijd de laatste temperatuur meting wilt hebben, zal je het endpoint __/temperature/live__
moeten pollen. Dit is natuurlijk niet `reactive`. Het is mogelijk om via http de connectie open 
te houden zodat de server nieuwe data kan `pushen`. Dit is mogelijk met het content-type 
`text/event-stream`. 

Als de server altijd de nieuwste temperatuur entry uit de database moet pushen zal de server dus
moeten watchen of er nieuwe data aan de database toegevoegd is. Ook dit willen we natuurlijk
reactive doen. Gelukkig heeft MongoDB hier een out-of-the-box oplossing voor: `Tailable Cursors`.

Zorg ervoor dat nieuwe temperatuur entries gepushed worden naar de client. Hiervoor moet je:

1. Zorgen dat de repositories met een tailable cursor werken
2. De content-type van responsen veranderen naar text/event-stream

Voor nu mag je ook nog alle history uit de database terug geven naar de client. In de volgende 
opdracht gaan we er pas een hot source van maken.

---
**tips**

* De collections in de MongoDb zijn al Capped Collections. Hier hoef je dus niks aan te
  veranderen.

* Door de Tailable Cursor wordt een Flux infinite. Dit betekent dat sommige methods op een stream 
  niet meer werken.
  
---

### Testing
De code is gewijzigd dus dit zal waarschijnlijk invloed hebben op de tests. Pas waar nodig de
tests aan en run de tests:

```
mvn test
```

---
**tip**
De `TestRestTemplate` kan niet goed omgaan met event streams. Gelukkig is er voor Spring Webflux
de `WebTestClient`. Hiermee is het heel makkelijk om Reactive web applicaties te Integration testen.

---

Wanneer dit allemaal werkt kan je verder met [opdracht 4](https://git.quintor.nl/SG-QuintorAcademy/webflux-hands-on/tree/assignment-4-start)





