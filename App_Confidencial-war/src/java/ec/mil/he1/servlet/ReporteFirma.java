/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.servlet;

import he1.seguridades.entities.nuevos.VUsuariosClasif;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author christian_ruiz
 */
@WebServlet(name = "ReporteFirma", urlPatterns = {"/ReporteFirma"})
public class ReporteFirma extends HttpServlet {

    @Resource(name = "he1")
    private DataSource he1;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    VUsuariosClasif vUsuariosClasif = new VUsuariosClasif();
//   session.setAttribute("vUsuariosClasif", vUsuariosClasif);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        ServletContext servletContext = request.getSession().getServletContext();

        HttpSession session = request.getSession();

        vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");

        HashMap hashMap = new HashMap();
        //aca se coloca los parámetros del reporte
        hashMap.put("CI", vUsuariosClasif.getCedulaLogin());
        hashMap.put("escudo", "http://servicios.he1.mil.ec/AppImg/resources/images/escudo.png");
        hashMap.put("firma", "http://servicios.he1.mil.ec/AppImg/resources/images/firmapng.png");

        Connection connection = null;
        byte[] bytes = null;
        try {
            //dentro de la carpeta WEB-INF se debe colocar los reportes, 
            //en este caso se coloca los .jrxml no el .jasper
            String jrxmlPath = servletContext.getRealPath("/WEB-INF/report/");
            // directories where the report files are 
            String reportfile = "firma_digital_1.jrxml";
            String jrxmlfile = jrxmlPath + "/" + reportfile;

            //InputStream is = this.getClass().getClassLoader().getResourceAsStream("/WEB-INF/report/"+jrxmlfile);
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlfile);            //is.close();

            //se obtiene la conexion a la base de datos
            connection = he1.getConnection();
            //se envia los parametros en este caso el compilado, el hashmap con los param del reporte y la conexión 
            //a la base de datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hashMap, connection);
            //se almacena la impresión en un arreglo de bytes    
            bytes = JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (JRException e) {
            //en caso de error imprimirlo
            System.out.println("e = " + e.getLocalizedMessage());
        } finally {
            //se cierra la conexion
            connection.close();
        }

        response.setHeader("Content-disposition", "inline;filename=morningShift.pdf;");
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);

        response.getOutputStream().write(bytes);
        response.flushBuffer();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteFirma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ReporteFirma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
