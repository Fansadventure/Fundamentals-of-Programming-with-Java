### Primfaktorzerlegung
Jede natürliche Zahl n > 1 ist entweder selbst eine Primzahl oder lässt sich als ein Produkt von Primzahlen darstellen. Zur Berechnung der Primfaktorzerlegung einer Zahl n soll der Reihe nach durch alle natürlichen Zahlen ab der 2 geteilt werden. Wenn ein Teiler t gefunden wurde, so wird t ausgegeben. Falls der Quotient n/t groesser ist als 1, so wird dieser auch in seine Primfaktoren zerlegt.

Schreiben Sie ein MiniJava-Programm, das die Aufforderung <Span style="color: #FF00A2" > "Bitte Zahl eingeben:" </Span>   ausgibt und vom Nutzer eine natürliche Zahl n > 1 einliest und in Primfakoren zerlegt. Ihr Programm soll alle Primfaktoren der Zahl n durch Leerzeichen getrennt am Bildschirm ausgeben. Ist die eingegebene Zahl n <= 1, soll <Span style="color: #FF00A2" > "Fehler: n>1 erwartet!" </Span> ausgegeben werden. Die Eingabe ist bereits im Template vorgegeben.

Hinweis: Sie können die MiniJava-Methode <Span style="color: #FF00A2" > writeLineConsole() </Span>  nutzen, um etwas ohne zusätzlichen Zeilenumbruch auf der Konsole auszugeben. Mit  <Span style="color: #FF00A2" > writeLineConsole() </Span> kann ein Zeilenumbruch ausgegeben werden. Alle Ausgaben sollen auf eine abschließende neue Zeile enden.

#### Beispiele:
```
1.
Bitte Zahl eingeben:
> 1
Fehler: n>1 erwartet!

2.
Bitte Zahl eingeben:
> 84
2 2 3 7

3.
Bitte Zahl eingeben:
> 105
3 5 7

4.
Bitte Zahl eingeben:
> 12321342
2 3 3 3 11 20743
```
Die Zeilen, die mit "> " beginnen, markieren dabei die Nutzereingaben und werden nicht von dem Programm ausgegeben. Sie dienen nur der besseren Verständlichkeit.