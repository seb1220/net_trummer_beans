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
public class Rectangle extends Figure{
    public Rectangle(int x, int y){
        super(x, y);
    }
    
    @Override
    public void paint(Graphics g){
        g.drawRect(x-SIZE/2, y-SIZE/2, SIZE, SIZE);
    }
}
