/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;


import he1.odonto.entities.OInforInicial;
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
public class OInforInicialFacade extends AbstractFacade<OInforInicial> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OInforInicialFacade() {
        super(OInforInicial.class);
    }

    public List<OInforInicial> listInfoInicial(Pacientes paciente) {
        StringBuilder sb = new StringBuilder("select object(o) from OInforInicial as o");
        sb.append(" where o.pacientes = :pacientes");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", paciente);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }
    
    public OInforInicial findByHojaEvl(HojasDeEvolucion hjaEvl){
         Query q = em.createQuery("select object(o) FROM OInforInicial o WHERE o.hojasDeEvolucion = :hjaEvl");
        q.setParameter("hjaEvl", hjaEvl);
        q.setHint("eclipselink.refresh", true);
        List<OInforInicial> l = q.getResultList();
        if (!l.isEmpty()) {
            return (OInforInicial) l.get(0);
        } else {
            return null;
        }
    }
}
