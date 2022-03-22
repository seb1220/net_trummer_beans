/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawdemofrm;

import java.awt.Graphics;

/**
 *
 * @author Verena
 */
public abstract class Figure {
    public int x, y;
    public static int SIZE=40;
    
    public Figure(int x, int y){
        set(x, y);
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public int getX(){
        return x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getY(){
        return y;
    }
    
    public void set(int x, int y){
        setX(x);
        setY(y);
    }
    
    public abstract void paint(Graphics g);
}
