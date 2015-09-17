/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;


import he1.odonto.entities.OSistemaEstomatognico;
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
public class OSistemaEstomatognicoFacade extends AbstractFacade<OSistemaEstomatognico> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OSistemaEstomatognicoFacade() {
        super(OSistemaEstomatognico.class);
    }

    public List<OSistemaEstomatognico> listByFecha(Pacientes paciente) {
        StringBuilder sb = new StringBuilder("select object(u) from OSistemaEstomatognico as u ");
        sb.append(" where u.pacientes = :pacientes");
        sb.append(" order by u.sieFecha desc, u.oPatologias.patId ");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", paciente);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }

    public BigDecimal patologiaExiste(String existe) {
        return (BigDecimal) em.createNativeQuery(existe).getSingleResult();
    }
    public boolean findPatologia(String existe) {
        BigDecimal count;
        count = (BigDecimal) em.createNativeQuery(existe).getSingleResult();
        if (count.longValue()== 0) {
            return false;
        } else {
            return true;
        }
        //return (BigDecimal) em.createNativeQuery(existe).getSingleResult();
    }

    public List<OSistemaEstomatognico> findByHcFecha(String cadena) {
        Query query = em.createNativeQuery(cadena, OSistemaEstomatognico.class);
        List<OSistemaEstomatognico> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return result;

    }
    
    public List<OSistemaEstomatognico>  findByHojaEvl(HojasDeEvolucion hjaEvl) {
        Query q = em.createQuery("select object(o) FROM OSistemaEstomatognico o WHERE o.hojasDeEvolucion = :hjaEvl");
        q.setParameter("hjaEvl", hjaEvl);
        q.setHint("eclipselink.refresh", true);
        List<OSistemaEstomatognico> result = q.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }
}
