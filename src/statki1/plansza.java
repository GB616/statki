/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statki1;

import java.util.List;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Kompik1
 */
public class plansza {

    
    int [][] tab = new int[10][10];
    int iloscTrafien = 0;
    
    plansza(){
        for(int i =0 ;i<10;i++)
        {
            for(int j =0 ;j<10;j++)
            {
                tab[i][j] = 0;
            }
        }
    }
    
    private  void dodajPunkt(Point a) {
        int x = a.x, y = a.y;
        tab[x][y] = 2; 
    }
    
    public boolean dodajStatek(Statek s)
    {
        dodajPunkt(s.a);
        return false;
    }
    
    public boolean dodajDwumasztowiec(Dwumasztowiec d)
    {
        dodajPunkt(d.a);
        dodajPunkt(d.b);
        return false;
    }
    
    public boolean dodajTrojmasztowiec(Trojmasztowiec d)
    {
        dodajPunkt(d.a);
        dodajPunkt(d.b);
        dodajPunkt(d.c);
        return false;
    }
    
    public boolean dodajCzteromasztowiec(Czteromasztowiec d)
    {
        dodajPunkt(d.a);
        dodajPunkt(d.b);
        dodajPunkt(d.c);
        dodajPunkt(d.d);
        return false;
    }
    
    
    
    
    public boolean  dodajStrzal(Point p)
    {
        int puste = 0, pudlo = 1, statek = 2, trafiony = 3; 
        if(tab[p.x][p.y] == puste)
        {
            tab[p.x][p.y] = pudlo ;
            return true;
        }
        
        if(tab[p.x][p.y] == statek )
        {
            tab[p.x][p.y] = trafiony  ;
            iloscTrafien++;
            return true;
        }
        
        if(tab[p.x][p.y] == pudlo)
        {
            return false;
        }
        
        if(tab[p.x][p.y] == trafiony)
        {
            return false;
        }
        return false;
    }
   
    
    public boolean  dodajStrzal(int x, int y)
    {
        int puste = 0, pudlo = 1, statek = 2, trafiony = 3; 
        if(tab[x][y] == puste)
        {
            tab[x][y] = pudlo ;
            return true;
        }
        
        if(tab[x][y] == statek )
        {
            tab[x][y] = trafiony  ;
            return true;
        }
        
        if(tab[x][y] == pudlo)
        {
            return false;
        }
        
        if(tab[x][y] == trafiony)
        {
            return false;
        }
        return false;
    }

    int zwrocWartosc(int i , int j )
    {
        return tab[i][j];
    }
       
    int zwroctrafienia()
    {
        return iloscTrafien;
    }
}
