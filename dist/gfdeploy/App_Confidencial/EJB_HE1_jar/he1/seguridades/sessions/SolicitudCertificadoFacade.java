/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.sessions;

import he1.seguridades.entities.nuevos.PersonalNomina;
import he1.seguridades.entities.nuevos.SolicitudCertificado;
import he1.seguridades.entities.nuevos.SolicitudCertificado_;
import he1.seguridades.entities.nuevos.TipoSolicitud;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author christian_ruiz
 */
@Stateless
public class SolicitudCertificadoFacade extends AbstractFacade<SolicitudCertificado> {

    @EJB
    private TipoSolicitudFacade tipoSolicitudFacade;

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudCertificadoFacade() {
        super(SolicitudCertificado.class);
    }

    public List<SolicitudCertificado> findSolicitudes(PersonalNomina pParSolicitudes) {
        TipoSolicitud tipoSolicitud = new TipoSolicitud();

        tipoSolicitud = tipoSolicitudFacade.find(new BigDecimal("1"));

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SolicitudCertificado> cq = cb.createQuery(SolicitudCertificado.class);
        Root<SolicitudCertificado> root = cq.from(SolicitudCertificado.class);
        List<Predicate> predicatesAND = new ArrayList<Predicate>();
        cq.where(cb.equal(root.get(SolicitudCertificado_.personalNomina), pParSolicitudes));

        predicatesAND.add(cb.equal(root.get(SolicitudCertificado_.personalNomina), pParSolicitudes));
        predicatesAND.add(cb.equal(root.get(SolicitudCertificado_.tipoSolicitud), tipoSolicitud));
        cq.where(cb.and(predicatesAND.toArray(new Predicate[predicatesAND.size()])));

        cq.orderBy(cb.desc(root.get(SolicitudCertificado_.slcFechaSolicitud)));
        List resultList = em.createQuery(cq).getResultList();
        return resultList;
    }

    public List<SolicitudCertificado> findSolicitudes2(PersonalNomina pParSolicitudes) {
        TipoSolicitud tipoSolicitud = new TipoSolicitud();

        tipoSolicitud = tipoSolicitudFacade.find(new BigDecimal("2"));

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SolicitudCertificado> cq = cb.createQuery(SolicitudCertificado.class);
        Root<SolicitudCertificado> root = cq.from(SolicitudCertificado.class);
        List<Predicate> predicatesAND = new ArrayList<Predicate>();
        cq.where(cb.equal(root.get(SolicitudCertificado_.personalNomina), pParSolicitudes));

        predicatesAND.add(cb.equal(root.get(SolicitudCertificado_.personalNomina), pParSolicitudes));
        predicatesAND.add(cb.equal(root.get(SolicitudCertificado_.tipoSolicitud), tipoSolicitud));
        cq.where(cb.and(predicatesAND.toArray(new Predicate[predicatesAND.size()])));

        cq.orderBy(cb.desc(root.get(SolicitudCertificado_.slcFechaSolicitud)));
        List resultList = em.createQuery(cq).getResultList();
        return resultList;
    }

    public List<SolicitudCertificado> findSolicitudes3(PersonalNomina pParSolicitudes) {
        TipoSolicitud tipoSolicitud = new TipoSolicitud();

        tipoSolicitud = tipoSolicitudFacade.find(new BigDecimal("3"));

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SolicitudCertificado> cq = cb.createQuery(SolicitudCertificado.class);
        Root<SolicitudCertificado> root = cq.from(SolicitudCertificado.class);
        List<Predicate> predicatesAND = new ArrayList<Predicate>();
        cq.where(cb.equal(root.get(SolicitudCertificado_.personalNomina), pParSolicitudes));

        predicatesAND.add(cb.equal(root.get(SolicitudCertificado_.personalNomina), pParSolicitudes));
        predicatesAND.add(cb.equal(root.get(SolicitudCertificado_.tipoSolicitud), tipoSolicitud));
        cq.where(cb.and(predicatesAND.toArray(new Predicate[predicatesAND.size()])));

        cq.orderBy(cb.desc(root.get(SolicitudCertificado_.slcFechaSolicitud)));
        List resultList = em.createQuery(cq).getResultList();
        return resultList;
    }

}
