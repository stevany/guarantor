/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity

public class ViewHdrModel {
    @Id
    private int id_kerjasama;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tglMulai;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date tglSelesai;
    private String asuransiModel;
    private String keterangan;
    private String syarat;
    private String pengecualian;
    private Boolean aktif;

    public int getId_kerjasama() {
        return id_kerjasama;
    }

    public void setId_kerjasama(int id_kerjasama) {
        this.id_kerjasama = id_kerjasama;
    }

   
    public Date getTglMulai() {
        return tglMulai;
    }

    public void setTglMulai(Date tglMulai) {
        this.tglMulai = tglMulai;
    }

    public Date getTglSelesai() {
        return tglSelesai;
    }

    public void setTglSelesai(Date tglSelesai) {
        this.tglSelesai = tglSelesai;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getSyarat() {
        return syarat;
    }

    public void setSyarat(String syarat) {
        this.syarat = syarat;
    }

    public String getPengecualian() {
        return pengecualian;
    }

    public void setPengecualian(String pengecualian) {
        this.pengecualian = pengecualian;
    }

    public Boolean getAktif() {
        return aktif;
    }

    public void setAktif(Boolean aktif) {
        this.aktif = aktif;
    }

    public String getAsuransiModel() {
        return asuransiModel;
    }

    public void setAsuransiModel(String asuransiModel) {
        this.asuransiModel = asuransiModel;
    }
    
    
}
