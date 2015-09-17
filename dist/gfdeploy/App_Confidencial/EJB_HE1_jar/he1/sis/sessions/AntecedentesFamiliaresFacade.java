/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;

import he1.odonto.sessions.AbstractFacade;
import he1.sis.entities.AntecedentesFamiliares;
import he1.sis.entities.Pacientes;
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
public class AntecedentesFamiliaresFacade extends AbstractFacade<AntecedentesFamiliares> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AntecedentesFamiliaresFacade() {
        super(AntecedentesFamiliares.class);
    }

    public List<AntecedentesFamiliares> listAntFamByHC(Pacientes pacientes) {
        StringBuilder sb = new StringBuilder("select object(o) from AntecedentesFamiliares as o");
        sb.append(" where o.pacientes = :pacientes ORDER BY o.antecedentesFamiliaresPK.fecha DESC");
        Query q = em.createQuery(sb.toString());
        q.setParameter("pacientes", pacientes);
        q.setHint("eclipselink.refresh", true);
        return q.getResultList();
    }

    public List<AntecedentesFamiliares> findByHcFecha(String cadena) {
        Query query = em.createNativeQuery(cadena, AntecedentesFamiliares.class);
        List<AntecedentesFamiliares> result = query.getResultList();
        if (result.isEmpty()) {
            return null;
        }
        return result;

    }
}
