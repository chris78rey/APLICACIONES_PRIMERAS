/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;


import he1.odonto.sessions.AbstractFacade;
import he1.sis.entities.TiposAntecedentesFamiliares;
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
public class TiposAntecedentesFamiliaresFacade extends AbstractFacade<TiposAntecedentesFamiliares> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposAntecedentesFamiliaresFacade() {
        super(TiposAntecedentesFamiliares.class);
    }

    public List<TiposAntecedentesFamiliares> listByOdontoFam() {
        StringBuilder sb = new StringBuilder("select object(o) from TiposAntecedentesFamiliares as o");
        sb.append(" WHERE o.id IN (2,4,6,7,9,30)");
        Query q = em.createQuery(sb.toString());
        //System.out.println("q "+q);
        return q.getResultList();
    }
}
