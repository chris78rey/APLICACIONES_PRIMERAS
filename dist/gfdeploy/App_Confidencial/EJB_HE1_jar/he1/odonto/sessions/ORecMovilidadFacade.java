/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;



import he1.odonto.entities.OOdontograma;
import he1.odonto.entities.ORecMovilidad;
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
public class ORecMovilidadFacade extends AbstractFacade<ORecMovilidad> {
    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ORecMovilidadFacade() {
        super(ORecMovilidad.class);
    }
    
    public List<ORecMovilidad> listMovilidad(OOdontograma odonto){
        StringBuilder sb = new StringBuilder("select object(o) from ORecMovilidad as o");
        sb.append(" where o.oOdontograma = :odonto");
        Query q = em.createQuery(sb.toString());
        q.setParameter("odonto", odonto);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }
    
    public ORecMovilidad findRecMov(OOdontograma odonto){
        Query q;
        q = em.createQuery("SELECT object(o) from ORecMovilidad o WHERE  o.oOdontograma = :odonto");
        q.setParameter("odonto", odonto);
        List o = q.setHint("eclipselink.refresh", true).getResultList();
        if (o.isEmpty()) {
            return null;
        } else {
        }
        return (ORecMovilidad) o.get(0);
    }
}
