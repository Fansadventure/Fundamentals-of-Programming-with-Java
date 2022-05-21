### Kaninchenpopulation
Auf einer einsamen Insel wird ein Paar geschlechtsreifer Kaninchen ausgesetzt, um herauszufinden, wie viele Kaninchen innerhalb eines Jahres geboren werden. Hierbei wird angenommen, dass jedes geschlechtsreife Paar jeden Monat ein neues Kaninchenpaar zur Welt bringt. Jedes Kaninchenpaar ist bereits im ersten Monat seiner Lebenszeit geschlechtsreif und jedes Kaninchen hat eine Lebenszeit von 3 Monaten.

Schreiben Sie ein MiniJava-Programm, welches die Zahl n einliest, die den n-ten Monat bezeichnet. Ihr Programm soll die Summe der Kaninchenpaare, die im n-ten Monat geschlechtsreif sind, ausgeben. Sie können davon ausgehen, dass n >= 1 gilt. Als Beispiel der Kaninchenpopulation dient folgende Tabelle:

| Monat   | 1.Generation | 2.Generation | 3.Generation |
|:---|:---|:---| :---|
| 1 |  1 |    |      |
| 2 |  2 |  1 |      |
| 3 |  2 |  1 |  1   |
| 4 |  4 |  2 |  1  |
| 5 |  7 |  4 |  2  |

Hinweis: Verwenden Sie die Methode readInt(text) aus MiniJava zum Einlesen von Zahlen.

#### Beispiele:
```
1.
Bitte Zahl eingeben:
> 1
1

2.
Bitte Zahl eingeben:
> 2
2

3.
Bitte Zahl eingeben:
> 3
4

4.
Bitte Zahl eingeben:
> 4
7
```

Die Zeilen, die mit "> " beginnen, markieren dabei die Nutzereingaben und werden nicht von dem Programm ausgegeben. Sie dienen nur der besseren Verständlichkeit.

