Ohjelma koostuu kahdesta paketista, astro ja gui. Astro-paketissa on ohjelman toiminnallisuuteen liittyvät luokat
ja gui-paketissa käyttöjärjestelmään liityvät.

Body-luokan ilmentymät kuvaavat planeettajärjestelmän eri kappaleita, joiden tiettyjä ominaisuuksia käyttäjä voi muuttaa
guin kautta. Myös VerletIntegrator voi muuttaa kappaleiden ominaisuuksia. Se hyödyntää laskuriluokkia (Acceleration-, Force-,
Position- ja VelocityCalculator) ajaessaan systeemin integrointia eteenpäin.

Gui-paketin App-luokka käynnistää koko ohjelman, luo sen alkutilan ja käynnistää integroinnin. GUI-luokka vastaa niistä
toiminnoista, mitä käyttöliittymässä voi tehdä. Se käyttää apunaan erilaisia Listener-luokkia, jotka vastaavat siitä että
käyttöliittymän eri komponentit aikaansaavat toimintaa. DrawingBoard luokkaa hoitaa planeettajärjestelmän piirtämisen ruudulle.
