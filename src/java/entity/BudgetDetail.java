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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ayemi
 */
@Entity
@Table(name = "budget_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BudgetDetail.findAll", query = "SELECT b FROM BudgetDetail b"),
    @NamedQuery(name = "BudgetDetail.findById", query = "SELECT b FROM BudgetDetail b WHERE b.id = :id"),
    @NamedQuery(name = "BudgetDetail.findByDescription", query = "SELECT b FROM BudgetDetail b WHERE b.description = :description"),
    @NamedQuery(name = "BudgetDetail.findByBudgetAmount", query = "SELECT b FROM BudgetDetail b WHERE b.budgetAmount = :budgetAmount"),
    @NamedQuery(name = "BudgetDetail.findBySpentAmount", query = "SELECT b FROM BudgetDetail b WHERE b.spentAmount = :spentAmount")})
public class BudgetDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @Id
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "budgetAmount")
    private Double budgetAmount;
    @Column(name = "spentAmount")
    private Double spentAmount;

    public BudgetDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
