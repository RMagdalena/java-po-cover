package cover;

import java.util.HashSet;
import java.util.Set;

public class Zbior {
    private Set<Skladnik> skladniki;

    public Zbior(Set<Skladnik> skladniki) {
        this.skladniki = skladniki;
    }

    public Set<Integer> wspolneWartosci(ZbiorDoPokrycia zbiorDoPokrycia) {
        Set<Integer> pokryteElementy = new HashSet<>();

        for (Skladnik skladnik : skladniki) {
            Set<Integer> pokryteElementySkladnika = skladnik.wspolneWartosci(zbiorDoPokrycia);
            pokryteElementy.addAll(pokryteElementySkladnika);
        }
        return pokryteElementy;
    }
}
