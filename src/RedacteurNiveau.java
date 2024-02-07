import java.io.OutputStream;
import java.io.PrintStream;

public class RedacteurNiveau implements AutoCloseable {
    private PrintStream printStream;

    public RedacteurNiveau(OutputStream outputStream) {
        this.printStream = new PrintStream(outputStream);
    }

    public void ecrisNiveau(Niveau niveau) {
        // Écris le nom du niveau
        printStream.println("Nom du Niveau: " + niveau.nom());

        // Écris le contenu du niveau
        for (int i = 0; i < niveau.lignes(); i++) {
            for (int j = 0; j < niveau.colonnes(); j++) {
                // solved problem first character missing while reading, solution LecteurNiveaux in the ";" case, starting j=1.
                if (niveau.monTableau[i][j] != '\0'){
                    //print => same ligne, println => new line.
                    printStream.print(niveau.monTableau[i][j]);
                }
            }
            printStream.println();  // Nouvelle ligne après chaque ligne du tableau
        }

        //printStream.println();  // Ligne vide entre les niveaux
        printStream.flush();    // Assurez-vous que les données sont écrites sur le flux de sortie voir documentation si j'oublie
    }


    //IDE suggested this, no idea why but without it theres an error.
    //TODO : understand why

    @Override
    public void close() throws Exception {
        // Ferme le PrintStream
        if (printStream != null) {
            printStream.close();
        }
    }
}
