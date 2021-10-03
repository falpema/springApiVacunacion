/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falpema.codes.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author falpema
 */
@Embeddable
public class TblsgHorarioPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "NUMERO_PROCESO")
    private long numeroProceso;
    @Basic(optional = false)
    @Column(name = "NUMERO_LINEA")
    private short numeroLinea;

    public TblsgHorarioPK() {
    }

    public TblsgHorarioPK(long numeroProceso, short numeroLinea) {
        this.numeroProceso = numeroProceso;
        this.numeroLinea = numeroLinea;
    }

    public long getNumeroProceso() {
        return numeroProceso;
    }

    public void setNumeroProceso(long numeroProceso) {
        this.numeroProceso = numeroProceso;
    }

    public short getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(short numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeroProceso;
        hash += (int) numeroLinea;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblsgHorarioPK)) {
            return false;
        }
        TblsgHorarioPK other = (TblsgHorarioPK) object;
        if (this.numeroProceso != other.numeroProceso) {
            return false;
        }
        if (this.numeroLinea != other.numeroLinea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CODES.TblsgHorarioPK[ numeroProceso=" + numeroProceso + ", numeroLinea=" + numeroLinea + " ]";
    }
    
}
