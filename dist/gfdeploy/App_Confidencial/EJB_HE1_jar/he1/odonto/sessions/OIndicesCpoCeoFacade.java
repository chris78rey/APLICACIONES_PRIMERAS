/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;


import he1.odonto.entities.OIndicesCpoCeo;
import he1.odonto.entities.OOdontograma;
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
public class OIndicesCpoCeoFacade extends AbstractFacade<OIndicesCpoCeo> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OIndicesCpoCeoFacade() {
        super(OIndicesCpoCeo.class);
    }

    public OIndicesCpoCeo findByHcFecha(String cadena) {
        Query query = em.createNativeQuery(cadena, OIndicesCpoCeo.class);
        List<OIndicesCpoCeo> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return (OIndicesCpoCeo) result.get(0);

    }
    
    public List<OIndicesCpoCeo> listIndCpoCeo(Pacientes paciente) {
        StringBuilder sb = new StringBuilder("select object(o) from OIndicesCpoCeo as o");
        sb.append(" where o.oOdontograma.pacientes = :pacientes");
        sb.append(" ORDER BY o.iccFecha DESC");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", paciente);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }
    
    public OIndicesCpoCeo findIndice(OOdontograma odonto){
        Query q;
        q = em.createQuery("SELECT object(o) from OIndicesCpoCeo o WHERE  o.oOdontograma = :odonto");
        q.setParameter("odonto", odonto);
        List o = q.setHint("eclipselink.refresh", true).getResultList();
        if (o.isEmpty()) {
            return null;
        } else {
        }
        return (OIndicesCpoCeo) o.get(0);
    }
    
    
}
