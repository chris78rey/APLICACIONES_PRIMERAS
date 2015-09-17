/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.uci.sessions;


import he1.uci.entities.UOpciones;
import he1.uci.entities.UUciMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class UOpcionesFacade extends AbstractFacade<UOpciones> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UOpcionesFacade() {
        super(UOpciones.class);
    }

    public List<UOpciones> listOpcXMenu(UUciMenu uci, String tipo) {
        StringBuilder sb = new StringBuilder("SELECT object(o) FROM UOpciones o ");
        //sb.append(" WHERE o.uUciMenu = :uci AND o.opcEstado = :tipo ORDER BY o.opcDescripcion");
        sb.append(" WHERE o.uUciMenu = :uci AND o.opcEstado = :tipo ORDER BY o.opcOrdinal");
        
        Query q = em.createQuery(sb.toString());
        q.setParameter("uci", uci);
        q.setParameter("tipo", tipo);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }

    public BigInteger ordinalOpc(UUciMenu uci) {
        return (BigInteger) em.createQuery("select max(o.opcOrdinal) from UOpciones o WHERE o.uUciMenu = :uci").setParameter("uci", uci).setHint("eclipselink.refresh", true).getSingleResult();
    }

    public BigDecimal maxOpciones(UUciMenu uci) {
        return (BigDecimal) em.createQuery("select max(o.opcId) from UOpciones o WHERE o.uUciMenu = :uci").setParameter("uci", uci).setHint("eclipselink.refresh", true).getSingleResult();
    }
    
    public String findOpcRegistrado(UUciMenu uci, String nom) {
        Long cont;
        cont = (Long) em.createQuery("SELECT count(u) FROM UOpciones u WHERE u.uUciMenu = :uci AND u.opcDescripcion = :opcDescripcion").setParameter("uci",uci).setParameter("opcDescripcion",nom).getSingleResult();
        if (cont==0) {
            return "0";
        } else {
            return "1";
        }
    }
    
}
