### Glückspinguin
Es ist weit bekannt, dass Pinguine nach einem langen Arbeitstag gerne in die Kneipe gehen, und in einem Würfelspiel um die an dem Tag gefangenen Fische spielen. Dabei ist das Spiel Glückspinguin am beliebtesten, da man dabei nicht allzu viel denken muss und man das Spiel jederzeit verlassen kann. Außerdem kann das Spielbrett schnell und einfach auf den Tisch gezeichnet werden.

#### Die Spielregeln
Das Spielbrett besteht aus 11 Feldern, von F2 bis F12, auf welche man im Laufe des Spiels Fische hinlegen oder wegnehmen kann. Zu Beginn des Spiels sind alle Felder leer.

Das Spiel kann von 2 bis beliebig vielen Pinguinen gespielt werden. Sei *n* die Anzahl von mitspielenden Pinguinen. Jeder Pinguin besitzt am Anfang *m* Fische. Die Pinguine werden von 0 bis *n−1* nummeriert. Sie kommen nacheinander dran, zuerst der Pinguin 0, dann Pinguin 1, usw. bis Pinguin *n−1*. Danach ist wieder Pinguin 0 dran.

Wenn ein Pinguin an der Reihe ist, würfelt er mit zwei Würfeln. Die Augensumme der zwei Würfel wird dabei dem Feld mit dieser Zahl zugeordnet. Würfelt also ein Pinguin z. B. 3 und 2, entspricht das dem Feld 5.

Bei allen Feldern außer 2, 7 und 12: Falls ein Fisch bereits auf dem Feld liegt, gewinnt der Pinguin den Fisch. Falls aber das Feld leer war, muss der Pinguin einen Fisch auf das Feld hinlegen.

Bei Feld 7 gibt es eine Hochzeit: Der Pinguin muss einen Fisch auf das Feld hinlegen, egal wie viele Fische da bereits liegen.

Bei Feld 2 ist der Pinguin ein Glückspinguin: Der Glückspinguin gewinnt alle Fische von allen Feldern außer von dem Feld 7!

Bei Feld 12 ist der Pinguin ein Königspinguin: Der Königspinguin gewinnt alle Fische, die auf dem Brett liegen!

Der Pinguin, der aktuell dran ist, kann sich dann entscheiden, sofort aufzuhören und alle seine Fische zu behalten. Falls er sowieso keine Fische mehr hat, muss er aufhören zu spielen.

Danach ist der nächste (noch mitspielende) Pinguin dran. Das Spiel geht so weiter, bis alle außer einem keine Fische mehr haben oder freiwillig aufgehört haben. Dann gewinnt der letzte mitspielende Pinguin alle Fische, die auf dem Brett liegen, falls es welche gibt. Danach wird das Spiel beendet.

Am Ende des Spiels gewinnen die Pinguine, die am meisten Fische besitzen. Wohlgemerkt kann es mehrere Gewinnerpinguine geben.

#### Programmablauf
Initialisierung
Ihr Programm soll die Anzahl *n* von mitspielenden Pinguinen, sowie die Anzahl *m* von Fischen, die jeder Pinguin zu Beginn des Spiels besitzt, abfragen.

Die Eingabeaufforderung über die Konsole soll wie folgt aussehen:
```
Anzahl Pinguine:
Anfangsfische pro Pinguin:
```
Falls 
n
n weniger als 2 ist, soll die folgende Fehlermeldung wiederholt ausgegeben und dabei n erneut eingelesen werden, bis *n>1* eingegeben wird:
```
Anzahl Pinguine soll >1 sein:
```
Ebenfalls soll sichergestellt werden, dass m>0 gilt, mit der folgenden Eingabeaufforderung im Fehlerfall:
```
Anfangsfische soll >0 sein:
```
#### Ablauf eines Spielzugs
Jedes Mal, bevor ein Pinguin drankommt, wird das Spielbrett in der Form von ASCII-Art ausgegeben. Verwenden Sie dazu die MiniJava-Methode writeBoard(), die die Anzahl von Fischen auf den Feldern F3, F4, F5, …, F11 als Parameter nimmt und das Brett wie folgt ausgibt:
```
┌─── o  o  o ───┐
│    │╲╱ ╲╱│     │
│    │_F12_│     │
├────┬─────┬───┤
│ F9 │ F10 │ F11 │
│  0 │  0  │  0  │
├────┼─────┼───┤
│ F6 │ F7  │ F8  │
│  0 │  0  │  0  │
├────┼─────┼───┤
│ F3 │ F4  │ F5  │
│  0 │  0  │  0  │
├────┴─────┴───┤
│ ('>       <')  │
│ ╱/╲  F2   ╱\╲  │
├─V_╱─┐   ┌─╲_V─┤
└─────┴───┴────┘
```
Wenn ein Pinguin drankommt, soll das Folgende ausgegeben werden:
```
Pinguin p ist dran:
```
wobei "p" der Nummer des Pinguins entspricht.

