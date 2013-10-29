/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ayemi
 */
@Entity
@Table(name = "budget_summary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BudgetSummary.findAll", query = "SELECT b FROM BudgetSummary b"),
    @NamedQuery(name = "BudgetSummary.findByBudgetItemId", query = "SELECT b FROM BudgetSummary b WHERE b.budgetItemId = :budgetItemId"),
    @NamedQuery(name = "BudgetSummary.findByBudgetAmount", query = "SELECT b FROM BudgetSummary b WHERE b.budgetAmount = :budgetAmount"),
    @NamedQuery(name = "BudgetSummary.findBySpentAmount", query = "SELECT b FROM BudgetSummary b WHERE b.spentAmount = :spentAmount")})
public class BudgetSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "budget_item_id")
    @Id
    private int budgetItemId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "budgetAmount")
    private Double budgetAmount;
    @Column(name = "spentAmount")
    private Double spentAmount;

    public BudgetSummary() {
    }

    public int getBudgetItemId() {
        return budgetItemId;
    }

    public void setBudgetItemId(int budgetItemId) {
        this.budgetItemId = budgetItemId;
    }

    public Double getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(Double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public Double getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(Double spentAmount) {
        this.spentAmount = spentAmount;
    }

}
