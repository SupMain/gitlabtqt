package fr.iut.editeur.document;

public class Document {

    private String contentDocument;

    public Document() {
        this.contentDocument = "";
    }


	
    public String getTexte() {
        return contentDocument;
    }

    public void setTexte(String contentDocument) {
        this.contentDocument = contentDocument;
    }

    public void ajouter(String texte) {
        this.contentDocument += texte;
    }

    public void remplacer(int start, int end, String remplacement) {
        if (remplacement.isEmpty()) {
            remplacement = " ";
        }
        String leftPart = contentDocument.substring(0, start);
        String rightPart = contentDocument.substring(end);
        contentDocument = leftPart + remplacement + rightPart;
    }

    public void majuscules(int start, int end) {
        String portionEnMajuscules = contentDocument.substring(start, end).toUpperCase();
        remplacer(start, end, portionEnMajuscules);
    }
    public void minuscules(int start, int end){
        String portionEnMinuscule = contentDocument.substring(start, end).toLowerCase();
        remplacer(start, end, portionEnMinuscule);
    }

    public void effacer(int start, int end) {
        String texteAvant = contentDocument.substring(0, start);
        String texteApres = contentDocument.substring(end);
        contentDocument = texteAvant + texteApres;
    }

    public void clear() {
        remplacer(0, this.contentDocument.length(), "");
    }

    public void inserer(int index, String chainChara) {
        if (index < 0 || index > contentDocument.length()) {
            throw new IllegalArgumentException("L'indice doit être compris entre 0 et la longueur du texte inclus.");
        }

        String texteAvant = contentDocument.substring(0, index);
        String texteApres = contentDocument.substring(index);
        contentDocument = texteAvant + chainChara + texteApres;
    }
    @Override
    public String toString() {
        return this.contentDocument;
    }
}
