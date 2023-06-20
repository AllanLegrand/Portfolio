import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;

public class Menu extends JFrame implements ActionListener
{
    private JTextField txtVit    ;
    private JTextField txtHaut   ;
    private JTextField txtLarg   ;
    private JTextField txtNaisMin;
    private JTextField txtNaisMax;
    private JTextField txtVieMin ;
    private JTextField txtVieMax ;

    private JButton    btnValid;
    private JButton    btnAnnul;

    private JeuDeLaVie ctrl;

    public Menu(JeuDeLaVie ctrl)
    {
        this.ctrl = ctrl;

        this.setTitle   ("Jeu de la vie - Menu");
		this.setSize    (700,700               );
		this.setLocation(600,300               );

        this.setLayout(new GridLayout(6,1));

        JPanel panelVit  = new JPanel();
        JPanel panelHaut = new JPanel();
        JPanel panelLarg = new JPanel();
        JPanel panelNais = new JPanel();
        JPanel panelVie  = new JPanel();
        JPanel panelBtn  = new JPanel();

        panelVit .add(new JLabel("Vitesse de defilement"  ,10));
        panelHaut.add(new JLabel("Hauteur"                ,10));
        panelLarg.add(new JLabel("Largeur"                ,10));
        panelNais.add(new JLabel("Intervalle de naissance",10));
        panelVie .add(new JLabel("Intervalle de vie"      ,10));

        this.txtVit     = new JTextField("1000", 15);
        this.txtHaut    = new JTextField("10"  , 15);
        this.txtLarg    = new JTextField("10"  , 15);
        this.txtNaisMin = new JTextField("3"   , 15);
        this.txtNaisMax = new JTextField("3"   , 15);
        this.txtVieMin  = new JTextField("2"   , 15);
        this.txtVieMax  = new JTextField("3"   , 15);

        panelVit .add(this.txtVit    );
        panelHaut.add(this.txtHaut   );
        panelLarg.add(this.txtLarg   );
        panelNais.add(this.txtNaisMin);
        panelNais.add(this.txtNaisMax);
        panelVie .add(this.txtVieMin );
        panelVie .add(this.txtVieMax );

        this.btnValid = new JButton("Valider");
        this.btnAnnul = new JButton("Annuler");

        panelBtn.add(this.btnValid);
        panelBtn.add(this.btnAnnul);

        this.add(panelVit );
        this.add(panelHaut);
        this.add(panelLarg);
        this.add(panelNais);
        this.add(panelVie );
        this.add(panelBtn );

        this.btnValid.addActionListener(this);
        this.btnAnnul.addActionListener(this);

        this.pack();

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == this.btnValid)
        {
            this.ctrl.parametrage(Integer.parseInt(this.txtVit.getText()),Integer.parseInt(this.txtHaut.getText()),Integer.parseInt(this.txtLarg.getText()),
                                  Integer.parseInt(this.txtNaisMin.getText()),Integer.parseInt(this.txtNaisMax.getText()),Integer.parseInt(this.txtVieMin.getText())
                                  ,Integer.parseInt(this.txtVieMax.getText()));
        }
        
        this.dispose();
    }
}