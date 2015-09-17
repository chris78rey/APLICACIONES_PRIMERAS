/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.odonto.sessions;


import he1.odonto.entities.OOdontograma;
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
public class OOdontogramaFacade extends AbstractFacade<OOdontograma> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OOdontogramaFacade() {
        super(OOdontograma.class);
    }

    public List<OOdontograma> listOdontogramas(Pacientes paciente) {
        StringBuilder sb = new StringBuilder("select object(o) from OOdontograma as o");
        sb.append(" where o.pacientes = :pacientes");
        sb.append(" ORDER BY o.odoFecha DESC");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", paciente);
        q.setHint("eclipselink.refresh", true);
        //System.out.println("q "+q);
        return q.getResultList();

    }

    public OOdontograma findByHcFecha(String cadena) {
        Query query = em.createNativeQuery(cadena, OOdontograma.class);
        List<OOdontograma> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return (OOdontograma) result.get(0);

    }

    //select max(o.odoId) from OOdontograma o where o.pacientes.numeroHc = 468821
    public BigDecimal maxOdoId(Pacientes paciente) {
        return (BigDecimal) em.createQuery("select max(o.odoId) from OOdontograma o where o.pacientes = :pacientes").setParameter("pacientes", paciente).setHint("eclipselink.refresh", true).getSingleResult();
    }

    public String infPiezaDental(String campo, OOdontograma odontoId){
        return (String) em.createNativeQuery("SELECT "+campo+" FROM O_ODONTOGRAMA WHERE ODO_ID = ?").setParameter(1, odontoId.getOdoId()).getSingleResult();
    }
    
    public List<OOdontograma> listAll(){
        StringBuilder sb = new StringBuilder("select object(o) from OOdontograma as o ORDER BY o.odoFecha DESC");
        Query q = em.createQuery(sb.toString());
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }
}
