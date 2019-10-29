# Musterlösung nach Block 5 der Telekom Akademie

## Schwerpunkte

* Umstellung auf Spring Boot Projekt
  * Änderung pom
* Umstellung auf Spring CDI
  * Annotieren der Fach-Klassen mit @Component
  * Konfiguration mit application.properties und @Value
  * Einführung der Profiles dev (Starten der Application) und test (für die Spring Boot Tests) 
  * Einführen der BooksConfiguration für die Erzeugung der diversen Maps (books, store, generators)
* Umstellung der Tests auf Spring Boot Tests
  * Einführen der BooksTestConfiguration	
  * BooksServiceScenarioTest und BooksServiceScenarioTest lassen sich den BooksService autowiren, die init-Methode ist damit unnötig  

## Hinweise

* Der Mockito-Test BooksServiceFindBookByIsbnTest bleibt unverändert, da das Setzen der Mocks im Testfall bleibt

