import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Essai_Scanner {
    public static void main(String [] args) {
        Scanner my_scanner;
        int ligne = 0;

        my_scanner = new Scanner(System.in);
        boolean ok = false;
        while (!ok) {
            System.out.println("Saisissez une ligne");
            try {
                ligne = my_scanner.nextInt();
                ok = true;
            } catch (InputMismatchException i) {
                System.out.println("mismatch");
                my_scanner.next();
            } catch (NoSuchElementException e) {
                System.out.println("Aucune ligne saisie");
                return;
            }
        }


        System.out.println("Vous avez saisi la ligne : " + ligne);
    }
}