package cover;

import java.util.List;

public class Zapytanie {

    private ZbiorDoPokrycia zbiorDoPokrycia;
    private int numerAlgorytmu;

    public Zapytanie(ZbiorDoPokrycia zbiorDoPokrycia, int numerAlgorytmu) {
        this.zbiorDoPokrycia = zbiorDoPokrycia;
        this.numerAlgorytmu = numerAlgorytmu;
    }

    public List<Integer> znajdzPokrycieZbioru(List<Zbior> rodzinaZbiorow) {
        if (numerAlgorytmu == 1) {
            return new Dokladny().wybierzZbioryPokrywajace(rodzinaZbiorow, zbiorDoPokrycia);
        }
        else if (numerAlgorytmu == 2) {
            return new Zachlanny().wybierzZbioryPokrywajace(rodzinaZbiorow, zbiorDoPokrycia);
        }
        else {
            return new Naiwny().wybierzZbioryPokrywajace(rodzinaZbiorow, zbiorDoPokrycia);
        }
    }
}