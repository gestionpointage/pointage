/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.powerking.pointage.ui;

import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Help {
    
    public static void remplirBD(String chemin, Connection cnx) throws FileNotFoundException, IOException, SQLException{
        Statement s = null;
        int i=0;
        String req = "";
        String req1 = "";
        s = cnx.createStatement();
        req = "TRUNCATE TABLE pointage";
        req1 = "TRUNCATE TABLE employe";
        s.executeUpdate(req);
        s.executeUpdate(req1);
        BufferedReader br = new BufferedReader(new FileReader(chemin));
        try {
            String line = br.readLine();
            while (line != null) {
                if (i!=0){
                    line = br.readLine();
                    if (line!=null){
                        String[] li = line.split(";");
                        System.err.println(li.length+"");
                        if (li.length == 5){
                            String[] p = li[4].split(" ");
                            String[] s1 = p[0].split(":");
                            String[] s2 = p[1].split(":");
                            int x1 = Integer.parseInt(s1[0]);
                            int x2 = Integer.parseInt(s2[0]);
                            String str = ((x2-x1)*3)+"dt";
                            req = "INSERT INTO pointage VALUES("+i+",'"+li[3]+"','"+p[0]+"','"+p[1]+"',"+li[0]+")";
                            req1 = "INSERT INTO employe VALUES("+li[0]+",'"+li[1]+"','"+li[2]+"',"+(x2-x1)+","+(x2-x1)*3+")";
                            s.executeUpdate(req1);
                        }
                        else
                        {
                            req = "INSERT INTO pointage(id,mat,nom, departement,date) VALUES("+i+","+li[0]+",'"+li[1]+"','"+li[2]+"','"+li[3]+"')";
                        }
                        System.err.println(req);
                        s.executeUpdate(req);
                        
                    }
                }
                i++;
            }
        } finally {
            br.close();
        }
    }
    
    public static void exportCSV(Connection cnx) throws IOException{
        
        FileWriter writer = new FileWriter("C:\\Users\\delll\\Desktop\\historique.csv");
     
        writer.append("mat");
        writer.append(';');
        writer.append("nom");
        writer.append(';');
        writer.append("departement");
        writer.append(';');
        writer.append("date");
        writer.append(';');
        writer.append("date_deb");
        writer.append(';');
        writer.append("date_fin");
        writer.append(';');
        writer.append("taux");
        writer.append(';');
        writer.append('\n');
        try {
            String req = "SELECT e.matricule , e.nom, e.departemet, p.date, p.heure_deb, p.heure_fin, e.taux_pre  FROM employe e , pointage p WHERE e.matricule = p.matricule";
            Statement s = cnx.createStatement();
            ResultSet rs = s.executeQuery(req);
            
            while (rs.next()){
                writer.append(rs.getInt(1)+"");
                writer.append(';');
                writer.append(rs.getString(2));
                writer.append(';');
                writer.append(rs.getString(3));
                writer.append(';');
                writer.append(rs.getString(4));
                writer.append(';');
                writer.append(rs.getString(5));
                writer.append(';');
                writer.append(rs.getString(6));
                writer.append(';');
                writer.append(rs.getInt(7)+"");
                writer.append(';');
                writer.append('\n');
            }
            
             writer.flush();
	    writer.close();
                    JOptionPane.showMessageDialog(null, "DONE");
        } catch (SQLException ex) {
            Logger.getLogger(Help.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void exportCSVsalaireJour(Connection cnx) throws IOException{
        
        FileWriter writer = new FileWriter("C:\\Users\\delll\\Desktop\\salaireJour.csv");
        
        writer.append("matricule");
        writer.append(';');
        writer.append("nom");
        writer.append(';');
        writer.append("date");
        writer.append(';');
        writer.append("salaire_jour");
        writer.append(';');
        writer.append("taux_pre");
        writer.append(';');
        writer.append('\n');
        try {
            String req = "SELECT e.matricule, e.nom, date, salaire_jour,  taux_pre FROM employe e , pointage p WHERE p.matricule = e.matricule";
            Statement s = cnx.createStatement();
            ResultSet rs = s.executeQuery(req);
            
            while (rs.next()){
                writer.append(rs.getInt(1)+"");
                writer.append(';');
                writer.append(rs.getString(2)+"");
                writer.append(';');
                writer.append(rs.getString(3));
                writer.append(';');
                writer.append(rs.getInt(4)+"");
                writer.append(';');
                writer.append(rs.getInt(5)+"");
                writer.append(';');
                writer.append('\n');
            }
            
             writer.flush();
	    writer.close();
            
            JOptionPane.showMessageDialog(null, "DONE");
        } catch (SQLException ex) {
            Logger.getLogger(Help.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
