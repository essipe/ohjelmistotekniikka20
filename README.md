# Connect Four
Sovellus on neljän suora- peli, jossa kaksi pelaajaa pelaavat toisiaan vastaan yrittäen saada ensimmäisenä neljä oman väristään nappulaa suoraan joko pystyyn, vaakaan tai viistoon. 

## Dokumentaatio  
* [Alustava määrittelydokumentti](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/vaatimusmaarittely.md)  
* [Työaikakirjanpito](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/tyoaikakirjanpito.md)  
* [Arkkitehtuuri](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/arkkitehtuuri.md)

## Käyttöohje
Sovelluksessa pystyy pelaamaan kaksi pelaajaa vuorotellen tiputellen eri värisiä nappuloita. 

## Komentorivikomennot
##### Testit ja testikattavuusraportti
```mvn test jacoco:report```
Testikattavuusraportti selaimella target/site/jacoco/index.html
##### Jarin generointi
```mvn package```
generoi hakemistoon target suoritettavan jar-tiedoston, jonka voi suorittaa komennolla 
```java -jar target/connect4-1.0-SNAPSHOT.jar```
##### Checkstyle
```mvn jxr:jxr checkstyle:checkstyle```
tarkistaa checkstyle-määrittelyn mukaiset tarkistukset, selaimella target/site/checkstyle.html
