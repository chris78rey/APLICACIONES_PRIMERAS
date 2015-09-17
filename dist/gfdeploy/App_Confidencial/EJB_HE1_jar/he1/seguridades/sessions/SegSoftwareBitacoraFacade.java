/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.sessions;

import he1.seguridades.entities.nuevos.SegSoftwareBitacora;
import he1.seguridades.entities.nuevos.SegSoftwareBitacora_;
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
public class SegSoftwareBitacoraFacade extends AbstractFacade<SegSoftwareBitacora> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegSoftwareBitacoraFacade() {
        super(SegSoftwareBitacora.class);
    }

    public List<SegSoftwareBitacora> findAreasSistemas() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegSoftwareBitacora> cq = cb.createQuery(SegSoftwareBitacora.class);
        Root<SegSoftwareBitacora> root = cq.from(SegSoftwareBitacora.class);
        cq.orderBy(cb.asc(root.get(SegSoftwareBitacora_.modulo)));
        List resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;
    }

}
