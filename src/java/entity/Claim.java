/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ayemi
 */
@Entity
@Table(name = "claim")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Claim.findAll", query = "SELECT c FROM Claim c"),
    @NamedQuery(name = "Claim.findById", query = "SELECT c FROM Claim c WHERE c.id = :id"),
    @NamedQuery(name = "Claim.findByClaimDate", query = "SELECT c FROM Claim c WHERE c.claimDate = :claimDate"),
    @NamedQuery(name = "Claim.findByPurpose", query = "SELECT c FROM Claim c WHERE c.purpose = :purpose"),
    @NamedQuery(name = "Claim.findByPosted", query = "SELECT c FROM Claim c WHERE c.posted = :posted"),
    @NamedQuery(name = "Claim.findByPostedDate", query = "SELECT c FROM Claim c WHERE c.postedDate = :postedDate")})
public class Claim implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "claim_date")
    @Temporal(TemporalType.DATE)
    private Date claimDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "purpose")
    private String purpose;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posted")
    private boolean posted;
    @Column(name = "posted_date")
    @Temporal(TemporalType.DATE)
    private Date postedDate;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "claimId")
    private List<ClaimDetail> claimDetailList;

    public Claim() {
    }

    public Claim(Long id) {
        this.id = id;
    }

    public Claim(Long id, Date claimDate, String purpose, boolean posted) {
        this.id = id;
        this.claimDate = claimDate;
        this.purpose = purpose;
        this.posted = posted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public boolean getPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof Claim)) {
            return false;
        }
        Claim other = (Claim) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Claim[ id=" + id + " ]";
    }

}
