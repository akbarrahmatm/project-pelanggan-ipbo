/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctr;

import ent.entPelanggan;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class ctrPelanggan {
    entPelanggan o = new entPelanggan();
    
    public void setKdPlg(String p){
        o.setKdPlg(p);
        o.cariPelanggan();
    }
    
    public ArrayList<String> getDataPelanggan(){
        ArrayList<String> vLst = new ArrayList<String>();
        vLst.add(o.getKdPlg());
        vLst.add(o.atNamaPlg);
        vLst.add(o.atAlamat);
        vLst.add(o.atTelp);
        
        return vLst;
    }
    
    public void setDataPelanggan(ArrayList<String> p){
        o.setKdPlg(p.get(0));
        o.atNamaPlg = p.get(1);
        o.atAlamat = p.get(2);
        o.atTelp = p.get(3);
    }
    
    public void simpan(){
        o.insert();
    }
    
    public void edit(){
        o.update();
    }
    
    public void hapus(){
        o.delete();
    }
}
