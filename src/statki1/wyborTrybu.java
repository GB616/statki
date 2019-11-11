/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statki1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Kompik1
 */
public class wyborTrybu extends JFrame implements ActionListener {
    
    private JPanel panel;
    private JButton btnJeden, btnDwoch;
    String zalogowany;
    
    public wyborTrybu(String text){
        super("Statki");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
        setBounds(100,100,400,270);
        
        zalogowany = text;
        
        panel = new JPanel(  );
        panel.setLayout(null);
        add( panel );
        
        btnJeden = new JButton("Jeden Gracz");
        btnJeden.setBounds(10,25,200,25);
        btnJeden.addActionListener(this);
        panel.add(btnJeden);
        
        btnDwoch = new JButton("Dwoch Graczy");
        btnDwoch.setBounds(10,50,200,25);
        btnDwoch.addActionListener(this);
        panel.add(btnDwoch); 
     }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnJeden)
        {
            setVisible(false);
            new rozstawianieStatkowOkno();
        }
        
                if(e.getSource() == btnDwoch)
        {
            setVisible(false);
            new rozstawianieStatkowOkno2(zalogowany);
            
        }
    }
    
}
