package ihm;

import classes.Animal;
import controller.Menagerie;
import ihm.form.FormChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class IHM extends JFrame implements IHMInterface {

    private Menagerie menagerie;
    private JList<String> list;
    private FormChat formChat;

    private JPanel mainPanel;

    public IHM() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);

        this.menagerie = new Menagerie();
        this.menagerie.setEspeces();
        this.menagerie.setMaisons();
        this.menagerie.setAnimaux();

        creationIHM();

    }

    private void creationIHM() {
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.setContentPane(mainPanel);

        this.formChat = new FormChat(this, this.mainPanel, this.menagerie);

        rechercherAnimal();
        afficherListeAnimaux();
        afficherMenu();

        this.revalidate();
        this.repaint();
    }

    private void afficherMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenuItem ajouterAnimal = new JMenuItem("Ajouter un animal");
        ajouterAnimal.addActionListener(e -> {
            inputAjouter();
        });

        JMenuItem supprimerAnimal = new JMenuItem("Supprimer un animal");
        supprimerAnimal.addActionListener(e -> {
            this.menagerie.supprimerAnimal(list.getSelectedIndex());
            refresh();
        });

        menuBar.add(ajouterAnimal);
        menuBar.add(supprimerAnimal);

        this.setJMenuBar(menuBar);
    }

    private void afficherListeAnimaux() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Animal animal : this.menagerie.getAnimaux()) {
            listModel.addElement(animal.getUnNom());
        }
        this.list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(this.list);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        this.mainPanel.add(panel);
    }

    private void inputAjouter() {

        JPanel selectPanel = new JPanel();
        selectPanel.setLayout(new GridLayout(1, 2));
        JComboBox<Object> especes = this.formChat.inputSelect(selectPanel, "Espece", this.menagerie.getEspeces());
        this.mainPanel.add(selectPanel);

        especes.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if ("Chat".equals(especes.getSelectedItem().toString())) {
                    this.formChat.afficher();
                } else {
                    this.formChat.cacher();
                }
                this.revalidate();
                this.repaint();
            }
        });

        this.revalidate();
        this.repaint();
    }

    public void rechercherAnimal() {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(1, 2));

        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Rechercher");

        searchButton.addActionListener(e -> {
            String searchText = searchField.getText();
            DefaultListModel<String> listModel = new DefaultListModel<>();

            if (searchText.isEmpty()) {
                for (Animal animal : this.menagerie.getAnimaux()) {
                    listModel.addElement(animal.getUnNom());
                }
            } else {
                ArrayList<Animal> foundAnimals = new ArrayList<>();
                for (Animal animal : this.menagerie.getAnimaux()) {
                    if (animal.getUnNom().equalsIgnoreCase(searchText)) {
                        foundAnimals.add(animal);
                    }
                }
                for (Animal animal : foundAnimals) {
                    listModel.addElement(animal.getUnNom());
                }
            }

            this.list.setModel(listModel);
            this.revalidate();
            this.repaint();
        });

        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        this.mainPanel.add(searchPanel);
    }

    public void refresh() {
        this.mainPanel.removeAll();
        afficherListeAnimaux();
        this.revalidate();
        this.repaint();
    }

}