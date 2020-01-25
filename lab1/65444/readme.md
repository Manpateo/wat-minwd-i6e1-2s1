Zadanie 
Patryk MANTHEJ I6E1S1 
Python biblioteka PuLp

Treść zadania:

Przedsiębiorstwo produkuje cztery wyroby. Do ich produkcji zużywa się m.in. dwa surowce. Zużycie tych surowców na jednostkę każdego z wyrobów, dopuszczalne limity zużycia oraz zyski jednostkowe ze sprzedaży podano w tabeli poniżej. Należy wyznaczyć takie ilości poszczególnych wyrobów, aby zysk był maksymalny.

|           | 1  | 2  | 3  | 4  | Limit            |
|---        |--- |--- |--- |--- |---               |
| Zużycie I | 12 | 8  | 10 | 5  | 1600             |
| Zużycie II| 11 | 2  | 12 | 6  | 5000             |
| Zysk      | 8  | 4  | 6  | 3  |                  |

Opis zmiennych:

x1 - liczba produktów nr 1 
x2 - liczba produktów nr 2 
x3 - liczba produktów nr 3 
x4 - liczba produktów nr 4

Funkcja celu:

8x1 + 4x2 + 6x3 + 3x4 -> MAX

Ograniczenia:

A: 12x1 + 8x2 + 10x3 + 5x4 <= 1600 
B: 11x1 + 2x2 + 12x3 + 6x4 <= 5000

Rozwiązanie:

x1 = 132 
x2 = 0 
x3 = 0 
x4 = 3
Zysk = 1065


