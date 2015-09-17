/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;


import he1.odonto.sessions.AbstractFacade;
import he1.sis.entities.HojasDeEvolucion;
import he1.sis.entities.Pacientes;
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
public class HojasDeEvolucionFacade extends AbstractFacade<HojasDeEvolucion> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HojasDeEvolucionFacade() {
        super(HojasDeEvolucion.class);
    }

    public List<HojasDeEvolucion> listHojaEvoByHc(Pacientes paciente) {
        StringBuilder sb = new StringBuilder("SELECT object(o) FROM HojasDeEvolucion as o");
        sb.append(" WHERE o.pacientes = :pacientes");
        sb.append(" AND o.motivos.codigo in ('NO','NC','NH','NP','NY','NX','NT','ND')");
        sb.append(" ORDER BY o.fecha DESC");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", paciente);
        q.setHint("eclipselink.refresh", true);
        //System.out.println("q "+q);
        return q.getResultList();
    }
    
    public HojasDeEvolucion findByNumero(BigDecimal numero){
        Query q = em.createQuery("select object(o) FROM HojasDeEvolucion as o WHERE o.numero = :numero");
        q.setParameter("numero", numero);
        List<HojasDeEvolucion> l = q.getResultList();
        if (!l.isEmpty()) {
            return (HojasDeEvolucion) l.get(0);
        } else {
            return null;
        }
    }
//    public List<HojasDeEvolucion> listHojaEvoByHc(Pacientes paciente, Motivos motivo){
//         StringBuilder sb = new StringBuilder("SELECT object(o) FROM HojasDeEvolucion as o");
//        sb.append(" WHERE o.pacientes = :pacientes");
//        sb.append(" AND o.motivos = :motivos");
//        sb.append(" ORDER BY o.fecha DESC");
//        Query q = em.createQuery(sb.toString());
//        q.setParameter("pacientes", paciente);
//        q.setParameter("motivos", motivo);
//        q.setHint("eclipselink.refresh", true);
//        //System.out.println("q "+q);
//        return q.getResultList();
//    }

    public HojasDeEvolucion findByHcFecha(String cadena) {
        Query query = em.createNativeQuery(cadena, HojasDeEvolucion.class);
        List<HojasDeEvolucion> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return (HojasDeEvolucion) result.get(0);

    }
}
