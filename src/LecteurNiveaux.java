import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LecteurNiveaux {

    //TODO : refactor

    String file = "" ;
    Niveau currentNiveau;
    Scanner scanner;
    List<Niveau> niveauxList = new ArrayList<>();


    public LecteurNiveaux(String file) throws FileNotFoundException {
        this.file = file;
        this.scanner = new Scanner(new File(file));
    }



    public List<Niveau> getNiveauxList() {
        return niveauxList;
    }

    void lectureNiveau() {
        scanner.useDelimiter("");

        // TODO: Make sure with a teacher that i am reallocating space the right way
        int numRows = 5;
        int numCols = 5;
        currentNiveau = new Niveau(numRows,numCols);
        int i=0;
        int j=0;
        while (scanner.hasNext()) {
            if (j >= numCols){
                currentNiveau.resizeArray(numRows, numCols * 2);
                numCols *= 2; // Update the number of columns
            }
            if (i >= numRows){
                currentNiveau.resizeArray(numRows * 2, numCols);
                numRows *= 2; // Update the number of rows
            }
            char current = scanner.next().charAt(0);
            //floor
            if (current == ' ' || current == '\r'){
                currentNiveau.monTableau[i][j] = ' ';
                j++;
            }
            //wall
            else if (current == '#'){
                currentNiveau.ajouteMur(i,j);
                j++;
            }
            //i++
            else if (current == '\n'){
                // first character is \n and i=j=0 => end of file
                if (i==0 && j==0 ){
                    break;
                }
                i++;
                j=0;
            }
            //box
            else if (current == '$'){
                currentNiveau.ajouteCaisse(i,j);
                j++;
            }
            //goal square
            else if (current == '.'){
                currentNiveau.ajouteBut(i,j);
                j++;
            }
            //player
            else if (current == '@'){
                currentNiveau.ajoutePousseur(i,j);
                j++;
            }
            //commentaire
            else if (current == ';'){
                StringBuilder commentContent = new StringBuilder();

                // Read characters after ';' until '\n' is encountered
                while (scanner.hasNext() && current != '\n') {
                    current = scanner.next().charAt(0);
                    commentContent.append(current);
                }
                //consume empty line between diff niveau
                while (scanner.hasNext() && (current == '\n' || current == '\r')) {
                    //first character missing problem coming from here
                    current = scanner.next().charAt(0);
                }
                currentNiveau.fixeNom(commentContent.toString().trim());

                niveauxList.add(currentNiveau);
                currentNiveau = new Niveau(numRows,numCols);

                //Resolution of first character missing problem
                i=0;
                j=0;
                currentNiveau.monTableau[i][j] = current;
                j=1;





            }
            //player on goal square
            else if (current == '+'){
                currentNiveau.monTableau[i][j] = '+';
                j++;
            }
            //box on goal square
            else if (current == '*'){
                currentNiveau.monTableau[i][j] = '*';
                j++;
            }
        }
        //fin de fichier



        scanner.close();

    }
}
