/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;


import he1.odonto.sessions.AbstractFacade;
import he1.sis.entities.Enfermedades;
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
public class EnfermedadesFacade extends AbstractFacade<Enfermedades> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnfermedadesFacade() {
        super(Enfermedades.class);
    }

    public List<Enfermedades> itemsEnfermOdonto() {
        String sb = "select object(o) from Enfermedades as o WHERE o.codigo like 'K0%' ORDER BY o.codigo ASC";
        Query q = em.createQuery(sb);
        return q.getResultList();
    }

    public List<Enfermedades> enfermByTipoAntc(String tipo) {
        StringBuilder sb = new StringBuilder("SELECT object(o) FROM Enfermedades as o");
        sb.append(" WHERE o.enfermedad LIKE :tipo");
        Query q = em.createQuery(sb.toString());
        q.setParameter("tipo", tipo);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }
}
