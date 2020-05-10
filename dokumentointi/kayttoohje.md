# Käyttöohje
Ohjelma löytyy tiedostosta [connect.jar](https://github.com/essipe/ohjelmistotekniikka20/releases/tag/loppupalautus). Lataa tämä.

### Käynnistys
Ohjelma käynnistetään komennolla 
```java -jar connect4.jar```

### Pelaaminen
Sovellus käynnistyy main menu -näkymään, jossa on kuvaus pelistä, kentät pelaajien nimimerkeille ja nappi pelin aloitukseen. Näkymästä on myös mahdollisuus vaihtaa peliruutu pienemmäksi tai suuremmaksi. Peli käynnistyy oletuksena 7x6 ruudulla.
![](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/kuvat/mainmenu.jpg)


Ensimmäisenä on 1-pelaajan vuoro. Nappulan pudotus tapahtuu rivien yllä olevista napeista. Napin painallus pudottaa nappulan alimmaiseen vapaana olevaan ruutuun laudalla. Pelaajat pudottavat nappuloitaan vuorotellen, kunnes toisella on neljän suora.
![](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/kuvat/gameview.jpg)


Kun toinen pelaaja voittaa, tulee yläpalkkiin tästä ilmoitus sekä nappi, jota painamalla voi aloittaa uuden pelin.
![](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/kuvat/winview.jpg)
