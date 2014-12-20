/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_asuransi")
public class AsuransiModel {

// One to One 
    @Id
    @GeneratedValue
    @Column(name = "id_asuransi")
    private int id_asuransi;

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

    @Column(name = "kd_asuransi")
    private String kd_asuransi;

    @Column(name = "usrUpdate")
    private String usrUpdate;

    @Temporal(TemporalType.DATE)
    @Column(name = "lastUpdate")
    private Date TglUpdate;
    
    @OneToMany(mappedBy = "asuransiModel")
    @JoinColumn(name = "id_asuransi")
    Set<Hdr_KerjasamaModel> hdr_kerjasama;
//private Hdr_KerjasamaModel hdr_kerjasama;

    public int getId_asuransi() {
        return id_asuransi;
    }

    public void setId_asuransi(int id_asuransi) {
        this.id_asuransi = id_asuransi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getC_person() {
        return c_person;
    }

    public void setC_person(String c_person) {
        this.c_person = c_person;
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

    public String getKd_asuransi() {
        return kd_asuransi;
    }

    public void setKd_asuransi(String kd_asuransi) {
        this.kd_asuransi = kd_asuransi;
    }

    public Set<Hdr_KerjasamaModel> getHdr_kerjasama() {
        return hdr_kerjasama;
    }

    public void setHdr_kerjasama(Set<Hdr_KerjasamaModel> hdr_kerjasama) {
        this.hdr_kerjasama = hdr_kerjasama;
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

}
