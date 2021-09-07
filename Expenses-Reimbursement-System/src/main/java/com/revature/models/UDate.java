package com.revature.models;


import java.sql.Timestamp;

/**
 * This is the model class used when the ers_reimbursement table is updated
 * when the Finance_Managers or accepts a reimbursement request
 */
public class UDate {
    Integer idReim;
    Timestamp resolved;
    Integer resolver;
    Integer status;

    public UDate() {
    }

    public UDate(Integer idReim, Timestamp resolved, Integer resolver, Integer status) {
        this.idReim = idReim;
        this.resolved = resolved;
        this.resolver = resolver;
        this.status = status;
    }

    public Integer getIdReim() {
        return idReim;
    }

    public void setIdReim(Integer idReim) {
        this.idReim = idReim;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public Integer getResolver() {
        return resolver;
    }

    public void setResolver(Integer resolver) {
        this.resolver = resolver;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UDate{" +
                "idReim=" + idReim +
                ", resolved=" + resolved +
                ", resolver=" + resolver +
                ", status=" + status +
                '}';
    }
}
