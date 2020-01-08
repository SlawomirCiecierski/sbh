package pl.ciecierski.sbh.sections;

import java.util.LinkedList;

class RandomDialogFromSection {

    String getRandomDialogFromSection(Sections s){

        LinkedList<String> to = new LinkedList<>();

        switch (s) {
            case RETURN_TO_POLAND:
                if (to.size() == 0) {
                    to.add("1 kwietnia 1920 roku włączono do Bydgoszczy Wilczak Wielki – obecnie Wilczak.");
                    to.add("1 kwietnia 1920 roku włączono do Bydgoszczy Wilczak – obecnie Miedzyń");
                    to.add("1 kwietnia 1920 roku włączono do Bydgoszczy Wilczak Mały – obecnie Okole.");
                    to.add("1 kwietnia 1920 roku włączono do Bydgoszczy Kapuściska Małe – obecnie Bydgoszcz-wschód.");
                    to.add("1 kwietnia 1920 roku włączono do Bydgoszczy Wilczak Dolne – obecnie Siernieczek.");
                    to.add("1 kwietnia 1920 roku włączono do Bydgoszczy Kapuściska Wielkie – obecnie Zimne Wody.");
                    to.add("Okole to dawna nazwa Wyspy Młyńskiej - sprzed 1 kwietnia 1920.");
                    to.add("845 hektarów zamowała Bydgoszcz przed 1 kwietnia 1920r.");
                    to.add("Po dołączeniu przedmieść po 1 kwietnia 1920 obszar Bydgoszczy powiększył się ośmiokrotnie i wynosił 6523,65 hektarów");
                    to.add("Obecnie w Bydgoszczy jest 31 parków o łącznej powierchni ponad 876 hektarów");
                    to.add("Pierwsza pisemna wzmianka o Bydgoszczy - 1238r. Prawa miejskie - 1346r.");
                    to.add("2 sierpnia 1914 r. w Bydgoszczy ogłoszono stan wojenny.");
                    to.add("Miesiąc od rozpoczęcia I Wojny Światowej w Bydgoszczy istniało 10 lazaretów.");
                    to.add("Do końca 1914 r. powstało 20 lazaretów, gdzie leczono jednocześnie nawet 3000 rannych żołnierzy.");
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
                    to.add("Według danych z przełomu 1928/1929 r. Polacy stanowili 92% populacji miasta.");
                    to.add("22 stycznia 1920r. do Bydgoszczy przybył dowódca Frontu Wielkopolskiego gen. Józef Dowbor-Muśnicki");
                    to.add("22 stycznia 1920r. po uroczystościach na Rynku odbyła się defilada wojsk ulicą Gdańską.");
                    to.add("25 stycznia o godzinie 16 do miasta wkroczyła reszta pododdziałów dawnego 8 Pułku Strzelców Wielkopolskich, obecnie przemianowanego na 62 pp. Wlkp.");
                    to.add("20 maja 1919 r. do restauracji Sikorskiego znajdującej się przy u. Gdańskiej wtargnęli członkowie Grenzschutzu i obrzucili granatami zebranych Polaków.");
                    to.add("30 maja 1919 r. trzech żołnierzy Grenzschutzu wtargnęło na teren kościoła farnego i obrzucili kamieniami grotę Matki Boskiej z Lourdes.");
                    to.add("Od 18 stycznia 1919 r. do 21 stycznia 1920 roku trwała Konferencja Pokojowa w Paryżu.");
                    to.add("18 lutego 1919 r., doszło do potyczki pod Rynarzewem, która zakończyła się zdobyciem niemieckiego pociągu pancernego.");
                    to.add("25 listopada 1919 r. podpisano umowę o wycofaniu wojsk z odstąpionych obszarów oraz przekazaniu w ręce polskie zarządu cywilnego nad tymi obszarami.");
                }
                int listRandomIndex = (int) (Math.random() * to.size());
                return to.get(listRandomIndex);

            case ERYGOWANIE:
                return "Erygowanie";


            case THIRD_SECTION:
                return "3cia sekcja";


            case FOURTH_SECTION:
                return "4ta sekcja";


            default:
                return "";
        }



    }

}
