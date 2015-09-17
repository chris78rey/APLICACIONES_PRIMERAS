/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;


import he1.odonto.entities.OTratamiento;
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
public class OTratamientoFacade extends AbstractFacade<OTratamiento> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OTratamientoFacade() {
        super(OTratamiento.class);
    }

    public List<OTratamiento> listaTratamientos(Pacientes paciente) {
        StringBuilder sb = new StringBuilder("select object(o) from OTratamiento as o");
        sb.append(" where o.pacientes = :pacientes ORDER BY o.trtFecha DESC");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", paciente);
        q.setHint("eclipselink.refresh", true);
        //System.out.println("q "+q);
        return q.getResultList();
    }

    public OTratamiento findByHojaEvl(HojasDeEvolucion hjaEvl) {
        Query q = em.createQuery("select object(o) FROM OTratamiento o WHERE o.hojasDeEvolucion = :hjaEvl");
        q.setParameter("hjaEvl", hjaEvl);
        q.setHint("eclipselink.refresh", true);
        List<OTratamiento> l = q.getResultList();
        if (!l.isEmpty()) {
            return (OTratamiento) l.get(0);
        } else {
            return null;
        }
    }

}
