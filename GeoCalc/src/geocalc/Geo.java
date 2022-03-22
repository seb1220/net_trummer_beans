/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geocalc;

import java.awt.Point;

/**
 *
 * @author sebastian kawicher
 */

public abstract class Geo {
    public static final int T_DREIECK = 1;
    public static final int T_Quadrat = 2;
    public static final int T_Kreis = 3;
    public static final int T_PYRAMIDE = 4;
    public static final int T_QUADER= 5;
    public static final int T_ZYLINDER = 6;
    public static final int T_PRISMA = 7;
    
    private String desc;
    
    protected Geo(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
    
    protected abstract void println();
    
}
