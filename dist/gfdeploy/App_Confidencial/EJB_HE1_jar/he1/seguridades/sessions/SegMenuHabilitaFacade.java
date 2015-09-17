/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.sessions;

import he1.seguridades.entities.SegMenuHabilita;
import he1.seguridades.entities.SegMenuHabilita_;
import he1.seguridades.entities.SegPerfil;
import he1.sis.entities.Personal;
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
 * @author luis_guanoluiza
 */
@Stateless
public class SegMenuHabilitaFacade extends AbstractFacade<SegMenuHabilita> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegMenuHabilitaFacade() {
        super(SegMenuHabilita.class);
    }

    /**
     *
     * @param par
     * @return
     */
    public List<SegMenuHabilita> findHabilitados(SegPerfil par) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegMenuHabilita> cq = cb.createQuery(SegMenuHabilita.class);
        Root<SegMenuHabilita> root;
        root = cq.from(SegMenuHabilita.class);
        List<Predicate> predicatesAND = new ArrayList<Predicate>();
        predicatesAND.add(cb.equal(root.get(SegMenuHabilita_.segPerfil), par));
        cq.where(cb.or(predicatesAND.toArray(new Predicate[predicatesAND.size()])));
        List resultList = em.createQuery(cq).setMaxResults(20).getResultList();        
        return resultList;
    }

}
