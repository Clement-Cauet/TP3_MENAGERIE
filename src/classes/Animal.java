package classes;

public class Animal {

    private String unNom;
    private Object uneEspece;

    /**
     * Constructeur par défaut
     */
    protected Animal() {}

    /**
	 * Constructeur avec un nom
	 * @param unNom
	 */
    protected Animal(String unNom) {
        this.unNom = unNom;
    }

    /**
     * Constructeur avec un nom et une espèce
     * @param unNom
     * @param uneEspece
     */
    protected Animal(String unNom, Object uneEspece) {
        this.unNom = unNom;
        this.uneEspece = uneEspece;
    }

    /* Getters and Setters */
    protected void setUnNom(String unNom) {
        this.unNom = unNom.toUpperCase();
    }

    public String getUnNom() {
        return this.unNom;
    }

    protected Object getUneEspece() {
        return this.uneEspece;
    }

    protected String sePresenter() {
        String result = "";
        if (this.unNom != null) {
            result += "\nNom: " + this.unNom;
        }
        if (this.uneEspece != null) {
            result += "\nEspece: " + this.uneEspece;
        }
        return result;
    }
}