### Pingu-Art
Es kommt immer wieder vor, dass wir Menschen schnell überprüfen müssen, ob zwei lange Zahlen gleich sind. Da wir uns damit schwertun, können wir uns damit behelfen, aus den Zahlen ein Bild zu generieren. Deren Gleichheit können wir dann viel schneller und sicherer überprüfen. Interessierte können dazu den Begriff "Randomart" nachschlagen, was aber hier nicht Teil der Aufgabe ist.

Überraschenderweise stehen auch Pinguine vor diesem Problem, und wollen es nun auf ähnliche Weise – mit der Implementierung von "Pingu-Art" – lösen.

Programmablauf
Ihr Programm soll es ermöglichen, vom Nutzerpinguin eingegebene Zahlen als Pingu-Art zu visualisieren.

Dafür sollen im ersten Schritt acht Zahlen über die Konsole eingegeben werden. Sind alle Zahlen erfolgreich eingelesen und zwischengespeichert, werden sie als Pingu-Art auf der Konsole ausgegeben werden.

Jede der acht Zahlen, die der Nutzerpinguin eingibt, ist maximal acht Ziffern lang, und besteht nur aus den Ziffern 0, 1, 2 und 3. Grund für die Beschränkung auf diese Ziffern ist, dass Pinguine nur drei Zehen zum Zählen verwenden können [(mehr über Pinguine)](http://www.pinguine.net/pinguinlexikon/tauchen/äußerlicheanpassungen). Bei Zahlen mit weniger als acht Ziffern sind die "fehlenden" vorderen Ziffern implizit 0 (z.B. die Zahl 122 kann auch als 00000122 gesehen werden). Für Eingaben, die nicht diesem Format entsprechen, ist das Programmverhalten nicht definiert.

Die Eingabeaufforderung soll wie folgt aussehen:
```
Bitte geben Sie eine Pingu-Art-Zahl ein:
```
Nachdem der Nutzerpinguin achtmal Zahlen auf diese Weise eingegeben hat, erscheint das Pingu-Art auf der Konsole. Ein Pingu-Art visualisiert diese Zahlen durch ein generiertes Bild, das im Meer schwimmende Pinguine zeigt.

Ein Pingu-Art beginnt mit der Zeile
```
+---[PinguArt]---+
```
Dann folgen die Zeilen für den Inhalt des Bildes:
```
|<zahl 1><zahl 2>|
|<zahl 3><zahl 4>|
|<zahl 5><zahl 6>|
|<zahl 7><zahl 8>|
```
<zahl 1> steht dabei für die in Pingu-Art umgewandelte Zahl 1. Umgewandelt wird eine Zahl wie folgt:

Die Ziffern 0, 1, 2 und 3 werden zu " " (Leerzeichen), "-", "~" und "P" (Pinguin).
Dabei wird die Zahl von der hintersten Ziffer ausgehend zur vordersten Ziffer abgearbeitet.
Gleiches gilt für die Zahlen 2 bis 8.

Die Zahl 12010302 wird dadurch beispielsweise zu
```
"~ P - ~-"
```
und die Zahl 122 zu
```
"~~-     "
```
Das Pingu-Art endet dann mit der Zeile
```
+----------------+
```
Danach ist das Programm zu Ende.

#### Beispiel
Ein Beispielaublauf sieht dann so aus:
```
Bitte geben Sie eine Pingu-Art-Zahl ein:
> 20200220
Bitte geben Sie eine Pingu-Art-Zahl ein:
> 10121201
Bitte geben Sie eine Pingu-Art-Zahl ein:
> 12
Bitte geben Sie eine Pingu-Art-Zahl ein:
> 10302101
Bitte geben Sie eine Pingu-Art-Zahl ein:
> 2303120
Bitte geben Sie eine Pingu-Art-Zahl ein:
> 1231200
Bitte geben Sie eine Pingu-Art-Zahl ein:
> 20201210
Bitte geben Sie eine Pingu-Art-Zahl ein:
> 120012
+---[PinguArt]---+
| ~~  ~ ~- ~-~- -|
|~-      - -~ P -|
| ~-P P~   ~-P~- |
| -~- ~ ~~-  ~-  |
+----------------+
```

Die Zeilen, die mit "> " beginnen, markieren dabei die Nutzereingaben und werden nicht von dem Programm ausgegeben. Sie sind nur der besseren Verständlichkeit halber angegeben.

**Test, dass das obige Beispiel funktioniert**

Ein weiters Beispiel mit Test:
Hier wird mit den Eingaben "213201", "0023201", "032120", "01010321", "20320101", "02120203", "2103201" und "021320" getestet.

**Zweites Beispiel**

Hinweis: In der Vorlesung wurde erwähnt, das Zahlenkonstanten mit führenden Nullen im Javaquelltext als Oktalzahlen betrachtet werden. Beim Einlesen mit MiniJava über readInt werden Ganzzahlen mit führenden Nullen weiterhin als Dezimalzahlen betrachtet, so, wie es hier gewollt ist.







