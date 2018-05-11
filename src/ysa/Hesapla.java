/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ysa;

import java.util.Random;

/**
 *
 * @author Fatih
 */
public class Hesapla {
    private ToplamFonksiyonu toplamFonksiyonu;
    private AktivasyonFonksiyonu aktivasyonFonksiyonu;

    public double[] hesapla(int veriSayisi,int parametreSayisi,int altSinir,int ustSinir,int toplamFonk,int aktivasyonFonk){
        Random rnd=new Random();
        double[] sonuc=new double[veriSayisi];
        int fark=ustSinir-altSinir;
        double[][] x=new double[veriSayisi][parametreSayisi];
        double[] w=new double[parametreSayisi];
        for (int i = 0; i < parametreSayisi; i++) {
            w[i]=Math.random();
        }
        for (int i = 0; i < veriSayisi; i++) {
            for (int j = 0; j < parametreSayisi; j++) {
                x[i][j]=altSinir+rnd.nextDouble()*fark;
            }
        }
        if(toplamFonk==1){
            toplamFonksiyonu=new Tip2();
        }else{
            toplamFonksiyonu=new Tip1();
        }
        if(aktivasyonFonk==2){
            aktivasyonFonksiyonu=new Sinus();
        }else if(aktivasyonFonk==1){
            aktivasyonFonksiyonu=new HiperbolikTanjant();
        }else{
            aktivasyonFonksiyonu=new Sigmoid();
        }
        for (int i = 0; i < veriSayisi; i++) {
            
            sonuc[i]=aktivasyonFonksiyonu.sonucHesapla(toplamFonksiyonu.hesapla(parametreSayisi, x[i], w));
        }
        return sonuc;
    }
}
