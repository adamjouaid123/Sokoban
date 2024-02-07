public class Niveau {


    public String nom;
    char[][] monTableau;
    int numRows, numCols;


    //Constructor
    public Niveau(int i, int j){
        nom="";
        monTableau = new char[i][j];
        numRows = i;
        numCols = j;
    }

    public void resizeArray(int newRows, int newCols) {
        char[][] newArray = new char[newRows][newCols];
        for (int i = 0; i < Math.min(numRows, newRows); i++) {
            System.arraycopy(monTableau[i], 0, newArray[i], 0, Math.min(numCols, newCols));
        }
        monTableau = newArray;
        numRows = newRows;
        numCols = newCols;
    }



    //permet de fixer le nom du niveau
    void fixeNom (String s){
        this.nom = s;
    }

    //supprime le contenu de la case à la ligne i et à la colonne j
    void videCase(int i, int j){
        monTableau[i][j] = ' ';
    }

    //ajoutent respectivement un mur, un pousseur, une caisse ou un but à la case à la ligne i et à la colonne j
    void ajouteMur (int i, int j){
        monTableau[i][j] = '#';
    }
    void ajoutePousseur(int i, int j) {
        monTableau[i][j] = '@';
    }
    void ajouteCaisse(int i, int j){
        monTableau[i][j] = '$';
    }
    void ajouteBut(int i, int j){
        monTableau[i][j] = '.';
    }

    //renvoient respectivement le nombre lignes, le nombre de colonnes ou le nom du niveau
     int lignes(){
         return monTableau.length;
     }
     int colonnes(){
         return monTableau.length > 0 ? monTableau[0].length : 0;
    }
    String nom(){
        return nom;
    }

    //renvoie vrai si la case à la ligne i et à la colonne j est vide
    boolean estVide(int l, int c){
        for (int i=0; i < l; i++){
            for (int j =0; i < c ; i++){
                if (monTableau[i][j] != ' ') return true;
            }
        }
        return false;
    }

    //renvoient vrai si la case à la ligne i et à la colonne j contient respectivement un mur, un but, un pousseur ou une caisse.
    boolean aMur(int l, int c){
        for (int i=0; i < l; i++){
            for (int j =0; j < c ; j++){
                if (monTableau[i][j] != '#') return true;
            }
        }
        return false;
    }
    boolean aBut(int l, int c){
        for (int i=0; i < l; i++){
            for (int j =0; j < c ; j++){
                if (monTableau[i][j] != '.') return true;
            }
        }
        return false;
    }
    boolean aPousseur(int l, int c){
        for (int i=0; i < l; i++){
            for (int j =0; j < c ; j++){
                if (monTableau[i][j] != '@') return true;
            }
        }
        return false;
    }
    boolean aCaisse(int l, int c){
        for (int i=0; i < l; i++){
            for (int j =0; j < c ; j++){
                if (monTableau[i][j] != '$') return true;
            }
        }
        return false;
    }
}