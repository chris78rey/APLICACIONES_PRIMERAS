/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.mil.he1.servlet;

import he1.seguridades.entities.nuevos.VUsuariosClasif;
import he1.seguridades.sessions.SegUsuarioFacade;
import he1.seguridades.sessions.VUsuariosClasifFacade;
import he1.utilities.SesionSeguridades;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christian_ruiz
 */
@WebServlet(name = "Decrypt", urlPatterns = {"/decr"})
public class Decrypt extends HttpServlet {

    @EJB
    private SesionSeguridades sesionSeguridades;
    @EJB
    private VUsuariosClasifFacade vUsuariosClasifFacade;

    @EJB
    private SegUsuarioFacade segUsuarioFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {

        try {
            HttpSession session = request.getSession(true);

   
            String usuid = "";
            //usuario encryptado
            String usuarioEncriptado = (request.getParameter("xphsumf"));
            String modulo = (request.getParameter("ldmjcgd"));
            usuid = segUsuarioFacade.p_decript_palabra(usuarioEncriptado);
            //llama a la vista de usuarios donde se encuentra integrada 
            //la información
            VUsuariosClasif vUsuariosClasif = vUsuariosClasifFacade.find(new BigDecimal(usuid));
            session.setAttribute("vUsuariosClasif", vUsuariosClasif);
            session.setAttribute("modulo", modulo);
            //refirecciona a la primera página del módulo

            String usuario = "";

            session.setAttribute("usuarioDB", vUsuariosClasif.getPerCodigo());
            session.setAttribute("perfilDB", "");
            session.setAttribute("usuarioBase", "");
            String perfil = "";
            response.sendRedirect("faces/template/Template.xhtml");

        } catch (SQLException | NamingException | NumberFormatException e) {
            System.out.println("e.getLocalizedMessage() = " + e.getLocalizedMessage());
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Decrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Decrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Decrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Decrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
