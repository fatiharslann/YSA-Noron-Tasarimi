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
public interface AktivasyonFonksiyonu {
    double sonucHesapla(double net);
}
class Sigmoid implements AktivasyonFonksiyonu{

    @Override
    public double sonucHesapla(double net) {
        double sonuc=0;
        sonuc=1/(1+Math.exp(net));
        return sonuc;
    }
    
}
class HiperbolikTanjant implements AktivasyonFonksiyonu{

    @Override
    public double sonucHesapla(double net) {
        double sonuc=0;
        sonuc=(1-Math.exp((-2)*net))/(1+Math.exp(2*net));
        return sonuc;
    }
    
}
class Sinus implements AktivasyonFonksiyonu{

    @Override
    public double sonucHesapla(double net) {
        double sonuc=0;
        net=Math.toRadians(net);
        sonuc=Math.sin(net);
        return sonuc;
    }
    
}
