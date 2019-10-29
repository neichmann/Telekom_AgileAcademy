# Musterlösung nach den Blöcken 2 und 3 der Telekom Akademie

## Schwerpunkte

* Simples Programmieren
  * RandomIsbnGenerator mit Properties, Constructor, java.util.Random
  * Datenstruktur Book, hier insbesondere auch auf die generierten Funktionen (toString etc) 
* Vererbung	
  * Book
  * SchoolBook
  * SpecialistBook
* Collections
  * MapStoreService mit einer verschachtelten Hashmap
* Streaming-API und Lambda-Funktionen
  * MapBooksService mit den diversen find- und list-Methoden
* Funktionale Programmierung
  * Die Generators-Map im MapBooksService

## Hinweise

* Es wird keine Main-Klasse benutzt sondern ausschließlich ein JUnit-Test
* Die Musterlösung enthält kein javadoc. Bringt bei dem einfachen Beispiel auch nicht wirklich was
* Schnittstellen sind grob behandelt durch Implementierung von Comparable im Book
* Ein enum-Beispiel ist mit Ordering gegeben
* Das Beispiel zur funktionalen Programmierung in Generators-Map muss von den Teilnehmern nicht aktiv realisiert werden
* Mögliche Erweiterungen:
  * Natürlich beliebige zusätzliche Subklassen von Book.
  * Weitere Such-Methoden
  * Zusätzliche Sortier-Methoden und damit Einführung des Comparator-Interfaces
  * Einlesen von Properties-Dateien zum Befüllen der Store-Kategorien   
