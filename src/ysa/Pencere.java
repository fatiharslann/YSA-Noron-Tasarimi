/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ysa;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Fatih
 */
public class Pencere extends JFrame{
    private JPanel panel;
    private JLabel label1,label;
    private JTextField textParametreSayisi,textAltSinir,textUstSinir,textVeriSayisi;
    private JRadioButton toplamFonk1,toplamFonk2,aktivasyonFonk1,aktivasyonFonk2,aktivasyonFonk3;
    private ButtonGroup grpToplamFonk,grpAktivasyonFonk;
    private JButton btnHesapla;
    private int tempToplam=0,tempAktivasyon=0;
    private Hesapla hesapla;
    private double[] sonuc;
    private JComboBox comboBox;
    private ToplamFonksiyonu toplamFonksiyonu;
    private AktivasyonFonksiyonu aktivasyonFonksiyonu;
    private int sayac=0;
    private ArrayList<Noron> noronlar=new ArrayList<>();
    public Pencere(int noronSayisi){
        setSize(850,600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        for (int i = 0; i < noronSayisi; i++) {
            noronlar.add(new Noron());
        }
        hesapla=new Hesapla();
        
        label=new JLabel("NÖRON-1");
        label.setBounds(20,0,110,30);
        add(label);
        
        label1=new JLabel("Parametre Sayısı: ");
        label1.setBounds(20,20,110,30);
        add(label1);
        
        textParametreSayisi=new JTextField();
        textParametreSayisi.setBounds(140,20,100,30);
        add(textParametreSayisi);
        
        label1=new JLabel("Veri Sayısı: ");
        label1.setBounds(20,60,110,30);
        add(label1);
        
        textVeriSayisi=new JTextField();
        textVeriSayisi.setBounds(140,60,100,30);
        add(textVeriSayisi);
        
        label1=new JLabel("Alt Sınır: ");
        label1.setBounds(20,100,110,30);
        add(label1);
        
        textAltSinir=new JTextField();
        textAltSinir.setBounds(140,100,100,30);
        add(textAltSinir);
        
        label1=new JLabel("Üst Sınır: ");
        label1.setBounds(20,150,150,30);
        add(label1);
        
        textUstSinir=new JTextField();
        textUstSinir.setBounds(140,150,100,30);
        add(textUstSinir);
        
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,20,250,110);
        panel.setBackground(Color.LIGHT_GRAY);
        
        label1=new JLabel("--TOPLAM FOKSİYONU--");
        label1.setBounds(20, 0, 150, 30);
        panel.add(label1);
        
        toplamFonk1 =new JRadioButton("Genel",true);
        toplamFonk1.setBounds(50, 30, 100, 30);
        toplamFonk2 =new JRadioButton("Çarpım",true);
        toplamFonk2.setBounds(50, 60, 100, 30);
        grpToplamFonk = new ButtonGroup();
        grpToplamFonk.add(toplamFonk1);
        grpToplamFonk.add(toplamFonk2);
        toplamFonk2.setBackground(Color.LIGHT_GRAY);
        toplamFonk1.setBackground(Color.LIGHT_GRAY);
        panel.add(toplamFonk1);
        panel.add(toplamFonk2);
                              
        
        
        add(panel);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(550,20,250,110);
        panel.setBackground(Color.LIGHT_GRAY);
        
        label1=new JLabel("--AKTİVASYON FOKSİYONU--");
        label1.setBounds(20, 0, 200, 30);
        panel.add(label1);
        
        aktivasyonFonk1 =new JRadioButton("Sigmoid",true);
        aktivasyonFonk1.setBounds(50, 30, 100, 30);
        aktivasyonFonk2 =new JRadioButton("Hiperbolik Tanjant",true);
        aktivasyonFonk2.setBounds(50, 55, 150, 30);
        aktivasyonFonk3 =new JRadioButton("Sinüs",true);
        aktivasyonFonk3.setBounds(50, 80, 100, 30);
        grpAktivasyonFonk = new ButtonGroup();
        grpAktivasyonFonk.add(aktivasyonFonk1);
        grpAktivasyonFonk.add(aktivasyonFonk2);
        grpAktivasyonFonk.add(aktivasyonFonk3);
        aktivasyonFonk1.setBackground(Color.LIGHT_GRAY);
        aktivasyonFonk2.setBackground(Color.LIGHT_GRAY);
        aktivasyonFonk3.setBackground(Color.LIGHT_GRAY);
        panel.add(aktivasyonFonk1);
        panel.add(aktivasyonFonk2);
        panel.add(aktivasyonFonk3);
        add(panel);
        toplamFonk1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tempToplam=0;
            }
        });
        toplamFonk2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tempToplam=1;
            }
        });
        aktivasyonFonk1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tempAktivasyon=0;
            }
        });
        aktivasyonFonk2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tempAktivasyon=1;
            }
        });
        aktivasyonFonk3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tempAktivasyon=2;
            }
        });
        label1=new JLabel("Sonuç : ");
        label1.setBounds(20,300,100,30);
        add(label1);
        comboBox=new JComboBox();
        comboBox.setBounds(130,300,150,30);
        add(comboBox);
        btnHesapla = new JButton("Bilgileri Nörona Kaydet");
        btnHesapla.setBounds(20,200,800,50);
        btnHesapla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                /*sonuc=hesapla.hesapla(
                        Integer.valueOf(textVeriSayisi.getText()),
                        Integer.valueOf(textParametreSayisi.getText()),
                        Integer.valueOf(textAltSinir.getText()), 
                        Integer.valueOf(textUstSinir.getText()), 
                        tempToplam, tempAktivasyon);
                comboBox.removeAllItems();
                for (int i = 0; i < sonuc.length; i++) {
                    comboBox.addItem(sonuc[i]);
                }*/
                if (sayac>=noronSayisi) {
                    JOptionPane.showMessageDialog(null, "Nöronlar üretildi");
                    for (int i = 0; i < noronlar.size(); i++) {
                        System.err.println(noronlar.get(i).getAgirliklar()[0]);
                    }
                }else{
                    if(tempToplam==1){
                        toplamFonksiyonu=new Tip2();
                    }else{
                        toplamFonksiyonu=new Tip1();
                    }
                    if(tempAktivasyon==2){
                        aktivasyonFonksiyonu=new Sinus();
                    }else if(tempAktivasyon==1){
                        aktivasyonFonksiyonu=new HiperbolikTanjant();
                    }else{
                        aktivasyonFonksiyonu=new Sigmoid();
                    }
                     double[] w=new double[Integer.valueOf(textParametreSayisi.getText())];
                     for (int i = 0; i < w.length; i++) {
                        w[i]=Math.random();
                     }
                    noronlar.get(sayac).setId(sayac);
                    noronlar.get(sayac).setAktivasyonFonksiyonu(aktivasyonFonksiyonu);
                    noronlar.get(sayac).setToplamFonksiyonu(toplamFonksiyonu);
                    noronlar.get(sayac).setAgirliklar(w);
                    sayac++;
                    label.setText("NÖRON-"+(sayac+1));
                }
                
            }
        });
       add(comboBox);
       add(btnHesapla);
       setVisible(true);
        
    }
}
