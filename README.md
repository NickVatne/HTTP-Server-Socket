Innlevering #1: HTTP Server
===========================

- Serveren kjøres gjennom main metoden i HttpMainClient til designert port,da kjøres en test request men det er også mulig å sende en egen request gjennom default: localhost:10080 på ønsket nettleser.


Kommentar på resultat:
--------------------
- Mye gikk som ønsket, men grunnet kortere tid og middels kunnskap  rundt HTTP og dens funksjonalitet ble vi ikke helt ferdig med ting som HTTPPath og dens TestsKlasse. Sammen med dette ønsket vi også å gjøre noe refakotrering som ikke ble mulig innenfor satt tid.
- Det var derimot en lærerik opplevelse som ga meg en god innføring i hvordan vi skal løse kommende problemstillinger innenfor HTTP



Oppgaven:
---------

Nesten alle utviklere jobber med HTTP til daglig.Den mest brukte versjonen av HTTP er definert i [RFC 7230](https://tools.ietf.org/html/rfc7230) mm. For at dere skal bli kjent med protokollen går innlevering #1 ut på å lage en minimal implementasjon av protokollen.

Serveren skal bruke parametre fra requesten og svare tilsvarende. Dere kan benytte tjesten [URL Echo](http://ivanzuzak.info/urlecho/) som mal.

HTTP er definert som en request/response protokoll. Det vil si at en klient (typisk en nettleser) oppretter en forbindelse til en server og sender en request. Serveren svarer med en response. Både requesten og responsen er tekst som sendes over nettverket. En typisk utveksling kan se slik ut (fra [RFC 7230](https://tools.ietf.org/html/rfc7230#section-2.1)):


Spørsmål videre:
----------------

- En forklaring av de konkrete forskjellene på de unike klassene.
- Tips & Triks for hvordan du selv ville brutt ned en slik oppgave i håndterbare deler.

Deltakere:
---------
@NickVatne & @s0lveig


Vurderingskriterier:
-------------------

* Koden må kompilerer og serveren må la seg starte.
* README.md må beskrive hvordan man starter opp serveren
* Det bør være god testdekning på koden
* Serveren bør ikke krasje/falle ned av seg selv
* Klienten bør koble seg fra korrekt
* Prosjektet bør være dokumentert i form av README.md som også bør inneholde:
  * Hvordan man tester løsningen
  * Kommentarer på eget resultat. Hva kunne vært gjort bedre?
  * Eventuelle spørsmål dere trenger svar på for å komme videre.
* Koden bør kunne håndtere funksjonalitet:
  * Forskjellige status codes
  * Forskjellige HTTP headere
  * Forskjellige HTTP bodies





