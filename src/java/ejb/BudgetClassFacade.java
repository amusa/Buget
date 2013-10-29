/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.BudgetClass;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ayemi
 */
@Stateless
public class BudgetClassFacade extends AbstractFacade<BudgetClass> {
    @PersistenceContext(unitName = "BugetPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public BudgetClassFacade() {
        super(BudgetClass.class);
    }

}
