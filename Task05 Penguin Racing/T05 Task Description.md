### Pingu-Racing
Alan und Bjarne sind die beiden schnellsten Pinguine der Antarktis. Um zu entscheiden, wer von den Beiden nun der schnellste Pinguin ist, verabreden sie sich zu einem Rennen. Ihr Programm soll den Ablauf des Wettrennens simulieren und entscheiden, wer gewonnen hat.

Die Regeln des Rennens
Die ganzzahlige Variable *t* stellt die Zeit im Laufe des Rennens dar. Die Dauer des Rennens beträgt insgesamt t <sub>dauer</sub> Sekunden, also verläuft die Zeit *t* im Intervall [0, t <sub>dauer</sub>). Das Programm berechnet die Positionen und die Geschwindigkeiten der beiden Pinguine für jede Sekunde des Rennens.

Die ganzzahligen Positionen von Alan und Bjarne, 
*pos* <sub>*A*</sub> und *pos* <sub>*B*</sub>,
können beliebige Startwerte besitzen. Die ganzzahligen Geschwindigkeiten von Alan und Bjarne, *ges*<sub>*A*</sub> und *ges*<sub>*B*</sub>), sind zum Start beide 0.

Jede Sekunde in der ersten Hälfte des Rennens [0, ⎣t <sub>dauer</sub> / 2⎦] gelten die folgenden Regeln, um die Geschwindigkeiten der Pinguine zu bestimmen:
* Alan leidet unter Tetraphobie. Falls also seine aktuelle Position *pos* <sub>*A*</sub>  mit der Ziffer 4 endet, wird seine Geschwindigkeit *ges*<sub>*A*</sub> halbiert (ggf. wird dabei abgerundet) und um 1 erhöht.
* Andernfalls hat Alan keine Angst und kann seine Geschwindigkeit *ges*<sub>*A*</sub> um 7 erhöhen.
* Bjarne hingegen leidet unter Triskaidekaphobie. Falls also seine aktuelle Position *ges*<sub>*B*</sub> durch 13 teilbar ist, kriegt er einen Adrenalinstoß und verdoppelt sich seine Geschwindigkeit *ges*<sub>*B*</sub> und erhöht sie zusätzlich um 1.
* Andernfalls bekommt Bjarne keine Panik und kann seine Geschwindigkeit *ges*<sub>*B*</sub> um 3 erhöhen.

In der zweiten Hälfte des Rennens [⎣t <sub>dauer</sub> / 2⎦, t <sub>dauer</sub>) gelten nicht mehr die oberen Regeln, sondern nur noch die folgenden:
* Grundsätzlich wird *ges*<sub>*A*</sub> nun um 1 erhöht pro Zeitschritt. Lediglich an den Zeitpunkten ⎣t <sub>dauer</sub>\*3/5⎦ und ⎣t <sub>dauer</sub>\*4/5⎦ wird *ges*<sub>*A*</sub> stattdessen um 4 dividiert und ggf. abgerundet.
* Grundsätzlich wird  *ges*<sub>*B*</sub> nun um 1 reduziert pro Zeitschritt. Lediglich in den letzten 13 Sekunden [t <sub>dauer</sub> -13, t <sub>dauer</sub>) hat Bjarne Unglück und stolpert, sodass seine Geschwindigkeit jede Sekunde halbiert und ggf. abgerundet wird.

Es gibt außerdem eine maximale Geschwindigkeit 
*ges*<sub>*max*</sub> = 128, die zu keinem Zeitpunkt jemals überschritten werden darf. Die Geschwindigkeiten können auch nie negativ werden. D.h. falls die Geschwindigkeit laut den oberen Regeln die *ges*<sub>*max*</sub> überschreiten oder 0 unterschreiten sollte, wird die Geschwindigkeit einfach auf *ges*<sub>*max*</sub> bzw. 0 gesetzt.

Nachdem die aktuelle Geschwindigkeit für den Zeitpunkt *t* bestimmt wird, wird die Position des Pinguins einfach um die Geschwindigkeit erhöht.

