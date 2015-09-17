/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.sessions;

import he1.seguridades.entities.nuevos.SegMinisterioFinanzas;
import he1.seguridades.entities.nuevos.SegMinisterioFinanzas_;
import he1.seguridades.entities.nuevos.TipoRelacionLaboral;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author christian_ruiz
 */
@Stateless
public class SegMinisterioFinanzasFacade extends AbstractFacade<SegMinisterioFinanzas> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegMinisterioFinanzasFacade() {
        super(SegMinisterioFinanzas.class);
    }

    public List<SegMinisterioFinanzas> findPersonalCriterios() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegMinisterioFinanzas> cq = cb.createQuery(SegMinisterioFinanzas.class);
        Root<SegMinisterioFinanzas> root = cq.from(SegMinisterioFinanzas.class);
        List<Predicate> predicatesOR = new ArrayList<Predicate>();
        cq.orderBy(cb.asc(root.get(SegMinisterioFinanzas_.id)));
        List resultList = em.createQuery(cq).getResultList();
        return resultList;
    }

    public List<SegMinisterioFinanzas> findPersonalCriteriosporPersonal(TipoRelacionLaboral laboral) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<SegMinisterioFinanzas> cq = cb.createQuery(SegMinisterioFinanzas.class);
        Root<SegMinisterioFinanzas> root = cq.from(SegMinisterioFinanzas.class);
        List<Predicate> predicatesOR = new ArrayList<Predicate>();
        predicatesOR.add(cb.equal(root.get(SegMinisterioFinanzas_.tipoRelacionLaboral), laboral));
        cq.where(cb.and(predicatesOR.toArray(new Predicate[predicatesOR.size()])));
        cq.orderBy(cb.asc(root.get(SegMinisterioFinanzas_.id)));
        List resultList = em.createQuery(cq).getResultList();
        return resultList;
    }

    public List<SegMinisterioFinanzas> findOrdenados() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegMinisterioFinanzas> cq = cb.createQuery(SegMinisterioFinanzas.class);
        Root<SegMinisterioFinanzas> root = cq.from(SegMinisterioFinanzas.class);
        cq.orderBy(cb.asc(root.get(SegMinisterioFinanzas_.mfiAnio)), cb.asc(root.get(SegMinisterioFinanzas_.orden)));
        List resultList = em.createQuery(cq).setMaxResults(20).getResultList();
        return resultList;
    }

    public String BuscaAutoComplete(String codPErsoal) {

        String sql = "SELECT distinct to_char(NOMINA.TIPO_RELACION_LABORAL.TRL_IDTIPORELACION) "
                + "  FROM SIS.PERSONAL,"
                + "       NOMINA.PERSONAL PERSONAL_1,"
                + "       NOMINA.TIPO_RELACION_LABORAL,"
                + "       SEGURIDADES.SEG_MINISTERIO_FINANZAS"
                + " WHERE     PERSONAL.CODIGO = '" + codPErsoal + "'"
                + "       AND PERSONAL_1.PRN_NUMDOCUMENTO = PERSONAL.CEDULA"
                + "       AND TIPO_RELACION_LABORAL.TRL_IDTIPORELACION ="
                + "              PERSONAL_1.TRL_IDTIPORELACION"
                + "       AND TIPO_RELACION_LABORAL.TRL_IDTIPORELACION ="
                + "              SEG_MINISTERIO_FINANZAS.TRL_ID";

        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = getEntityManager().createNativeQuery(sql);

        Object results = query.getSingleResult();
        String toString = results.toString();
        return toString;
    }

}
