/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falpema.codes.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author falpema
 */
@Entity
@Table(name = "TBLSG_HORARIO")
public class TblsgHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblsgHorarioPK tblsgHorarioPK;
    @Column(name = "HH24_INI")
    private String hh24Ini;
    @Column(name = "HH24_FIN")
    private String hh24Fin;

    public TblsgHorario() {
    }

    public TblsgHorario(TblsgHorarioPK tblsgHorarioPK) {
        this.tblsgHorarioPK = tblsgHorarioPK;
    }

    public TblsgHorario(long numeroProceso, short numeroLinea) {
        this.tblsgHorarioPK = new TblsgHorarioPK(numeroProceso, numeroLinea);
    }

    public TblsgHorarioPK getTblsgHorarioPK() {
        return tblsgHorarioPK;
    }

    public void setTblsgHorarioPK(TblsgHorarioPK tblsgHorarioPK) {
        this.tblsgHorarioPK = tblsgHorarioPK;
    }

    public String getHh24Ini() {
        return hh24Ini;
    }

    public void setHh24Ini(String hh24Ini) {
        this.hh24Ini = hh24Ini;
    }

    public String getHh24Fin() {
        return hh24Fin;
    }

    public void setHh24Fin(String hh24Fin) {
        this.hh24Fin = hh24Fin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblsgHorarioPK != null ? tblsgHorarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblsgHorario)) {
            return false;
        }
        TblsgHorario other = (TblsgHorario) object;
        if ((this.tblsgHorarioPK == null && other.tblsgHorarioPK != null) || (this.tblsgHorarioPK != null && !this.tblsgHorarioPK.equals(other.tblsgHorarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CODES.TblsgHorario[ tblsgHorarioPK=" + tblsgHorarioPK + " ]";
    }
    
}
