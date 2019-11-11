/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statki1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Kompik1
 */
public class rozstawianieStatkowOkno2 extends JFrame implements ActionListener, MouseListener{
      private JButton btnDalej;
    JPanel panel, panel1 ;
      private JButton btnWroc = new JButton("Wroc");
      String zalogowany;
    public rozstawianieStatkowOkno2(String text)
    {
        super("Statki");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
        setBounds(100,100,400,270);
        
        zalogowany = text;
        panel = new rozstawianieStatkow2();
        add(panel);
        pack();
         
         
//         panel1 = new rozstawianieStatkow();
//         
//         
//         panel1.setBounds(150, 75, 400, 400);
//         add(panel1);
//         pack();
         
        btnDalej = new JButton("Dalej");
        btnDalej.addActionListener(this);
        panel.add(btnDalej);
        
        btnWroc.addActionListener(this);
        panel.add(btnWroc);
         
        JTextArea txtPozycja = new JTextArea();
        txtPozycja.setBounds(150,75,100,25);
        panel.add(txtPozycja);
       
         
        addMouseListener(this);
        
//        if  (((rozstawianieStatkow2)panel).getOK())
//        {
//            refresh();
//        }               
        

         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnDalej)
        {
            //setVisible(false);
             panel.paintImmediately(0,0,panel.getHeight(),panel.getWidth());
      
            // panel.setVisible(false);
        }
        if(e.getSource() == btnWroc)
        {
            setVisible(false);
            new oknoStartowe(zalogowany);
        }
        
        //JOptionPane.showMessageDialog(null,  e.getActionCommand());
       
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Point p = e.getPoint();
        //lista.add(p);
       // panel.revalidate();
        //panel.repaint();
        ((rozstawianieStatkow2)panel).refresh();
         //JOptionPane.showMessageDialog(null,  e.getActionCommand() );
        JOptionPane.showMessageDialog(null, "ok");
        if(((rozstawianieStatkow2)panel).ok){
            
            JOptionPane.showMessageDialog(null, "ok");
            panel.paintImmediately(0,0,panel.getHeight(),panel.getWidth());
           
            refresh();
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        JOptionPane.showMessageDialog(null, "ok");
// Point p = e.getPoint();
       // lista.add(p);
        //panel.repaint();
       // panel.paintImmediately(0,0,panel.getHeight(),panel.getWidth());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // panel.paintImmediately(0,0,panel.getHeight(),panel.getWidth());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // panel.paintImmediately(0,0,panel.getHeight(),panel.getWidth());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    void refresh()
    {
       
        panel.paintImmediately(0,0,panel.getHeight(),panel.getWidth());
    }
}