Ihr Programm soll nun feststellen, ob dieser Pinguin der letzte mitspielende Pinguin ist. Falls ja, wird das Folgende ausgegeben, bevor das Spiel beendet wird:  

```
Sie sind der letzte mitspielende Pinguin! Sie gewinnen alle Fische auf dem Brett!
```
Falls nicht, würfelt der Pinguin mit den zwei Würfeln. Verwenden Sie dafür die MiniJava-Methode dice(), die eine zufällige natürliche Zahl zwischen 1 und 6 zurückgibt. Die gewürfelten Zahlen sollen wie folgt ausgegeben werden:
```
w1 + w2 = sum wurde gewürfelt.

```
wobei w1 und w2 jeweils die erste und die zweite gewürfelte Zahl ist, und sum die Summe davon.

Je nach gewürfelter Augensumme soll Ihr Programm die oben beschriebenen Regel ausführen und dabei die eine entsprechende Zeile von den folgenden ausgeben:

```
Glückspinguin! Sie gewinnen alle Fische auf dem Brett außer von F7!
Königspinguin! Sie gewinnen alle Fische auf dem Brett!
Hochzeit! Sie schenken einen Fisch und legen ihn auf F7.
Sie nehmen den Fisch von F sum.
Sie legen einen Fisch auf F sum.
```

Danach soll ausgegeben werden, wie viele Fische der aktuelle Pinguin besitzt, nachdem er die oberen Regeln befolgt hat:

```
Sie haben jetzt f Fische!
```
Bzw. falls f = 1, dann:
```
Sie haben jetzt 1 Fisch!
```
Es soll dann nur noch entschieden werden, ob dieser Pinguin nun aufhört zu spielen oder nicht. Falls er alle Fische verloren hat, hört er sofort auf:
```
Sie haben alle Fische verloren, daher können Sie nicht mehr spielen!
```
Sonst hat er aber trotzdem die Auswahlmöglichkeit, freiwillig aufzuhören. Dafür soll Ihr Programm eine Integerzahl einlesen:
```
Geben Sie 1 ein, um jetzt das Spiel zu verlassen:
```
Falls die Zahl 1 tatsächlich eingegeben wird, hört der Pinguin sofort auf. Wenn ein Pinguin aufhört zu spielen, kommt er ab dem Punkt nie wieder dran.

#### Ende des Spiels
Am Ende sollen alle Gewinnerpinguine ausgegeben werden. Sollten mehrere Pinguine gewonnen haben, sollen sie aufsteigend sortiert ausgegeben werden. In dem folgenden Beispiel gewinnen Pinguin 1 und Pinguin 5, die beide 17 Fische besitzen:

