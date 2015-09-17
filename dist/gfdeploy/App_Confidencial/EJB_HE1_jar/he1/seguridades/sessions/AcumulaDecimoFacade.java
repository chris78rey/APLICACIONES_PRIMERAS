/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.sessions;

import he1.seguridades.entities.SegPerfil;
import he1.seguridades.entities.nuevos.AcumulaDecimo;
import he1.seguridades.entities.nuevos.AcumulaDecimo_;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author christian_ruiz
 */
@Stateless
public class AcumulaDecimoFacade extends AbstractFacade<AcumulaDecimo> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcumulaDecimoFacade() {
        super(AcumulaDecimo.class);
    }

    public List<AcumulaDecimo> findBuscaPorIdAcumula(String prnIdPersonal, BigInteger anio) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AcumulaDecimo> cq = cb.createQuery(AcumulaDecimo.class);
        Root<AcumulaDecimo> root = cq.from(AcumulaDecimo.class);
        List<Predicate> predicatesAND = new ArrayList<Predicate>();

        predicatesAND.add(cb.equal(root.get(AcumulaDecimo_.prnIdPersonal), prnIdPersonal));
        predicatesAND.add(cb.equal(root.get(AcumulaDecimo_.anio), anio));
        cq.where(cb.and(predicatesAND.toArray(new Predicate[predicatesAND.size()])));
        cq.orderBy(cb.desc(root.get(AcumulaDecimo_.tipo)));
        List resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();

        return resultList;
    }

    public void p_cambia_estado_decimos(String user, String dt, String dc, String anio) {
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("p_cambia_estado_decimos");
        // set parameters
        storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        storedProcedure.setParameter(1, user);
        storedProcedure.setParameter(2, dt);
        storedProcedure.setParameter(3, dc);
        storedProcedure.setParameter(4, anio);

        // execute SP
        storedProcedure.execute();

    }

}
