package pl.ciecierski.sbh.sections;

import java.util.LinkedList;

class RandomTextFromSection {

    String getRandomDialogFromSection(Sections s) {
        int listRandomIndex;
        LinkedList<String> to = new LinkedList<>();

        switch (s) {
            case BYDGOSZCZ_1920:
                if (to.size() == 0) {
                    to.add("1 kwietnia 1920 roku włączono do Bydgoszczy Wilczak Wielki – obecnie Wilczak.");
                    to.add("1 kwietnia 1920 roku włączono do Bydgoszczy Wilczak – obecnie Miedzyń");
                    to.add("1 kwietnia 1920 roku włączono do Bydgoszczy Wilczak Mały – obecnie Okole.");
                    to.add("1 kwietnia 1920 roku włączono do Bydgoszczy Kapuściska Małe – obecnie Bydgoszcz-wschód.");
                    to.add("1 kwietnia 1920 roku włączono do Bydgoszczy Wilczak Dolne – obecnie Siernieczek.");
                    to.add("1 kwietnia 1920 roku włączono do Bydgoszczy Kapuściska Wielkie – obecnie Zimne Wody.");
                    to.add("Okole to dawna nazwa Wyspy Młyńskiej - sprzed 1 kwietnia 1920r.");
                    to.add("845 hektarów zajmowała Bydgoszcz przed 1 kwietnia 1920r.");
                    to.add("Po dołączeniu przedmieść po 1 kwietnia 1920 obszar Bydgoszczy powiększył się ośmiokrotnie i wynosił 6523,65 hektarów");
                    to.add("Obecnie w Bydgoszczy jest 31 parków o łącznej powierchni ponad 876 hektarów");
                    to.add("Pierwsza pisemna wzmianka o Bydgoszczy - 1238r. Prawa miejskie - 1346r.");
                    to.add("2 sierpnia 1914r. w Bydgoszczy ogłoszono stan wojenny.");
                    to.add("Miesiąc od rozpoczęcia I Wojny Światowej w Bydgoszczy istniało 10 lazaretów.");
                    to.add("Do końca 1914r. powstało 20 lazaretów, gdzie leczono jednocześnie nawet 3000 rannych żołnierzy.");
                    to.add("W 1916 r. swoją działalność rozpoczęły  Zakłady Amunicyjne na Osowej Górze.");
                    to.add("Pierwsza pisemna wzmianka o Bydgoszczy - 1238r. Prawa miejskie - 1346r.");
                    to.add("Nocą z 10 na 11 listopada 1918r. w mieście doszło do starcia grupki niemieckich żołnierzy z patrolem Rady Żołnierskiej.");
                    to.add("19 listopada 1918r. w Bydgoszczy rozporządzeniem Rady Robotników i Żołnierzy wprowadzono sądownictwo wojenne.");
                    to.add("W połowie grudnia 1919r. mianowano Stanisława Niesiołowskiego komisarycznym Starostą bydgoskim.");
                    to.add("Przygotowania do powitania Wojska Polskiego w Bydgoszczy  trwały już od lipca 1919 roku.");
                    to.add("Koszt przystrojenia ulic w celu powitania Wojska Polskiego w 1920r. wyniósł 35 400 Reichsmarek.");
                    to.add("17 stycznia 1920r. rozkazem nr 24 Ministra Spraw Wojskowych 2 Dywizja Strzelców Wielkopolskich została przemianowana na 15 Dywizję Piechoty Wielkopolskiej.");
                    to.add("Od 17 stycznia 1920r. z ramienia Podkomisariatu Narodowej Rady Ludowej w Hotelu „Adler” funkcjonowało biuro informacyjne ds. przyjęcia Wojska Polskiego.");
                    to.add("19 stycznia 1920r., o godz. 18:00 w Ratuszu Miejskim odbyło się uroczyste przekazanie miasta w polskie władanie.");
                    to.add("Pierwszym wojskowym komendantem miasta został ppłk Witold Butler.");
                    to.add("Według danych z przełomu 1928/1929r. Polacy stanowili 92% populacji miasta.");
                    to.add("22 stycznia 1920r. do Bydgoszczy przybył dowódca Frontu Wielkopolskiego gen. Józef Dowbor-Muśnicki");
                    to.add("22 stycznia 1920r. po uroczystościach na Rynku odbyła się defilada wojsk ulicą Gdańską.");
                    to.add("25 stycznia o godzinie 16 do miasta wkroczyła reszta pododdziałów dawnego 8 Pułku Strzelców Wielkopolskich, obecnie przemianowanego na 62 pp. Wlkp.");
                    to.add("20 maja 1919r. do restauracji Sikorskiego znajdującej się przy ul. Gdańskiej wtargnęli członkowie Grenzschutzu i obrzucili granatami zebranych Polaków.");
                    to.add("30 maja 1919r. trzech żołnierzy Grenzschutzu wtargnęło na teren kościoła farnego i obrzucili kamieniami grotę Matki Boskiej z Lourdes.");
                    to.add("18 lutego 1919r., doszło do potyczki pod Rynarzewem, która zakończyła się zdobyciem niemieckiego pociągu pancernego.");
                    to.add("25 listopada 1919r. podpisano umowę o wycofaniu wojsk z odstąpionych obszarów oraz przekazaniu w ręce polskie zarządu cywilnego nad tymi obszarami.");
                }
                listRandomIndex = (int) (Math.random() * to.size());
                return (listRandomIndex + 1) + ".\n" + to.get(listRandomIndex);

            case BYDGOSZCZ_1945:
                if (to.size() == 0) {
                    to.add("Pierwsza pisemna wzmianka o Bydgoszczy - 1238r. Prawa miejskie - 1346r.");
                    to.add("24 stycznia Roman Borowski, oficer Ludowego Wojska Polskiego, razem z gronem obywateli organizuje Tymczasowy Komitet Obywatelski; faktyczna władza należy jednak do wojskowej administracji radzieckiej i NKWD.");
                    to.add("28 stycznia wybuchł pożar Teatru Miejskiego wywołany przez żołnierzy radzieckich.");
                    to.add("28 stycznia powstaje 40-osobowa orkiestra symfoniczna pod kierunkiem Z. Nowakowskiego.");
                    to.add("28 stycznia ukazuje się pierwszy numer „Wiadomości Bydgoskich”, 2 marca gazety codziennej „Ziemia Pomorska”, a 15 kwietnia „Trybuny Pomorskiej” – organu PPR.");
                    to.add("Pod stycznia do kwietnia NKWD prowadzi deportacje osób uznanych, często niesłusznie za kolaborantów: z Bydgoszczy (1635 osób), Fordonu (102 osoby) i całego Pomorza do ZSRR; Polacy umieszczani są w łagrach na Uralu i na Ukrainie; większość jesienią powraca do kraju, kilkaset umiera; NKWD wspólnie z MBP prowadzi również aresztowania polskich działaczy konspiracyjnych AK, korzystając m.in. z przejętej agentury gestapo.");
                    to.add("3 lutego przybywa do Bydgoszczy grupa operacyjna „Pomorze” KC PPR, wyznaczona przez Ministerstwo Przemysłu i Biuro Ekonomiczne przy Radzie Ministrów w celu organizacji administracji, służb siłowych (milicja, urząd bezpieczeństwa), zabezpieczenia majątku, uruchamiania przedsiębiorstw, prac przy reformie rolnej.");
                    to.add("5 lutego odbywa się organizacja na wzór NKWD Pomorskiego Urzędu Bezpieczeństwa Publicznego, który rozpoczyna walkę z podziemiem zbrojnym oraz inwigilację środowisk społecznych, w tym młodzieży.");
                    to.add("20 lutego następuje otwarcie w Bydgoszczy Pomorskiego Oddziału Polskiej Agencji Prasowej (zasięg: Pomorze i Mazury.)");
                    to.add("12 lutego w 10 szkołach powszechnych w Bydgoszczy rozpoczyna naukę 12 tys. dzieci.");
                    to.add("19 lutego następuje wznowienie pracy Biblioteki Miejskiej i Konserwatorium Muzycznego.");
                    to.add("21 lutego powstaje 40-osobowa Tymczasowa Rada Narodowa miasta Bydgoszczy (17 marca przekształcona w stałą Miejską Radę Narodową) oraz Tymczasowy Komitet Wojewódzki z I sekretarzem Antonim Alsterem, który pozostaje na tym stanowisku do 1947; w prasie pojawiają się informacje o planowanym ulokowaniu władz wojewódzkich w Bydgoszczy, co forsują u wicepremiera, ministra Ziem Odzyskanych Władysława Gomułki przedstawiciele Rządu Tymczasowego oddelegowani na teren Pomorza.");
                    to.add("27 lutego następuje aresztowanie przez funkcjonariuszy MBP i NKWD ppor. Leszka Białego, szefa łączności Okręgu Pomorze AK, który zostaje zamordowany w gmachu Urzędu Bezpieczeństwa Publicznego przy ul. Poniatowskiego 5.");
                    to.add("po wyzwoleniu w mieście pozostaje ok. 3 tys. Niemców (38 tys. wyjechało przed radziecką ofensywą); Niemcy są skoszarowani w więzieniu przy Nowym Rynku, obozach tymczasowych oraz dużych obozach internowania w Zimnych Wodach i Łęgnowie (po ok. 1 tys. osób), jesienią przeniesieni do Centralnego Obozu Pracy w Potulicach; dzieci niemieckie lokowane są w domach dziecka; razem z Niemcami więziona jest pewna liczba Polaków, którzy należąc do III grupy Volksliste zostali zadenuncjowani jako kolaboranci; z powodu złych warunków, braku pożywienia i okrucieństwa strażników wysoka jest śmiertelność.");
                    to.add("od lutego do maja Armia Radziecka wywozi z bydgoskich zakładów przemysłowych wyposażenie i zapasy, szerzą się grabieże, gwałty i dewastacje; 25 kwietnia przedstawiciele Misji Ekonomicznej ZSRR przedstawiają pełnomocnikowi Rządu na Pomorze Antoniemu Alsterowi plan demontażu urządzeń z 66 zakładów z województwa pomorskiego, w tym 30 zakładów bydgoskich i 250 statków z flotylli Kanału Bydgoskiego, wobec protestów władz polskich całkowita wywózka urządzeń następuje tylko z DAG Fabrik Bromberg, a częściowa m.in. z zakładów elektrotechnicznych Ciszewskiego, zakładu sygnałów kolejowych.");
                    to.add("2 marca wydana jest decyzja na szczeblu rządowym o przeniesieniu Pomorskiego Urzędu Wojewódzkiego z Torunia (będącego w organizacji od 5 lutego) i dalszej jego organizacji w Bydgoszczy; oficjalne stanowisko przekazuje 17 marca pełnomocnik Rządu Tymczasowego na województwo pomorskie Henryk Świątkowski wskazując, że Bydgoszcz wyznaczono ośrodkiem administracji publicznej z racji pełnienia funkcji centrum przemysłowego i komunikacyjnego regionu, podczas gdy Toruń ma zostać ośrodkiem kulturalno-oświatowym Pomorza; argumenty polityczne to korzystniejsze warunki w Bydgoszczy dla rozwoju struktur nowej władzy opartej na PPR, niż w Toruniu opanowanym przez działaczy PPS.");
                    to.add("8 marca powstaje Pomorska Okręgowa Dyrekcja Polskiego Radia w Bydgoszczy; obejmuje całe Pomorze z Gdańskiem i Szczecinem włącznie.");
                    to.add("24 marca pod kierownictwem dyrektora Aleksandra Rodziewicza zespół teatralny wystawia swą pierwszą premierę Zemstę Aleksandra Fredry w Teatrze Elysium przy al. Mickiewicza; założenie przez Adama Grzymałę-Siedleckiego i Aleksandra Rodziewicza Szkoły Dramatycznej kształcącej aktorów teatralnych (działa do 1948, od 1949 Studium dla Reżyserów Teatrów Amatorskich); w następnych miesiącach rozpoczynają działalność teatry amatorskie m.in. Teatr Aktualności, Teatr Rewii, Teatr Literacki, Teatr Powszechny Towarzystwa Uniwersytetów Robotniczych, Pomorski Związek Teatrów Ludowych itp.");
                    to.add("15 marca powstaje rozkaz o formowaniu w Bydgoszczy, Fordonie i Koronowie 14. Dywizji Piechoty – ostatniej dywizji Wojska Polskiego formowanej w okresie działań wojennych, wchodzącej w skład Odwodu Naczelnego Dowództwa WP obok 11.DP (Łódź), 12.DP (Poznań) i 13.DP (Katowice); dywizja uczestniczy w walkach z podziemiem zbrojnym na wschodzie kraju i w Bieszczadach, wraca na Pomorze w 1949, rozwiązana w 1957.");
                    to.add("w marcu powstaje w Bydgoszczy Okręgowa Dyrekcja Przedsiębiorstwa „Film Polski” obejmująca region bydgoski, toruński, włocławski, pilski, gdański i olsztyński.");
                    to.add("30 marca wydany został dekret Rządu Tymczasowego o utworzeniu województwa gdańskiego z 6 północnych powiatów dotychczasowego województwa pomorskiego z siedzibą w Bydgoszczy.");
                    to.add("od marca do grudnia w mieście funkcjonują 3 polowe szpitale ewakuacyjne rozmieszczone w kilkunastu budynkach szkolnych i użyteczności publicznej.");
                    to.add("w kwietniu następuje reaktywacja Izby Rzemieślniczej w Bydgoszczy, której podlegają cechy i rzemieślnicy w całym województwie pomorskim.");
                    to.add("1 maja odbywa się inauguracja działalności Rozgłośni Pomorskiej Polskiego Radia w Bydgoszczy, która otrzymuje budynki przy ul. Gdańskiej 48-50.");
                    to.add("w maju powstaje Klub Literacko-Artystyczny, do którego należą m.in. Zygmunt Felczak, Marian Turwid, Jan Piechocki, Alfred Kowalkowski[1]; inauguracja Teatru Lalki i Aktora założonego przez Irenę Pikiel-Samorewiczową i Jadwigę Badowską.");
                    to.add("15 maja odbywa się atak NKWD na oddział partyzancki AK por. Alojzego Bruskiego w Puszczy Bydgoskiej; w maju aresztowanie działaczy bydgoskiego obwodu Okręgowej Delegatury Rządu Londyńskiego, działaczy AK; w grudniu por. Zbigniew Smoleński i por. Alojzy Bruski zostają skazani na śmierć i straceni (Bruskiemu Bolesław Bierut osobiście zamienia karę dożywocia na karę śmierci).");
                    to.add("27 maja następuje oddanie do użytku wiernym kościoła św. Wincentego à Paulo zdewastowanego i podpalonego pod koniec okupacji niemieckiej.");
                    to.add("31 maja w uroczystej procesji Bożego Ciała w farze uczestniczą władze państwowe – wiceprezydent Władysław Jagniewski, pułk Wojska Polskiego, przedstawiciel Armii Radzieckiej, orkiestra MO (oficjalny udział władz w uroczystościach religijnych ma miejsce do roku 1948 włącznie).");
                    to.add("12 czerwca w mieście działa 20 szkół powszechnych, 3 szkoły średnie ogólnokształcące, 1 gimnazjum krawieckie, 1 liceum administracyjno-handlowe, 1 gimnazjum kupieckie, 1 publiczna szkoła dokształcająca zawodowa, 1 szkoła gospodarstwa wiejskiego i 2 publiczne szkoły powszechne dla dorosłych.");
                    to.add("19 czerwca powstaje bydgoski komitet do badania zbrodni niemieckich na Pomorzu (przewodniczący Tadeusz Esman), w grudniu 1945 przekształcony w okręgowy komitet Głównej Komisji Badania Zbrodni Niemieckich w Polsce (działa do połowy 1949).");
                    to.add("22 czerwca powstaje bydgoski oddział Związku Polskich Artystów Plastyków; w jego skład wchodzi też oddział olsztyński; 2 grudnia odbywa się w Bydgoszczy walny zjazd ZPAP.");
                    to.add("1 lipca odbywa się inauguracja Radiowej Orkiestry Symfonicznej (dyrygent Arnold Rezler), która upiększa na żywo audycje Pomorskiej Rozgłośni Polskiego Radia w Bydgoszczy.");
                    to.add("7 lipca do województwa pomorskiego włączone są powiaty: człuchowski i złotowski (29 maja 1946 przekazane nowo powołanemu województwu szczecińskiemu).");
                    to.add("15 lipca odbywa się w Bydgoszczy Ogólnopolski Zjazd Stronnictwa Pracy.");
                    to.add("16 lipca ukazuje się pierwszy numer tygodnika „Kuriera Sportowego” wydawanego w Bydgoszczy z ekspozyturami w Inowrocławiu, Toruniu, Poznaniu i Krakowie; do 1947 największego i najlepiej kolportowanego pisma sportowego w kraju.");
                    to.add("12 sierpnia następuje pierwsze Ogólnopolskie Regaty Wioślarskie na torze w Brdyujściu z udziałem 226 zawodników z 16 klubów.");
                    to.add("w sierpniu następuje reaktywacja Stowarzyszenia Techników Polskich w Bydgoszczy, przemianowanego później na Pomorską Organizację Techniczną z oddziałami we: Włocławku (1951), Grudziądzu (1957), Inowrocławiu (1959), Toruniu (1960) i Chojnicach (1975).");
                    to.add("24 sierpnia dekretem KRN powstaje Uniwersytet Mikołaja Kopernika w Toruniu, w którym zatrudnienie znajduje kadra zlikwidowanego Uniwersytetu Wileńskiego; nie znajduje poparcia koncepcja prof. Ludwika Kolankowskiego o rozdziale wydziałów uniwersytetu między miasta: Toruń, Gdańsk i Bydgoszcz.");
                    to.add("30 sierpnia następuje powołanie na wniosek Witolda Bełzy Komitetu Obchodów 600-lecia miasta Bydgoszczy powiązanych z Pomorską Wystawą Przemysłu, Rzemiosła i Handlu[35]; ustalenie planu odbudowy i rozbiórek wypalonych budynków (w tym Teatru Miejskiego) oraz rozwoju placówek kulturalnych.");
                    to.add("1 września funkcję prezydenta miasta obejmuje Józef Twardzicki; 3 września odbywa się msza św. i apel poległych na Starym Rynku ku uczczeniu „krwawej niedzieli” z udziałem władz, wojska, harcerzy, uczniów, rzemieślników.");
                    to.add("11 września następuje zatwierdzenie przez Ministerstwo Kultury i Sztuki powołania Szkoły Sztuk Plastycznych w Bydgoszczy z dyrektorem Marianem Turwidem (od 31 sierpnia 1946 Państwowa Szkoła Sztuk Plastycznych, od 1961 Państwowe Liceum Sztuk Plastycznych).");
                    to.add("30 września odbywa się reaktywacja Polskiego Związku Towarzystw Wioślarskich z siedzibą w Bydgoszczy[39] oraz Polskiego Związku Kajakowego (w 1950 przeniesione do Warszawy).");
                    to.add("12 października na podstawie decyzji Ministerstwa Kultury i Sztuki zostaje połączony Teatr Polski w Bydgoszczy z Teatrem Ziemi Pomorskiej w Toruniu (dyrektor Aleksander Rodziewicz).");
                    to.add("22 października z inicjatywy Zygmunta Felczaka ukazuje się pierwszy numer Ilustrowanego Kuriera Polskiego – gazety ogólnopolskiej Stronnictwa Pracy.");
                    to.add("28 października na zaprzysiężenie 14. Dywizji Piechoty przybywa marszałek Polski Michał Rola-Żymierski, któremu miasto nadaje Honorowe Obywatelstwo, we mszy św. uczestniczą m.in. gen. Karol Świerczewski, wojewoda Kazimierz Pasenkiewicz, kilka dni później odbywa się Święto Podchorążego, podczas którego otwarta zostaje pierwsza w kraju Oficerska Szkoła Samochodowa w Bydgoszczy.");
                    to.add("w październiku następuje utworzenie na bazie Miejskiego Konserwatorium Muzycznego Państwowej Średniej i Niższej Szkoły Muzycznej.");
                    to.add("5 listopada następuje przydzielenie przez wojewodę kościoła Zbawiciela parafii ewangelicko-augsburskiej; katolicy otrzymują byłe zbory ewangelickie: św. Piotra i Pawła, św. Krzyża, na Okolu, Wilczaku i Bartodziejach Małych.");
                    to.add("7 listopada następuje odsłonięcie pomnika Wdzięczności Żołnierzom Armii Czerwonej autorstwa Jana Kossowskiego.");
                    to.add("18-19 listopada w Bydgoszczy przebywają: premier Tymczasowego Rządu Jedności Narodowej Edward Osóbka-Morawski oraz Stanisław Mikołajczyk na zjeździe wojewódzkim PSL.");
                    to.add("26 listopada rozpoczyna się ekshumacja ofiar zbrodni hitlerowskich w miejscach masowych egzekucji z udziałem komisji sądowo-lekarskich (trwają do 3 czerwca 1948, wydobyto 1795 zwłok); 1 grudnia odbywa się manifestacyjny pogrzeb 400 ekshumowanych polskich ofiar na Starym Rynku w asyście 20 księży.");
                    to.add("w listopadzie wychodzi czasopismo kulturalne „Arkona”, którego pomysłodawcą i redaktorem jest Marian Turwid (oddziały w Warszawie i Poznaniu).");
                    to.add("jesienią następuje utworzenie w obiektach DAG Fabrik Bromberg Państwowej Wytwórni Prochu w Łęgnowie, zaś w 1948 wytwórni chemicznych nr 9 i 11, które w latach 50. przekształcone są w Zakłady Chemiczne Zachem; dyrektor inż. E. Smoliński w 1947 zostaje aresztowany przez MBP i stracony w 1949.");
                    to.add("20 grudnia następuje reaktywacja Bydgoskiego Towarzystwa Lekarskiego (od 1952 oddział wojewódzki Polskiego Towarzystwa Lekarskiego); powołanie Okręgowej Izby Aptekarskiej w Bydgoszczy.");
                    to.add("Uruchomienie Wojskowych Zakładów Lotniczych nr 2[47]; w mieście znajduje się 209 zakładów przemysłowych, w tym część czeka na uruchomienie.");
                    to.add("Wśród partii politycznych walczących o wpływy w Bydgoszczy liczą się: Polska Partia Robotnicza, Polska Partia Socjalistyczna, Stronnictwo Pracy i Stronnictwo Demokratyczne.");
                    to.add("Bydgoszcz jest siedzibą kierownictw organizacji podziemnych, m.in. Komendy Pomorskiej Okręgu Wolność i Niezawisłość, sztabu pomorskiego Narodowych Sił Zbrojnych, lokali kontaktowych Brygady Wileńskiej „Łupaszki”, Okręgu Pomorskiego Stronnictwa Narodowego i Narodowego Zjednoczenia Wojskowego, podziemnego skautingu i organizacji młodzieżowych nawiązujących do tradycji Armii Krajowej oraz endecji; organizacje te zostają rozbite do końca 1948.");
                }
                listRandomIndex = (int) (Math.random() * to.size());
                return (listRandomIndex + 1) + ".\n" + to.get(listRandomIndex);


            case THIRD_SECTION:
                return "3cia sekcja";


            case FOURTH_SECTION:
                return "4ta sekcja";


            default:
                return "";
        }


    }

}
