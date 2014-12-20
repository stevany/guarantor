/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "tbl_userId")
public class UserModel {
    @Id
    @Column(name = "userid")
    private String userid;
    
    @Column(name = "nama")
    private String nama;
    
    @Column(name = "pass")
    private String pass;
    @Column(name="otorisasi")
    private Boolean otorisasi;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Boolean getOtorisasi() {
        return otorisasi;
    }

    public void setOtorisasi(Boolean otorisasi) {
        this.otorisasi = otorisasi;
    }
    
    
}   
