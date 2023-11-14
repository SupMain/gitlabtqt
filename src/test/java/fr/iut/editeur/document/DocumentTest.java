package fr.iut.editeur.document;

import junit.framework.TestCase;

import junit.framework.TestCase;

public class DocumentTest extends TestCase {

    public void testConstructor() {
        Document doc = new Document();
        assertEquals("Le document doit être initialisé avec un contenu vide.", "", doc.getTexte());
    }

    public void testSetTexteAndGetTexte() {
        Document doc = new Document();
        String testContent = "Test";
        doc.setTexte(testContent);
        assertEquals("Le contenu doit être égal à la valeur définie par setTexte.", testContent, doc.getTexte());
    }

    public void testAjouter() {
        Document doc = new Document();
        String initialText = "Bonjour";
        doc.setTexte(initialText);
        String ajout = " Monde";
        doc.ajouter(ajout);
        assertEquals("Le contenu doit être la concaténation du texte initial et du texte ajouté.", initialText + ajout, doc.getTexte());
    }

    public void testRemplacer() {
        Document doc = new Document();
        doc.setTexte("Bonjour Monde");
        doc.remplacer(8, 13, "le monde");
        assertEquals("Le contenu doit être modifié correctement après remplacement.", "Bonjour le monde", doc.getTexte());
    }

    public void testMajuscules() {
        Document doc = new Document();
        doc.setTexte("Bonjour Monde");
        doc.majuscules(8, 13);
        assertEquals("La partie spécifiée du texte doit être convertie en majuscules.", "Bonjour MONDE", doc.getTexte());
    }

    public void testMinuscules() {
        Document doc = new Document();
        doc.setTexte("Bonjour MONDE");
        doc.minuscules(8, 13);
        assertEquals("La partie spécifiée du texte doit être convertie en minuscules.", "Bonjour monde", doc.getTexte());
    }

    public void testEffacer() {
        Document doc = new Document();
        doc.setTexte("Bonjour Monde");
        doc.effacer(8, 13);
        assertEquals("La partie spécifiée du texte doit être effacée.", "Bonjour ", doc.getTexte());
    }

    public void testInsererException() {
        Document doc = new Document();
        try {
            doc.inserer(-1, "test");
            fail("Une IllegalArgumentException aurait dû être lancée pour un indice invalide.");
        } catch (IllegalArgumentException e) {
            // Test réussi
        }
    }

    public void testToString() {
        Document doc = new Document();
        doc.setTexte("Bonjour Monde");
        assertEquals("La méthode toString doit retourner le contenu du document.", "Bonjour Monde", doc.toString());
    }
}
