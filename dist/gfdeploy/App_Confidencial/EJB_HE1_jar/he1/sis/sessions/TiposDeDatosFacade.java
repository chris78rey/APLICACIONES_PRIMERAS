/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.sis.sessions;



import he1.odonto.sessions.AbstractFacade;
import he1.sis.entities.TiposDeDatos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luis_guanoluiza
 */
@Stateless
public class TiposDeDatosFacade extends AbstractFacade<TiposDeDatos> {
    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposDeDatosFacade() {
        super(TiposDeDatos.class);
    }
    
}
