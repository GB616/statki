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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 *
 * @author Kompik1
 */


public class panelLogowania extends JFrame implements ActionListener{

    private JPanel panel;
    JButton btnZaloguj = new JButton("Zaloguj");
    JTextArea txthaslo = new JTextArea();
    JTextArea txtlogin = new JTextArea();
    
    public panelLogowania(){
        super("Statki");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
        setBounds(100,100,400,270);
        
       
        
        panel = new JPanel(  );
        panel.setLayout(null);
        add( panel );
        
        JLabel tekst = new JLabel("Zaloguj się");
        tekst.setBounds(10,10,200,25);
        panel.add(tekst);
        
        JLabel lbllogin = new JLabel("Podaj login");
        lbllogin.setBounds(10,50,100,25);
        panel.add(lbllogin);
        
       
        txtlogin.setBounds(150,50,100,25);
        panel.add(txtlogin);
        
        JLabel lblhaslo = new JLabel("Podaj haslo");
        lblhaslo.setBounds(10,75,100,25);
        panel.add(lblhaslo);
                
      
        txthaslo.setBounds(150,75,100,25);
        panel.add(txthaslo);
        
        
        
        btnZaloguj.setBounds(10,100,100,25);
        btnZaloguj.addActionListener(this);
        panel.add(btnZaloguj);
       // btnZaloguj.setVisible(false);
        
       
        
     
        
        
        
         
    }
    
    public static String odczytPlikuTekstowego(String nazwa) throws IOException {
        BufferedReader plik2 = null;
        int c;
        String o = "";
        try {            
            plik2 = new BufferedReader(new FileReader(nazwa));
            //System.out.println("\n\nOdczyt buforowany:\n");
           // o = plik2.readLine();
           //c = plik2.read();
           while ( (c = plik2.read()) != -1   ) { 
               
                if(c  == 32)
                    break;
                else
                {
                    //if(o ==null)
                    //{
                    //    o = (char)c;
                   // }
                   // else
                   // {
                    o = o +  (char)c;
                   System.out.println(c);
                   // }
                }
           

            }
//            while (l != null) {
//                System.out.println(l);
//                l = plik2.readLine();
            //}
        } finally {
            if (plik2 != null) {
                plik2.close();
            }
    }        
        return o;
    }
    String haslo ;
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == btnZaloguj)
       {
           //BufferedReader plik ;
           String nazwa = txtlogin.getText() + ".txt";
//         System.out.println(nazwa);
//             try {
//               //        File plik = new File(nazwa);
//                 plik = new BufferedReader(new FileReader(nazwa));
////               Scanner odczyt = new Scanner(nazwa);
//                 String haslo = plik.readLine();
//               
//              
//              } catch (FileNotFoundException ex) {
//               Logger.getLogger(panelLogowania.class.getName()).log(Level.SEVERE, null, ex);
//              } catch (IOException ex) {
//               Logger.getLogger(panelLogowania.class.getName()).log(Level.SEVERE, null, ex);
//           }
            try {
               //System.out.println(odczyt.nextLine());
        
//        String haslo = odczyt.nextLine();
        
//        System.out.println(txthaslo.getText());
//        if(haslo == txthaslo.getText())
//        {
//            setVisible(false);
//           new oknoStartowe();
//        }
         
                haslo = odczytPlikuTekstowego(nazwa);
            } catch (IOException ex) {
                Logger.getLogger(panelLogowania.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            System.out.println(haslo);
            haslo.toString();
            String hzt =txthaslo.getText();
            hzt.toString();
            //haslo.toString();
            System.out.println(hzt);
            if(hzt.equals(haslo)  )
            {
                setVisible(false);
            
                new oknoStartowe(txtlogin.getText());
                //new oknoStartowe();
            }
            else
            {
                System.out.println("zle haslo");
            }
       }
    }
    
}
