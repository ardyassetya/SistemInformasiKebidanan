/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Ardyas Setya Nugraha
 */

public class RujukanMDL {
    private int id_rujukan;
    private String rs_rujukan;
    private String alamat_rs;
    private Date tgl_rujukan;
    private String tindakan;

    public int getId_rujukan() {
        return id_rujukan;
    }

    public void setId_rujukan(int id_rujukan) {
        this.id_rujukan = id_rujukan;
    }

    public String getRs_rujukan() {
        return rs_rujukan;
    }

    public void setRs_rujukan(String rs_rujukan) {
        this.rs_rujukan = rs_rujukan;
    }

    public String getAlamat_rs() {
        return alamat_rs;
    }

    public void setAlamat_rs(String alamat_rs) {
        this.alamat_rs = alamat_rs;
    }

    public Date getTgl_rujukan() {
        return tgl_rujukan;
    }

    public void setTgl_rujukan(Date tgl_rujukan) {
        this.tgl_rujukan = tgl_rujukan;
    }

    public String getTindakan() {
        return tindakan;
    }

    public void setTindakan(String tindakan) {
        this.tindakan = tindakan;
    }
 
}

