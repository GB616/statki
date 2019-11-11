/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statki1;

import java.awt.Point;

/**
 *
 * @author Kompik1
 */
public class Trojmasztowiec extends Dwumasztowiec{
    Point c;
    
    Trojmasztowiec(Point a, Point b , Point c)
    {
        super(a, b);
        
        this.c = c;
    }
    }
