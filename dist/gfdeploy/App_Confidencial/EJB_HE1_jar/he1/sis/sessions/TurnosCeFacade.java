/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;


import he1.odonto.sessions.AbstractFacade;
import he1.sis.entities.TurnosCe;
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
public class TurnosCeFacade extends AbstractFacade<TurnosCe> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TurnosCeFacade() {
        super(TurnosCe.class);
    }

    public TurnosCe findByHcFecha(Integer hc) {
        Query q = em.createQuery("select object(o) FROM TurnosCe as o WHERE o.pacientes.numeroHc = :hc AND o.personal1.codigo = 'M648'");
        q.setParameter("hc", hc);
        q.setHint("eclipselink.refresh", true);
        List<TurnosCe> l = q.getResultList();
        if (!l.isEmpty()) {
            return (TurnosCe) l.get(0);
        } else {
            return null;
        }
    }
    
    public TurnosCe findByHcFechaTurno(Integer hc,String fecha){
        List<TurnosCe> lTurnos = em.createNativeQuery("SELECT * FROM TURNOS_CE WHERE PCN_NUMERO_HC = ? AND trunc(FECHA) = TO_DATE(?,'dd/mm/yyyy')", TurnosCe.class).setParameter(1, hc).setParameter(2, fecha).setHint("eclipselink.refresh", true).getResultList();
        if (lTurnos.size() == 1) {
            return lTurnos.get(0);
        } else {
            return null;
        }
    }
}
