### Rette die Pinguine
Der Gelbaugenpinguin (Megadyptes antipodes) ist vom Aussterben bedroht. Wissenschaftler haben den Plan die noch verbleibenden 2700 Gelbaugenpinguine umzusiedeln in ein Gebiet ohne natürliche Feinde.

Um die Erfolgschancen dieses Plans abschätzen zu können, haben Sie uns um Hilfe gebeten die Populationsentwicklung zu simulieren.
### Pinguine
Wir teilen die Pinguine in 5 Altersstufen ein: Jungtiere, Junge Erwachsene, Erwachsene, Alte Erwachsene und Weise. In jedem Schritt der Simulation werden alle Pinguine einer Altersstufe in die nächst höhere verschoben, mit den unten beschriebenen Einschränkungen. Weise Pinguine haben die maximale Lebenserwartung erreicht und werden nicht älter, sondern sterben friedlich in Ihrem Schlaf.

#### Paarungsverhalten
Alle Pinguine der Altersstufe Junge Erwachsene, Erwachsene und Alte Erwachsene versuchen den Fortbestand der Pinguine zu sichern, indem sie sich fortpflanzen. Dabei entstehen Jungtiere nach den folgenden Regeln:
* Junge Erwachsene sind zumeist noch auf Partnersuche, daher werden Anzahl <Span style="color: #FF00A2" > _JungeErwachsene/4_ </Span>Jungtiere geboren.
* Erwachsene haben zu großen Teilen einen Partner (und einen sicheren Job) gefunden, daher werden <Span style="color: #FF00A2" > _AnzahlErwachsene/2_ </Span> Jungtiere geboren.
* Alte Erwachsene haben große Angst vor der Pinguinrente, daher werden <Span style="color: #FF00A2" > _AnzahlAlteErwachsene/3_ </Span> Jungtiere geboren.

Natürlich kann es keine halben Jungtiere geben, daher würden 31 Junge Erwachsene in nur sieben Jungtieren resultieren
#### Nahrungssuche
Für die Nahrungssuche sind ausschliesslich die Jungen Erwachsenen und Erwachsenen zuständig. Jeder Pinguin braucht pro Zeiteinheit 1 Essensportion.

* Junge Erwachsene sammeln und jagen pro Zeiteinheit 3 Essensportionen
* Erwachsene sammeln und jagen pro Zeiteinheit 2 Essensportionen

Um den Fortbestand der Gelbaugenpinguine zu sichern wird das Essen in der folgenden Reihenfolge verteilt:

1. Jungtiere
2. Junge Erwachsene
3. Erwachsene
4. Alte Erwachsene
5. Weise

Alle Pinguine die kein Essen bekommen sterben sofort. Sollte am Ende eines Zeitschrittes noch Nahrung übrig sein, so wird sie leider schlecht und kann im darauf folgenden Zeitschritt nicht benutzt werden.

#### Simulation
In jedem Zeitschritt wird die Veränderung der Population wie folgt berechnet:

1. Die Pinguine sammeln und jagen die gesamte Nahrung.
2. Die Nahrung wird verteilt. Sollte nicht genügend Nahrung da sein, verhungern entsprechend viele Pinguine sofort.
3. Es wird berechnet wie viele Jungtiere es gibt.
4. Die Pinguine werden eine Altersstufe älter.

#### Programmablauf
Ihr Programm soll zuerst den Benutzer fragen, wieviele Zeitschritte simuliert werden sollen (bei einer Eingabe < 1 soll sich das Programm mit der Ausgabe Zeitschritte >= 1 erforderlich beenden).

Als nächstes fragt Ihr Programm die Startpopulationen für die Altersgruppen in der gegebenen Reihenfolge ab. Hier darf angenommen werden, dass keine negativen Eingaben erfolgen.

Danach nimmt es die gegebene StartPopulation und simuliert auf dieser Basis die vom Benutzer eingegebenen Zeitschritte.

Nach Ende der Simulation gibt es Zeilenweise die Population der Jungtiere, Jungen Erwachsenen, Erwachsenen, Alten Erwachsenen und Weisen aus.

#### Beispielhafte Programmabläufe
1. Beispiel mit einem Zeitschritt 
```
<Bitte Geben Sie die Anzahl an Zeitschritten ein (>= 1):
>1
<Startpopulation Jungtiere
>300
<Startpopulation Junge Erwachsene
>400
<Startpopulation Erwachsene
>500
<Startpopulation Alte Erwachsene
>500
<Startpopulation Weise
>1000
<Anzahl Jungtiere:
<516
<Anzahl Junge Erwachsene:
<300
<Anzahl Erwachsene:
<400
<Anzahl Alte Erwachsene:
<500
<Anzahl Weise:
<500
```
2. Beispiel mit 100 Zeitschritt
```
<Bitte Geben Sie die Anzahl an Zeitschritten ein (>= 1):
>100
<Startpopulation Jungtiere
>300
<Startpopulation Junge Erwachsene
>400
<Startpopulation Erwachsene
>500
<Startpopulation Alte Erwachsene
>500
<Startpopulation Weise
>1000
<Anzahl Jungtiere:
<5495
<Anzahl Junge Erwachsene:
<5354
<Anzahl Erwachsene:
<5217
<Anzahl Alte Erwachsene:
<5083
<Anzahl Weise:
<4952
```

Hinweis: Zur besseren Kenntlichmachung ist im Beispiel Zeilen, die vom Programm ausgegeben werden, "<" vorangestellt. Zeilen mit Nutzereingaben ist ein ">" vorangestellt. Diese Zeichen gehören nicht zum Programmablauf.