package com.vfedotov.dao_layer.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "AuditRecords")
public class AuditRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Date")
    private Date date;

    @Column(name = "AccountId")
    private long accountId;

    @Column(name = "HaveAccess")
    private boolean haveAccess;

    @Column(name = "RequestParameters")
    private String requestParameters;

    @Column(name = "RequestType")
    private String requestType;

    @Column(name = "Request entity")
    private String requestEntity;

    public AuditRecord() {
    }

    public Long getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public long getAccountId() {
        return this.accountId;
    }

    public boolean isHaveAccess() {
        return this.haveAccess;
    }

    public String getRequestParameters() {
        return this.requestParameters;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public String getRequestEntity() {
        return this.requestEntity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public void setHaveAccess(boolean haveAccess) {
        this.haveAccess = haveAccess;
    }

    public void setRequestParameters(String requestParameters) {
        this.requestParameters = requestParameters;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public void setRequestEntity(String requestEntity) {
        this.requestEntity = requestEntity;
    }
}
