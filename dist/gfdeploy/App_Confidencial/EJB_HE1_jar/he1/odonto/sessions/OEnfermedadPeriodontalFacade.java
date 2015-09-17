/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;


import he1.odonto.entities.OEnfermedadPeriodontal;
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
public class OEnfermedadPeriodontalFacade extends AbstractFacade<OEnfermedadPeriodontal> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OEnfermedadPeriodontalFacade() {
        super(OEnfermedadPeriodontal.class);
    }

    public List<OEnfermedadPeriodontal> listEnfPeriodontal(Pacientes paciente) {
        StringBuilder sb = new StringBuilder("select object(o) from OEnfermedadPeriodontal as o");
        sb.append(" where o.pacientes = :pacientes");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", paciente);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }

    public OEnfermedadPeriodontal findByHcFecha(String cadena) {
        Query query = em.createNativeQuery(cadena, OEnfermedadPeriodontal.class);
        List<OEnfermedadPeriodontal> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return (OEnfermedadPeriodontal) result.get(0);

    }

    public OEnfermedadPeriodontal findByHojaEvl(HojasDeEvolucion hjaEvl) {
        Query q = em.createQuery("select object(o) FROM OEnfermedadPeriodontal o WHERE o.hojasDeEvolucion = :hjaEvl");
        q.setParameter("hjaEvl", hjaEvl);
        q.setHint("eclipselink.refresh", true);
        List<OEnfermedadPeriodontal> l = q.getResultList();
        if (!l.isEmpty()) {
            return (OEnfermedadPeriodontal) l.get(0);
        } else {
            return null;
        }
    }
}
