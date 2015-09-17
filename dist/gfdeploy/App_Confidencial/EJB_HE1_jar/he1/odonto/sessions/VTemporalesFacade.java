/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;


import he1.odonto.entities.VTemporales;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author luis_guanoluiza
 */
@Stateless
public class VTemporalesFacade extends AbstractFacade<VTemporales> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VTemporalesFacade() {
        super(VTemporales.class);
    }

    public Long countIndiceTemporal(BigDecimal odoId, String tipo) {
//        return em.createQuery("SELECT count(o) FROM VTemporales o WHERE o.odoId = :odoId AND o.tipo = :tipo",long.class).setParameter("odoId",odoId).setParameter("tipo",tipo).setHint("eclipselink.refresh", true).getSingleResult();
        StringBuilder sb = new StringBuilder("select count(o.odoId) from VTemporales as o");
        sb.append(" WHERE o.odoId = :odoId");
        sb.append(" AND o.tipo = :tipo");
        Query q = em.createQuery(sb.toString());
        q.setParameter("odoId", odoId);
        q.setParameter("tipo", tipo);
        q.setHint("eclipselink.refresh", true);
        Long count = (Long) q.getSingleResult();
        return count;
    }
}
