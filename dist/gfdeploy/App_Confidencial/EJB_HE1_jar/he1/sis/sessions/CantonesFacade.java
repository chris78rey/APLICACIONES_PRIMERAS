/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;

import he1.sis.entities.Cantones;
import he1.sis.entities.Cantones_;
import he1.sis.entities.Provincias;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author christian_ruiz
 */
@Stateless
public class CantonesFacade extends AbstractFacade<Cantones> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CantonesFacade() {
        super(Cantones.class);
    }

    public List<Cantones> findByProvincia(Provincias p) {
        System.out.println("p findByProvincia = " + p);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cantones> cq = cb.createQuery(Cantones.class);
        Root<Cantones> root = cq.from(Cantones.class);
        List<Predicate> predicatesOR = new ArrayList<Predicate>();
        cq.where(cb.equal(root.get(Cantones_.provincias), p));
        cq.orderBy(cb.asc(root.get(Cantones_.canton)));
        List resultList = em.createQuery(cq).getResultList();
        return resultList;
    }

}
