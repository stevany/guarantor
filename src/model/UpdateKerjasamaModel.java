/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "tbl_updateKerjaSama")
public class UpdateKerjasamaModel {

    @Id
    @GeneratedValue
    private int urut;
    private String nama;
    private String keterangan;
    private String usrUpdate;
    private String tglUpdate;
    private Boolean muncul;

    public int getUrut() {
        return urut;
    }

    public void setUrut(int urut) {
        this.urut = urut;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getUsrUpdate() {
        return usrUpdate;
    }

    public void setUsrUpdate(String usrUpdate) {
        this.usrUpdate = usrUpdate;
    }

    public Boolean getMuncul() {
        return muncul;
    }

    public void setMuncul(Boolean muncul) {
        this.muncul = muncul;
    }

    public String getTglUpdate() {
        return tglUpdate;
    }

    public void setTglUpdate(String tglUpdate) {
        this.tglUpdate = tglUpdate;
    }
}
