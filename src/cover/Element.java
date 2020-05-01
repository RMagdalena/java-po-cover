package cover;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Element extends Skladnik {

    private int wartosc;

    public Element(int wartosc) {
        this.wartosc = wartosc;
    }

    @Override
    Set<Integer> wspolneWartosci(ZbiorDoPokrycia zbiorDoPokrycia) {
        Set<Integer> pokrycie = new HashSet<>();
        if (wartosc <= zbiorDoPokrycia.OstatniElement() && wartosc > 0) {
            pokrycie.add(wartosc);
        }
        return pokrycie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return wartosc == element.wartosc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wartosc);
    }
}
