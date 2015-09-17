/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.servlet;

import he1.seguridades.entities.SegUrls;
import he1.seguridades.entities.nuevos.VUsuariosClasif;
import he1.seguridades.sessions.SegUrlsFacade;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
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
@WebServlet(name = "RepAcumula", urlPatterns = {"/acumula"})
public class RepAcumula extends HttpServlet {

    @Resource(name = "jdbche1")
    private DataSource jdbche1;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    private SegUrlsFacade segUrlsFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JRException, SQLException {

        ServletContext servletContext = request.getSession().getServletContext();
        HashMap hashMap = new HashMap();
        //aca se coloca los parámetros del reporte

//        hashMap.put("hc", "45397");
        Connection connection = null;
        byte[] bytes = null;
        try {
            //obtengo los valores almacenados en Decrypt(el servlet que desencrypta la data)
            HttpSession session = request.getSession(true);
            VUsuariosClasif vUsuariosClasif = new VUsuariosClasif();
            vUsuariosClasif = (VUsuariosClasif) session.getAttribute("vUsuariosClasif");

            //buscar el sello
            SegUrls findURL = segUrlsFacade.findURL("sello http he1");
            String urlSello = findURL.getUrl();

            hashMap.put("imagen_sello_he1", urlSello);
            hashMap.put("vUsuariosClasif_id", vUsuariosClasif.getId().toString());

            //se obtiene la conexion a la base de datos
            connection = jdbche1.getConnection();

            //dentro de la carpeta WEB-INF se debe colocar los reportes, 
            //en este caso se coloca los .jrxml no el .jasper
            String jrxmlPath = servletContext.getRealPath("/WEB-INF/report/");
            // directories where the report files are 
            String reportfile = "Racumula.jrxml";
            String jrxmlfile = jrxmlPath + "/" + reportfile;
//            String jrxmlfile = jrxmlPath + "\\" + reportfile;
            //InputStream is = this.getClass().getClassLoader().getResourceAsStream("/WEB-INF/report/"+jrxmlfile);
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlfile);            //is.close();
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
        } catch (JRException ex) {
            Logger.getLogger(RepAcumula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RepAcumula.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (JRException ex) {
            Logger.getLogger(RepAcumula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RepAcumula.class.getName()).log(Level.SEVERE, null, ex);
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
