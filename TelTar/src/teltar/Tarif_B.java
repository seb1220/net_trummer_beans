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
public class Tarif_B extends Tarif {
    private double gebuehren;
    private double conentgelt;
    
    protected Tarif_B(String bez, String telnr, double gebuehren, double conentgelt) {
        super(bez, telnr);
        this.gebuehren = gebuehren;
        this.conentgelt = conentgelt;
    }

    public double getGebuehren() {
        return gebuehren;
    }

    public double getConentgelt() {
        return conentgelt;
    }

    public void setGebuehren(double gebuehren) {
        this.gebuehren = gebuehren;
    }

    public void setConentgelt(double conentgelt) {
        this.conentgelt = conentgelt;
    }
    
    @Override
    public String GetInfo() {
        return super.GetInfo() + " und " + getConentgelt() + "/Minute";
    }
    
    @Override
    public double GetKosten (int x) {
        return super.GetKosten(x) + x * getConentgelt();
    }
    
    @Override
    public int GetBonuspunkte (int x) {
        if (x <= 1000) {
            return x;
        }else if (x <= 2000) {
            return x * 2 - 1000;
        } else {
            return x * 3 - 4000;
        }
    }
}
