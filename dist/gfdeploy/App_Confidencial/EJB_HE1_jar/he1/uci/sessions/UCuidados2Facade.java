/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.uci.sessions;


import he1.uci.entities.UCuidados2;
import he1.uci.entities.UOpcionPaciente;
import he1.uci.entities.UUciMenu;
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
public class UCuidados2Facade extends AbstractFacade<UCuidados2> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UCuidados2Facade() {
        super(UCuidados2.class);
    }

    public List<UCuidados2> listCuidados2(UOpcionPaciente opcPaciente, UUciMenu uciMenu) {
        StringBuilder sb = new StringBuilder("select object(o) from UCuidados2 o");
        sb.append(" where o.uOpcionPaciente = :opcPaciente AND O.uOpciones.uUciMenu = :uciMenu ORDER BY o.uOpciones.opcOrdinal");
        Query q = em.createQuery(sb.toString());
        q.setParameter("opcPaciente", opcPaciente);
        q.setParameter("uciMenu", uciMenu);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }
    
     public UCuidados2 cuidados2(UCuidados2 idCuid) {
        Query q = em.createQuery("select object(o) from UCuidados2 o WHERE o.cu2Id = :cu2Id");
        q.setParameter("cu2Id", idCuid.getCu2Id());
        q.setHint("eclipselink.refresh", true);
        List<UCuidados2> l = q.getResultList();
        if (!l.isEmpty()) {
            return (UCuidados2) l.get(0);
        } else {
            return null;
        }
    }
}
