/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statki1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
public class uzytkownikOkno extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton btnWroc = new JButton("Wroc");
    private JButton btnZmienHaslo = new JButton("Zmien haslo");
    JTextArea txtSH, txtNH, txtPP ;
      
    String zalogowany;
    String nazwaPliku, nazwaPlikuDane;
    uzytkownikOkno(String nazwa){
        
        
        super("Statki");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
        setBounds(100,100,400,400);
                 
                
                
        panel = new JPanel(new BorderLayout());
        add(panel);
                
        btnWroc.setBounds(10,205,200,25);   
        btnWroc.addActionListener(this);
        panel.add(btnWroc);
                
                
        zalogowany = nazwa;
        nazwaPliku = zalogowany + ".txt";
        nazwaPlikuDane =zalogowany + "Dane.txt";
                
        JLabel login = new JLabel("Login: " + zalogowany);
        login.setBounds(10,10,200,25);
        panel.add(login);
                
        String liczbaRozgrywek = "";
        
        try {
            liczbaRozgrywek = odczytRozgrywek(nazwaPlikuDane);
        } catch (IOException ex) {
            Logger.getLogger(uzytkownikOkno.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        JLabel lblRozegrane = new JLabel("Liczba rozegranych rozgrywek: " +  liczbaRozgrywek);
        lblRozegrane.setBounds(10,35,200,25);
        panel.add(lblRozegrane);
                
        btnZmienHaslo.setBounds(10,70,200,25);
        btnZmienHaslo.addActionListener(this);
        panel.add(btnZmienHaslo);
                
        JLabel lblSH = new JLabel("Stare haslo");
        lblSH.setBounds(10,105,200,25);
        panel.add(lblSH);
                
        txtSH = new JTextArea();
        txtSH.setBounds(230,105,200,25);
        txtSH.setBackground(Color.white);
        panel.add(txtSH);
                
        JLabel lblNH = new JLabel("Nowe haslo");
        lblNH.setBounds(10,140,200,25);
        panel.add(lblNH);
                
        txtNH = new JTextArea();
        txtNH.setBounds(230,140,200,25);
        txtNH.setBackground(Color.white);
        panel.add(txtNH);
                
        txtPP = new JTextArea();
        txtPP.setBounds(230,175,200,25);
        txtPP.setBackground(Color.white);
        panel.add(txtPP); 
                
        JLabel lblPP = new JLabel("Powtorz haslo: ");
        lblPP.setBounds(10,175,200,25);
        panel.add(lblPP);
                
               
                
                
                
                
                
    }
    
    public static String odczytHasla(String nazwa) throws IOException {
        BufferedReader plik = null;
        int c;
        String o = "";
        
        try {            
            plik = new BufferedReader(new FileReader(nazwa));
           //c = plik.read();
           while ( (c = plik.read()) != -1   ) { 
               
            if(c  != 32)
            {             
                o = o +  (char)c;
               System.out.println(c);          
            }

            }

        } finally {
            if (plik != null) {
                plik.close();
            }
    }
        plik.close();
        return o;
    }
  
    public static String odczytRozgrywek(String nazwa) throws IOException {
        BufferedReader plik = null;
        int c;
        String o = "";
        
        try {            
            plik = new BufferedReader(new FileReader(nazwa));
           
           plik.readLine();
           o = plik.readLine();

        } finally {
            if (plik != null) {
                plik.close();
            }
    }
        plik.close();
        return o;
    }
    
    public static void zmienHaslo(String h, String nazwa) throws IOException
    {
        FileWriter plik = null;
        try {
            // tworzy nowy plik jeżeli nie istnieje, w przeciwnym przypadku
            // usuwa zawartość pliku i nadpisuje od początku
            plik = new FileWriter(nazwa);
            // zapis łańcucha
            String tekst = h;
            plik.write(tekst);
            // zapis po znaku
            
 
        } finally {
            if (plik != null) {
                plik.close();
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnWroc)
        {
            setVisible(false);
            new oknoStartowe(zalogowany);
        }
        if(e.getSource() == btnZmienHaslo)
        {
            String PP = txtPP.getText();
            String NH = txtNH.getText();
            String SH = txtSH.getText();
            if( PP.equals(NH) )
            {
                System.out.println("wszedl");
                String haslo = "";
                try {
                    haslo = odczytHasla(nazwaPliku);
                } catch (IOException ex) {
                    Logger.getLogger(uzytkownikOkno.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(haslo.equals(SH))
                {
                     System.out.println(haslo.equals(SH));
                    try {
                        zmienHaslo(PP, nazwaPliku);
                    } catch (IOException ex) {
                        Logger.getLogger(uzytkownikOkno.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   System.out.println("zmieniono haslo");
                }
                else
                    System.out.println("zle stare haslo");
            }
        }
    
    }
    
}