Am Ende gewinnt der Pinguin, der die höchste Position besitzt. Ein Unentschieden kann natürlich auch vorkommen.

#### Programmablauf
Ihr Programm soll die Startpositionen von Alan und Bjarne, sowie die Renndauer abfragen, und das Rennen simulieren.

Die Eingabeaufforderung über die Konsole soll wie folgt aussehen:
```
Alan Startposition:
Bjarne Startposition:
Renndauer:
```
Falls die eingegebene Renndauer negativ ist, soll die folgende Fehlermeldung wiederholt ausgegeben werden, bis eine nicht-negative Renndauer eingegeben wird:
```
Bitte keine negative Zahl eingeben:
```
Für jede Sekunde der Simulation sollen die Positionen und die Geschwindigkeiten von Alan und Bjarne wie folgt ausgegeben werden:
```
t = <zeit>
Alan Position = <posA>; Geschwindigkeit = <gesA>
Bjarne Position = <posB>; Geschwindigkeit = <gesB>
```

Dabei steht <zeit> für *t* <posA> für *pos*<sub>*A*</sub>, <gesA> für *ges*<sub>*A*</sub> und so weiter.
Am Ende soll der Gewinnerpinguin ausgegeben werden. Also, falls Alan gewinnt:
```
Alan gewinnt!
```
Falls Bjarne gewinnt:
```
Bjarne gewinnt!
```
Und falls das Rennen unentschieden ausgeht:
```
Unentschieden!
```

#### Beispiele
Die Zeilen, die mit "> " beginnen, markieren die Nutzereingaben und werden nicht von dem Programm ausgegeben. Sie sind nur der besseren Verständlichkeit halber angegeben.

Beispiel 1: Fehlermeldungen 
```
Alan Startposition:
> 0
Bjarne Startposition:
> 0
Renndauer:
> -1
Bitte keine negative Zahl eingeben:
> -3
Bitte keine negative Zahl eingeben:
> 0
Unentschieden!
```
Beispiel 2: Alan gewinnt
Alan Startposition:
```
> 3
Bjarne Startposition:
> 3
Renndauer:
> 6
t = 0
Alan Position = 10; Geschwindigkeit = 7
Bjarne Position = 6; Geschwindigkeit = 3
t = 1
Alan Position = 24; Geschwindigkeit = 14
Bjarne Position = 12; Geschwindigkeit = 6
t = 2
Alan Position = 32; Geschwindigkeit = 8
Bjarne Position = 21; Geschwindigkeit = 9
t = 3
Alan Position = 34; Geschwindigkeit = 2
Bjarne Position = 25; Geschwindigkeit = 4
t = 4
Alan Position = 34; Geschwindigkeit = 0
Bjarne Position = 27; Geschwindigkeit = 2
t = 5
Alan Position = 35; Geschwindigkeit = 1
Bjarne Position = 28; Geschwindigkeit = 1
Alan gewinnt!
```
Beispiel 3: Bjarne gewinnt 
```
Alan Startposition:
> -3
Bjarne Startposition:
> 4
Renndauer:
> 7
t = 0
Alan Position = 4; Geschwindigkeit = 7
Bjarne Position = 7; Geschwindigkeit = 3
t = 1
Alan Position = 8; Geschwindigkeit = 4
Bjarne Position = 13; Geschwindigkeit = 6
t = 2
Alan Position = 19; Geschwindigkeit = 11
Bjarne Position = 26; Geschwindigkeit = 13
t = 3
Alan Position = 31; Geschwindigkeit = 12
Bjarne Position = 32; Geschwindigkeit = 6
t = 4
Alan Position = 34; Geschwindigkeit = 3
Bjarne Position = 35; Geschwindigkeit = 3
t = 5
Alan Position = 34; Geschwindigkeit = 0
Bjarne Position = 36; Geschwindigkeit = 1
t = 6
Alan Position = 35; Geschwindigkeit = 1
Bjarne Position = 36; Geschwindigkeit = 0
Bjarne gewinnt!
```














