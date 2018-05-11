/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ysa;

/**
 *
 * @author Fatih
 */
public class Noron {
    private AktivasyonFonksiyonu aktivasyonFonksiyonu;
    private ToplamFonksiyonu toplamFonksiyonu;
    private double[] agirliklar;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public AktivasyonFonksiyonu getAktivasyonFonksiyonu() {
        return aktivasyonFonksiyonu;
    }

    public void setAktivasyonFonksiyonu(AktivasyonFonksiyonu aktivasyonFonksiyonu) {
        this.aktivasyonFonksiyonu = aktivasyonFonksiyonu;
    }

    public double[] getAgirliklar() {
        
        return agirliklar;
    }

    public void setAgirliklar(double[] agirliklar) {
        this.agirliklar = agirliklar;
    }

    public ToplamFonksiyonu getToplamFonksiyonu() {
        return toplamFonksiyonu;
    }

    public void setToplamFonksiyonu(ToplamFonksiyonu toplamFonksiyonu) {
        this.toplamFonksiyonu = toplamFonksiyonu;
    }
    
}
