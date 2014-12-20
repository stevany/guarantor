/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_perusahaan")
public class PerusahaanModel implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_perusahaan")
    private int id_perusahaan;

    @Column(name = "nama")
    private String nama;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "kota")
    private String kota;

    @Column(name = "email")
    private String email;

    @Column(name = "c_person")
    private String c_person;

    @Column(name = "telp1")
    private String telp1;

    @Column(name = "telp2")
    private String telp2;

    @Column(name = "fax1")
    private String fax1;

    @Column(name = "fax2")
    private String fax2;

    @Column(name = "kd_perusahaan")
    private String kd_perusahaan;
    
    @Column(name = "usrUpdate")
    private String usrUpdate;

    @Temporal(TemporalType.DATE)
    @Column(name = "lastUpdate")
    private Date TglUpdate;
    
    @OneToMany(mappedBy = "perusahaanModel")
    @JoinColumn(name = "id_perusahaan")
    Set<Dtl_KerjasamaModel> dtl_kerjasama;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getC_person() {
        return c_person;
    }

    public void setC_person(String c_person) {
        this.c_person = c_person;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax1() {
        return fax1;
    }

    public void setFax1(String fax1) {
        this.fax1 = fax1;
    }

    public String getFax2() {
        return fax2;
    }

    public void setFax2(String fax2) {
        this.fax2 = fax2;
    }

    public int getId_perusahaan() {
        return id_perusahaan;
    }

    public void setId_perusahaan(int id_perusahaan) {
        this.id_perusahaan = id_perusahaan;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelp1() {
        return telp1;
    }

    public void setTelp1(String telp1) {
        this.telp1 = telp1;
    }

    public String getTelp2() {
        return telp2;
    }

    public void setTelp2(String telp2) {
        this.telp2 = telp2;
    }

    public String getKd_perusahaan() {
        return kd_perusahaan;
    }

    public void setKd_perusahaan(String kd_perusahaan) {
        this.kd_perusahaan = kd_perusahaan;
    }

    public String getUsrUpdate() {
        return usrUpdate;
    }

    public void setUsrUpdate(String usrUpdate) {
        this.usrUpdate = usrUpdate;
    }

    public Date getTglUpdate() {
        return TglUpdate;
    }

    public void setTglUpdate(Date TglUpdate) {
        this.TglUpdate = TglUpdate;
    }
    
    public Set<Dtl_KerjasamaModel> getDtl_kerjasama() {
        return dtl_kerjasama;
    }

    public void setDtl_kerjasama(Set<Dtl_KerjasamaModel> dtl_kerjasama) {
        this.dtl_kerjasama = dtl_kerjasama;
    }

}
