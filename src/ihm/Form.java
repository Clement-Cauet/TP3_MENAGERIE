package ihm;

import javax.swing.*;
import java.util.ArrayList;

public class Form {

    protected JPanel mainPanel;
    protected JPanel inputPanel;

    /**
     * Constructeur
     *
     * @param mainPanel
     */
    public Form(JPanel mainPanel) {
        this.mainPanel = mainPanel;

    }

    /**
     * Afficher le formulaire
     */
    protected void afficher() {
    }

    /**
     * Cacher le formulaire
     */
    protected void cacher() {
        if (this.inputPanel != null) {
            this.mainPanel.remove(this.inputPanel);
            this.inputPanel = null;
        }
    }

    /**
     * Ajouter un champ de texte
     *
     * @param parent
     * @param label
     * @return
     */
    protected JTextField inputText(JPanel parent, String label) {
        JLabel jLabel = new JLabel(label);
        JTextField jTextField = new JTextField();
        parent.add(jLabel);
        parent.add(jTextField);

        return jTextField;
    }

    /**
     * Ajouter un selecteur
     *
     * @param parent
     * @param label
     * @param list
     * @return
     */
    protected JComboBox<Object> inputSelect(JPanel parent, String label, ArrayList list) {
        JLabel jLabel = new JLabel(label);
        JComboBox<Object> jComboBox = new JComboBox<>(list.toArray());
        parent.add(jLabel);
        parent.add(jComboBox);

        return jComboBox;
    }
}
