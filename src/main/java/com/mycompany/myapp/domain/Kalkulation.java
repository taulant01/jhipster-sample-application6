package com.mycompany.myapp.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mycompany.myapp.domain.enumeration.Status;

/**
 * A Kalkulation.
 */
@Entity
@Table(name = "kalkulation")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Kalkulation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "kalk_id")
    private Integer kalkId;

    @Column(name = "version")
    private Double version;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "editing")
    private Boolean editing;

    @OneToMany(mappedBy = "kalkulation")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<KalkulationDetails> kalkulationDetails = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("kalkulations")
    private User user;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKalkId() {
        return kalkId;
    }

    public Kalkulation kalkId(Integer kalkId) {
        this.kalkId = kalkId;
        return this;
    }

    public void setKalkId(Integer kalkId) {
        this.kalkId = kalkId;
    }

    public Double getVersion() {
        return version;
    }

    public Kalkulation version(Double version) {
        this.version = version;
        return this;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public Status getStatus() {
        return status;
    }

    public Kalkulation status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean isEditing() {
        return editing;
    }

    public Kalkulation editing(Boolean editing) {
        this.editing = editing;
        return this;
    }

    public void setEditing(Boolean editing) {
        this.editing = editing;
    }

    public Set<KalkulationDetails> getKalkulationDetails() {
        return kalkulationDetails;
    }

    public Kalkulation kalkulationDetails(Set<KalkulationDetails> kalkulationDetails) {
        this.kalkulationDetails = kalkulationDetails;
        return this;
    }

    public Kalkulation addKalkulationDetails(KalkulationDetails kalkulationDetails) {
        this.kalkulationDetails.add(kalkulationDetails);
        kalkulationDetails.setKalkulation(this);
        return this;
    }

    public Kalkulation removeKalkulationDetails(KalkulationDetails kalkulationDetails) {
        this.kalkulationDetails.remove(kalkulationDetails);
        kalkulationDetails.setKalkulation(null);
        return this;
    }

    public void setKalkulationDetails(Set<KalkulationDetails> kalkulationDetails) {
        this.kalkulationDetails = kalkulationDetails;
    }

    public User getUser() {
        return user;
    }

    public Kalkulation user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Kalkulation)) {
            return false;
        }
        return id != null && id.equals(((Kalkulation) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Kalkulation{" +
            "id=" + getId() +
            ", kalkId=" + getKalkId() +
            ", version=" + getVersion() +
            ", status='" + getStatus() + "'" +
            ", editing='" + isEditing() + "'" +
            "}";
    }
}
