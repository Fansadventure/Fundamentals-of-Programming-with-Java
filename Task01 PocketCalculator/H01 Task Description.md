#### Taschenrechner
Es soll ein einfacher, konsolenbasierter Taschenrechner implementiert werden. Dabei soll der Nutzer zuerst nach der Operation gefragt werden, die durchgeführt werden soll. Dazu werden die zur Verfügung stehenden Operationen des Taschenrechners +,-,*,/, % und Programm beenden über Zahlen kodiert. Die Eingabeaufforderung soll wie folgt aussehen:
```
Wählen Sie eine Operation:
1) +
2) -
3) *
4) /
5) %
6) Programm beenden
```
Der Nutzer gibt soll anschließend eine ganze Zahl von 1 bis 6 eingeben, um festzulegen, was getan werden soll. Falls der Nutzer sich für Option 6 entschieden hat, wird das Programm beendet. Falls er sich für eine Option von 1 bis 5 entschieden hat, werden die beiden ganzzahligen Operanden mit "Ersten Operand eingeben:" und "Zweiten Operand eingeben:" nacheinander vom Nutzer abgefragt. Das Programm soll dann das Ergebnis der Operation ausgeben. Anschließend geht es von vorne los und es wird wieder nach der nächsten Operation gefragt.

Überprüfen Sie jeweils, ob versucht wird, durch null zu teilen bzw. den Rest bzgl. null zu berechnen! Geben Sie dann die Meldung "Fehler: Division durch 0!" anstelle des Ergebnisses aus. Wird bei der Frage nach der auszuführenden Operation eine ganze Zahl kleiner als 1 oder größer als 6 eingegeben, so soll diese Eingabeaufforderung wiederholt werden. Verwenden sie für die Berechnungen die entsprechenden Operatoren auf dem Datentyp int. Sie müssen keine Sonderbehandlung für einen etwaigen arithmetischen Überlauf implementieren.

#### Beispiele:
1.  Programm beenden
```
<Wählen Sie eine Operation:
<1) +
<2) -
<3) *
<4) /
<5) %
<6) Programm beenden
>6
```
2.  Addition und Subtraktion 
```
<Wählen Sie eine Operation:
<1) +
<2) -
<3) *
<4) /
<5) %
<6) Programm beenden
>1
<Ersten Operand eingeben:
>65
<Zweiten Operand eingeben:
>34
<99
<Wählen Sie eine Operation:
<1) +
<2) -
<3) *
<4) /
<5) %
<6) Programm beenden
>2
<Ersten Operand eingeben:
>34
<Zweiten Operand eingeben:
>-12
<46
<Wählen Sie eine Operation:
<1) +
<2) -
<3) *
<4) /
<5) %
<6) Programm beenden
>6
```
3.  Ungültige Auswahl
```
<Wählen Sie eine Operation:
<1) +
<2) -
<3) *
<4) /
<5) %
<6) Programm beenden
>7
<Wählen Sie eine Operation:
<1) +
<2) -
<3) *
<4) /
<5) %
<6) Programm beenden
>6
```
4. Rest
```
<Wählen Sie eine Operation:
<1) +
<2) -
<3) *
<4) /
<5) %
<6) Programm beenden
>5
<Ersten Operand eingeben:
>-11
<Zweiten Operand eingeben:
>3
<-2
<Wählen Sie eine Operation:
<1) +
<2) -
<3) *
<4) /
<5) %
<6) Programm beenden
>5
<Ersten Operand eingeben:
>65
<Zweiten Operand eingeben:
>0
<Fehler: Division durch 0!
<Wählen Sie eine Operation:
<1) +
<2) -
<3) *
<4) /
<5) %
<6) Programm beenden
>6
```
5. Division
```
<Wählen Sie eine Operation:
<1) +
<2) -
<3) *
<4) /
<5) %
<6) Programm beenden
>4
<Ersten Operand eingeben:
>-34
<Zweiten Operand eingeben:
>5
<-6
<Wählen Sie eine Operation:
<1) +
<2) -
<3) *
<4) /
<5) %
<6) Programm beenden
>6
```
Hinweis: Zur besseren Kenntlichmachung ist in den Beispielen Zeilen, die vom Programm ausgegeben werden, je ein "<" vorangestellt. Zeilen mit Nutzereingaben ist ein ">" vorangestellt. Diese Zeichen gehören nicht zum Programmablauf.