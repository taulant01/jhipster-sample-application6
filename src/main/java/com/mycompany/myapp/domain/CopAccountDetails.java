package com.mycompany.myapp.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A CopAccountDetails.
 */
@Entity
@Table(name = "cop_account_details")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CopAccountDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "cop_user")
    private String copUser;

    @Column(name = "cop_password")
    private String copPassword;

    @Column(name = "cop_name")
    private String copName;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCopUser() {
        return copUser;
    }

    public CopAccountDetails copUser(String copUser) {
        this.copUser = copUser;
        return this;
    }

    public void setCopUser(String copUser) {
        this.copUser = copUser;
    }

    public String getCopPassword() {
        return copPassword;
    }

    public CopAccountDetails copPassword(String copPassword) {
        this.copPassword = copPassword;
        return this;
    }

    public void setCopPassword(String copPassword) {
        this.copPassword = copPassword;
    }

    public String getCopName() {
        return copName;
    }

    public CopAccountDetails copName(String copName) {
        this.copName = copName;
        return this;
    }

    public void setCopName(String copName) {
        this.copName = copName;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CopAccountDetails)) {
            return false;
        }
        return id != null && id.equals(((CopAccountDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CopAccountDetails{" +
            "id=" + getId() +
            ", copUser='" + getCopUser() + "'" +
            ", copPassword='" + getCopPassword() + "'" +
            ", copName='" + getCopName() + "'" +
            "}";
    }
}
