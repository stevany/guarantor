/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author user
 */
@Entity
@Table(name = "tblHdr_Kerjasama")
public class Hdr_KerjasamaModel {
@Id
@GeneratedValue
@Column(name = "id_kerjaSama")
private int id_kerjasama;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "id_Asuransi")
private AsuransiModel asuransiModel;


@Column(name = "keterangan")
private String keterangan;

@Temporal(TemporalType.DATE)
@Column(name = "tglMulai")
private Date tglMulai;

@Temporal(TemporalType.DATE)
@Column(name = "tglSelesai")
private Date tglSelesai;

@Column(name = "UsrUpdate")
private String usrUpdate;

@Temporal(TemporalType.DATE)
@Column(name = "tglUpdate")
private Date tglUpdate;

@Column(name = "aktif")
private int aktif;

@Column(name = "syarat")
private String syarat;

@Column(name="pengecualian")
private String pengecualian;

//@OneToMany(cascade = {CascadeType.ALL})
@OneToMany(mappedBy="hdr_kerjasama")  
@JoinColumn(name = "id_kerjaSama")
Set<Dtl_KerjasamaModel> dtl_kerjasama;

    public int getId_kerjasama() {
        return id_kerjasama;
    }

    public void setId_kerjasama(int id_kerjasama) {
        this.id_kerjasama = id_kerjasama;
    }

    public AsuransiModel getAsuransiModel() {
        return asuransiModel;
    }

    public void setAsuransiModel(AsuransiModel asuransiModel) {
        this.asuransiModel = asuransiModel;
    }

  
    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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

    public String getUsrUpdate() {
        return usrUpdate;
    }

    public void setUsrUpdate(String usrUpdate) {
        this.usrUpdate = usrUpdate;
    }

    public Date getTglUpdate() {
        return tglUpdate;
    }

    public void setTglUpdate(Date tglUpdate) {
        this.tglUpdate = tglUpdate;
    }

    public int getAktif() {
        return aktif;
    }

    public void setAktif(int aktif) {
        this.aktif = aktif;
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
    
    public Set<Dtl_KerjasamaModel> getDtl_kerjasama() {
        return dtl_kerjasama;
    }

    public void setDtl_kerjasama(Set<Dtl_KerjasamaModel> dtl_kerjasama) {
        this.dtl_kerjasama = dtl_kerjasama;
    }




}




