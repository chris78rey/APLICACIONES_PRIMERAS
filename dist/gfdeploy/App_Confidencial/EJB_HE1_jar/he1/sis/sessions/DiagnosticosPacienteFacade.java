/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;


import he1.odonto.sessions.AbstractFacade;
import he1.sis.entities.DiagnosticosPaciente;
import he1.sis.entities.Pacientes;
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
public class DiagnosticosPacienteFacade extends AbstractFacade<DiagnosticosPaciente> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiagnosticosPacienteFacade() {
        super(DiagnosticosPaciente.class);
    }

    public List<DiagnosticosPaciente> listDiagnosticoPacientes(Pacientes paciente) {
        StringBuilder sb = new StringBuilder("select object(o) from DiagnosticosPaciente as o");
        sb.append(" where o.pacientes = :pacientes");
        sb.append(" and o.enfermedades.codigo between 'K00' and 'K14.9'");
        sb.append(" order by o.fechaInicio desc");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", paciente);
        q.setHint("eclipselink.refresh", true);
        //System.out.println("q "+q);
        return q.getResultList();
    }

    public Long maxDiagId() {
        return em.createQuery("select max(o.dgnpcnId) from DiagnosticosPaciente as o", long.class).setHint("eclipselink.refresh", true).getSingleResult();
    }
    
    public List<DiagnosticosPaciente> findByHcFecha(String cadena) {
        Query query = em.createNativeQuery(cadena, DiagnosticosPaciente.class);
        List<DiagnosticosPaciente> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return result;

    }
}
