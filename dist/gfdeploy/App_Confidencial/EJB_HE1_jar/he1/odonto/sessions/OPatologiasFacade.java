/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;


import he1.odonto.entities.OPatologias;
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
public class OPatologiasFacade extends AbstractFacade<OPatologias> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OPatologiasFacade() {
        super(OPatologias.class);
    }

    public List<OPatologias> listPatologias() {
        String sb = "select object(o) from OPatologias as o ORDER BY o.patNumero";
        Query q = em.createQuery(sb).setHint("eclipselink.refresh", true);
        return q.getResultList();
    }
}
