package ihm.form;

import classes.Maison;
import classes.espece.Chat;
import controller.Menagerie;
import ihm.Form;
import ihm.IHMInterface;

import javax.swing.*;
import java.awt.*;

public class FormChat extends Form {

    private IHMInterface ihmInterface;
    private Menagerie menagerie;

    /**
     * Constructeur
     * @param ihmInterface
     * @param mainPanel
     * @param menagerie
     */
    public FormChat(IHMInterface ihmInterface, JPanel mainPanel, Menagerie menagerie) {
        super(mainPanel);

        this.ihmInterface = ihmInterface;
        this.menagerie = menagerie;
    }

    /**
     * Afficher le formulaire
     */
    @Override
    public void afficher() {
        this.inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        JTextField nomArea = inputText(inputPanel, "Nom");
        JTextField couleurArea = inputText(inputPanel, "Couleur");
        JComboBox<Object> maisons = inputSelect(inputPanel, "Maison", this.menagerie.getMaisons());
        JButton addButton = new JButton("Ajouter");
        addButton.addActionListener(e1 -> {
            this.menagerie.ajouterAnimal(new Chat(nomArea.getText(), couleurArea.getText(), (Maison) maisons.getSelectedItem()));
            cacher();
            ihmInterface.refresh();
        });
        inputPanel.add(addButton);

        this.mainPanel.add(inputPanel);
    }
}
