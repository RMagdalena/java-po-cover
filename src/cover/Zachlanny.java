package cover;

import java.util.*;

public class Zachlanny extends Algorytm {
    @Override
    public List<Integer> wybierzZbioryPokrywajace(List<Zbior> rodzinaZbiorow, ZbiorDoPokrycia zbiorDoPokrycia) {

        List<Integer> listaWybranych = new LinkedList<>();
        Set<Integer> tworzony = new HashSet<>();
        boolean szukajDalej = true;

        for (int i = 0; szukajDalej && tworzony.size() < zbiorDoPokrycia.OstatniElement(); i++) {
            int wybranyZbior = wybierzNajlepszyZbior(rodzinaZbiorow, tworzony, zbiorDoPokrycia);
            if (wybranyZbior > -1) {
                tworzony.addAll(rodzinaZbiorow.get(wybranyZbior).wspolneWartosci(zbiorDoPokrycia));
                listaWybranych.add(wybranyZbior + 1);
            }
            else {
                szukajDalej = false;
            }
        }
        if (!(tworzony.size() == zbiorDoPokrycia.OstatniElement())) {
            listaWybranych.clear();
            listaWybranych.add(0);
        }
        Collections.sort(listaWybranych);
        return listaWybranych;
    }

    private static int wybierzNajlepszyZbior(List<Zbior> rodzinaZbiorow, Set<Integer> tworzony, ZbiorDoPokrycia zbiorDoPokrycia) {

        int numerWybranegoZbioru = -1;
        int ileElementowDodano = 0;

        for (int i = 0; i < rodzinaZbiorow.size(); i++) {
            Set<Integer> nowy = new HashSet<>();
            nowy.addAll(tworzony);
            nowy.addAll(rodzinaZbiorow.get(i).wspolneWartosci(zbiorDoPokrycia));

            int dodane = nowy.size() - tworzony.size();

            if (dodane > ileElementowDodano) {
                ileElementowDodano = dodane;
                numerWybranegoZbioru = i;
            }
        }
        return numerWybranegoZbioru;
    }
}
