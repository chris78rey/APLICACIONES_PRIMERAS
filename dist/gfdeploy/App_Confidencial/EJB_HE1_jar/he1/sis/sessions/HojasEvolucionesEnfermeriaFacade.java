/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;

import he1.sis.entities.HojasEvolucionesEnfermeria;
import he1.sis.entities.Pacientes;
import he1.sis.entities.PermanenciasYAtenciones;
import he1.sis.entities.TurnosCamas;
import java.math.BigDecimal;
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
public class HojasEvolucionesEnfermeriaFacade extends AbstractFacade<HojasEvolucionesEnfermeria> {
    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HojasEvolucionesEnfermeriaFacade() {
        super(HojasEvolucionesEnfermeria.class);
    }
    
    public List<HojasEvolucionesEnfermeria> listHjasEvlEnferm(Pacientes pacientes) {
        StringBuilder sb = new StringBuilder("select object(o) from HojasEvolucionesEnfermeria as o");
        sb.append(" where o.permanenciasYAtenciones.pacientes = :pacientes ORDER BY o.hojasEvolucionesEnfermeriaPK.fecha DESC");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", pacientes);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }
    
    public String findRegistradoTurno(TurnosCamas nroPerm, String nroTurno) {
        BigDecimal cont;
        cont = (BigDecimal) em.createNativeQuery("SELECT COUNT(*) FROM SIS.HOJAS_EVOLUCIONES_ENFERMERIA WHERE PRMATN_NUMERO = ? AND TURNO = ? AND trunc(FECHA) = trunc(sysdate)").setParameter(1,nroPerm.getTurnosCamasPK().getPrmNumero()).setParameter(2, nroTurno).getSingleResult();
        if (cont.equals(BigDecimal.ZERO)) {
            return "0";
        } else {
            return "1";
        }
    }
}
