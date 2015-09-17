/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.uci.sessions;


import he1.sis.entities.Pacientes;
import he1.uci.entities.UOpcionPaciente;
import he1.uci.entities.UUciMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class UOpcionPacienteFacade extends AbstractFacade<UOpcionPaciente> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UOpcionPacienteFacade() {
        super(UOpcionPaciente.class);
    }

    public List<UOpcionPaciente> listHorario(Pacientes paciente, UUciMenu uciMenu) {
        StringBuilder sb = new StringBuilder("SELECT object(o) FROM UOpcionPaciente o ");
        sb.append(" WHERE o.pacientes = :paciente AND o.uUciMenu = :uciMenu ORDER BY o.oppFecha");
        Query q = em.createQuery(sb.toString());
        q.setParameter("paciente", paciente);
        q.setParameter("uciMenu", uciMenu);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }

    public String findRegActual(BigDecimal uci,Pacientes paciente) {
        BigDecimal cont;
        cont = (BigDecimal) em.createNativeQuery("select count(*) from U_OPCION_PACIENTE WHERE UCI_ID = ? AND PCN_NUMERO_HC = ? AND trunc(OPP_FECHA) = trunc(sysdate)").setParameter(1, uci).setParameter(2, paciente.getNumeroHc()).getSingleResult();
        if (cont.equals(BigDecimal.ZERO)) {
            return "0";
        } else {
            return "1";
        }
    }
    
    public String nroHojaPaciente(Pacientes paciente){
        int i;
        Query q = em.createNativeQuery("SELECT trunc(OPP_FECHA) FROM UCI.U_OPCION_PACIENTE WHERE PCN_NUMERO_HC = ? GROUP BY trunc(OPP_FECHA)");
         q.setParameter(1, paciente.getNumeroHc());
         List<UOpcionPaciente> l = q.getResultList();
         if(l.isEmpty()){
           i = 0;  
         }else{
             i= l.size();
         }
         return String.valueOf(i);
    }

    public BigDecimal maxRegId() {
        return (BigDecimal) em.createQuery("select max(o.oppId) from UOpcionPaciente o").setHint("eclipselink.refresh", true).getSingleResult();
    }
    
    public BigDecimal maxRegIdHc(Pacientes paciente, UUciMenu uciMenu) {
        return (BigDecimal) em.createQuery("select max(o.oppId) from UOpcionPaciente o WHERE o.pacientes = :paciente AND o.uUciMenu = :uciMenu").setParameter("paciente", paciente).setParameter("uciMenu", uciMenu).setHint("eclipselink.refresh", true).getSingleResult();
    }
     public BigDecimal minRegIdHc(Pacientes paciente, UUciMenu uciMenu) {
        return (BigDecimal) em.createQuery("select min(o.oppId) from UOpcionPaciente o WHERE o.pacientes = :paciente AND o.uUciMenu = :uciMenu").setParameter("paciente", paciente).setParameter("uciMenu", uciMenu).setHint("eclipselink.refresh", true).getSingleResult();
    }
    
    public BigDecimal balanceAcum(Pacientes paciente, UUciMenu uciMenu){
      return (BigDecimal) em.createQuery("select sum(o.) from UOpcionPaciente o WHERE o.pacientes = :paciente AND o.uUciMenu = :uciMenu").setParameter("paciente", paciente).setParameter("uciMenu", uciMenu).setHint("eclipselink.refresh", true).getSingleResult();  
    }
    
    public UOpcionPaciente findOpcPacId(BigDecimal oppId){
        Query q = em.createQuery("SELECT u FROM UOpcionPaciente u WHERE u.oppId = :oppId");
        q.setParameter("oppId", oppId);
        q.setHint("eclipselink.refresh", true);
        List<UOpcionPaciente> l = q.getResultList();
        if (!l.isEmpty()) {
            return (UOpcionPaciente) l.get(0);
        } else {
            return null;
        }
        
    }
}
