/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;

import he1.odonto.sessions.AbstractFacade;
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
public class PacientesFacade extends AbstractFacade<Pacientes> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacientesFacade() {
        super(Pacientes.class);
    }

    public BigDecimal edadPaciente(Pacientes paciente) {
        return (BigDecimal) em.createNativeQuery("SELECT trunc(months_between(sysdate, PACIENTES.FECHA_NACIMIENTO )/12) FROM PACIENTES WHERE (PACIENTES.NUMERO_HC = ?)").setParameter(1, paciente.getNumeroHc()).getSingleResult();
    }

    public Pacientes findByHc(Integer nroHc) {
        Query q = null;
        q = em.createQuery("SELECT object(o) from Pacientes o WHERE  o.numeroHc = :nroHc");
        q.setParameter("nroHc", nroHc);
        List o = q.setHint("eclipselink.refresh", true).getResultList();
        if (o.isEmpty()) {
            return null;
        }
        return (Pacientes) o.get(0);
    }

    public Pacientes findByNroCed(String nroCed) {
        Query q = null;
        q = em.createQuery("SELECT object(o) from Pacientes o WHERE  o.cedula = :nroCed");
        q.setParameter("nroCed", nroCed);
        List o = q.setHint("eclipselink.refresh", true).getResultList();
        if (o.isEmpty()) {
            return null;
        }
        return (Pacientes) o.get(0);
    }
}
