/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.uci.sessions;


import he1.uci.entities.UHorarioIngesta;
import he1.uci.entities.UOpcionPaciente;
import he1.uci.entities.UOpciones;
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
public class UHorarioIngestaFacade extends AbstractFacade<UHorarioIngesta> {
    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UHorarioIngestaFacade() {
        super(UHorarioIngesta.class);
    }
    
    public List<UHorarioIngesta> listHorarioIngesta(UOpcionPaciente opcPaciente, UUciMenu uciMenu) {
        StringBuilder sb = new StringBuilder("SELECT object(o) FROM UHorarioIngesta o");
        sb.append(" WHERE o.uOpcionPaciente = :opcPaciente AND O.uOpciones.uUciMenu = :uciMenu ORDER BY o.uOpciones.opcOrdinal");
        Query q = em.createQuery(sb.toString());
        q.setParameter("opcPaciente", opcPaciente);
        q.setParameter("uciMenu", uciMenu);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }
    
    
    public String findByOppOpc(UOpciones opc, UOpcionPaciente opcp) {
        Long cont;
        cont = (Long) em.createQuery("SELECT count(u) FROM UHorarioIngesta u WHERE u.uOpciones = :opciones AND u.uOpcionPaciente = :opcPac").setParameter("opciones",opc).setParameter("opcPac",opcp).getSingleResult();
        if (cont==0) {
            return "0";
        } else {
            return "1";
        }
    }
   
}
