Opis programu

Scrapper pobiera dane o domach ze strony https://www.otodom.pl/ oraz zapisując je w pliku o formacie json

Wymagania 

Python 3.7

Instrukcja

1) Wejść do katalogu z plikami requirements.txt, Scraper.py, Readme.md oraz flats.json
2) Otworzyć konsole systemową w tym katalogu
3) Wpisać do konsoli polecenie pip install -r requirements.txt
4) Przygotować dane wejściowe na podstawie, których będą pobierane dane z serwisu:
    - Rodzaj lokum
    - Sprzedaz czy wynajem
    - Miejscowość
    - Minimalna cena
    - Maksymalna cena
    - Minimalna wielkość w m2
    - Maksymalna wielkość w m2
    - Ilość pokoi
4) Uruchomić skrypt 
 Przykład uruchomienia z danymi:
 - py Scraper.py mieszkanie sprzedaz Gliwice 190000 200000 25 90 1

Przykładowy skrypt powinien zwrócic wszsytkie mieszkania wystawione na sprzedaż w miejscowości Gliwice w cenie od 190000 do 200000 o wielkośći od 25 do 90 m2 z ilością pokoi równą 1 

Dane wynikowe

W pliku flats.json zostaną zapisane pobrane dane