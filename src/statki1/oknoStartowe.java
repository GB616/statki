/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statki1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kompik1
 */
public class oknoStartowe extends JFrame implements ActionListener {
    private JPanel panel, panelpanel;
    JButton btnNowaGra = new JButton("Nowa gra");
    JButton btnWrocDoRozgrywki = new JButton("Wróć do rozgrywki");
    JButton btnObejrzyjPoprzednieGry = new JButton("Obejrzyj poprzednie gry");
    JButton btnProfilUzytkownika = new JButton("Profil użytkownika");
    String zalogowany;
    public  oknoStartowe() {
		super("Statki");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
                setBounds(100,100,400,270);
                
                panelpanel = new JPanel(new BorderLayout());
                add(panelpanel);
                panel = new JPanel(  );
                panel.setLayout(new FlowLayout(FlowLayout.CENTER));
                panelpanel.add(panel, BorderLayout.CENTER);
                
                JLabel tytul = new JLabel("Menu główne");
                tytul.setBounds(10,10,200,25);
                panel.add(tytul);
                
               
                btnNowaGra.setBounds(10,75,100,25);
                btnNowaGra.addActionListener(this);
                panel.add( btnNowaGra, BorderLayout.CENTER );
        
               
                btnWrocDoRozgrywki.setBounds(10,100,100,25);
                btnWrocDoRozgrywki.addActionListener(this);
                panel.add( btnWrocDoRozgrywki );
        
                
                btnObejrzyjPoprzednieGry.setBounds(10,125,100,25);
                btnObejrzyjPoprzednieGry.addActionListener(this);
                panel.add( btnObejrzyjPoprzednieGry );
        
                
                btnProfilUzytkownika.setBounds(10,150,100,25);
                btnProfilUzytkownika.addActionListener(this);
                panel.add( btnProfilUzytkownika );
                        
	}

    oknoStartowe(String text) {
      
                
          
                super("Statki");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
                setBounds(100,100,400,270);
                
                panelpanel = new JPanel(new BorderLayout());
                add(panelpanel);
                panel = new JPanel(  );
                //panel.setLayout(new FlowLayout(FlowLayout.CENTER));
                panelpanel.add(panel, BorderLayout.CENTER);
                
                JLabel tytul = new JLabel("Menu główne");
                tytul.setBounds(10,10,200,25);
                panel.add(tytul);
                
               
                btnNowaGra.setBounds(10,75,100,25);
                btnNowaGra.addActionListener(this);
                panel.add( btnNowaGra, BorderLayout.CENTER );
        
               
                btnWrocDoRozgrywki.setBounds(10,100,100,25);
                btnWrocDoRozgrywki.addActionListener(this);
                panel.add( btnWrocDoRozgrywki );
        
                
                btnObejrzyjPoprzednieGry.setBounds(10,125,100,25);
                btnObejrzyjPoprzednieGry.addActionListener(this);
                panel.add( btnObejrzyjPoprzednieGry );
        
                
                btnProfilUzytkownika.setBounds(10,150,100,25);
                btnProfilUzytkownika.addActionListener(this);
                panel.add( btnProfilUzytkownika );
                
                zalogowany = text;
                 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnNowaGra)
        {
            setVisible(false);
            new wyborTrybu(zalogowany);
        }
        if(e.getSource() == btnProfilUzytkownika)
        {
            setVisible(false);
            new uzytkownikOkno(zalogowany);
        }
    }
}
