/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;


import he1.odonto.entities.OFluorosis;
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
public class OFluorosisFacade extends AbstractFacade<OFluorosis> {
    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OFluorosisFacade() {
        super(OFluorosis.class);
    }
    
    public List<OFluorosis> listFluorosis(Pacientes paciente){
        StringBuilder sb = new StringBuilder("select object(o) from OFluorosis as o");
        sb.append(" where o.pacientes = :pacientes");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", paciente);
        q.setHint("eclipselink.refresh", true);
        //System.out.println("q "+q);
        return q.getResultList();
        
    }
    
    public OFluorosis findByHcFecha(String cadena) {
        Query query = em.createNativeQuery(cadena, OFluorosis.class);
        List<OFluorosis> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return (OFluorosis) result.get(0);

    }
    
    public OFluorosis findByHojaEvl(HojasDeEvolucion hjaEvl) {
        Query q = em.createQuery("select object(o) FROM OFluorosis o WHERE o.hojasDeEvolucion = :hjaEvl");
        q.setParameter("hjaEvl", hjaEvl);
        q.setHint("eclipselink.refresh", true);
        List<OFluorosis> l = q.getResultList();
        if (!l.isEmpty()) {
            return (OFluorosis) l.get(0);
        } else {
            return null;
        }
    }
}
