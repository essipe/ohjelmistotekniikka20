# Connect Four
Sovellus on Neljän Suora -peli, jossa kaksi pelaajaa pelaavat toisiaan vastaan yrittäen saada ensimmäisenä neljä oman väristään nappulaa suoraan joko pystyyn, vaakaan tai viistoon. 

## Dokumentaatio  
* [Määrittelydokumentti](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/vaatimusmaarittely.md)  
* [Työaikakirjanpito](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/tyoaikakirjanpito.md)  
* [Arkkitehtuuri](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/arkkitehtuuri.md)

## Käyttöohje
[Käyttöohje](https://github.com/essipe/ohjelmistotekniikka20/blob/master/dokumentointi/kayttoohje.md)
## Releaset
[Viikko 5](https://github.com/essipe/ohjelmistotekniikka20/releases/tag/viikko5)  
[Loppupalautus](https://github.com/essipe/ohjelmistotekniikka20/releases/tag/loppupalautus)
## Komentorivikomennot
##### Testit ja testikattavuusraportti
```mvn test jacoco:report```
Testikattavuusraportti selaimella target/site/jacoco/index.html
##### Jarin generointi
```mvn package```
generoi hakemistoon target suoritettavan jar-tiedoston, jonka voi suorittaa komennolla 
```java -jar target/connect4-1.0-SNAPSHOT.jar```
##### JavaDoc
```mvn javadoc:javadoc``` luo javadocin, jota voi tarkastella selaimella /target/site/apidocs/index.html
##### Checkstyle
```mvn jxr:jxr checkstyle:checkstyle```
tarkistaa checkstyle-määrittelyn mukaiset tarkistukset, selaimella target/site/checkstyle.html
