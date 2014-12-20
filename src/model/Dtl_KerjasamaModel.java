/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tblDtl_KerjaSama")
public class Dtl_KerjasamaModel {
    @Id
    @GeneratedValue
    @Column(name = "id_kerjaSamaDetil")
    private int id_kerjaSamaDetil;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_perusahaan")
    private PerusahaanModel perusahaanModel;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "TglMulai")
    private Date TglMulai;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "TglSelesai")
    private Date TglSelesai;
    
    @Column(name = "excess_b")
    private int excess_b;
    
    @Column(name = "excess_s")
    private String excess_s;
    
    @Column(name = "vitamin_b")
    private int vitamin_b;
    
    @Column(name = "vitamin_s")
    private String vitamin_s;
    
    @Column(name = "supplemen_b")
    private int supplemen_b;
    
    @Column(name = "supplemen_s")
    private String supplemen_s;
    
    @Column(name = "ri_b")
    private int ri_b;
    
    @Column(name = "ri_s")
    private String ri_s;
    
    @Column(name = "rj_b")
    private int rj_b;
    
    @Column(name="rj_s")
    private String rj_s;
    
    @Column(name = "melahirkan_b")
    private int melahirkan_b;
    
    @Column(name = "melahirkan_s")
    private String melahirkan_s;
    
    @Column(name = "rg_b")
    private int rg_b;
    
    @Column(name = "rg_s")
    private String rg_s;
    
    @Column(name = "maternity_b")
    private int maternity_b;
    
    @Column(name = "maternity_s")
    private String maternity_s;
    
    @Column(name = "mcu_b")
    private int mcu_b;
    
    @Column(name = "mcu_s")
    private String mcu_s;
    
    @Column(name = "ket")
    private String ket;
    
    @Column(name = "usrUpdate")
    private String usrUpdate;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "TglUpdate")
    private Date TglUpdate;
    
    @Column(name = "aktif")
    private Boolean aktif;
    
    @Column(name = "syarat")
    private String syarat;
    
    @Column(name="pengecualian")
    private String pengecualian;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_kerjaSama")
    private Hdr_KerjasamaModel hdr_kerjasama;

    public int getId_kerjaSamaDetil() {
        return id_kerjaSamaDetil;
    }

    public void setId_kerjaSamaDetil(int id_kerjaSamaDetil) {
        this.id_kerjaSamaDetil = id_kerjaSamaDetil;
    }

    public PerusahaanModel getPerusahaanModel() {
        return perusahaanModel;
    }

    public void setPerusahaanModel(PerusahaanModel perusahaanModel) {
        this.perusahaanModel = perusahaanModel;
    }

   
    public Date getTglMulai() {
        return TglMulai;
    }

    public void setTglMulai(Date TglMulai) {
        this.TglMulai = TglMulai;
    }

    public Date getTglSelesai() {
        return TglSelesai;
    }

    public void setTglSelesai(Date TglSelesai) {
        this.TglSelesai = TglSelesai;
    }

    public int getExcess_b() {
        return excess_b;
    }

    public void setExcess_b(int excess_b) {
        this.excess_b = excess_b;
    }

    public String getExcess_s() {
        return excess_s;
    }

    public void setExcess_s(String excess_s) {
        this.excess_s = excess_s;
    }

    public int getVitamin_b() {
        return vitamin_b;
    }

    public void setVitamin_b(int vitamin_b) {
        this.vitamin_b = vitamin_b;
    }

    public String getVitamin_s() {
        return vitamin_s;
    }

    public void setVitamin_s(String vitamin_s) {
        this.vitamin_s = vitamin_s;
    }

    public int getSupplemen_b() {
        return supplemen_b;
    }

    public void setSupplemen_b(int supplemen_b) {
        this.supplemen_b = supplemen_b;
    }

    public String getSupplemen_s() {
        return supplemen_s;
    }

    public void setSupplemen_s(String supplemen_s) {
        this.supplemen_s = supplemen_s;
    }

    public int getRi_b() {
        return ri_b;
    }

    public void setRi_b(int ri_b) {
        this.ri_b = ri_b;
    }

    public String getRi_s() {
        return ri_s;
    }

    public void setRi_s(String ri_s) {
        this.ri_s = ri_s;
    }

    public int getRj_b() {
        return rj_b;
    }

    public void setRj_b(int rj_b) {
        this.rj_b = rj_b;
    }

    public String getRj_s() {
        return rj_s;
    }

    public void setRj_s(String rj_s) {
        this.rj_s = rj_s;
    }

    public int getMelahirkan_b() {
        return melahirkan_b;
    }

    public void setMelahirkan_b(int melahirkan_b) {
        this.melahirkan_b = melahirkan_b;
    }

    public String getMelahirkan_s() {
        return melahirkan_s;
    }

    public void setMelahirkan_s(String melahirkan_s) {
        this.melahirkan_s = melahirkan_s;
    }

    public int getRg_b() {
        return rg_b;
    }

    public void setRg_b(int rg_b) {
        this.rg_b = rg_b;
    }

    public String getRg_s() {
        return rg_s;
    }

    public void setRg_s(String rg_s) {
        this.rg_s = rg_s;
    }

    public int getMaternity_b() {
        return maternity_b;
    }

    public void setMaternity_b(int maternity_b) {
        this.maternity_b = maternity_b;
    }

    public String getMaternity_s() {
        return maternity_s;
    }

    public void setMaternity_s(String maternity_s) {
        this.maternity_s = maternity_s;
    }

    public int getMcu_b() {
        return mcu_b;
    }

    public void setMcu_b(int mcu_b) {
        this.mcu_b = mcu_b;
    }

    public String getMcu_s() {
        return mcu_s;
    }

    public void setMcu_s(String mcu_s) {
        this.mcu_s = mcu_s;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
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

    public Boolean getAktif() {
        return aktif;
    }

    public void setAktif(Boolean aktif) {
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
    
    public Hdr_KerjasamaModel getHdr_kerjasama() {
        return hdr_kerjasama;
    }

    public void setHdr_kerjasama(Hdr_KerjasamaModel hdr_kerjasama) {
        this.hdr_kerjasama = hdr_kerjasama;
    }
    


   
  

   
    

  
    

  
  
  

   
  
   
    
}
