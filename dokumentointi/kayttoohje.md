# Käyttöohje
Ohjelma löytyy tiedostosta connect.jar. Lataa tämä.

### Käynnistys
Ohjelma käynnistetään komennolla 
```java -jar connect4.jar```

### Pelaaminen
Sovellus käynnistyy yksinkertaiseen main menu -näkymään, jossa on kuvaus pelistä ja nappi pelin aloitukseen.
![](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/mainmenu.jpg)


Ensimmäisenä on 1-pelaajan vuoro. Nappulan pudotus tapahtuu rivien yllä olevista napeista. Napin painallus pudottaa nappulan alimmaiseen vapaana olevaan ruutuun laudalla. Pelaajat pudottavat nappuloitaan vuorotellen, kunnes toisella on neljän suora.
![](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/gameview.jpg)


Kun toinen pelaaja voittaa, tulee yläpalkkiin tästä ilmoitus sekä nappi, jota painamalla voi aloittaa uuden pelin.
![](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/winview.jpg)
