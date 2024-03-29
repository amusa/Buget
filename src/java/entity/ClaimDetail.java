/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "claim_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClaimDetail.findAll", query = "SELECT c FROM ClaimDetail c"),
    @NamedQuery(name = "ClaimDetail.findById", query = "SELECT c FROM ClaimDetail c WHERE c.id = :id"),
    @NamedQuery(name = "ClaimDetail.findByAmount", query = "SELECT c FROM ClaimDetail c WHERE c.amount = :amount"),
    @NamedQuery(name = "ClaimDetail.findByDescription", query = "SELECT c FROM ClaimDetail c WHERE c.description = :description")})
public class ClaimDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "claim_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Claim claimId;
    @JoinColumn(name = "budget_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BudgetItem budgetItemId;

    public ClaimDetail() {
    }

    public ClaimDetail(Long id) {
        this.id = id;
    }

    public ClaimDetail(Long id, double amount, String description) {
        this.id = id;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Claim getClaimId() {
        return claimId;
    }

    public void setClaimId(Claim claimId) {
        this.claimId = claimId;
    }

    public BudgetItem getBudgetItemId() {
        return budgetItemId;
    }

    public void setBudgetItemId(BudgetItem budgetItemId) {
        this.budgetItemId = budgetItemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClaimDetail)) {
            return false;
        }
        ClaimDetail other = (ClaimDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClaimDetail[ id=" + id + " ]";
    }

}
