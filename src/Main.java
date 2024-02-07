import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String inputFile = "C:\\adam\\Uni\\L3S2\\PROG6\\ap-tds\\src\\test.txt";

            // Test LecteurNiveaux
            LecteurNiveaux lecteurNiveaux = new LecteurNiveaux(inputFile);
            List<Niveau> niveauxList = lecteurNiveaux.getNiveauxList();

            // Lecture
            lecteurNiveaux.lectureNiveau();

            // Test list niveau, y a t-il une autre methode pour ne pas perdre les niveaux?
            // TODO : a revoir
            for (Niveau niveau : niveauxList) {
                System.out.println("Level Name: " + niveau.nom());
                System.out.println("Number of Rows: " + niveau.lignes());
                System.out.println("Number of Columns: " + niveau.colonnes());
            }

            // Test RedacteurNiveau avecFileOutputStream
            try (RedacteurNiveau redacteur = new RedacteurNiveau(new FileOutputStream("output.txt"))) {
                for (Niveau niveau : niveauxList) {
                    redacteur.ecrisNiveau(niveau);
                }

                // les erreurs rencontrer
            } catch (IOException e) {
                System.err.println("Erreur d'ecriture dans le fichier " + e.getMessage());
            }
            // un catch obligatoire je sais pas pourquoi mais erreur sinon
            // TODO : understand why
            catch (Exception e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Fichier inexistant " + e.getMessage());
        }
    }
}
