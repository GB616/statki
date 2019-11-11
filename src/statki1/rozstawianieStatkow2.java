/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statki1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Kompik1
 */
public class rozstawianieStatkow2 extends JPanel implements MouseListener {
    Point p = new Point() ;
    Point pp = new Point(2,2) ;
    Point ppp = new Point(3,4);
    Point pppp = new Point(3,5);
     List<Point> lista = new ArrayList<Point>();
    //Point g = new Point(3,2);
    //Graphics g = new Graphics() ;
    
    int rozmiarPola = 30;
    public boolean ok, pierwszy = true,gameover =false; ;
    plansza plansza =  new plansza();
    plansza plansza2 = new plansza();
    
    
    public rozstawianieStatkow2()
    {
       // lista.add(g);   
        
        JPanel panel = new JPanel();
        JTextArea txtPozycja = new JTextArea();
        txtPozycja.setBackground(Color.white);
        txtPozycja.setBounds(550,75,100,25);
        
        panel.add(txtPozycja);
        
//        JButton btnDalej = new JButton("Dalej");
//         //btnDalej.addActionListener(this);
//          txtPozycja.setBounds(150,75,100,25);
//         panel.add(btnDalej);
        
        ok = false;
        
        Statek s = new Statek(pp);
        Dwumasztowiec d = new Dwumasztowiec(ppp,pppp);
        
        plansza.dodajStatek(s);
        plansza2.dodajStatek(s);
        plansza.dodajDwumasztowiec(d);
        plansza2.dodajDwumasztowiec(d);
        setPreferredSize(new Dimension(800, 800));
        addMouseListener(this);
        
        
    }
    
    @Override
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
                
                
                for (int x=0; x<24; x++)
            {
                for (int y = 0; y < 10; y++)
                {
                    if(x==10 || x==11 || x==12 || x==12 ||x==13)
                    {
                        
                    }   
                    else
                    {
                        Rectangle2D rectangle = new Rectangle2D.Double(
                                    x * rozmiarPola,
                                    y * rozmiarPola,
                                    rozmiarPola,
                                    rozmiarPola
                                    );
                    g2d.draw(rectangle);  
                    }
                             
                }
            }
                if(pierwszy == true)
                {
		for(int i=0 ;i<10;i++)
                {
                    for(int j =0; j<10;j++)
                    {
                        p.x = i;
                        p.y = j;
                        System.out.println(p);
                        if(plansza.zwrocWartosc(i, j)== 1)
                        {
                        Ellipse2D circle = new Ellipse2D.Double(p.x * rozmiarPola, p.y * rozmiarPola, rozmiarPola, rozmiarPola);
                        g2d.draw(circle);
                        }
                        if(plansza.zwrocWartosc(i, j)== 3)
                        {
                        g2d.fillOval(p.x * rozmiarPola, p.y * rozmiarPola, rozmiarPola, rozmiarPola);
                        }
                        if(plansza.zwrocWartosc(i, j)== 4)
                        {
                        g2d.fillRect(p.x * rozmiarPola, p.y * rozmiarPola, rozmiarPola, rozmiarPola);
                        }
                    }
                    
                }
                }
                else
                {
                    for(int i=0 ;i<10;i++)
                {
                    for(int j =0; j<10;j++)
                    {
                        p.x = i + 14;
                        p.y = j;
                        //System.out.println(p);
                        if(plansza2.zwrocWartosc(i, j)== 1)
                        {
                        Ellipse2D circle = new Ellipse2D.Double(p.x * rozmiarPola, p.y * rozmiarPola, rozmiarPola, rozmiarPola);
                        g2d.draw(circle);
                        }
                        if(plansza2.zwrocWartosc(i, j)== 3)
                        {
                        g2d.fillOval(p.x * rozmiarPola, p.y * rozmiarPola, rozmiarPola, rozmiarPola);
                        }
                        if(plansza.zwrocWartosc(i, j)== 4)
                        {
                        g2d.fillRect(p.x * rozmiarPola, p.y * rozmiarPola, rozmiarPola, rozmiarPola);
                        }
                    }
                    
                }
                }
                
		if(pierwszy == false)
                {
                    for (int x=0; x<10; x++)
                    {
                        for (int y = 0; y < 10; y++)
                        {
                            
                            g2d.fillRect( x * rozmiarPola,
                                    y * rozmiarPola,
                                    rozmiarPola,
                                    rozmiarPola);
                       }
            }
            }
                else
                {
                     for (int x=14; x<24; x++)
                    {
                        for (int y = 0; y < 10; y++)
                        {
                            
                            g2d.fillRect( x * rozmiarPola,
                                    y * rozmiarPola,
                                    rozmiarPola,
                                    rozmiarPola);
                       }
                }
              
	}
         }
    void refresh( )
    {
        
       // Graphics d = new Graphics();
      //Graphics2D d = (Graphics2D) d;
      //paintComponent(d);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
       if(gameover == false)
       {
            //ok = true;
            p = e.getPoint();
            p.x = p.x/rozmiarPola;
            p.y = p.y/rozmiarPola;
            if(pierwszy == true)
            {
                if(p.x<10 && p.x>=0 && p.y<10 && p.y>=0)
                {
           
                    if( plansza.dodajStrzal(p))
                    {
                        ok= true;
                    
                    System.out.println("dodano strzal do 1 " + p);
                    if(plansza.zwroctrafienia()==3)
                    {
                        System.out.println("gracz wygral");
                        JOptionPane.showMessageDialog(null, "Gracz wygral");
                        gameover=true;
                    
                    if(pierwszy == true)
                    {
                        pierwszy = false;
                    }
                    else
                        pierwszy = true;
                   }
                    else{
                        JOptionPane.showMessageDialog(null, "Wybrano złe pole");
                    }
                }
            }
            else
            {
                if(p.x<24 && p.x>=14 && p.y<10 && p.y>=0)
                {
                    p.x = p.x - 14;
             
                    if( plansza2.dodajStrzal(p))
                    {
                        ok = true;
                    
                        if(plansza2.zwroctrafienia()==3)
                        {
                            JOptionPane.showMessageDialog(null, "Gracz 2 wygrał");
                        }
                        System.out.println("dodano strzal do 2 " + p);
                        if(pierwszy == false)
                        {
                            pierwszy = true;
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Wybrano złe pole");
                    }
                }
                else
                    pierwszy = true;
                    this.refresh();
                }
            
         
       }
       else{
           
       }
           
    }
         //System.out.println(p);
        // refresh(g);
//         for(Point i : lista)
//         {
//             System.out.println(i);
//         }
//         System.out.println("   ");
//         
         
       
    
    
    }
    public boolean getOK()
    {
        return ok;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // p = e.getPoint();
        // lista.add(p);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       //  p = e.getPoint();
        // lista.add(p);
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
