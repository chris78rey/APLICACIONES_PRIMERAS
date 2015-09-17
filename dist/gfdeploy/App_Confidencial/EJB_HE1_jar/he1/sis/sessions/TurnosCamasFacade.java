/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;

import he1.sis.entities.TurnosCamas;
import java.util.Date;
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
public class TurnosCamasFacade extends AbstractFacade<TurnosCamas> {
    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TurnosCamasFacade() {
        super(TurnosCamas.class);
    }
    
//    public List<TurnosCamas> listByFecha(String fecha) {
//        Query query;
//        query = em.createNativeQuery("SELECT * FROM TURNOS_CAMAS,CAMAS_HOSPITALIZACION WHERE SALA = CMAHSP_SALA AND CAMA = CMAHSP_CAMA AND SERVICIO = 'UCI' AND FECHA = TO_DATE (?, 'DD-MM-YYYY')").setParameter(1, fecha);
//        List<TurnosCamas> result = query.getResultList();
//        if (result.isEmpty()) {
//            return null;
//        }
//        return result;
//
//    }
    public List<TurnosCamas> ListByFecha(Date fecha){
        Query q = em.createQuery("SELECT object(o) FROM TurnosCamas o WHERE o.camasHospitalizacion.servicio = 'UCI' AND o.turnosCamasPK.fecha = :fecha ORDER BY o.turnosCamasPK.fecha DESC,o.turnosCamasPK.cmahspSala, o.turnosCamasPK.cmahspCama").setParameter("fecha", fecha);
        return q.getResultList();
    }
}
