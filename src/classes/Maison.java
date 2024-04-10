package classes;

public class Maison {

    private String nom;

    /**
     * Constructeur par défaut
     * @param nom
     */
    public Maison(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }

    /* Getters and Setters */
    public String getNom() {
        return this.nom;
    }
}