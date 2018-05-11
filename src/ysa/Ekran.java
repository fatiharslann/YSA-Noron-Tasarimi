/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ysa;

import java.awt.HeadlessException;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Fatih
 */
public class Ekran{
    int noronSayisi=0;
    ArrayList<Noron> noronlar=new ArrayList<>();

    public ArrayList<Noron> getNoronlar() {
        return noronlar;
    }
    public Ekran()  {
        noronSayisi=Integer.valueOf(JOptionPane.showInputDialog(null, "Nöron Sayısı", null,1));
        new Pencere(noronSayisi);
        
    }
    
    
}
