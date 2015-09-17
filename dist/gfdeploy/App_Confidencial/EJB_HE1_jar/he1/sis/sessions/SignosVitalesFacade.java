/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;


import he1.odonto.sessions.AbstractFacade;
import he1.sis.entities.HojasDeEvolucion;
import he1.sis.entities.Pacientes;
import he1.sis.entities.SignosVitales;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author luis_guanoluiza
 */
@Stateless
public class SignosVitalesFacade extends AbstractFacade<SignosVitales> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SignosVitalesFacade() {
        super(SignosVitales.class);
    }

    public List<SignosVitales> listSignosVitales(Pacientes pHc) {
        StringBuilder sb = new StringBuilder("select object(o) from SignosVitales as o");
        sb.append(" where o.pacientes = :pacientes");
        sb.append(" order by o.signosVitalesPK.fecha desc");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", pHc);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();

    }
    
    public List<SignosVitales> listSignosVitalesByHoja(HojasDeEvolucion hoja) {
        StringBuilder sb = new StringBuilder("select object(o) from SignosVitales as o");
        sb.append(" where o.hojasDeEvolucion = :hojaEvol");
        sb.append(" order by o.signosVitalesPK.fecha desc");
        Query q = em.createQuery(sb.toString());
        q.setParameter("hojaEvol", hoja);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();

    }
    
   
    public SignosVitales findByHcFecha(String cadena) {
       Query query = em.createNativeQuery(cadena, SignosVitales.class);
        List<SignosVitales> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return (SignosVitales) result.get(0);
    }
    
    public SignosVitales findByHojaEvl(HojasDeEvolucion hjaEvl) {
        Query q = em.createQuery("select object(o) FROM SignosVitales o WHERE o.hojasDeEvolucion = :hjaEvl");
        q.setParameter("hjaEvl", hjaEvl);
        q.setHint("eclipselink.refresh", true);
        List<SignosVitales> l = q.getResultList();
        if (!l.isEmpty()) {
            return (SignosVitales) l.get(0);
        } else {
            return null;
        }
    }
}
