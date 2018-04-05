/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Piezas;
import com.sv.udb.modelos.Proveedores;
import com.sv.udb.modelos.Bodega;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author luisedu
 */
public class BodegaCtrl {
    private final Connection conn;

    public BodegaCtrl() {
        this.conn = new Conexion().getConn();
    }
    
    
    
     public boolean guardar(Piezas codigopiez, Proveedores codigoprov,int cantidad, String fecha){
        boolean resp = false;
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("insert into Bodega values(null,?,?,?,?)");
            cmd.setInt(1, codigopiez.getCodigoPiez());
            cmd.setInt(2, codigoprov.getCodigoProv());
            cmd.setInt(3, cantidad);
            cmd.setString(4, fecha);
            cmd.executeUpdate();
            resp = true;
        } catch (Exception ex) {
            System.err.println("Error al guardar pieza en bodega" + ex.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion en jugadores: " + e.getMessage());
            }
        }
        
        return resp;
    }
    
     public List<Bodega> obtenerTodo(){
        List<Bodega> resp = new ArrayList<>();
        try {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT Bodega.codi_bode, Piezas.*, Proveedores.*, Bodega.cant, Bodega.fecha_comp FROM Bodega INNER JOIN Piezas ON Bodega.codi_piez = Piezas.codi_piez INNER JOIN Proveedores ON Bodega.codi_prov=Proveedores.codi_prov");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                resp.add(new Bodega(rs.getInt(1),
                         new Piezas(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)),
                         new Proveedores(rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9)),
                         rs.getInt(10), rs.getString(11)));                
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar: " + ex.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    } 
    
     public boolean modificar(int id, Piezas codigopiez, Proveedores codigoprov, int cantidad, String fecha){
        boolean resp = false;
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("UPDATE Bodega SET codi_piez=?, codi_prov=?, cant=?, fecha_comp=? WHERE codi_bode=?");
            cmd.setInt(1, codigopiez.getCodigoPiez());
            cmd.setInt(2, codigoprov.getCodigoProv());
            cmd.setInt(3, cantidad);
            cmd.setString(4, fecha);
            cmd.setInt(5, id);
            cmd.executeUpdate();
            resp = true;
        } catch (Exception ex) {
            System.err.println("Error al modificar Bodega" + ex.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion en bodega: " + e.getMessage());
            }
        }
        
        return resp;
    }
     
     public boolean eliminar(int id){
        boolean resp = false;
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("DELETE FROM Bodega WHERE codi_bode=?");
            cmd.setInt(1, id);
            cmd.executeUpdate();
            resp = true;
        } catch (Exception ex) {
            System.err.println("Error al eliminar bodega" + ex.getMessage());
        } finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion en bodega: " + e.getMessage());
            }
        }
        
        return resp;
    }
}