```
Die Gewinnerpinguine mit 17 Fischen:
Pinguin 1
Pinguin 5
```
#### Beispiel
```
Anzahl Pinguine:
> 1
Anzahl Pinguine soll >1 sein:
> 3
Anfangsfische pro Pinguin:
> -2
Anfangsfische soll >0 sein:
> 2
┌─── o  o  o ───┐
│    │╲╱ ╲╱│     │
│    │_F12_│     │
├────┬─────┬───┤
│ F9 │ F10 │ F11 │
│  0 │  0  │  0  │
├────┼─────┼───┤
│ F6 │ F7  │ F8  │
│  0 │  0  │  0  │
├────┼─────┼───┤
│ F3 │ F4  │ F5  │
│  0 │  0  │  0  │
├────┴─────┴───┤
│ ('>       <')  │
│ ╱/╲  F2   ╱\╲  │
├─V_╱─┐   ┌─╲_V─┤
└─────┴───┴────┘
Pinguin 0 ist dran:
5 + 6 = 11 wurde gewürfelt.
Sie legen einen Fisch auf F11.
Sie haben jetzt 1 Fisch!
Geben Sie 1 ein, um jetzt das Spiel zu verlassen:
> 0
┌─── o  o  o ───┐
│    │╲╱ ╲╱│     │
│    │_F12_│     │
├────┬─────┬───┤
│ F9 │ F10 │ F11 │
│  0 │  0  │  0  │
├────┼─────┼───┤
│ F6 │ F7  │ F8  │
│  0 │  0  │  0  │
├────┼─────┼───┤
│ F3 │ F4  │ F5  │
│  0 │  0  │  0  │
├────┴─────┴───┤
│ ('>       <')  │
│ ╱/╲  F2   ╱\╲  │
├─V_╱─┐   ┌─╲_V─┤
└─────┴───┴────┘
Pinguin 1 ist dran:
5 + 6 = 11 wurde gewürfelt.
Sie nehmen den Fisch von F11.
Sie haben jetzt 3 Fische!
Geben Sie 1 ein, um jetzt das Spiel zu verlassen:
> 1
┌─── o  o  o ───┐
│    │╲╱ ╲╱│     │
│    │_F12_│     │
├────┬─────┬───┤
│ F9 │ F10 │ F11 │
│  0 │  0  │  0  │
├────┼─────┼───┤
│ F6 │ F7  │ F8  │
│  0 │  0  │  0  │
├────┼─────┼───┤
│ F3 │ F4  │ F5  │
│  0 │  0  │  0  │
├────┴─────┴───┤
│ ('>       <')  │
│ ╱/╲  F2   ╱\╲  │
├─V_╱─┐   ┌─╲_V─┤
└─────┴───┴────┘
Pinguin 2 ist dran:
1 + 1 = 2 wurde gewürfelt.
Glückspinguin! Sie gewinnen alle Fische auf dem Brett außer von F7!
Sie haben jetzt 2 Fische!
Geben Sie 1 ein, um jetzt das Spiel zu verlassen:
> 123
┌─── o  o  o ───┐
│    │╲╱ ╲╱│     │
│    │_F12_│     │
├────┬─────┬───┤
│ F9 │ F10 │ F11 │
│  0 │  0  │  0  │
├────┼─────┼───┤
│ F6 │ F7  │ F8  │
│  0 │  0  │  0  │
├────┼─────┼───┤
│ F3 │ F4  │ F5  │
│  0 │  0  │  0  │
├────┴─────┴───┤
│ ('>       <')  │
│ ╱/╲  F2   ╱\╲  │
├─V_╱─┐   ┌─╲_V─┤
└─────┴───┴────┘
Pinguin 0 ist dran:
3 + 4 = 7 wurde gewürfelt.
Hochzeit! Sie schenken einen Fisch und legen ihn auf F7.
Sie haben jetzt 0 Fische!
Sie haben alle Fische verloren, daher können Sie nicht mehr spielen!
┌─── o  o  o ───┐
│    │╲╱ ╲╱│     │
│    │_F12_│     │
├────┬─────┬───┤
│ F9 │ F10 │ F11 │
│  0 │  0  │  0  │
├────┼─────┼───┤
│ F6 │ F7  │ F8  │
│  0 │  0  │  0  │
├────┼─────┼───┤
│ F3 │ F4  │ F5  │
│  0 │  0  │  0  │
├────┴─────┴───┤
│ ('>       <')  │
│ ╱/╲  F2   ╱\╲  │
├─V_╱─┐   ┌─╲_V─┤
└─────┴───┴────┘
Pinguin 2 ist dran:
Sie sind der letzte mitspielende Pinguin! Sie gewinnen alle Fische auf dem Brett!
Die Gewinnerpinguine mit 3 Fischen:
Pinguin 1
Pinguin 2
```

Die Zeilen, die mit "> " beginnen, markieren dabei die Nutzereingaben und werden nicht von dem Programm ausgegeben. Sie dienen nur der besseren Verständlichkeit.





