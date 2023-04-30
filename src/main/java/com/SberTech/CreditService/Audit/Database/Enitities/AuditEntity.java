package com.SberTech.CreditService.Audit.Database.Enitities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "entity")
public class AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String primaryKey;
    @Enumerated(EnumType.ORDINAL)
    private StateType mode;
    @Column(length = 65555)
    private String fullVersion;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "entity_id")
    private List<com.SberTech.CreditService.Audit.Database.Enitities.Version> versions;
    public AuditEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public StateType getMode() {
        return mode;
    }

    public void setMode(StateType mode) {
        this.mode = mode;
    }

    public List<com.SberTech.CreditService.Audit.Database.Enitities.Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    public String getFullVersion() {
        return fullVersion;
    }

    public void setFullVersion(String fullVersion) {
        this.fullVersion = fullVersion;
    }
}
