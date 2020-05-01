package cover;

import java.util.Scanner;
import java.util.Stack;

public class Lexer {

    private Scanner scanner;
    private Stack<Integer> buffor = new Stack<>();

    public Lexer(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean czyJestNastepnyInt() {
        return scanner.hasNext() || !buffor.empty();
    }

    public int nastepnyInt() {
        if (!buffor.empty()) {
            return buffor.pop();
        }
        else {
            return scanner.nextInt();
        }
    }

    public void odlozDoBufforu(int liczba) {
        buffor.add(liczba);
    }


    public boolean czyNastepnyJestSkladnikiem() {
        if (czyJestNastepnyInt()) {
            int nastepny = nastepnyInt();
            odlozDoBufforu(nastepny);
            return nastepny >= 0;
        }
        return false;
    }

    public boolean czyNastepnyJestZapytaniem() {
        if (czyJestNastepnyInt()) {
            int nastepny = nastepnyInt();
            odlozDoBufforu(nastepny);
            return nastepny < 0;
        }
        return false;
    }

    public boolean czySkladnikToElement() {
        int ominPierwszy = nastepnyInt();
        if (czyJestNastepnyInt()) {
            int nastepny = nastepnyInt();
            odlozDoBufforu(nastepny);
            odlozDoBufforu(ominPierwszy);
            return nastepny >= 0;
        }
        odlozDoBufforu(ominPierwszy);
        return false;
    }

    public boolean czySkladnikToSkonczony() {
        int ominPierwszy = nastepnyInt();
        if (czyJestNastepnyInt()) {
            int nastepny1 = nastepnyInt();
            if ((nastepny1 < 0) && (czyJestNastepnyInt())) {
                int nastepny2 = nastepnyInt();
                odlozDoBufforu(nastepny2);
                odlozDoBufforu(nastepny1);
                odlozDoBufforu(ominPierwszy);

                return nastepny2 < 0;
            }
            odlozDoBufforu(nastepny1);
        }
        odlozDoBufforu(ominPierwszy);
        return false;
    }

    public boolean czySkladnikToNieskonczony() {
        int ominPierwszy = nastepnyInt();
        if (czyJestNastepnyInt()) {
            int nastepny1 = nastepnyInt();
            if ((nastepny1 < 0) && (czyJestNastepnyInt())) {
                int nastepny2 = nastepnyInt();
                odlozDoBufforu(nastepny2);
                odlozDoBufforu(nastepny1);
                odlozDoBufforu(ominPierwszy);
                return nastepny2 >= 0;
            }
            odlozDoBufforu(nastepny1);
        }
        odlozDoBufforu(ominPierwszy);
        return false;
    }

    public boolean czyKoniecZbioru() {
        if (czyJestNastepnyInt()) {
            int nastepny = nastepnyInt();
            odlozDoBufforu(nastepny);
            return nastepny == 0;
        }
        return false;
    }
}
