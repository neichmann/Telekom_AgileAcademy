# Musterlösung nach Block 11 der Telekom Akademie

## Schwerpunkte

* Refactoring der Projekte und Einführen von Microservices
  * Hinzufügen von Swagger zur Service-Beschreibung
  * Modularisierung der Projekte, Auslagern des StoreService in ein separates Projekt
* Einführen von Parent-POMS zur Vereinfachung des Build-Prozesses
* Beispiel ContentService mit Zugriff auf ein Couchbase-Repository


## Hinweise

* Ein fertig konfigurierter Couchbase-Server inklusive des im Beispiel angegebenen Testdatensatzes liegt auf Docker-Hub
  * docker pull javacream/couchbase:telekom
  * docker run -d --name telekomcouchbase -p 8091-8094:8091-8094 -p 11210:11210 javacream/couchbase:telekom 



