### Collatz-Folge
Die Collatz-Folge ist eine mathematische Folge, die wie folgt definiert ist:

* Beginne mit irgendeiner natürlichen Zahl n > 0.
* Ist n gerade, so nimm als nächstes n / 2.
* Ist n ungerade, so nimm als nächstes 3 n + 1.
* Wiederhole die Vorgehensweise mit der erhaltenen Zahl.

Die bislang unbewiesene Collatz-Vermutung besagt, dass diese Folge für alle natürlichen Zahlen n im Zyklus (4, 2, 1) mündet.

Schreiben Sie ein MiniJava-Programm, das die Aufforderung "Bitte Zahl eingeben:" ausgibt und vom Nutzer eine natürliche Zahl n einliest und die von diesem n ausgehende Collatz-Folge berechnet, bis die 1 erreicht wurde. Ihr Programm soll alle Zahlen der Folge durch Leerzeichen getrennt am Bildschirm ausgeben. Ist die eingegebene Zahl n <= 0, soll "Fehler: n>0 erwartet!" ausgegeben werden. Das Abfragen der Eingabe ist bereits im Template vorgegeben. Zusätzlich soll ihr Programm die Länge der Folge mitzählen und abschließend in einer neuen Zeile "Länge: " sowie die Länge der Folge ausgeben.

Hinweis: Sie können die MiniJava-Methode writeConsole() nutzen, um etwas ohne zusätzlichen Zeilenumbruch auf der Konsole auszugeben. Mit writeLineConsole() kann ein Zeilenumbruch ausgegeben werden. Alle Ausgaben sollen auf eine abschließende neue Zeile enden.

#### Beispiele
```
1.
Bitte Zahl eingeben:
> 0
Fehler: n>0 erwartet!

2.
Bitte Zahl eingeben:
> 4
4 2 1
Länge: 3

3.
Bitte Zahl eingeben:
> 11
11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
Länge: 15

4.
Bitte Zahl eingeben:
> 27
27 82 41 124 62 31 94 47 142 71 214 107 322 161 484 242 121 364 182 91 274 137 412 206 103 310 155 466 233 700 350 175 526 263 790 395 1186 593 1780 890 445 1336 668 334 167 502 251 754 377 1132 566 283 850 425 1276 638 319 958 479 1438 719 2158 1079 3238 1619 4858 2429 7288 3644 1822 911 2734 1367 4102 2051 6154 3077 9232 4616 2308 1154 577 1732 866 433 1300 650 325 976 488 244 122 61 184 92 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1
Länge: 112
```

Hinweis: Ihr Programm soll alle Folgenglieder in einer Zeile ausgeben, die Zeilenumbrüche sind nur der Darstellung halber hier

Die Zeilen, die mit "> " beginnen, markieren dabei die Nutzereingaben und werden nicht von dem Programm ausgegeben. Sie dienen nur der besseren Verständlichkeit.