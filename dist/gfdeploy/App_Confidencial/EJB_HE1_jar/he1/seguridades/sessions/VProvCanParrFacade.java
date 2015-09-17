/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.sessions;

import he1.seguridades.entities.nuevos.VProvCanParr;
import he1.seguridades.entities.nuevos.VProvCanParr_;
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
public class VProvCanParrFacade extends AbstractFacade<VProvCanParr> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VProvCanParrFacade() {
        super(VProvCanParr.class);
    }

    public List<VProvCanParr> findVProvCanParrOrderProvincia() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<VProvCanParr> cq = cb.createQuery(VProvCanParr.class);
        Root<VProvCanParr> root = cq.from(VProvCanParr.class);

        cq.orderBy(cb.asc(root.get(VProvCanParr_.provincia)));
        List resultList = em.createQuery(cq).getResultList();
        return resultList;
    }
//SELECT distinct  v.provinciasCodigo,v.provincia FROM VProvCanParr v order by v.provincia

    public List<VProvCanParr> findVProvCanParrOrderProvin() {

        List resultList = em.createQuery(
                "SELECT distinct v FROM VProvCanParr v order by v.provincia").getResultList();
        return resultList;

    }

}
