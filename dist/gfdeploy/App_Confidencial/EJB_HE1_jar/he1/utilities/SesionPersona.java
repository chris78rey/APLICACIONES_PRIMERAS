/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author christian_ruiz
 */
@Stateless
@LocalBean
public class SesionPersona {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    public List<Map> buscaHistorial(String pCriterio) {

        String sql;
        sql = " SELECT TO_CHAR (FECHA,  'fmday/dd/month/yyyy',  'nls_date_language = spanish')FECHAS, "
                + "NUMERO, APELLIDOS, NOMBRES, "
                + "(CASE ESTADO WHEN 'R' THEN 'RESERVADO' WHEN "
                + "'A' THEN 'ATENDIDO' WHEN 'P' THEN 'PAGADO'  END) "
                + "ESTADO, TIPO   "
                + "FROM SIS.TURNOS_CE, "
                + "SIS.PERSONAL, SIS.PACIENTES  "
                + "WHERE TURNOS_CE.PCN_NUMERO_HC = " + pCriterio + " "
                + "AND CODIGO = TURNOS_CE.PRS_CODIGO AND "
                + "NUMERO_HC = TURNOS_CE.PCN_NUMERO_HC "
                + "AND ESTADO IN ('R', 'A', 'P') "
                + "AND TO_CHAR (FECHA, 'YYYYMMDD') "
                + "BETWEEN TO_CHAR (SYSDATE,  'YYYYMMDD') "
                + "AND TO_CHAR (SYSDATE + 20,  'YYYYMMDD')   "
                + "ORDER BY FECHA DESC";
//si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("FECHAS", result[0]);
                resultMap.put("NUMERO", result[1]);
                resultMap.put("APELLIDOS", result[2]);
                resultMap.put("NOMBRES", result[3]);
                resultMap.put("ESTADO", result[4]);
                resultMap.put("TIPO", result[5]);
                data.add(resultMap);

            }
        }

        return data;

    }

    public List<Map> listaFacturasPorHC(String pHC) {
        String sql
                = "  SELECT FACTURA_ELECTRONICA_SRI.FCT_NUMERO codigo,"
                + "         FACTURA_ELECTRONICA_SRI.FECHA_EMISION,"
                + "         FACTURA_ELECTRONICA_SRI.FCT_CAJA,"
                + "         PERSONAL.APELLIDOS || ' ' || PERSONAL.NOMBRES realizado_por,"
                + "         FACTURA_ELECTRONICA_SRI.RUC,"
                + "         estab || '-' || pto_emi || '-' || FACTURA_ELECTRONICA_SRI.SECUENCIAL"
                + "            nro_fact,"
                + "         SUM (DISTINCT FACTURA_ELECTRONICA_DTL_SRI.PRCTOT_SINIMP)"
                + "            valor_cancelado"
                + "    FROM SIS.DETALLES_FACTURA,"
                + "         SIS.CARGOS,"
                + "         SIS.FACTURAS,"
                + "         SIS.FACTURA_ELECTRONICA_SRI,"
                + "         SIS.PACIENTES,"
                + "         SIS.FACTURA_ELECTRONICA_DTL_SRI,"
                + "         SIS.ITEM_CARGOS,"
                + "         SIS.PERSONAL"
                + "   WHERE     CARGOS.CODIGO = DETALLES_FACTURA.CRG_CODIGO"
                + "         AND CARGOS.TIPO = DETALLES_FACTURA.CRG_TIPO"
                + "         AND FACTURAS.CAJA = DETALLES_FACTURA.FCT_CAJA"
                + "         AND FACTURAS.NUMERO = DETALLES_FACTURA.FCT_NUMERO"
                + "         AND FACTURAS.NUMERO = FACTURA_ELECTRONICA_SRI.FCT_NUMERO"
                + "         AND FACTURAS.CAJA = FACTURA_ELECTRONICA_SRI.FCT_CAJA"
                + "         AND FACTURA_ELECTRONICA_SRI.FCT_NUMERO ="
                + "                FACTURA_ELECTRONICA_DTL_SRI.FCT_NUMERO"
                + "         AND FACTURA_ELECTRONICA_SRI.FCT_CAJA ="
                + "                FACTURA_ELECTRONICA_DTL_SRI.FCT_CAJA"
                + "         AND PACIENTES.NUMERO_HC = FACTURAS.PCN_NUMERO_HC"
                + "         AND DETALLES_FACTURA.CRG_CODIGO = ITEM_CARGOS.CRG_CODIGO"
                + "         AND DETALLES_FACTURA.CRG_TIPO = ITEM_CARGOS.CRG_TIPO"
                + "         AND PACIENTES.NUMERO_HC = " + pHC
                + "         AND AMBIENTE = 2"
                + "         AND PERSONAL.CODIGO = FACTURAS.PRS_CODIGO"
                + " GROUP BY FACTURA_ELECTRONICA_SRI.FCT_NUMERO,"
                + "         FACTURA_ELECTRONICA_SRI.FECHA_EMISION,"
                + "         FACTURA_ELECTRONICA_SRI.FCT_CAJA,"
                + "         PERSONAL.APELLIDOS || ' ' || PERSONAL.NOMBRES,"
                + "         FACTURA_ELECTRONICA_SRI.RUC,"
                + "         estab || '-' || pto_emi || '-' || FACTURA_ELECTRONICA_SRI.SECUENCIAL"
                + " ORDER BY FACTURA_ELECTRONICA_SRI.FECHA_EMISION desc    ";

        System.out.println("7777777777777777777777 = " + sql);

        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("CODIGO", result[0]);
                resultMap.put("FECHA_EMISION", result[1]);
                resultMap.put("FCT_CAJA", result[2]);
                resultMap.put("REALIZADO_POR", result[3]);
                resultMap.put("RUC", result[4]);
                resultMap.put("NRO_FACT", result[5]);
                resultMap.put("VALOR_CANCELADO", result[6]);
                data.add(resultMap);

            }
        }
        return data;

    }
}
