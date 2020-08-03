# Musterlösung nach Block 6 und 7 der Telekom Akademie

## Schwerpunkte

* Umstellung auf Datenhaltung in einer relationalen Datenbank
  * Änderung pom: Starter für JDBC/JPA
* Umstellung der Fachklassen in folgender Reihenfolge
  * DatabaseIsbnGenerator mit JPA native Queries
  * Einführen von  data-{platform}.sql
    * Vorsicht: eine schema-{platform}.sql kollidiert mit dem ddl von Hibernate. Deshalb wird hier die data-test.sql zum Erzeugen der KEYS-Tabelle missbraucht 
  * JpaStoreService mit native Query für Stock, Entity für Speichern. Dazu wird der StoreService erweitert
  * JpaBooksService mit Verwendung eines Spring-Data-Repositories
  * Löschen des Mock-Tests
    * Für das JPA-Beispiel müsste man ja das Repository mocken. Möglich und interessant, aber nicht unbedingt relevant

## Hinweise

* Sowohl die Tests als auch  die Applikation kann mit der Embedded Datenbank aber auch mit einer externen H2 gemacht werden
  * Ein Beispiel für das Aufrufscript ist im db-server vorhanden. Zu beachten ist hier die -ifNotExists Option: Ohne die müsste die Datenbank gesondert erzeugt werden
* Die ganzen List-Methode im Booksservice wurden als Default-Methoden ins Interface gezogen
* Die ganzen List-Methode im Booksservice sind so unsinnig implementiert, da die ganze Sortiererei etc. viel besser die Datenbank machen sollte. Das wäre ein Beispiel für die Erweiterung des Spring-Data-Repositories, was ich als optionale Ergänzung machen würde.
* Plain JDBC und das Spring JDBC-Template wird nicht benutzt
* Der JpaBooksService kann auch mit dem EntityManager realisiert werden, erst zum Schluss wird auf das JpaRepository umgestellt
* Auf Relationen etc. wird in der Musterlösung komplett verzichtet. Das Thema wird aber im Seminar selber natürlich präsentiert
