package cover;

import java.math.BigInteger;
import java.util.*;

public class Dokladny extends Algorytm {
    @Override
    public List<Integer> wybierzZbioryPokrywajace(List<Zbior> rodzinaZbiorow, ZbiorDoPokrycia zbiorDoPokrycia) {

        int ileZbiorow = rodzinaZbiorow.size();
        BigInteger maksPlusJeden = BigInteger.ONE.shiftLeft(ileZbiorow);

        List<Integer> zbior = new ArrayList<>(rodzinaZbiorow.size());
        for (int i = 0; i < rodzinaZbiorow.size(); i++) {
            zbior.add(i + 1);
        }

        int minimalnaLiczbaPodzbiorow = 0;
        List<Integer> wybrany = new LinkedList<>();

        for (BigInteger i = BigInteger.ONE; i.compareTo(maksPlusJeden) < 0; i = i.add(BigInteger.ONE)) {

            List<Integer> nowyPodzbior = zamienBigIntegerNaPodzbior(zbior, i);

            if (wybrany.isEmpty() || nowyPodzbior.size() < minimalnaLiczbaPodzbiorow) {
                Set<Integer> tworzony = new HashSet<>();

                for (Integer integer : nowyPodzbior) {
                    int indnex = integer - 1;
                    tworzony.addAll(rodzinaZbiorow.get(indnex).wspolneWartosci(zbiorDoPokrycia));
                }
                if (tworzony.size() == zbiorDoPokrycia.OstatniElement()) {
                    minimalnaLiczbaPodzbiorow = nowyPodzbior.size();
                    wybrany = nowyPodzbior;
                }
            }
        }
        if (wybrany.isEmpty()) {
            wybrany.add(0);
        }
        return wybrany;
    }

    private static List<Integer> zamienBigIntegerNaPodzbior(List<Integer> zbior, BigInteger podzbior) {
        List<Integer> nowy = new LinkedList<>();
        int i = 0;
        for (Integer element : zbior) {
            if (podzbior.testBit(i)) {
                nowy.add(element);
            }
            i++;
        }
        return nowy;
    }
}
