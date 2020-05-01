package cover;

import java.util.HashSet;
import java.util.Set;

public class Skonczony extends Skladnik {
    private int poczatek;
    private int postep;
    private int koniec;

    public Skonczony(int poczatek, int postep, int koniec) {
        this.poczatek = poczatek;
        this.postep = postep;
        this.koniec = koniec;
    }

    @Override
    Set<Integer> wspolneWartosci(ZbiorDoPokrycia zbiorDoPokrycia) {
        Set<Integer> pokrycie = new HashSet<>();

        for (int i = poczatek; i <= koniec && i <= zbiorDoPokrycia.OstatniElement(); i += postep) {
            pokrycie.add(i);
        }
        return pokrycie;
    }
}
