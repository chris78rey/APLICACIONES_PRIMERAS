/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.sessions;

import he1.seguridades.entities.SegUrls;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luis_guanoluiza
 */
@Stateless
public class SegUrlsFacade extends AbstractFacade<SegUrls> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegUrlsFacade() {
        super(SegUrls.class);
    }

    public SegUrls findBySalir(String name) {
        SegUrls singleResult = (SegUrls) em.createQuery(
                "SELECT s FROM SegUrls s WHERE s.urlDescrip = :urlDescrip")
                .setParameter("urlDescrip", name).setHint("eclipselink.refresh", "true").getSingleResult();
        return singleResult;
    }

    public SegUrls findURL(String name) {
        SegUrls singleResult = (SegUrls) em.createQuery(
                "SELECT s FROM SegUrls s WHERE s.urlDescrip = :urlDescrip")
                .setParameter("urlDescrip", name).setHint("eclipselink.refresh", "true").getSingleResult();
        return singleResult;
    }

}
