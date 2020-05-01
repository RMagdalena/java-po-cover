package cover;

import java.io.PrintStream;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        obslugaDanych(scanner, System.out);
    }

    public static void obslugaDanych(Scanner scanner, PrintStream out) {
        List<Zbior> rodzinaZbiorow = new ArrayList<>();
        Lexer lexer = new Lexer(scanner);

        while (lexer.czyJestNastepnyInt()) {
            if (lexer.czyNastepnyJestSkladnikiem()) {
                Set<Skladnik> skladnikiZbioru = new HashSet<>();
                while (!lexer.czyKoniecZbioru()) {
                    // Element
                    if (lexer.czySkladnikToElement()) {
                        Element nowy = new Element(lexer.nastepnyInt());
                        skladnikiZbioru.add(nowy);
                    }
                    // Nieskonczony
                    else if (lexer.czySkladnikToNieskonczony()) {
                        int poczatek = lexer.nastepnyInt();
                        int postep = -lexer.nastepnyInt();
                        skladnikiZbioru.add(new Nieskonczony(poczatek, postep));
                    }
                    //Skonczony
                    else if (lexer.czySkladnikToSkonczony()) {
                        int poczatek = lexer.nastepnyInt();
                        int postep = -lexer.nastepnyInt();
                        int koniec = -lexer.nastepnyInt();
                        skladnikiZbioru.add(new Skonczony(poczatek, postep, koniec));
                    }
                }
                lexer.nastepnyInt(); // konsumuje koncowe zero
                Zbior nowy = new Zbior(skladnikiZbioru);
                rodzinaZbiorow.add(nowy);
            }
            else if (lexer.czyNastepnyJestZapytaniem()) {
                ZbiorDoPokrycia zbiorDoPokrycia = new ZbiorDoPokrycia(-lexer.nastepnyInt());
                int numerAlgorytmu = lexer.nastepnyInt();
                Zapytanie zapytanie = new Zapytanie(zbiorDoPokrycia, numerAlgorytmu);

                wypiszPokrycie(zapytanie.znajdzPokrycieZbioru(rodzinaZbiorow), out);
            }
        }
    }


    private static void wypiszPokrycie(List<Integer> pokrycie, PrintStream out) {

        for (int i = 0; i < pokrycie.size(); i++) {
            out.print(pokrycie.get(i));
            if (i == pokrycie.size() - 1) {
                out.print("\n");
            }
            else {
                out.print(" ");
            }
        }
    }
}
