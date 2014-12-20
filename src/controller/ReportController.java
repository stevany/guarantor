/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author edepe7
 */
public class ReportController {
    /**
     * Preview Laporan
     * @param namaReport
     * @param parameter
     * @param DataSource
     * @param JudulLap 
     */
    public static void PreviewLap(String namaReport, Map parameter, List DataSource, String JudulLap){
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(namaReport, 
                    parameter, 
                    new JRBeanCollectionDataSource(DataSource) );
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);
            jasperViewer.setTitle(JudulLap);
            
            
        } catch (JRException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
    public static void CetakLap(String namaLaporan, Map parameter, List dataSource, String JudulLap){
        try {
              
//            JRDataSource jRDataSource = new JRBeanCollectionDataSource(dataSource,false);
            //JasperPrint jasperPrint = JasperFillManager.fillReport(namaLaporan, parameter, jRDataSource );
            JasperPrint jasperPrint = JasperFillManager.fillReport(namaLaporan, parameter, new JRBeanCollectionDataSource(dataSource) );
            JasperPrintManager.printReport(jasperPrint, true);
//            JRXlsExporter exporterXLS = new JRXlsExporter();
//                exporterXLS.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
//                exporterXLS.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
//                exporterXLS.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//                exporterXLS.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);
//                exporterXLS.setParameter(JRXlsExporterParameter.OFFSET_X, 0);
//                exporterXLS.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BORDER, Boolean.FALSE);
//                exporterXLS.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, true);
//                exporterXLS.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, false);
            
        } catch (JRException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
