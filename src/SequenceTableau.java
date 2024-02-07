class SequenceTableau {
    int[] elements;
    int taille, debut;

    SequenceTableau(){
        elements = new int[1];
    }

    private void redimensionne() {
        if (taille >= elements.length) {
            System.out.println("Redimensionne de " + elements.length + " à " + elements.length*2);
            int [] nouveau = new int[elements.length*2];
            int fin = Math.min(debut+taille, elements.length);
            for (int i=debut; i<fin; i++)
                nouveau[i] = elements[i];
            fin = (debut+taille)-elements.length;
            for (int i=0; i<fin; i++) {
                nouveau[i+elements.length] = elements[i];
            }
            elements = nouveau;
        }
    }


    public void insereTete(int element) {
        redimensionne();
        debut--;
        if (debut < 0)
            debut += elements.length;
        elements[debut] = element;
        taille++;
    }

    public void insereQueue(int element) {
        redimensionne();
        int position = (debut+taille)%elements.length;
        elements[position] = element;
        taille++;
    }

    public int extraitTete() {
        if (taille == 0)
            throw new RuntimeException("Sequence vide");
        int resultat = elements[debut];
        taille--;
        debut = (debut+1)%elements.length;
        return resultat;
    }

    public boolean estVide() {
        return taille == 0;
    }

    public String toString() {
        String resultat = "[ ";
        int fin = Math.min(debut+taille, elements.length);
        for (int i=debut; i<fin; i++)
            resultat += elements[i] + " ";
        fin = (debut+taille)-elements.length;
        for (int i=0; i<fin; i++)
            resultat += elements[i] + " ";
        resultat += "]";
        return resultat;
    }



}