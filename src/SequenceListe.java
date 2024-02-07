class Maillon {
    int element;
    Maillon suivant;
}

class SequenceListe {
    Maillon tete, queue;

    void insereTete(int element) {
        Maillon nouvElem = new Maillon();
        nouvElem.element = element;
        nouvElem.suivant = tete;
        if (tete == null){
            tete = nouvElem;
            queue = nouvElem;
        } else {
            tete = nouvElem;
        }

    }
    //    insère l'élément nommé element en début de séquence (en première position) ;
    void insereQueue(int element) {
        Maillon nouvElem = new Maillon();
        nouvElem.element = element;
        nouvElem.suivant = null;
        if (tete == null){
            tete = nouvElem;
            queue = nouvElem;
        } else {
            queue.suivant = nouvElem;
            queue = nouvElem;
        }
    }
    //    insère l'élément nommé element en fin de séquence (en dernière position) ;
    int extraitTete() {
        if (tete == null){
            throw new RuntimeException("empty list\n");
        }
        int res = tete.element;
        tete = tete.suivant;
        return res;
    }
    //    extrait et renvoie la valeur de l'élément situé en début de séquence (en première position) ;
    boolean estVide() {
        return tete==null;
    }
    //    renvoie vrai si et seulement si la séquence est vide.
    public String toString() {
        String resultat = "[ ";
        Maillon courant = tete;
        while (courant != null) {
            resultat += courant.element + " ";
            courant = courant.suivant;
        }
        resultat += "]";
        return resultat;
    }



}