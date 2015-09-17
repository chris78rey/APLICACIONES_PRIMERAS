/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;


import he1.odonto.entities.ORayosX;
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
public class ORayosXFacade extends AbstractFacade<ORayosX> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ORayosXFacade() {
        super(ORayosX.class);
    }

    public List<ORayosX> listRayosX(Pacientes paciente) {
        StringBuilder sb = new StringBuilder("select object(o) from ORayosX as o");
        sb.append(" where o.pacientes = :pacientes order by o.rayFecha DESC");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", paciente);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }
    public List<ORayosX>  findByHojaEvl(HojasDeEvolucion hjaEvl) {
        Query q = em.createQuery("select object(o) FROM ORayosX o WHERE o.hojasDeEvolucion = :hjaEvl");
        q.setParameter("hjaEvl", hjaEvl);
        q.setHint("eclipselink.refresh", true);
        List<ORayosX> result = q.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }
    
}
