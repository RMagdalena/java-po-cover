package cover;

import java.util.*;

public class Naiwny extends Algorytm {

    @Override
    public List<Integer> wybierzZbioryPokrywajace(List<Zbior> rodzinaZbiorow, ZbiorDoPokrycia zbiorDoPokrycia) {

        List<Integer> listaWybranych = new LinkedList<>();
        Set<Integer> tworzony = new HashSet<>();

        for (int i = 0; i < rodzinaZbiorow.size(); i++) {
            Set<Integer> aktualny = rodzinaZbiorow.get(i).wspolneWartosci(zbiorDoPokrycia);
            if (!tworzony.containsAll(aktualny)) {
                tworzony.addAll(aktualny);
                listaWybranych.add(i + 1);
            }
        }
        if (!(tworzony.size() == zbiorDoPokrycia.OstatniElement())) {
            listaWybranych.clear();
            listaWybranych.add(0);
        }
        return listaWybranych;
    }
}
