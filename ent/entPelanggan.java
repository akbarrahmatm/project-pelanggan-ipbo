/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.dbConnection;

/**
 *
 * @author ACER
 */
public class entPelanggan {
    private String atKdPlg = "";
    public String atNamaPlg = "";
    public String atAlamat = "";
    public String atTelp = "";
    
    public void setKdPlg(String pKdPlg){
        this.atKdPlg = pKdPlg;
    }
    
    public String getKdPlg(){
        return this.atKdPlg;
    }
    
    public void cariPelanggan(){
        String vSql = "SELECT pelanggan.KdPlg, pelanggan.NamaPlg, "
                    + "pelanggan.Alamat, pelanggan.Telp FROM `pelanggan` "
                    + "WHERE pelanggan.KdPlg='"+this.atKdPlg+"'";
        dbConnection db = new dbConnection();
        Connection con = db.koneksiDB();
        PreparedStatement stat = null;
        try{
            stat = con.prepareStatement(vSql);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                this.atKdPlg=rs.getString("KdPlg");
                this.atNamaPlg=rs.getString("NamaPlg");
                this.atAlamat=rs.getString("Alamat");
                this.atTelp=rs.getString("Telp");    
            }else{
                this.atNamaPlg = "";
                this.atAlamat = "";
                this.atTelp = "";
            }
                      
        } catch (SQLException e){
            System.out.println("error----->"+e.toString());
        } 
    }
    
    public void insert() {
       
       String vSql="INSERT INTO pelanggan "
                 + "(pelanggan.KdPlg, pelanggan.NamaPlg, pelanggan.Alamat, "
                 + "pelanggan.Telp) VALUES "
                 + "('"+this.atKdPlg+"', '"+this.atNamaPlg
                 + "', '"+this.atAlamat+"','"+this.atTelp+"')";
        dbConnection db = new dbConnection();
        Connection con = db.koneksiDB();
        PreparedStatement Stat = null;
        try{
            Stat = con.prepareStatement(vSql);           
            Stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error -> "+ex.toString());
        }
    }  
    
    public void update() {
       String vSql="UPDATE pelanggan SET "
                 + "NamaPlg='"+this.atNamaPlg+"', Alamat='"+this.atAlamat
                 + "', Telp='"+this.atTelp+"' "
                 + "WHERE pelanggan.KdPlg='"+this.atKdPlg+"'";
       dbConnection db = new dbConnection();
        Connection con = db.koneksiDB();
       //System.out.println(sql);       
        PreparedStatement Stat = null;
        try{
            Stat = con.prepareStatement(vSql);                                                
            Stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error -> "+ex.toString());
        }
   }
    
   public void delete() {
       String vSql="DELETE FROM pelanggan WHERE pelanggan.KdPlg='"+this.atKdPlg+"'";
       dbConnection db = new dbConnection();
        Connection con = db.koneksiDB();
        PreparedStatement Stat = null;
        try{
            Stat = con.prepareStatement(vSql);                                                
            Stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error -> "+ex.toString());
        }
   }
   
   public static void main(String[] args){
        entPelanggan o = new entPelanggan();
//        o.setKdPlg("003");
//        o.delete();
        
        
        /*update
        o.setKdPlg("003");
        o.atNamaPlg="PT ABC-----";
        o.atAlamat="Jln Tentara Pelajar muda mudi";
        o.atTelp="1111111";
        o.update();
        */
        

        // insert
//        o.setKdPlg("003");
//        o.atNamaPlg="PT ABC";
//        o.atAlamat="Jln Tentara Pelajar";
//        o.atTelp="1112221111";
//        o.insert();

        // search
        o.setKdPlg("001");
        o.cariPelanggan();       
        System.out.println("Kd Plg : "+o.getKdPlg());
        System.out.println("Nama Plg : "+o.atNamaPlg);
        System.out.println("Alamat : "+o.atAlamat);
        System.out.println("Telp :"+o.atTelp);
    }
}
