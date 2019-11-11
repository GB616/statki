/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statki1;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 *
 * @author Kompik1
 */

public class rozstawianieStatkow extends JPanel implements MouseListener{
    Point p = new Point() ;
    List<Point> lista = new ArrayList<Point>();
    //Point g = new Point(3,2);
     //Graphics g = new Graphics() ;
    
    int rozmiarPola = 30;
    public boolean ok ;
    plansza plansza =  new plansza();
    public rozstawianieStatkow()
    {
       // lista.add(g);   
        
        JPanel panel = new JPanel();
        JTextArea txtPozycja = new JTextArea();
        txtPozycja.setBounds(150,75,100,25);
        
        panel.add(txtPozycja);
        
        JButton btnDalej = new JButton("Dalej");
        //btnDalej.addActionListener(this);
        txtPozycja.setBounds(150,75,100,25);
        panel.add(btnDalej);
        
        ok = false;
        setPreferredSize(new Dimension(400, 400));
        addMouseListener(this);
        
        
    }
    
    @Override
	 protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
      
		for(int i=0 ;i<10;i++)
                {
                    for(int j =0; j<10;j++)
                    {
                        p.x = i;
                        p.y = j;
                       // System.out.println(p);
                        if(plansza.zwrocWartosc(i, j)== 1)
                        {
                        Ellipse2D circle = new Ellipse2D.Double(p.x * rozmiarPola, p.y * rozmiarPola, rozmiarPola, rozmiarPola);
                        g2d.draw(circle);
                        }
                        if(plansza.zwrocWartosc(i, j)== 2)
                        {
                      
                        g2d.fillOval(p.x * rozmiarPola, p.y * rozmiarPola, rozmiarPola, rozmiarPola);
                        }
                    }
                    
                }
		
                for (int x=0; x<10; x++)
            {
                for (int y = 0; y < 10; y++)
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
    void refresh( )
    {
       // Graphics d = new Graphics();
      //Graphics2D d = (Graphics2D) d;
      //paintComponent(d);
    }
    Point a,b,c,d;
    @Override
    public void mouseClicked(MouseEvent e) {
       
        ok = true;
        p = e.getPoint();
        p.x = p.x/rozmiarPola;
        p.y = p.y/rozmiarPola;
        int i =0;
        if(i<3)
        {
            if(p.x<10 && p.x>=0 && p.y<10 && p.y>=0)
            {   
                Statek s = new Statek(p); 
                ok=plansza.dodajStatek(s);
               
                //ok = plansza.dodajStrzal(p);    
            }
             i++;
        }
        else
           System.out.println("koniec wybierania");
//         int j=0,z=0;
//         if(z<3)
//         {
//             if(p.x<10 && p.x>=0 && p.y<10 && p.y>=0)
//            {   
//                Statek s = new Statek(p); 
//                ok=plansza.dodajStatek(s);
//                i++;
//                //ok = plansza.dodajStrzal(p);    
//            }
//         }
         
         
             
            
            
       
         
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
