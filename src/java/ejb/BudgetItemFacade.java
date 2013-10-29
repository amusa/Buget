/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.BudgetItem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ayemi
 */
@Stateless
public class BudgetItemFacade extends AbstractFacade<BudgetItem> {
    @PersistenceContext(unitName = "BugetPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public BudgetItemFacade() {
        super(BudgetItem.class);
    }

}
