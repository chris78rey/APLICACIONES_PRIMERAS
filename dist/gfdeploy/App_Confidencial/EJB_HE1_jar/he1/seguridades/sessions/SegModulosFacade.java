/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.sessions;

import he1.seguridades.entities.SegMenu;
import he1.seguridades.entities.SegMenu_;
import he1.seguridades.entities.SegModulos;
import he1.seguridades.entities.SegModulos_;
import java.math.BigInteger;
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
 * @author luis_guanoluiza
 */
@Stateless
public class SegModulosFacade extends AbstractFacade<SegModulos> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SegModulosFacade() {
        super(SegModulos.class);
    }

    public List<SegModulos> findModulossOrdenados() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegModulos> cq = cb.createQuery(SegModulos.class);
        Root<SegModulos> root = cq.from(SegModulos.class);
        List<Predicate> predicatesOR = new ArrayList<>();
        cq.orderBy(cb.asc(root.get(SegModulos_.modNombreModulo)));
        List resultList = em.createQuery(cq).getResultList();
        return resultList;
    }

    public List<SegMenu> findMenuBaseModulo(SegModulos par) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegMenu> cq = cb.createQuery(SegMenu.class);
        Root<SegMenu> root = cq.from(SegMenu.class);
        List<Predicate> predicatesAND = new ArrayList<Predicate>();
        predicatesAND.add(cb.equal(root.get(SegMenu_.menNivel), new BigInteger("1")));
        predicatesAND.add(cb.equal(root.get(SegMenu_.segModulos), par));
        cq.where(cb.and(predicatesAND.toArray(new Predicate[predicatesAND.size()])));
        cq.orderBy(cb.desc(root.get(SegMenu_.segMenu)), cb.asc(root.get(SegMenu_.menOrden)));
        List resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;

    }

    public List<SegMenu> findMenuBaseModuloNivel2(SegModulos par) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegMenu> cq = cb.createQuery(SegMenu.class);
        Root<SegMenu> root = cq.from(SegMenu.class);
        List<Predicate> predicatesAND = new ArrayList<Predicate>();
        predicatesAND.add(cb.equal(root.get(SegMenu_.segModulos), par));
        predicatesAND.add(cb.equal(root.get(SegMenu_.menNivel), 2));
        cq.where(cb.and(predicatesAND.toArray(new Predicate[predicatesAND.size()])));
        cq.orderBy(cb.desc(root.get(SegMenu_.segMenu)), cb.asc(root.get(SegMenu_.menOrden)));
        List resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;

    }

    public List<SegMenu> findMenuBaseModuloNivel1(SegModulos parModulo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegMenu> cq = cb.createQuery(SegMenu.class);
        Root<SegMenu> root = cq.from(SegMenu.class);
        List<Predicate> predicatesAND = new ArrayList<Predicate>();
        predicatesAND.add(cb.equal(root.get(SegMenu_.segModulos), parModulo));
        predicatesAND.add(cb.equal(root.get(SegMenu_.menNivel), new BigInteger("1")));
        cq.where(cb.and(predicatesAND.toArray(new Predicate[predicatesAND.size()])));
        List resultList = em.createQuery(cq).getResultList();
        return resultList;
    }

    public List<Map> listaMenuHabilita(String pCriterio) {
        String sql = "SELECT SEG_MODULOS.MOD_ID,"
                + "       SEG_MODULOS.MOD_NOMBRE_MODULO,"
                + "       SEG_MODULOS.MOD_FECHA_CREACION,"
                + "       SEG_MODULOS.MOD_URL,"
                + "       SEG_MODULOS.MOD_URL_SIGUIENTE,"
                + "       SEG_MODULOS.MOD_LOGO_NAME,"
                + "       SEG_MODULOS.MOD_TITULO,"
                + "       SEG_USUARIO.ID"
                + "  FROM SEGURIDADES.SEG_USUARIO,"
                + "       SEGURIDADES.SEG_USUARIO_PERFIL,"
                + "       SEGURIDADES.SEG_PERFIL,"
                + "       SEGURIDADES.SEG_MODULOS"
                + " WHERE     SEG_USUARIO.ID = " + pCriterio + " "
                + "       AND SEG_USUARIO.ID = SEG_USUARIO_PERFIL.USU_ID"
                + "       AND SEG_PERFIL.PER_ID = SEG_USUARIO_PERFIL.PER_ID"
                + "       AND SEG_MODULOS.MOD_ID = SEG_PERFIL.MOD_ID"
                + "       AND SEG_PERFIL.PER_ID = SEG_USUARIO_PERFIL.PER_ID"
                +"       order by mod_orden";
        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = getEntityManager().createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("MOD_ID", result[0]);
                resultMap.put("MOD_NOMBRE_MODULO", result[1]);
                resultMap.put("MOD_FECHA_CREACION", result[2]);
                resultMap.put("MOD_URL", result[3]);
                resultMap.put("MOD_URL_SIGUIENTE", result[4]);
                resultMap.put("MOD_LOGO_NAME", result[5]);
                resultMap.put("MOD_TITULO", result[6]);
                resultMap.put("ID", result[7]);
                data.add(resultMap);

            }
        }
        return data;

    }

}
