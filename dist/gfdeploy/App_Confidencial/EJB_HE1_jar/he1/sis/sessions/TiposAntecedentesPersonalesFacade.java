/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;


import he1.odonto.sessions.AbstractFacade;
import he1.sis.entities.TiposAntecedentesPersonales;
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
public class TiposAntecedentesPersonalesFacade extends AbstractFacade<TiposAntecedentesPersonales> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposAntecedentesPersonalesFacade() {
        super(TiposAntecedentesPersonales.class);
    }

    public List<TiposAntecedentesPersonales> listByOdontoPerson() {
        StringBuilder sb = new StringBuilder("select object(o) from TiposAntecedentesPersonales as o");
        sb.append(" WHERE o.id IN (5,6,14,18,17,25) ORDER BY o.descripcion");
        Query q = em.createQuery(sb.toString());
        //System.out.println("q "+q);
        return q.getResultList();
    }
}
