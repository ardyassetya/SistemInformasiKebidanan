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
public class Bidan {
    private String STR;
    private String email_bidan;
    private String password_bidan;
    private String nama_bidan;
    private String tempatlahir_bdn;
    private Date tgllahir_bdn;
    private String telp_bdn;
    private String alamat_bdn;

    public String getSTR() {
        return STR;
    }

    public void setSTR(String STR) {
        this.STR = STR;
    }

    public String getEmail_bidan() {
        return email_bidan;
    }

    public void setEmail_bidan(String email_bidan) {
        this.email_bidan = email_bidan;
    }

    public String getPassword_bidan() {
        return password_bidan;
    }

    public void setPassword_bidan(String password_bidan) {
        this.password_bidan = password_bidan;
    }

    public String getNama_bidan() {
        return nama_bidan;
    }

    public void setNama_bidan(String nama_bidan) {
        this.nama_bidan = nama_bidan;
    }

    public String getTempatlahir_bdn() {
        return tempatlahir_bdn;
    }

    public void setTempatlahir_bdn(String tembatlahir_bdn) {
        this.tempatlahir_bdn = tembatlahir_bdn;
    }

    public Date getTgllahir_bdn() {
        return tgllahir_bdn;
    }

    public void setTgllahir_bdn(Date tgllahir_bdn) {
        this.tgllahir_bdn = tgllahir_bdn;
    }

    public String getTelp_bdn() {
        return telp_bdn;
    }

    public void setTelp_bdn(String telp_bdn) {
        this.telp_bdn = telp_bdn;
    }

    public String getAlamat_bdn() {
        return alamat_bdn;
    }

    public void setAlamat_bdn(String alamat_bdn) {
        this.alamat_bdn = alamat_bdn;
    }

}
