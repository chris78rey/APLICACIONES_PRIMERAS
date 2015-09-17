/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;

import he1.sis.entities.Cantones;
import he1.sis.entities.Parroquias;
import he1.sis.entities.Parroquias_;
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
public class ParroquiasFacade extends AbstractFacade<Parroquias> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParroquiasFacade() {
        super(Parroquias.class);
    }

    public List<Map> findProvCantParroq(String pprovincia, String pcanton, String pparroq) {
        String sql
                = "     SELECT PARROQUIAS.CNT_PRV_CODIGO,"
                + "            PARROQUIAS.CNT_CODIGO,"
                + "            PARROQUIAS.CODIGO,"
                + "            PROVINCIAS.PROVINCIA,"
                + "            CANTONES.CANTON,"
                + "            PARROQUIAS.PARROQUIA"
                + "       FROM SIS.PROVINCIAS, SIS.CANTONES, SIS.PARROQUIAS"
                + "      WHERE     PROVINCIAS.PROVINCIA = '" + pprovincia + "'"
                + "            AND CANTONES.CANTON = '" + pcanton + "'"
                + "            AND PARROQUIAS.PARROQUIA ="
                + "                   '" + pparroq + "'"
                + "            AND PROVINCIAS.CODIGO = CANTONES.PRV_CODIGO"
                + "            AND CANTONES.PRV_CODIGO = PARROQUIAS.CNT_PRV_CODIGO"
                + "            AND CANTONES.CODIGO = PARROQUIAS.CNT_CODIGO"
                + "            AND ROWNUM = 1"
                + "   ORDER BY PROVINCIAS.PROVINCIA, CANTONES.CANTON, PARROQUIAS.PARROQUIA";

        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("CNT_PRV_CODIGO", result[0]);
                resultMap.put("CNT_CODIGO", result[1]);
                resultMap.put("CODIGO", result[2]);
                resultMap.put("PROVINCIA", result[3]);
                resultMap.put("CANTON", result[4]);
                resultMap.put("PARROQUIA", result[5]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public List<Parroquias> findParrporCanton(Cantones pcant) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Parroquias> cq = cb.createQuery(Parroquias.class);
        Root<Parroquias> root = cq.from(Parroquias.class);
        cq.where(cb.equal(root.get(Parroquias_.cantones), pcant));
        cq.orderBy(cb.asc(root.get(Parroquias_.parroquia)));
        List resultList = em.createQuery(cq).getResultList();
        return resultList;
    }

}
