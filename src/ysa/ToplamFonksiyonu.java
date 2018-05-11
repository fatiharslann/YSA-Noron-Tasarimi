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
public interface ToplamFonksiyonu {
    public double hesapla(int parametreSayisi,double[] x,double[] w);
}
class Tip1 implements ToplamFonksiyonu{

    @Override
    public double hesapla(int parametreSayisi,double[] x,double[] w) {
        double toplam=0;
        for(int i=0;i<parametreSayisi;i++){
            toplam+=(x[i]*w[i]);
        }
        return toplam;
    }
    
}
class Tip2 implements ToplamFonksiyonu{

    @Override
    public double hesapla(int parametreSayisi, double[] x, double[] w) {
        double carpim=1;
        for (int i = 0; i < parametreSayisi; i++) {
            carpim*=(x[i]*w[i]);
        }
        return carpim;
    }
    
}
