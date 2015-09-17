/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.sessions;

import he1.seguridades.entities.nuevos.CodigoMifinPortal;
import he1.seguridades.entities.nuevos.CodigoMifinPortal_;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author christian_ruiz
 */
@Stateless
public class CodigoMifinPortalFacade extends AbstractFacade<CodigoMifinPortal> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CodigoMifinPortalFacade() {
        super(CodigoMifinPortal.class);
    }

    public List<CodigoMifinPortal> findCodigosPersonalNomina(BigInteger idPersonal) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CodigoMifinPortal> cq = cb.createQuery(CodigoMifinPortal.class);
        Root<CodigoMifinPortal> root = cq.from(CodigoMifinPortal.class);
        cq.where(cb.equal(root.get(CodigoMifinPortal_.idPersonal), idPersonal));
        cq.orderBy(cb.desc(root.get(CodigoMifinPortal_.anio)), cb.desc(root.get(CodigoMifinPortal_.mesNumero)));
        List resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;
    }

}
