package classes.espece;

import classes.Animal;
import classes.Maison;

public class Chat extends Animal {
    private String uneCouleur;
    private Maison uneMaison;

    /**
     * Constructeur par défaut
     */
    public Chat() {
        super();
    }

    /**
     * Constructeur avec un nom et une couleur
     * @param unNom
     * @param uneCouleur
     */
    public Chat(String unNom, String uneCouleur, Maison uneMaison) {
        super(unNom);
        this.uneCouleur = uneCouleur;
        this.uneMaison  = uneMaison;
    }

    /* Getters and Setters */
    public String getCouleur() {
        return this.uneCouleur;
    }

    public Maison getMaison() {
        return this.uneMaison;
    }
}
