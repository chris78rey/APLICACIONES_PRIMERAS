/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package he1.seguridades.sessions;

import he1.seguridades.entities.nuevos.PersonalNomina;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author christian_ruiz
 */
@Stateless
public class PersonalNominaFacade extends AbstractFacade<PersonalNomina> {

    @PersistenceContext(unitName = "EJB_HE1PU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonalNominaFacade() {
        super(PersonalNomina.class);
    }

    public PersonalNomina findByPrnNumdocumento(String cedula) {
        return (PersonalNomina) em.createQuery(
                "SELECT p FROM PersonalNomina p WHERE p.prnNumdocumento = :prnNumdocumento")
                .setParameter("prnNumdocumento", cedula)
                .getSingleResult();
    }

}
