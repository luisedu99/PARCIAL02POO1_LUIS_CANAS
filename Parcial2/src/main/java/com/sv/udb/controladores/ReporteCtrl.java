/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.recursos.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
/**
 *
 * @author luisedu
 */
public class ReporteCtrl {
    public static int PDF = 1;
    String jrxmlFileName="";
    String jasperFileName="";
    String fileName="";
    
    public void Report(String des, String has, int type) {
        HashMap map;
        
        try {
            //Rutas de archivos
            jrxmlFileName = new File("src/main/java/com/sv/udb/reportes/Reporte2.jrxml").getAbsolutePath();
            jasperFileName = new File("src/main/java/com/sv/udb/reportes/Reporte2.jasper").getAbsolutePath();

            //Compilando jasperreport
            net.sf.jasperreports.engine.JasperCompileManager.compileReportToFile(jrxmlFileName, jasperFileName);
            //Conexion
            Connection conn = new Conexion().getConn();
            
            map = new HashMap();
            map.put("desde",des);
            map.put("hasta",has);
            JasperPrint print = (JasperPrint)JasperFillManager.fillReport(jasperFileName, map,conn);
            
            if(type == PDF){
            //guardando
                fileName = new File("reportes/pdf/ReporteBodega.pdf").getAbsolutePath();
                JasperExportManager.exportReportToPdfFile(print, fileName);
                
                //mostrar en el jasperviewer
                JasperViewer.viewReport(print, false);
                //si se desea que el reporte se imprima tambien en el visor por defecto quitar la siguiente linea
                return;
            }
            
            //mostrando
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(fileName));
                } catch (IOException ex) {
                    System.out.println("No fue posible abrir el archivo" + ex);
                }
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
