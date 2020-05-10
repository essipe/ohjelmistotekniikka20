# Vaatimusmäärittely  
## Sovelluksen tarkoitus  
Sovellus on Connect Four -peli, missä kaksi pelaajaa pelaavat toisiaan vastaan ja yrittävät yhdistää neljä saman väristä palaa joko pystyyn, vaakaan tai vinoon. Se kumpi saa ensimmäisenä neljän rivin, voittaa. 
## Käyttöliittymäluonnos  
Sovelluksessa on kaksi näkymää, päävalikko sekä pelinäkymä. Pelinäkymän sisällä on vielä erilaiset tilanteet voitolle ja tasapelille, joista molemmista kuitenkin pääsee takaisin pääalikkoon.
![](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/kuvat/kayttoliittymaluonnos.png)
## Toiminnallisuus 
##### Aloitusvalikko
* Pelaajat voivat asettaa itselleen nimimerkit
* Pelaaja voi valita ruudun koon kolmesta vaihtoehdosta, peli alkaa oletuksena standardikokoisella 7x6-peliruudulla
* Peli alkaa pelaajien valitsemalla ruudulla painettaessa aloitusnappia
##### Pelin alkaessa
* Peli alkaa pelaajan 1 vuorosta
* Vuorossa olevan pelaajan nimi lukee aina oikeassa reunassa. Reunassa lukee myös edellisen pelin voittaja.
* Pelaajat tiputttavat omia kiekkojaan painamalla peliruudun yllä olevia nappeja. Kiekko tippuu aina sarakkeen alimpaan vapaana olevaan ruutuun.
* Vuoro vaihtuu onnistuneen tiputuksen jälkeen (eli jos sarake ei ollut täynnä)
* Jomman kumman pelaajan saadessa neljä omaa nappulaansa riviin, peli ilmoittaa tästä ja peli loppuu
* Pelin loppuessa on mahdollisuus aloittaa uusi peli. Ruudun kokoa voi vaihtaa tässä välissä.
## Jatkokehitysideoita  
* Voi valita värin  
* Voi muuttaa halutun rivin pituutta, esim yhdistä 3 tai 5