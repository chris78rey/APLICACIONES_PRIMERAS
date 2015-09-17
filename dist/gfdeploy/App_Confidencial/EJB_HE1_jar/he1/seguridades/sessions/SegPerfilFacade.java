/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.sessions;

import he1.seguridades.entities.SegPerfil;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author luis_guanoluiza
 */
@Stateless
public class SegPerfilFacade extends AbstractFacade<SegPerfil> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegPerfilFacade() {
        super(SegPerfil.class);
    }

    public List<SegPerfil> findPerfilPorModulo() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegPerfil> cq = cb.createQuery(SegPerfil.class);
        Root<SegPerfil> root = cq.from(SegPerfil.class);        
        List resultList = em.createQuery(cq).setMaxResults(20).getResultList();
        return resultList;
    }

}
