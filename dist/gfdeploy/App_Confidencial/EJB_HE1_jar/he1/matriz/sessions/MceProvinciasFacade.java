/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.matriz.sessions;

import he1.matriz.entities.MceProvincias;
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
public class MceProvinciasFacade extends AbstractFacade<MceProvincias> {
    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MceProvinciasFacade() {
        super(MceProvincias.class);
    }
     public List<MceProvincias> itemsProvincias() {
        StringBuilder sb = new StringBuilder("SELECT object(o) FROM MceProvincias o ORDER BY o.provincia");
        Query q = em.createQuery(sb.toString());
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }
}
