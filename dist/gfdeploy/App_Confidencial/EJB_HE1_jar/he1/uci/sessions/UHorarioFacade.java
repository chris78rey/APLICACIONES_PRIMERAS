/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.uci.sessions;


import he1.uci.entities.UHorario;
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
public class UHorarioFacade extends AbstractFacade<UHorario> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UHorarioFacade() {
        super(UHorario.class);
    }

    public List<UHorario> listHorario(UOpcionPaciente opcPaciente, UUciMenu uciMenu, String estado) {
        StringBuilder sb = new StringBuilder("SELECT object(o) FROM UHorario o");
        sb.append(" WHERE o.uOpcionPaciente = :opcPaciente AND O.uOpciones.uUciMenu = :uciMenu AND O.uOpciones.opcEstado = :estado ORDER BY o.uOpciones.opcOrdinal");
        Query q = em.createQuery(sb.toString());
        q.setParameter("opcPaciente", opcPaciente);
        q.setParameter("uciMenu", uciMenu);
        q.setParameter("estado", estado);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }
    

    public UHorario horario(UHorario Id) {
        Query q = em.createQuery("select object(o) from UHorario o WHERE o.horId = :horId");
        q.setParameter("horId", Id.getHorId());
        q.setHint("eclipselink.refresh", true);
        List<UHorario> l = q.getResultList();
        if (!l.isEmpty()) {
            return (UHorario) l.get(0);
        } else {
            return null;
        }
    }

    public UHorario horarioActual(UOpcionPaciente opcPac) {
        Query q = em.createQuery("select object(o) from UHorario o WHERE o.uOpcionPaciente = :opcPac");
        q.setParameter("opcPac", opcPac);
        q.setHint("eclipselink.refresh", true);
        List<UHorario> l = q.getResultList();
        if (!l.isEmpty()) {
            return (UHorario) l.get(0);
        } else {
            return null;
        }
    }

}
