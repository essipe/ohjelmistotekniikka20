# Arkkitehtuurikuvaus
### Pakkausrakenne
![](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/kuvat/pakkauskaavio1.jpg)

Main-luokka käynnistää sovelluksen UI:ta käyttäen ja sovelluslogiikasta vastaava luokka Board tarjoaa toiminnallisuuden käyttöliittymälle.
### Käyttöliittymä
Käyttöliittymässä on kaksi näkymää, main menu ja itse pelinäkymä, jotka on toteutettu Scene-olioina. Käyttöliittymä sijaitsee luokassa Connect4UI.java.  

Käyttöliittymässä on metodeja mm. peliruudun, nappejen ja näkymän alustamiselle ja yhden pelinappulan ruudulle piirtämiseen. Käyttöliittymäluokka käyttää luokan Board metodeja mm. tietääkseen mihin ruutuun pudotettu pelinappula piirretään ja onko peli voitettu, jolloin se siirtyy näyttämään voittonäkymää.  

Pelinäkymän asettelun pohjana toimii Borderpane-olio, johon puolestaan on aseteltu Gridpane ja kaksi HBoxia.
### Sovelluslogiikka
Sovelluksen toiminnallisuudesta vastaa luokka Board. Boardilla on metodi nappulan pudottamiseen laudalle, jota se käsittelee int[][]-taulukkona. Sovelluslogiikka vastaa myös voiton tarkistamisesta jokaisen vuoron jälkeen. 
### Pysyväistallennus
Tietojen tallennuksesta huolehtii pakkauksessa connect4.dao oleva luokka StatsDao. Luokka tallentaa ja lukee viimeisimmän voittajan juuritiedostossa sijaitsevasta tekstitiedostosta. Tiedostoon tallentuu voittaneen pelaajan nimimerkki.

### Nappulan pudottaminen ja edellisen voittajan hakeminen
![](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/kuvat/sekvenssikaavio.png)
### Parannettavaa

Voiton tarkistus erikseen kaikkiin neljään eri suuntaan tuntuu myös hieman itseään toistavalta, mutta jokaisessa suunnassa on kuitenkin omat rajoituksensa jonka vuoksi en niitä pystynyt samassa metodissa toteuttamaan. Tarkistusta ei ole optimoitu sen ihmeellisemmin esimerkiksi jatkamaan tarkistusta ainoastaan jos vierekkäinen nappula on saman värinen, mutta pelin pelilauta on niin pieni että mielestäni tällainen saattaisi vain tehdä koodista turhan monimutkaisen. Tarkistusta voisi kuitenkin mahdollisesti jollain tapaa tehdä yksinkertaisemmaksi.