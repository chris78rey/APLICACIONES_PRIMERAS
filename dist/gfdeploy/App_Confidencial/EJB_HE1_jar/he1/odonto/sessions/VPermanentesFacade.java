/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;


import he1.odonto.entities.VPermanentes;
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
public class VPermanentesFacade extends AbstractFacade<VPermanentes> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VPermanentesFacade() {
        super(VPermanentes.class);
    }

    public Long countIndicePermanente(BigDecimal odoId, String tipo) {
//        return (Long)em.createQuery("SELECT count(o) FROM VPermanentes o WHERE o.odoId = :odoId AND o.tipo = :tipo").setParameter("odoId",odoId).setParameter("tipo",tipo).setHint("eclipselink.refresh", true).getSingleResult();
        StringBuilder sb = new StringBuilder("select count(o.odoId) from VPermanentes as o");
        sb.append(" WHERE o.odoId = :odoIdd");
        sb.append(" AND o.tipo = :tipod");
        Query q = em.createQuery(sb.toString());
        q.setParameter("odoIdd", odoId);
        q.setParameter("tipod", tipo);
        q.setHint("eclipselink.refresh", true);
        Long count = (Long) q.getSingleResult();
        return count;
    }
}
