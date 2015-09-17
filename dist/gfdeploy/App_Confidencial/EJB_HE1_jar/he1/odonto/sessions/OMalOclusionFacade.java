/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;


import he1.odonto.entities.OMalOclusion;
import he1.sis.entities.HojasDeEvolucion;
import he1.sis.entities.Pacientes;
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
public class OMalOclusionFacade extends AbstractFacade<OMalOclusion> {
    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OMalOclusionFacade() {
        super(OMalOclusion.class);
    }
    
    public List<OMalOclusion> listMalOclusion(Pacientes paciente){
        StringBuilder sb = new StringBuilder("select object(o) from OMalOclusion as o");
        sb.append(" where o.pacientes = :pacientes");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", paciente);
        q.setHint("eclipselink.refresh", true);
        //System.out.println("q "+q);
        return q.getResultList();
        
    }
    
    public OMalOclusion findByHcFecha(String cadena) {
        Query query = em.createNativeQuery(cadena, OMalOclusion.class);
        List<OMalOclusion> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return (OMalOclusion) result.get(0);

    }
    
    public OMalOclusion findByHojaEvl(HojasDeEvolucion hjaEvl) {
        Query q = em.createQuery("select object(o) FROM OMalOclusion o WHERE o.hojasDeEvolucion = :hjaEvl");
        q.setParameter("hjaEvl", hjaEvl);
        q.setHint("eclipselink.refresh", true);
        List<OMalOclusion> l = q.getResultList();
        if (!l.isEmpty()) {
            return (OMalOclusion) l.get(0);
        } else {
            return null;
        }
    }
}
