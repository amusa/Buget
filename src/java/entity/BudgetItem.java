/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ayemi
 */
@Entity
@Table(name = "budget_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BudgetItem.findAll", query = "SELECT b FROM BudgetItem b"),
    @NamedQuery(name = "BudgetItem.findById", query = "SELECT b FROM BudgetItem b WHERE b.id = :id"),
    @NamedQuery(name = "BudgetItem.findByDescription", query = "SELECT b FROM BudgetItem b WHERE b.description = :description")})
public class BudgetItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budgetItemId")
    private List<Budget> budgetList;
    @JoinColumn(name = "budget_class_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BudgetClass budgetClassId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budgetItemId")
    private List<ClaimDetail> claimDetailList;

    public BudgetItem() {
    }

    public BudgetItem(Integer id) {
        this.id = id;
    }

    public BudgetItem(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Budget> getBudgetList() {
        return budgetList;
    }

    public void setBudgetList(List<Budget> budgetList) {
        this.budgetList = budgetList;
    }

    public BudgetClass getBudgetClassId() {
        return budgetClassId;
    }

    public void setBudgetClassId(BudgetClass budgetClassId) {
        this.budgetClassId = budgetClassId;
    }

    @XmlTransient
    public List<ClaimDetail> getClaimDetailList() {
        return claimDetailList;
    }

    public void setClaimDetailList(List<ClaimDetail> claimDetailList) {
        this.claimDetailList = claimDetailList;
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
        if (!(object instanceof BudgetItem)) {
            return false;
        }
        BudgetItem other = (BudgetItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BudgetItem[ id=" + id + " ]";
    }

}
