package controller;

import java.util.ArrayList;
import classes.Animal;
import classes.Maison;
import classes.espece.Chat;

public class Menagerie {

	private ArrayList<String> especes;
	private ArrayList<Maison> maisons;
	private ArrayList<Animal> animaux;

    public Menagerie() {
		this.especes = new ArrayList<>();
		this.maisons = new ArrayList<>();
		this.animaux = new ArrayList<>();
	}

	/* Getters and Setters */
	public void setEspeces() {
		this.especes.add("");
		this.especes.add("Chat");
		this.especes.add("Chien");
	}

	public ArrayList<String> getEspeces() {
		return this.especes;
	}

	public void setMaisons() {
		this.maisons.add(new Maison("Maison1"));
		this.maisons.add(new Maison("Maison2"));
		this.maisons.add(new Maison("Maison3"));
	}

	public ArrayList<Maison> getMaisons() {
		return this.maisons;
	}

	public void setAnimaux() {
		this.animaux.add(new Chat("Félix", "Roux", this.maisons.get(0)));
		this.animaux.add(new Chat("Vanille", "Blanc", this.maisons.get(0)));
		this.animaux.add(new Chat("Garfield", "Marron", this.maisons.get(1)));
		this.animaux.add(new Chat("Tom", "Gris", this.maisons.get(2)));
	}

	public ArrayList<Animal> getAnimaux() {
		return this.animaux;
	}

	/**
	 * Ajouter un animal
	 * @param animal
	 */
	public void ajouterAnimal(Animal animal) {
		this.animaux.add(animal);
	}


	/**
	 * Supprimer un animal
	 * @param index
	 */
	public void supprimerAnimal(int index) {
		this.animaux.remove(index);
	}

}