import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener
{
    private JeuDeLaVie  ctrl;

    private JButton[][] tabBtn;

    private JButton btnRev;
    private JButton btnPause;
    private JButton btnPara;

    public Frame(JeuDeLaVie ctrl, int haut, int larg)
    {
        this.ctrl = ctrl;

        this.setTitle   ("Jeu de la vie");
        this.setSize(500,500);
		this.setLocation(600,300               );

        JPanel panelBtn  = new JPanel();
        JPanel panelGril = new JPanel();

        panelGril.setLayout(new GridLayout(haut, larg));

        this.tabBtn = new JButton[haut][larg];

        for(int cptLig = 0; cptLig < haut; cptLig++)
        {    
            for(int cptCol = 0; cptCol < larg; cptCol++)
            {
                this.tabBtn[cptLig][cptCol] = new JButton();
                this.tabBtn[cptLig][cptCol].addActionListener(this);
                panelGril.add(this.tabBtn[cptLig][cptCol]);
            }
        }

        this.btnRev   = new JButton("Annuler");
        this.btnPause = new JButton("Pause");
        this.btnPara  = new JButton("Option");

        this.btnRev  .addActionListener(this);
        this.btnPara .addActionListener(this);
        this.btnPause.addActionListener(this);

        panelBtn.add(this.btnRev);
        panelBtn.add(this.btnPause);
        panelBtn.add(this.btnPara);

        this.add(panelBtn,BorderLayout.NORTH);
        this.add(panelGril,BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void actualiser(boolean[][] tab)
    {
        for(int cptLig = 0; cptLig < tab.length; cptLig++)
        {
            for(int cptCol = 0; cptCol < tab[cptLig].length; cptCol++)
            {
                if(tab[cptLig][cptCol])
                    this.tabBtn[cptLig][cptCol].setBackground(Color.BLACK);    
                else
                    this.tabBtn[cptLig][cptCol].setBackground(Color.WHITE);
            }
        }
    }

    
    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == this.btnPause)
        {
            this.ctrl.temps = !this.ctrl.temps;
            this.ctrl.suivant();
        }

        if(e.getSource() == this.btnPara)
            this.ctrl.menu();

        if(e.getSource() == this.btnRev)
            this.ctrl.revenir();
            

        for(int cptLig = 0; cptLig < this.tabBtn.length; cptLig++)
            for(int cptCol = 0; cptCol < this.tabBtn[cptLig].length; cptCol++)
                if(e.getSource() == this.tabBtn[cptLig][cptCol])
                    this.ctrl.ajout(cptLig,cptCol);
    }
}
