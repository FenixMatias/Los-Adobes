/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Vivienda;

/**
 *
 * @author Matio_000
 */
public class ViviendaDAO {
    
    public boolean ingresarvivienda(Vivienda viv)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query="insert into VIVIENDA (codigo, rut, nombre, montopie, metros, tipovivienda) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, viv.getCodigo());
            ps.setString(2, viv.getRut());
            ps.setString(3, viv.getNombre());
            ps.setInt(4, viv.getMontopie());
            ps.setDouble(5, viv.getMetros());
            ps.setString(6, viv.getTipovivienda());
            resultado=ps.executeUpdate()==1;
            ps.close();  
        } catch (SQLException ex) {
            Logger.getLogger(ViviendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViviendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public Vivienda buscarvivienda(String codigo)
    {
        Vivienda viv=null;
        try {
            Connection con = Conexion.getConexion();
            String query="select * from  VIVIENDA where codigo=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, codigo);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
                viv=new Vivienda(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6));
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViviendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViviendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return viv;
    }   
    
    public ArrayList<Vivienda> mostrartodos()
    {
        ArrayList <Vivienda> vivienda=new ArrayList<Vivienda>();
        try {
            Connection con=Conexion.getConexion();
            String query="select * from VIVIENDA";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            Vivienda viv;
            while(rs.next())
            {
                viv=new Vivienda(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6));
                vivienda.add(viv);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViviendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViviendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vivienda;
    }    
    
    public boolean eliminarvivienda(String codigo)
    {
        boolean resultado=false;
        
        try {
            Connection con=Conexion.getConexion();
            String query="delete from VIVIENDA where codigo=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, codigo);
            resultado=ps.executeUpdate()==1;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViviendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViviendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public boolean modificarvivienda(Vivienda viv)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query="update VIVIENDA set rut=?,nombre=?,montopie=?,metros=?,tipovivienda=? where codigo=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, viv.getRut());
            ps.setString(2, viv.getNombre());
            ps.setInt(3, viv.getMontopie());
            ps.setDouble(4, viv.getMetros());
            ps.setDouble(5, viv.getMetros());
            ps.setString(6, viv.getTipovivienda());
            resultado=ps.executeUpdate()==1;
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ViviendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViviendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
}
