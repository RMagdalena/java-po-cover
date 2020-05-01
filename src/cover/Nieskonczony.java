package cover;

import java.util.HashSet;
import java.util.Set;

public class Nieskonczony extends Skladnik {
    private int poczatek;
    private int postep;

    public Nieskonczony(int poczatek, int postep) {
        this.poczatek = poczatek;
        this.postep = postep;
    }

    @Override
    Set<Integer> wspolneWartosci(ZbiorDoPokrycia zbiorDoPokrycia) {
        Set<Integer> pokrycie = new HashSet<>();

        for (int i = poczatek; i <= zbiorDoPokrycia.OstatniElement(); i += postep) {
            pokrycie.add(i);
        }
        return pokrycie;
    }
}
