/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statki1;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Kompik1
 */
public class rozstawianieStatkowOkno extends JFrame implements ActionListener, MouseListener{
   private JButton btnDalej;
    private JButton btnWroc = new JButton("Wroc");
    JPanel panel, panel1 ;
    //List<Point> lista = new ArrayList<Point>();
    public rozstawianieStatkowOkno()
    {
        super("Statki");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
        setBounds(100,100,400,270);
        
        panel = new rozstawianieStatkow();
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
        
          //btnWroc.setBounds(10,205,200,25);   
        btnWroc.addActionListener(this);
        panel.add(btnWroc);
         
        JTextArea txtPozycja = new JTextArea();
        txtPozycja.setBounds(150,75,100,25);
        panel.add(txtPozycja);
       
         
        addMouseListener(this);
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnDalej)
        {
            //setVisible(false);
             panel.paintImmediately(0,0,panel.getHeight(),panel.getWidth());
      
            // panel.setVisible(false);
        }
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Point p = e.getPoint();
        //lista.add(p);
       // panel.revalidate();
        //panel.repaint();
    
        panel.paintImmediately(0,0,panel.getHeight(),panel.getWidth());
    }

    @Override
    public void mousePressed(MouseEvent e) {
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
}
