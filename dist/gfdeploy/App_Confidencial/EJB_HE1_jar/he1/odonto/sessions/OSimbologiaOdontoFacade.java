/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;


import he1.odonto.entities.OSimbologiaOdonto;
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
public class OSimbologiaOdontoFacade extends AbstractFacade<OSimbologiaOdonto> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OSimbologiaOdontoFacade() {
        super(OSimbologiaOdonto.class);
    }

    public List<OSimbologiaOdonto> listSimbologia() {
        String sb = "select object(o) from OSimbologiaOdonto as o WHERE o.sodParametro IN (0,1) ORDER BY o.sodDescripcion";
        Query q = em.createQuery(sb).setHint("eclipselink.refresh", true);
        return q.getResultList();
    }
}
