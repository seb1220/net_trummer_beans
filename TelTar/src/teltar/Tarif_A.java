/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teltar;

/**
 *
 * @author Kawicher.Sebastian
 */
public class Tarif_A extends Tarif {
    private int gebuehren;
    
    protected Tarif_A(String bez, String telnr, int gebuehren) {
        super(bez, telnr);
        this.gebuehren = gebuehren;
    }

    public double getGebuehren() {
        return gebuehren;
    }
    
    public void setGebuehren(int gebuehren) {
        this.gebuehren = gebuehren;
    }
}
