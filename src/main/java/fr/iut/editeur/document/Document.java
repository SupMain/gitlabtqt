package fr.iut.editeur.document;

/**
 * Cette classe représente un document textuel.
 */
public class Document {

    private String contentDocument;

    /**
     * Constructeur par défaut de la classe Document.
     * Initialise le contenu du document à une chaîne vide.
     */
    public Document() {
        this.contentDocument = "";
    }

    /**
     * Obtient le contenu textuel du document.
     * @return Le contenu textuel du document.
     */
    public String getTexte() {
        return contentDocument;
    }

    /**
     * Définit le contenu textuel du document.
     * @param contentDocument Le nouveau contenu textuel du document.
     */
    public void setTexte(String contentDocument) {
        this.contentDocument = contentDocument;
    }

    /**
     * Ajoute du texte à la fin du document.
     * @param texte Le texte à ajouter.
     */
    public void ajouter(String texte) {
        this.contentDocument += texte;
    }

    /**
     * Remplace une portion du document par une nouvelle chaîne de caractères.
     * @param start L'indice de début de la portion à remplacer.
     * @param end L'indice de fin de la portion à remplacer.
     * @param remplacement La chaîne de remplacement.
     */
    public void remplacer(int start, int end, String remplacement) {
        if (remplacement.isEmpty()) {
            remplacement = " ";
        }
        String leftPart = contentDocument.substring(0, start);
        String rightPart = contentDocument.substring(end);
        contentDocument = leftPart + remplacement + rightPart;
    }

    /**
     * Convertit en majuscules une portion du document.
     * @param start L'indice de début de la portion à convertir en majuscules.
     * @param end L'indice de fin de la portion à convertir en majuscules.
     */
    public void majuscules(int start, int end) {
        String portionEnMajuscules = contentDocument.substring(start, end).toUpperCase();
        remplacer(start, end, portionEnMajuscules);
    }

    /**
     * Convertit en minuscules une portion du document.
     * @param start L'indice de début de la portion à convertir en minuscules.
     * @param end L'indice de fin de la portion à convertir en minuscules.
     */
    public void minuscules(int start, int end){
        String portionEnMinuscule = contentDocument.substring(start, end).toLowerCase();
        remplacer(start, end, portionEnMinuscule);
    }

    /**
     * Efface une portion du document.
     * @param start L'indice de début de la portion à effacer.
     * @param end L'indice de fin de la portion à effacer.
     */
    public void effacer(int start, int end) {
        String texteAvant = contentDocument.substring(0, start);
        String texteApres = contentDocument.substring(end);
        contentDocument = texteAvant + texteApres;
    }

    /**
     * Efface tout le contenu du document.
     */
    public void clear() {
        remplacer(0, this.contentDocument.length(), "");
    }

    /**
     * Insère une chaîne de caractères à un indice spécifié dans le document.
     * @param index L'indice d'insertion.
     * @param chainChara La chaîne de caractères à insérer.
     * @throws IllegalArgumentException Si l'indice est en dehors des limites du texte.
     */
    public void inserer(int index, String chainChara) {
        if (index < 0 || index > contentDocument.length()) {
            throw new IllegalArgumentException("L'indice doit être compris entre 0 et la longueur du texte inclus.");
        }

        String texteAvant = contentDocument.substring(0, index);
        String texteApres = contentDocument.substring(index);
        contentDocument = texteAvant + chainChara + texteApres;
    }

    /**
     * Convertit le document en une chaîne de caractères.
     * @return Le contenu textuel du document sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        return this.contentDocument;
    }
}
