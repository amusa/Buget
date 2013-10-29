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
@Table(name = "claim_summary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClaimSummary.findAll", query = "SELECT c FROM ClaimSummary c"),
    @NamedQuery(name = "ClaimSummary.findByBudgetItemId", query = "SELECT c FROM ClaimSummary c WHERE c.budgetItemId = :budgetItemId"),
    @NamedQuery(name = "ClaimSummary.findByAmount", query = "SELECT c FROM ClaimSummary c WHERE c.amount = :amount")})
public class ClaimSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "budget_item_id")
    @Id
    private int budgetItemId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;

    public ClaimSummary() {
    }

    public int getBudgetItemId() {
        return budgetItemId;
    }

    public void setBudgetItemId(int budgetItemId) {
        this.budgetItemId = budgetItemId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
