/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.utilities;

import he1.seguridades.entities.SegModulos;
import he1.seguridades.entities.SegModulos_;
import he1.seguridades.entities.SegPerfil;
import he1.seguridades.entities.SegPerfil_;
import he1.seguridades.entities.SegUsuarioPerfil;
import he1.seguridades.entities.nuevos.SegBitacora;
import he1.seguridades.entities.nuevos.SegBitacora_;
import he1.sis.entities.Personal;
import he1.sis.entities.Personal_;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
@LocalBean
public class SesionSeguridades {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    public List<Map> buscaHistorial(String pCriterio) {
        String sql
                = "SELECT to_char(FECHA, 'fmday/dd/month/yyyy','nls_date_language = spanish' ) FECHA,   NUMERO,   APELLIDOS,   NOMBRES,   ESTADO,   TIPO    FROM SIS.TURNOS_CE, SIS.PERSONAL, SIS.PACIENTES   WHERE     TURNOS_CE.PCN_NUMERO_HC = " + pCriterio + "   AND CODIGO = TURNOS_CE.PRS_CODIGO   AND NUMERO_HC = TURNOS_CE.PCN_NUMERO_HC ORDER BY FECHA DESC";
//si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("FECHA", result[0]);
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

    public String encyrpDinamico(String palabra) {

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("PACK_SEGURIDADES.P_ENCRIPT_PALABRA");
        storedProcedure.registerStoredProcedureParameter(1/*"palabra"*/, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(2/*"p_decrypt"*/, String.class, ParameterMode.OUT);
        storedProcedure.setParameter(1, palabra);

        // execute SP
        storedProcedure.execute();
        // get result
        String palabraEnc = (String) storedProcedure.getOutputParameterValue(2/*"p_decrypt"*/);
        return palabraEnc;
    }

    public String encyrptRegresaPortal(String palabra) {
        System.out.println("palabra = " + palabra);
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("PACK_SEGURIDADES.P_ENCRIPT_PALABRA");
        System.out.println("1 = " + 1);
        storedProcedure.registerStoredProcedureParameter(1/*"palabra"*/, String.class, ParameterMode.IN);
        System.out.println("2 = " + 2);
        storedProcedure.registerStoredProcedureParameter(2/*"p_decrypt"*/, String.class, ParameterMode.OUT);
        System.out.println("3 = " + 3);
        storedProcedure.setParameter(1, palabra);
        System.out.println("4 = " + 4);

        // execute SP
        storedProcedure.execute();
        System.out.println("5 = " + 5);
        // get result
        String palabraEnc = "";//(String) storedProcedure.getOutputParameterValue(2/*"p_decrypt"*/);
        palabraEnc = (String) storedProcedure.getOutputParameterValue(2/*"p_decrypt"*/);
        System.out.println("6 = " + 6);
        return palabraEnc;
    }

    public String decyrpDinamico(String palabra) {
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("PACK_SEGURIDADES.p_decript_palabra");
        storedProcedure.registerStoredProcedureParameter(1/*"palabra"*/, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(2/*"p_decrypt"*/, String.class, ParameterMode.OUT);
        storedProcedure.setParameter(1, palabra);
        // execute SP
        storedProcedure.execute();
        // get result
        String palabraEnc = (String) storedProcedure.getOutputParameterValue(2/*"p_decrypt"*/);
        return palabraEnc;
    }

    public String buscaURLMenu(String pCriterio) {
        String URL = "";

        if (!pCriterio.equalsIgnoreCase("SIN DATO")) {
//            String sql
//                    = "SELECT MOD_URL_siguiente   FROM SEG_PERFIL, SEG_USUARIO_PERFIL, SEG_MODULOS  WHERE     UMO_ID = " + pCriterio + "        AND SEG_PERFIL.PER_ID = SEG_USUARIO_PERFIL.PER_ID        AND SEG_MODULOS.MOD_ID = SEG_PERFIL.MOD_ID";
//            //si existen parámetros se deben poner ? en las posiciones respectivas 
            String sql
                    = "SELECT MOD_URL_siguiente   FROM SEG_PERFIL, SEG_USUARIO_PERFIL, SEG_MODULOS  WHERE     UMO_ID = 736348        AND SEG_PERFIL.PER_ID = SEG_USUARIO_PERFIL.PER_ID        AND SEG_MODULOS.MOD_ID = SEG_PERFIL.MOD_ID";
            //si existen parámetros se deben poner ? en las posiciones respectivas 

            try {
                Query query = em.createNativeQuery(sql);

                List<String> resultList = query.getResultList();
                Iterator iterator = resultList.iterator();

                while (iterator.hasNext()) {
                    URL = (String) iterator.next();
                }
            } catch (Exception e) {
            }

        } else {

            URL = buscaURLPortal();
        }

        return URL;

    }

    public String buscaURLPortal() {

        String sql
                = "SELECT URL   FROM seguridades.SEG_URLS  WHERE ID = 2";
        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<String> resultList = query.getResultList();
        Iterator iterator = resultList.iterator();
        String URL = "";
        while (iterator.hasNext()) {
            URL = (String) iterator.next();
        }

        return URL;

    }

    public String buscaURLSiguiente(String pModulo) {
        String sql
                = "SELECT SEG_MODULOS.MOD_URL_SIGUIENTE   FROM SEGURIDADES.SEG_MODULOS  WHERE SEG_MODULOS.MOD_ID = " + pModulo;
        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<String> resultList = query.getResultList();
        Iterator iterator = resultList.iterator();
        String URL = "";
        while (iterator.hasNext()) {
            URL = (String) iterator.next();
        }
        return URL;
    }

    public String getPresionarSalir() {
        String sql
                = "SELECT URL   FROM seguridades.SEG_URLS  WHERE ID = 2";
        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<String> resultList = query.getResultList();
        Iterator iterator = resultList.iterator();
        String URL = "";
        while (iterator.hasNext()) {
            URL = (String) iterator.next();
        }
        while (iterator.hasNext()) {
            URL = (String) iterator.next();
        }

        return URL;
    }

    public List<Map> litaPermanencias(String paciente, String pFecha1, String pFecha2) {
        String sql = "SELECT bloqueado,       CEDULA,       APELLIDO_PATERNO,       PRIMER_NOMBRE,       ENFERMEDAD,       TO_CHAR (FECHA_INGRESO,                'fmdd/month/yyyy',                'nls_date_language = spanish')          FECHA_INGRESOs,       TO_CHAR (FECHA_ALTA, 'fmdd/month/yyyy', 'nls_date_language = spanish')          FECHA_ALTAs,       TOTAL_DIAS  FROM (  SELECT DISTINCT bloqueado,                          CEDULA,                          APELLIDO_PATERNO,                          PRIMER_NOMBRE,                          ENFERMEDAD,                          FECHA_INGRESO,                          FECHA_ALTA,                          TOTAL_DIAS            FROM SIS.TURNOS_CAMAS,                 SIS.PERMANENCIAS_Y_ATENCIONES,                 SIS.PACIENTES,                 SIS.DIAGNOSTICOS_PACIENTE,                 SIS.ENFERMEDADES,                 SIS.CAMAS_HOSPITALIZACION           WHERE     (   TO_CHAR (PERMANENCIAS_Y_ATENCIONES.PCN_NUMERO_HC) LIKE                            '%" + paciente + "%'                      OR TO_CHAR (CEDULA) LIKE '%" + paciente + "%'                      OR TO_CHAR (APELLIDO_PATERNO) LIKE '%" + paciente + "%')                 AND PERMANENCIAS_Y_ATENCIONES.PCN_NUMERO_HC =                        PRM_PCN_NUMERO_HC                 AND NUMERO = PRM_NUMERO                 AND NUMERO_HC = PERMANENCIAS_Y_ATENCIONES.PCN_NUMERO_HC                 AND NUMERO_HC = DIAGNOSTICOS_PACIENTE.PCN_NUMERO_HC                 AND DGNPCN_ID = DGNPCN_DGNPCN_ID                 AND CODIGO = ENF_CODIGO                 AND CAMA = CMAHSP_CAMA                 AND SALA = CMAHSP_SALA                 AND TO_CHAR (FECHA_INGRESO, 'yyyymmdd') BETWEEN '" + pFecha1 + "'                                                             AND '" + pFecha2 + "'        ORDER BY FECHA_INGRESO DESC)";

        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("BLOQUEADO", result[0]);
                resultMap.put("CEDULA", result[1]);
                resultMap.put("APELLIDO_PATERNO", result[2]);
                resultMap.put("PRIMER_NOMBRE", result[3]);
                resultMap.put("ENFERMEDAD", result[4]);
                resultMap.put("FECHA_INGRESOs", result[5]);
                resultMap.put("FECHA_ALTAs", result[6]);
                resultMap.put("TOTAL_DIAS", result[7]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public List<Map> listaLogueadoDependiente(String pCriterio) {
        String sql
                = "SELECT (SELECT RV_MEANING"
                + "          FROM SIS.CG_REF_CODES CG_REF_CODES_1"
                + "         WHERE RV_DOMAIN = 'FUERZA' AND RV_LOW_VALUE = FUERZA)"
                + "          FUERZA,"
                + "       (SELECT RV_MEANING"
                + "          FROM SIS.CG_REF_CODES CG_REF_CODES_1"
                + "         WHERE RV_DOMAIN = 'GRADO MILITAR' AND RV_LOW_VALUE = grado)"
                + "          GRADOM,"
                + "       (SELECT RV_MEANING"
                + "          FROM SIS.CG_REF_CODES, SIS.PACIENTES"
                + "         WHERE     RV_DOMAIN = 'SITUACION_FINANCIERA'"
                + "               AND NUMERO_HC = PACIENTES_1.NUMERO_HC"
                + "               AND SITUACION = RV_LOW_VALUE)"
                + "          TIPO_DEPENDENCIA,"
                + "       'LOGUEADO' LOGEADO,"
                + "       NUMERO_HC,"
                + "       PRIMER_NOMBRE ||  ' '||  SEGUNDO_NOMBRE  PRIMER_NOMBRE,"
                + "       APELLIDO_PATERNO ||  ' '|| APELLIDO_MATERNO  APELLIDO_PATERNO ,"
                + "       (CASE WHEN SEXO = 'M' THEN 'MASCULINO' ELSE 'FEMENINO' END) SEXO,"
                + "       ESTADO_CIVIL,"
                + "       CLASIFICACION,"
                + "       APELLIDO_MATERNO,"
                + "       SEGUNDO_NOMBRE,"
                + "       CEDULA,"
                + "       FECHA_NACIMIENTO,"
                + "       NUMERO_AFILIACION_IESS,"
                + "       OCP_CODIGO,"
                + "       (CASE"
                + "           WHEN BLOQUEADO = 'F' THEN 'Usuario Activo'"
                + "           ELSE 'Usuario no Activo'"
                + "        END)"
                + "          BLOQUEADO,"
                + "       TIPO_PACIENTE,"
                + "       EMAIL,"
                + "       NUMERO_HC_ANTERIOR,"
                + "       FUERZA FUERZA_,"
                + "       GRADO,"
                + "       SITUACION,"
                + "       ID_ISSFA_TITULAR,"
                + "       ID_ISSFA,"
                + "       (CASE WHEN ID_ISSFA_TITULAR = ID_ISSFA THEN 'SI' ELSE 'NO' END)"
                + "          ES_TITULAR,"
                + "       telefono,"
                + "       telefono_trabajo,"
                + "       celular"
                + "  FROM SIS.PACIENTES PACIENTES_1"
                + " WHERE NUMERO_HC = '" + pCriterio + "'";

        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("FUERZA", result[0]);
                resultMap.put("GRADOM", result[1]);
                resultMap.put("TIPO_DEPENDENCIA", result[2]);
                resultMap.put("LOGEADO", result[3]);
                resultMap.put("NUMERO_HC", result[4]);
                resultMap.put("PRIMER_NOMBRE", result[5]);
                resultMap.put("APELLIDO_PATERNO", result[6]);
                resultMap.put("SEXO", result[7]);
                resultMap.put("ESTADO_CIVIL", result[8]);
                resultMap.put("CLASIFICACION", result[9]);
                resultMap.put("APELLIDO_MATERNO", result[10]);
                resultMap.put("SEGUNDO_NOMBRE", result[11]);
                resultMap.put("CEDULA", result[12]);
                resultMap.put("FECHA_NACIMIENTO", result[13]);
                resultMap.put("NUMERO_AFILIACION_IESS", result[14]);
                resultMap.put("OCP_CODIGO", result[15]);
                resultMap.put("BLOQUEADO", result[16]);
                resultMap.put("TIPO_PACIENTE", result[17]);
                resultMap.put("EMAIL", result[18]);
                resultMap.put("NUMERO_HC_ANTERIOR", result[19]);
                resultMap.put("FUERZA_", result[20]);
                resultMap.put("GRADO", result[21]);
                resultMap.put("SITUACION", result[22]);
                resultMap.put("ID_ISSFA_TITULAR", result[23]);
                resultMap.put("ID_ISSFA", result[24]);
                resultMap.put("ES_TITULAR", result[25]);
                resultMap.put("TELEFONO", result[26]);
                resultMap.put("TELEFONO_TRABAJO", result[27]);
                resultMap.put("CELULAR", result[28]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public List<Map> listaBuscaDependientes(String pCriterio) {
        String sql
                = "  SELECT 'DEPENDIENTES' DEPEN,"
                + "         (SELECT RV_MEANING"
                + "            FROM SIS.CG_REF_CODES CG_REF_CODES_1"
                + "           WHERE RV_DOMAIN = 'FUERZA' AND RV_LOW_VALUE = PACIENTES_1.FUERZA)"
                + "            FUERZA,"
                + "         (SELECT RV_MEANING"
                + "            FROM SIS.CG_REF_CODES CG_REF_CODES_1"
                + "           WHERE     RV_DOMAIN = 'GRADO MILITAR'"
                + "                 AND RV_LOW_VALUE = PACIENTES_1.grado)"
                + "            GRADOM,"
                + "         (SELECT DESCRIPCION TIPO_PACIENTE"
                + "            FROM SIS.PROMOCIONES_PACIENTES PACI, SIS.PROMOCIONES"
                + "           WHERE     PACI.PCN_NUMERO_HC = PACIENTES_1.NUMERO_HC"
                + "                 AND CODIGO = PACI.PRM_CODIGO"
                + "                 AND (PACI.PCN_NUMERO_HC, PACI.FECHA_CATEGORIZACION) IN (  SELECT PP.PCN_NUMERO_HC,"
                + "                                                                                  MAX ("
                + "                                                                                     PP.FECHA_CATEGORIZACION)"
                + "                                                                             FROM SIS.PROMOCIONES_PACIENTES PP"
                + "                                                                            WHERE PP.PCN_NUMERO_HC ="
                + "                                                                                     PACIENTES_1.NUMERO_HC"
                + "                                                                         GROUP BY PP.PCN_NUMERO_HC)"
                + "                 AND ROWNUM = 1)"
                + "            CATEG_PACIENTE,"
                + "         (SELECT RV_MEANING"
                + "            FROM SIS.CG_REF_CODES, SIS.PACIENTES"
                + "           WHERE     RV_DOMAIN = 'SITUACION_FINANCIERA'"
                + "                 AND NUMERO_HC = PACIENTES_1.NUMERO_HC"
                + "                 AND SITUACION = RV_LOW_VALUE)"
                + "            TIPO_DEPENDENCIA,"
                + "         PACIENTES_1.NUMERO_HC,"
                + "         PACIENTES_1.PRIMER_NOMBRE,"
                + "         PACIENTES_1.APELLIDO_PATERNO,"
                + "         PACIENTES_1.SEXO,"
                + "         PACIENTES_1.ESTADO_CIVIL,"
                + "         PACIENTES_1.CLASIFICACION,"
                + "         PACIENTES_1.APELLIDO_MATERNO,"
                + "         PACIENTES_1.SEGUNDO_NOMBRE,"
                + "         PACIENTES_1.CEDULA,"
                + "         PACIENTES_1.FECHA_NACIMIENTO,"
                + "         PACIENTES_1.NUMERO_AFILIACION_IESS,"
                + "         PACIENTES_1.OCP_CODIGO,"
                + "        (case when PACIENTES_1.BLOQUEADO='F' then 'Usuario Activo' Else 'Usuario no Activo' end) BLOQUEADO ,"
                + "         PACIENTES_1.TIPO_PACIENTE,"
                + "         PACIENTES_1.EMAIL,"
                + "         PACIENTES_1.NUMERO_HC_ANTERIOR,"
                + "         PACIENTES_1.FUERZA,"
                + "         PACIENTES_1.GRADO,"
                + "         PACIENTES_1.SITUACION,"
                + "         PACIENTES_1.ID_ISSFA_TITULAR,"
                + "         PACIENTES_1.ID_ISSFA,"
                + "         PACIENTES_1.TELEFONO,"
                + "         PACIENTES_1.TELEFONO_TRABAJO"
                + "    FROM SIS.PACIENTES, SIS.PACIENTES PACIENTES_1"
                + "   WHERE     PACIENTES.NUMERO_HC = '" + pCriterio + "'"
                + "         AND PACIENTES_1.ID_ISSFA_TITULAR = PACIENTES.ID_ISSFA_TITULAR"
                + "         AND SIS.PACIENTES.NUMERO_HC <> PACIENTES_1.NUMERO_HC"
                + " ORDER BY   PACIENTES_1.ID_ISSFA,TIPO_DEPENDENCIA";
//        System.out.println("sql = " + sql);
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("DEPEN", result[0]);
                resultMap.put("FUERZA", result[1]);
                resultMap.put("GRADOM", result[2]);
                resultMap.put("CATEG_PACIENTE", result[3]);
                resultMap.put("TIPO_DEPENDENCIA", result[4]);
                resultMap.put("NUMERO_HC", result[5]);
                resultMap.put("PRIMER_NOMBRE", result[6]);
                resultMap.put("APELLIDO_PATERNO", result[7]);
                resultMap.put("SEXO", result[8]);
                resultMap.put("ESTADO_CIVIL", result[9]);
                resultMap.put("CLASIFICACION", result[10]);
                resultMap.put("APELLIDO_MATERNO", result[11]);
                resultMap.put("SEGUNDO_NOMBRE", result[12]);
                resultMap.put("CEDULA", result[13]);
                resultMap.put("FECHA_NACIMIENTO", result[14]);
                resultMap.put("NUMERO_AFILIACION_IESS", result[15]);
                resultMap.put("OCP_CODIGO", result[16]);
                resultMap.put("BLOQUEADO", result[17]);
                resultMap.put("TIPO_PACIENTE", result[18]);
                resultMap.put("EMAIL", result[19]);
                resultMap.put("GRADO", result[20]);
                resultMap.put("SITUACION", result[21]);
                resultMap.put("ID_ISSFA_TITULAR", result[22]);
                resultMap.put("ID_ISSFA", result[23]);
                resultMap.put("TELEFONO", result[26]);
                resultMap.put("TELEFONO_TRABAJO", result[27]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public List<Map> listaBuscaFechasCertificados(String pCriterio) {
        String sql
                = "SELECT NUMERO, to_char(FECHA, 'fmday/dd/month/yyyy','nls_date_language = spanish' ) FECHAs"
                + "    FROM SIS.CERTIFICADOS, SIS.PACIENTES"
                + "   WHERE     CERTIFICADOS.PCN_NUMERO_HC = " + pCriterio + ""
                + "         AND NUMERO_HC = CERTIFICADOS.PCN_NUMERO_HC"
                + " ORDER BY NUMERO desc, FECHA DESC";
//        System.out.println("sql = " + sql);
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("NUMERO", result[0]);
                resultMap.put("FECHA", result[1]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public List<Map> despliegaCertificado(String pHC, String numeroCert) {
        String sql
                = "  SELECT PACIENTES.CEDULA,"
                + "       PRIMER_NOMBRE,"
                + "       SEGUNDO_NOMBRE,"
                + "       APELLIDO_PATERNO,"
                + "       APELLIDO_MATERNO,"
                + "       PERSONAL.CEDULA PERSONAL_CEDULA,"
                + "       PERSONAL.NOMBRES,"
                + "       PERSONAL.APELLIDOS,"
                + "       PERSONAL.CODIGO,"
                + "       ENFERMEDAD,"
                + "       ENFERMEDADES.CODIGO ENFERMEDADES_CODIGO,"
                + "       to_char(FECHA,'dd/mm/yyyy') FECHA,"
                + "       to_char(FECHA_INICIO_REPOSO,'dd/mm/yyyy') FECHA_INICIO_REPOSO,"
                + "       to_char(FECHA_FIN_REPOSO,'dd/mm/yyyy') FECHA_FIN_REPOSO,"
                + "       FECHA_RE_EVALUACION,"
                + "       ANTECEDENTES_CLINICOS,"
                + "       ANTECEDENTES_PERSONALES,"
                + "       ANTECEDENTES_FAMILIARES,"
                + "       ANTECEDENTES_POSTQUIRURGICOS,"
                + "       ENFERMEDAD_ACTUAL,"
                + "       IMPRESION_DIAGNOSTICA,"
                + "       TRATAMIENTO,"
                + "       PRONOSTICO,"
                + "       RECOMENDACIONES,"
                + "       SERVICIO,"
                + "       RV_MEANING,"
                + "       DECODE (TIPO_TRATAMIENTO,"
                + "               'C', 'Clínico',"
                + "               'Q', 'Quirúrgico',"
                + "               'O', 'Oncológico',"
                + "               'D', 'Diálisis',"
                + "               'F', 'Fisiatría',"
                + "               'T', 'Ortopédico'"
                + ", 'SIN DATO')"
                + "          TIPO_TRATAMIENTO,"
                + "       DIAS_PERMISO,"
                + "       DECODE (REPOSO_FISICO,"
                + "               'E', 'Estricto',"
                + "               'R', 'Relativo',"
                + "               'N', 'Ninguno','SIN DATO')"
                + "          REPOSO_FISICO,"
                + "      nvl( to_char(FECHA_INGRESO,'dd/mm/yyyy'), ' ') FECHA_INGRESO,"
                + "      nvl( to_char(FECHA_EGRESO ,'dd/mm/yyyy'), ' ') FECHA_EGRESO,"
                + "       OBSERVACIONES,"
                + "       JEFE_RRHH,"
                + "       CARGO_JEFE_RRHH,"
                + "       COMANDANTE,"
                + "       CARGO_COMANDANTE,"
                + "       CERTIFICADOS.PRS_CODIGO emite_certi,"
                + "       PERSONAL_1.CEDULA PERSONAL_1_CEDULA,"
                + "       PERSONAL_1.NOMBRES PERSONAL_1_NOMBRES,"
                + "       PERSONAL_1.APELLIDOS  PERSONAL_1_APELLIDOS,"
                + "       (SELECT NOMBRE"
                + "          FROM SIS.DEPARTAMENTOS_TRABAJAN, SIS.DEPARTAMENTOS"
                + "         WHERE     PRS_CODIGO = CERTIFICADOS.PRS_CODIGO"
                + "               AND ARA_CODIGO = DPR_ARA_CODIGO"
                + "               AND CODIGO = DPR_CODIGO"
                + "               AND ROWNUM = 1)"
                + "          departamento,"
                + "           CERTIFICADOS.PCN_NUMERO_HC "
                + "  FROM SIS.CERTIFICADOS,"
                + "       SIS.PACIENTES,"
                + "       SIS.PERSONAL,"
                + "       SIS.DIAGNOSTICOS_PACIENTE,"
                + "       SIS.ENFERMEDADES,"
                + "       SIS.CG_REF_CODES,"
                + "       SIS.PERSONAL PERSONAL_1"
                + " WHERE     CERTIFICADOS.PCN_NUMERO_HC = " + pHC + ""
                + "       AND NUMERO = " + numeroCert + "  "
                + "       AND RV_DOMAIN = 'SERVICIO PERMANENCIA'"
                + "       AND ENFERMEDADES.CODIGO = ENF_CODIGO"
                + "       AND RV_LOW_VALUE = SERVICIO"
                + "       AND PERSONAL_1.CODIGO = CERTIFICADOS.PRS_CODIGO"
                + "       AND NUMERO_HC = CERTIFICADOS.PCN_NUMERO_HC"
                + "       AND PRS_CODIGO_TRATANTE = PERSONAL.CODIGO"
                + "       AND DGNPCN_DGNPCN_ID = DGNPCN_ID";
        //si existen parámetros se deben poner ? en las posiciones respectivas 
//        System.out.println("7777777777777777777777 = " + sql);
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("CEDULA", result[0]);
                resultMap.put("PRIMER_NOMBRE", result[1]);
                resultMap.put("SEGUNDO_NOMBRE", result[2]);
                resultMap.put("APELLIDO_PATERNO", result[3]);
                resultMap.put("APELLIDO_MATERNO", result[4]);
                resultMap.put("PERSONAL_CEDULA", result[5]);
                resultMap.put("NOMBRES", result[6]);
                resultMap.put("APELLIDOS", result[7]);
                resultMap.put("CODIGO", result[8]);
                resultMap.put("ENFERMEDAD", result[9]);
                resultMap.put("ENFERMEDADES_CODIGO", result[10]);
                resultMap.put("FECHA", result[11]);
                resultMap.put("FECHA_INICIO_REPOSO", result[12]);
                resultMap.put("FECHA_FIN_REPOSO", result[13]);
                resultMap.put("FECHA_RE_EVALUACION", result[14]);
                resultMap.put("ANTECEDENTES_CLINICOS", result[15]);
                resultMap.put("ANTECEDENTES_PERSONALES", result[16]);
                resultMap.put("ANTECEDENTES_FAMILIARES", result[17]);
                resultMap.put("ANTECEDENTES_POSTQUIRURGICOS", result[18]);
                resultMap.put("ENFERMEDAD_ACTUAL", result[19]);
                resultMap.put("IMPRESION_DIAGNOSTICA", result[20]);
                resultMap.put("TRATAMIENTO", result[21]);
                resultMap.put("PRONOSTICO", result[22]);
                resultMap.put("RECOMENDACIONES", result[23]);
                resultMap.put("SERVICIO", result[24]);
                resultMap.put("RV_MEANING", result[25]);
                resultMap.put("TIPO_TRATAMIENTO", result[26]);
                resultMap.put("DIAS_PERMISO", result[27]);
                resultMap.put("REPOSO_FISICO", result[28]);
                resultMap.put("FECHA_INGRESO", result[29]);
                resultMap.put("FECHA_EGRESO", result[30]);
                resultMap.put("OBSERVACIONES", result[31]);
                resultMap.put("JEFE_RRHH", result[32]);
                resultMap.put("CARGO_JEFE_RRHH", result[33]);
                resultMap.put("COMANDANTE", result[34]);
                resultMap.put("CARGO_COMANDANTE", result[35]);
                resultMap.put("emite_certi", result[36]);
                resultMap.put("PERSONAL_1_CEDULA", result[37]);
                resultMap.put("PERSONAL_1_NOMBRES", result[38]);
                resultMap.put("PERSONAL_1_APELLIDOS", result[39]);
                resultMap.put("DEPARTAMENTO", result[40]);
                resultMap.put("HC", result[41]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public String pCambiarClavePaciente(String CC, String clave_anterior, String clave_nueva) {
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("seguridades.PACK_SEGURIDADES.p_cambiar_clave_portal");

        storedProcedure.registerStoredProcedureParameter(1/*"palabra"*/, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(2/*"palabra"*/, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(3/*"palabra"*/, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(4/*"p_decrypt"*/, String.class, ParameterMode.OUT);
        storedProcedure.setParameter(1, CC);
        storedProcedure.setParameter(2, clave_anterior);
        storedProcedure.setParameter(3, clave_nueva);
        // execute SP
        storedProcedure.execute();
        // get result
        String pEstado = (String) storedProcedure.getOutputParameterValue(4/*"p_decrypt"*/);
        return pEstado;
    }

    public List<String> RetornaAutocompleteModulo(String pNombreModulo) {
        String sql
                = "SELECT MOD_NOMBRE_MODULO"
                + "  FROM SEG_MODULOS"
                + " WHERE upper(MOD_NOMBRE_MODULO) LIKE '%" + pNombreModulo.toUpperCase() + "%'";

        Query query = em.createNativeQuery(sql);

        List<String> results = query.getResultList();
        return results;

    }

    public List<SegPerfil> findPerfil(SegModulos par) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegPerfil> cq = cb.createQuery(SegPerfil.class);
        Root<SegPerfil> root = cq.from(SegPerfil.class);
        cq.where(cb.equal(root.get(SegPerfil_.segModulos), par));
        List resultList = em.createQuery(cq).getResultList();
        return resultList;
    }

    public List<SegModulos> findModuloPorNombre(String par) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegModulos> cq = cb.createQuery(SegModulos.class);
        Root<SegModulos> root = cq.from(SegModulos.class);
        cq.where(cb.like(root.get(SegModulos_.modNombreModulo), "%" + par.toUpperCase() + "%"));
        List resultList = em.createQuery(cq).getResultList();
        return resultList;
    }

    public List<Personal> findPersonalCriterios(String par) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Personal> cq = cb.createQuery(Personal.class);
        Root<Personal> root = cq.from(Personal.class);
        List<Predicate> predicatesOR = new ArrayList<Predicate>();
        predicatesOR.add(cb.like(root.get(Personal_.cedula), "%" + par.toUpperCase() + "%"));
        predicatesOR.add(cb.like(root.get(Personal_.codigo), "%" + par.toUpperCase() + "%"));
        predicatesOR.add(cb.like(root.get(Personal_.apellidos), "%" + par.toUpperCase() + "%"));
        predicatesOR.add(cb.like(root.get(Personal_.nombres), "%" + par.toUpperCase() + "%"));
        cq.where(cb.or(predicatesOR.toArray(new Predicate[predicatesOR.size()])));
        List resultList = em.createQuery(cq).setMaxResults(20).getResultList();
        return resultList;
    }

    public List<SegPerfil> findPerfilesCriterios(String par) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegPerfil> cq = cb.createQuery(SegPerfil.class);
        Root<SegPerfil> root = cq.from(SegPerfil.class);
        List<Predicate> predicatesOR = new ArrayList<Predicate>();
        predicatesOR.add(cb.like(root.get(SegPerfil_.perDescripcion), "%" + par.trim() + "%"));
        cq.where(cb.or(predicatesOR.toArray(new Predicate[predicatesOR.size()])));
        cq.orderBy(cb.asc(root.get(SegPerfil_.perDescripcion)));
        List resultList = em.createQuery(cq).setMaxResults(20).getResultList();
        return resultList;
    }

    public List<SegUsuarioPerfil> buscaPerfilesNQ(String pCriterio) {
        List results = em.createNamedQuery("SegUsuarioPerfil.findByCodigoPersonal").setParameter("codigoPersonal", pCriterio).getResultList();
        return results;
    }

    public List<SegModulos> findPerfiles() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegModulos> cq = cb.createQuery(SegModulos.class);
        Root<SegModulos> root = cq.from(SegModulos.class);
        List<Predicate> predicatesOR = new ArrayList<Predicate>();
        cq.orderBy(cb.asc(root.get(SegModulos_.modNombreModulo)));
        List resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;
    }

    public List<Map> findByCedulaHCApellidos(String pCriterio) {
        String sql
                = "   SELECT PACIENTES.NUMERO_HC,"
                + "          PACIENTES.APELLIDO_PATERNO,"
                + "          PACIENTES.PRIMER_NOMBRE,"
                + "          PACIENTES.SEXO,"
                + "          PACIENTES.ESTADO_CIVIL,"
                + "          PACIENTES.CLASIFICACION,"
                + "          PACIENTES.APELLIDO_MATERNO,"
                + "          PACIENTES.SEGUNDO_NOMBRE,"
                + "          PACIENTES.CEDULA"
                + "     FROM SIS.PACIENTES"
                + "    WHERE    TO_CHAR (PACIENTES.NUMERO_HC) LIKE UPPER ('" + pCriterio + "%')"
                + "          OR (   UPPER (PACIENTES.APELLIDO_PATERNO)"
                + "              || ' '"
                + "              || UPPER (PACIENTES.APELLIDO_materno)) LIKE"
                + "                UPPER ('" + pCriterio + "%')"
                + "          OR UPPER (PACIENTES.CEDULA) LIKE UPPER ('" + pCriterio + "%')";

        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.setMaxResults(30).getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("NUMERO_HC", result[0]);
                resultMap.put("APELLIDO_PATERNO", result[1]);
                resultMap.put("PRIMER_NOMBRE", result[2]);
                resultMap.put("SEXO", result[3]);
                resultMap.put("ESTADO_CIVIL", result[4]);
                resultMap.put("CLASIFICACION", result[5]);
                resultMap.put("APELLIDO_MATERNO", result[6]);
                resultMap.put("SEGUNDO_NOMBRE", result[7]);
                resultMap.put("CEDULA", result[8]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public List<Map> findlistacertifindividuales(String pCriterio) {
        if (pCriterio.equalsIgnoreCase("")) {
            pCriterio = "-1";

        }
        String sql
                = "SELECT V_CERTIFICADOS.SEQUENCIA_TIPO,"
                + "       V_CERTIFICADOS.NUMERO_HC,"
                + "       V_CERTIFICADOS.NOMBRES,"
                + "       V_CERTIFICADOS.GRADO,"
                + "       V_CERTIFICADOS.NOMBRE,"
                + "       V_CERTIFICADOS.FECHA,"
                + "       V_CERTIFICADOS.FECHA_CERT,"
                + "       V_CERTIFICADOS.NUMERO"
                + "  FROM V_CERTIFICADOS"
                + " WHERE numero_hc = " + pCriterio;

//si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("SEQUENCIA_TIPO", result[0]);
                resultMap.put("NUMERO_HC", result[1]);
                resultMap.put("NOMBRES", result[2]);
                resultMap.put("GRADO", result[3]);
                resultMap.put("NOMBRE", result[4]);
                resultMap.put("FECHA", result[5]);
                resultMap.put("FECHA_CERT", result[6]);
                resultMap.put("NUMERO", result[7]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public String findFechasAcumulaDecimos(String pCriterio) {
        String sql = "SELECT NOMINA.F_DETERMINA_READ_ACUMULA (" + pCriterio + ")  valor_campo "
                + "FROM DUAL";
        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);
        String results = query.getSingleResult().toString();
        return results;
    }

    public String findAnioActual() {
        String sql = "SELECT TO_CHAR (SYSDATE, 'yyyy') FROM DUAL";
        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);
        String results = query.getSingleResult().toString();
        return results;
    }

    public String p_envia_mail(String correodestino, String subject, String mensaje, String tipocorreo) {
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("SIS.SEND_MAIL");
        // set parameters
        storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);

        storedProcedure.setParameter(1, correodestino);
        storedProcedure.setParameter(2, subject);
        storedProcedure.setParameter(3, mensaje);
        storedProcedure.setParameter(4, tipocorreo);

        // execute SP
        storedProcedure.execute();
        return null;
    }

    public String p_resetea_clave(String cedula) {
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("PACK_SEGURIDADES.P_RESETEA_CLAVE");
        // set parameters
        storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedure.setParameter(1, cedula);

        // execute SP
        storedProcedure.execute();
        return null;
    }

    public List<Map> listD13D14(String pCriterio) {
        String sql = " SELECT PERSONAL.PRN_NUMDOCUMENTO,"
                + "         PERSONAL.PRN_IDPERSONAL,"
                + "         PERSONAL.PRN_APELLIDOS,"
                + "         PERSONAL.PRN_NOMBRES,"
                + "         (SELECT ACUMULA_DECIMO.ACCION"
                + "            FROM NOMINA.ACUMULA_DECIMO"
                + "           WHERE     ACUMULA_DECIMO.PRN_ID_PERSONAL = PERSONAL.PRN_IDPERSONAL"
                + "                 AND ACUMULA_DECIMO.TIPO = 'Decimo Tercer Sueldo'"
                + "                 AND ACUMULA_DECIMO.ANIO = " + pCriterio + " )"
                + "            d13,"
                + "         (SELECT ACUMULA_DECIMO.ACCION"
                + "            FROM NOMINA.ACUMULA_DECIMO"
                + "           WHERE     ACUMULA_DECIMO.PRN_ID_PERSONAL = PERSONAL.PRN_IDPERSONAL"
                + "                 AND ACUMULA_DECIMO.TIPO = 'Decimo Cuarto Sueldo'"
                + "                 AND ACUMULA_DECIMO.ANIO = " + pCriterio + ")"
                + "            d14"
                + "    FROM NOMINA.PERSONAL"
                + "   WHERE    (SELECT ACUMULA_DECIMO.ACCION"
                + "               FROM NOMINA.ACUMULA_DECIMO"
                + "              WHERE     ACUMULA_DECIMO.PRN_ID_PERSONAL ="
                + "                           PERSONAL.PRN_IDPERSONAL"
                + "                    AND ACUMULA_DECIMO.TIPO = 'Decimo Tercer Sueldo')"
                + "               IS NOT NULL"
                + "         OR (SELECT ACUMULA_DECIMO.ACCION"
                + "               FROM NOMINA.ACUMULA_DECIMO"
                + "              WHERE     ACUMULA_DECIMO.PRN_ID_PERSONAL ="
                + "                           PERSONAL.PRN_IDPERSONAL"
                + "                    AND ACUMULA_DECIMO.TIPO = 'Decimo Cuarto Sueldo')"
                + "               IS NOT NULL"
                + "  ORDER BY 3, 4";

        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("PRN_NUMDOCUMENTO", result[0]);
                resultMap.put("PRN_IDPERSONAL", result[1]);
                resultMap.put("PRN_APELLIDOS", result[2]);
                resultMap.put("PRN_NOMBRES", result[3]);
                resultMap.put("D13", result[4]);
                resultMap.put("D14", result[5]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public List<Map> listaturnossiguientes() {
        String sql
                = "  SELECT MV_SERVICIOS_PORTAL.NOMBRE,   "
                + "            TO_CHAR (MV_SERVICIOS_PORTAL.FECHA_DISPONIBLE,   "
                + "                     'fmdd',   "
                + "                     'nls_date_language = spanish')   "
                + "         || ' de '   "
                + "         || TO_CHAR (MV_SERVICIOS_PORTAL.FECHA_DISPONIBLE,   "
                + "                     'fmmonth',   "
                + "                     'nls_date_language = spanish')   "
                + "         || ' de '   "
                + "         || TO_CHAR (MV_SERVICIOS_PORTAL.FECHA_DISPONIBLE,   "
                + "                     'fmyyyy',   "
                + "                     'nls_date_language = spanish')   "
                + "            FECHA_DISPONIBLE,   "
                + "         MV_SERVICIOS_PORTAL.CONSULTORIO,   "
                + "         MV_SERVICIOS_PORTAL.DISPONIBLES   "
                + "    FROM TABLEAU.MV_SERVICIOS_PORTAL   "
                + "ORDER BY MV_SERVICIOS_PORTAL.FECHA_DISPONIBLE asc   ";

        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("NOMBRE", result[0]);
                resultMap.put("FECHA_DISPONIBLE", result[1]);
                resultMap.put("CONSULTORIO", result[2]);
                resultMap.put("DISPONIBLES", result[3]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public String p_registra_evento(String phora,
            String parea,
            String pevento,
            String psolucion,
            String pusuario) {
        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("P_REGISTRA_EVENTO");
        // set parameters
        storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        storedProcedure.setParameter(1, phora);
        storedProcedure.setParameter(2, parea);
        storedProcedure.setParameter(3, pevento);
        storedProcedure.setParameter(4, psolucion);
        storedProcedure.setParameter(5, pusuario);

        // execute SP
        storedProcedure.execute();
        return null;
    }

    public List<SegBitacora> findBitacoraRecientes() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SegBitacora> cq = cb.createQuery(SegBitacora.class);
        Root<SegBitacora> root = cq.from(SegBitacora.class);
        cq.orderBy(cb.desc(root.get(SegBitacora_.hora)));
        List resultList = em.createQuery(cq).setHint("eclipselink.refresh", "true").getResultList();
        return resultList;
    }

    public List<Map> listaConsultaBitacora(String pCriterio, String pArea) {
        String sql = "SELECT SEG_BITACORA.ID,   "
                + "       to_char(SEG_BITACORA.FECHA, 'dd/mm/yyyy hh24:mi:ss') FECHA   ,   "
                + "       to_char(SEG_BITACORA.HORA, 'dd/mm/yyyy hh24:mi:ss') HORA,   "
                + "       SEG_BITACORA.AREA,   "
                + "       SEG_BITACORA.EVENTO,   "
                + "       SEG_BITACORA.SOLUCION,   "
                + "       SEG_BITACORA.ID_USUARIO   "
                + "  FROM SEGURIDADES.SEG_BITACORA   "
                + " WHERE    (UPPER (SEG_BITACORA.AREA) LIKE UPPER ('%" + pArea + "%'))   "
                + "       and ((UPPER (SEG_BITACORA.EVENTO) LIKE UPPER ('%" + pCriterio + "%'))   "
                + "       OR (UPPER (SEG_BITACORA.SOLUCION) LIKE UPPER ('%" + pCriterio + "%')))   "
                + " order by SEG_BITACORA.HORA desc";

        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("ID", result[0]);
                resultMap.put("FECHA", result[1]);
                resultMap.put("HORA", result[2]);
                resultMap.put("AREA", result[3]);
                resultMap.put("EVENTO", result[4]);
                resultMap.put("SOLUCION", result[5]);
                resultMap.put("ID_USUARIO", result[6]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public List<Map> findTieneSolicitudFirmaDigitalHoy(String pCriterio) {
        String sql = "SELECT COUNT (*) || ''  TOTAL "
                + "  FROM NOMINA.SOLICITUD_CERTIFICADO, NOMINA.TIPO_SOLICITUD, NOMINA.PERSONAL   "
                + " WHERE     SOLICITUD_CERTIFICADO.PRN_ID_PERSONAL = " + pCriterio + "   "
                + "       AND PERSONAL.PRN_FECHASALIDA IS NULL   "
                + "       AND TIPO_SOLICITUD.TSO_DESCRIPCION =   "
                + "              'Certificado Laboral con firma digital'   "
                + "       AND SOLICITUD_CERTIFICADO.SLC_FECHA_SOLICITUD IS NOT NULL   "
                + "       AND TIPO_SOLICITUD.ID = SOLICITUD_CERTIFICADO.TSO_ID   "
                + "       AND PERSONAL.PRN_IDPERSONAL = SOLICITUD_CERTIFICADO.PRN_ID_PERSONAL   ";

        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("TOTAL", result[0]);
                data.add(resultMap);

            }
        }
        return data;

    }

    public List<Map> listaRackPAcientes(String pCriterio) {
        String sql
                = "  SELECT PCNINT.SERVICIO,   "
                + "         (SELECT RV_MEANING   "
                + "            FROM CG_REF_CODES   "
                + "           WHERE     RV_DOMAIN = 'SERVICIO PERMANENCIA'   "
                + "                 AND RV_LOW_VALUE = PCNINT.SERVICIO   "
                + "                 AND ROWNUM = 1)   "
                + "            SERV_PERMA,   "
                + "         PCNINT.BLOQUEADO,   "
                + "         PCNINT.ULTIMA_CAMA HABITACION,   "
                + "         (SELECT C.RV_MEANING   "
                + "            FROM CG_REF_CODES C, CAMAS_HOSPITALIZACION CH   "
                + "           WHERE     C.RV_DOMAIN = 'CAMAS_HOSPITALIZACION.SERVICIO'   "
                + "                 AND C.RV_LOW_VALUE = CH.SERVICIO   "
                + "                 AND CH.SALA || CH.CAMA = PCNINT.ULTIMA_CAMA)   "
                + "            PISO,   "
                + "         PCNINT.NUMERO PERMANENCIA,   "
                + "         PCNINT.PCN_NUMERO_HC,   "
                + "         PCNINT.APELLIDO_PATERNO,   "
                + "         PCNINT.APELLIDO_MATERNO,   "
                + "         PCNINT.PRIMER_NOMBRE,   "
                + "         PCNINT.SEGUNDO_NOMBRE,   "
                + "         (SELECT SEXO   "
                + "            FROM PACIENTES P   "
                + "           WHERE P.NUMERO_HC = PCNINT.PCN_NUMERO_HC)   "
                + "            SEXO,   "
                + "         PCNINT.CEDULA,   "
                + "         to_char(PCNINT.FECHA_NACIMIENTO, 'DD/MM/YYYY')  FECHA_NACIMIENTO,   "
                + "         to_char(PCNINT.FECHA_INGRESO,'DD/MM/YYYY')  FECHA_INGRESO,   "
                + "     (CASE WHEN FLOOR (SYSDATE - PCNINT.FECHA_INGRESO + 1)<= 30 THEN FLOOR (SYSDATE - PCNINT.FECHA_INGRESO + 1) ELSE ''  END )     DIAS_HOSPITAL,   "
                + "         TO_CHAR(PCNINT.FECHA_ALTA ,'DD/MM/YYYY' ) FECHA_ALTA ,   "
                + "         PCNINT.DGN_DGN_ID,   "
                + "         PCNINT.PCNTMP_PCNTMP_ID,   "
                + "         (SELECT PRS.APELLIDOS || ' ' || PRS.NOMBRES   "
                + "            FROM PERSONAL PRS, PERMANENCIAS_Y_ATENCIONES PRM   "
                + "           WHERE PRS.CODIGO = PRM.PRS_CODIGO AND PRM.NUMERO = PCNINT.NUMERO)   "
                + "            MEDIC_TRATANTE,   "
                + "         PCNINT.ESPECIALIDAD   "
                + "    FROM PACIENTES_INTERNADOS PCNINT   "
                + "   WHERE    (SELECT UPPER (RV_MEANING)   "
                + "               FROM CG_REF_CODES   "
                + "              WHERE     RV_DOMAIN = 'SERVICIO PERMANENCIA'   "
                + "                    AND RV_LOW_VALUE = PCNINT.SERVICIO   "
                + "                    AND ROWNUM = 1) LIKE   "
                + "               UPPER ('%" + pCriterio + "%')   "
                + "         OR PCNINT.NUMERO LIKE UPPER ('%" + pCriterio + "%')   "
                + "         OR PCNINT.PCN_NUMERO_HC LIKE UPPER ('%" + pCriterio + "%')   "
                + "         OR PCNINT.APELLIDO_PATERNO LIKE UPPER ('%" + pCriterio + "%')   "
                + "         OR PCNINT.CEDULA LIKE UPPER ('%" + pCriterio + "%')   "
                + "         OR PCNINT.PRIMER_NOMBRE LIKE UPPER ('%" + pCriterio + "%')   "
                + "         OR PCNINT.ESPECIALIDAD LIKE UPPER ('%" + pCriterio + "%')   "
                + "         OR  ((SELECT UPPER(C.RV_MEANING)   FROM CG_REF_CODES C, CAMAS_HOSPITALIZACION CH    WHERE     C.RV_DOMAIN = 'CAMAS_HOSPITALIZACION.SERVICIO'    AND C.RV_LOW_VALUE = CH.SERVICIO    AND CH.SALA || CH.CAMA = PCNINT.ULTIMA_CAMA)   ) LIKE UPPER ('%" + pCriterio + "%')   "
                + "ORDER BY SERVICIO,   "
                + "         ULTIMA_CAMA,   "
                + "         APELLIDO_PATERNO,   "
                + "         APELLIDO_MATERNO,   "
                + "         PRIMER_NOMBRE,   "
                + "         SEGUNDO_NOMBRE   ";

        //si existen parámetros se deben poner ? en las posiciones respectivas 
        Query query = em.createNativeQuery(sql);

        List<Object[]> results = query.getResultList();
        List data = new ArrayList<HashMap>();

        if (!results.isEmpty()) {
            for (Object[] result : results) {
                HashMap resultMap = new HashMap();
                resultMap.put("SERVICIO", result[0]);
                resultMap.put("SERV_PERMA", result[1]);
                resultMap.put("BLOQUEADO", result[2]);
                resultMap.put("HABITACION", result[3]);
                resultMap.put("PISO", result[4]);
                resultMap.put("PERMANENCIA", result[5]);
                resultMap.put("PCN_NUMERO_HC", result[6]);
                resultMap.put("APELLIDO_PATERNO", result[7]);
                resultMap.put("APELLIDO_MATERNO", result[8]);
                resultMap.put("PRIMER_NOMBRE", result[9]);
                resultMap.put("SEGUNDO_NOMBRE", result[10]);
                resultMap.put("SEXO", result[11]);
                resultMap.put("CEDULA", result[12]);
                resultMap.put("FECHA_NACIMIENTO", result[13]);
                resultMap.put("FECHA_INGRESO", result[14]);
                resultMap.put("DIAS_HOSPITAL", result[15]);
                resultMap.put("FECHA_ALTA", result[16]);
                resultMap.put("DGN_DGN_ID", result[17]);
                resultMap.put("PCNTMP_PCNTMP_ID", result[18]);
                resultMap.put("MEDIC_TRATANTE", result[19]);
                resultMap.put("ESPECIALIDAD", result[20]);
                data.add(resultMap);

            }
        }
        return data;

    }

}
