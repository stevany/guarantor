/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author edepe7
 */

@Entity
public class ReportKerjasamaModel implements Serializable {
    
    @Id
//    @GeneratedValue
    private Integer Id_kerjaSama;
    
    @Temporal(TemporalType.DATE)
    private  Date TglMulaiAsuransi ;
    
    @Temporal(TemporalType.DATE)
    private Date TglSelesaiAsuransi;            
    private  String keterangan;   
    private String namaAsuransi; 
    private String namaPerusahaan;
    private String pengecualian_hdr;
    private String pengecualian_dtl;

    @Temporal(TemporalType.DATE)
    private Date tglMulaiPerusahaan;
    
    @Temporal(TemporalType.DATE)
    private Date tglSelesaiPerusahaan;
    
    private Boolean excess_b;   
    private String excess_s; 
    
    private Boolean vitamin_b;    
    private String vitamin_s;   
    
    private Boolean supplemen_b;  
    private String supplemen_s;
    
    private Boolean rj_b; 
    private String rj_s;
    
    private Boolean ri_b;    
    private String ri_s;
    
    private Boolean rg_b;   
    private String rg_s;
    
    private Boolean melahirkan_b;  
    private String melahirkan_s;
    
    private Boolean maternity_b;    
    private String maternity_s;
    
    private Boolean mcu_b;   
    private String mcu_s;
    
    private Boolean aktif_detil;
    private Boolean aktif_hdr;
    
    private String syarat_hdr;
    private String syarat_dt;
    private String ket_dt;

    public String getSyarat_dt() {
        return syarat_dt;
    }

    public void setSyarat_dt(String syarat_dt) {
        this.syarat_dt = syarat_dt;
    }

    public String getKet_dt() {
        return ket_dt;
    }

    public void setKet_dt(String ket_dt) {
        this.ket_dt = ket_dt;
    }
    

    public String getSyarat_hdr() {
        return syarat_hdr;
    }

    public void setSyarat_hdr(String syarat_hdr) {
        this.syarat_hdr = syarat_hdr;
    }

    
    
    public Boolean getAktif_hdr() {
        return aktif_hdr;
    }

    public void setAktif_hdr(Boolean aktif_hdr) {
        this.aktif_hdr = aktif_hdr;
    }

    public Boolean getRi_b() {
        return ri_b;
    }

    public void setRi_b(Boolean ri_b) {
        this.ri_b = ri_b;
    }

    public String getRi_s() {
        return ri_s;
    }

    public void setRi_s(String ri_s) {
        this.ri_s = ri_s;
    }

    public Boolean getRg_b() {
        return rg_b;
    }

    public void setRg_b(Boolean rg_b) {
        this.rg_b = rg_b;
    }

    public String getRg_s() {
        return rg_s;
    }

    public void setRg_s(String rg_s) {
        this.rg_s = rg_s;
    }

    public Boolean getMelahirkan_b() {
        return melahirkan_b;
    }

    public void setMelahirkan_b(Boolean melahirkan_b) {
        this.melahirkan_b = melahirkan_b;
    }

    public String getMelahirkan_s() {
        return melahirkan_s;
    }

    public void setMelahirkan_s(String melahirkan_s) {
        this.melahirkan_s = melahirkan_s;
    }

    public Boolean getMaternity_b() {
        return maternity_b;
    }

    public void setMaternity_b(Boolean maternity_b) {
        this.maternity_b = maternity_b;
    }

    public String getMaternity_s() {
        return maternity_s;
    }

    public void setMaternity_s(String maternity_s) {
        this.maternity_s = maternity_s;
    }

    public Boolean getMcu_b() {
        return mcu_b;
    }

    public void setMcu_b(Boolean mcu_b) {
        this.mcu_b = mcu_b;
    }

    public String getMcu_s() {
        return mcu_s;
    }

    public void setMcu_s(String mcu_s) {
        this.mcu_s = mcu_s;
    }

    public Boolean getAktif_detil() {
        return aktif_detil;
    }

    public void setAktif_detil(Boolean aktif_detil) {
        this.aktif_detil = aktif_detil;
    }

    public Integer getId_kerjaSama() {
        return Id_kerjaSama;
    }

    public void setId_kerjaSama(Integer Id_kerjaSama) {
        this.Id_kerjaSama = Id_kerjaSama;
    }

    public Date getTglMulaiAsuransi() {
        return TglMulaiAsuransi;
    }

    public void setTglMulaiAsuransi(Date TglMulaiAsuransi) {
        this.TglMulaiAsuransi = TglMulaiAsuransi;
    }

    public Date getTglSelesaiAsuransi() {
        return TglSelesaiAsuransi;
    }

    public void setTglSelesaiAsuransi(Date TglSelesaiAsuransi) {
        this.TglSelesaiAsuransi = TglSelesaiAsuransi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNamaAsuransi() {
        return namaAsuransi;
    }

    public void setNamaAsuransi(String namaAsuransi) {
        this.namaAsuransi = namaAsuransi;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public Date getTglMulaiPerusahaan() {
        return tglMulaiPerusahaan;
    }

    public void setTglMulaiPerusahaan(Date tglMulaiPerusahaan) {
        this.tglMulaiPerusahaan = tglMulaiPerusahaan;
    }

    public Date getTglSelesaiPerusahaan() {
        return tglSelesaiPerusahaan;
    }

    public void setTglSelesaiPerusahaan(Date tglSelesaiPerusahaan) {
        this.tglSelesaiPerusahaan = tglSelesaiPerusahaan;
    }

    public Boolean getExcess_b() {
        return excess_b;
    }

    public void setExcess_b(Boolean excess_b) {
        this.excess_b = excess_b;
    }

    public String getExcess_s() {
        return excess_s;
    }

    public void setExcess_s(String excess_s) {
        this.excess_s = excess_s;
    }

    public Boolean getVitamin_b() {
        return vitamin_b;
    }

    public void setVitamin_b(Boolean vitamin_b) {
        this.vitamin_b = vitamin_b;
    }

    public String getVitamin_s() {
        return vitamin_s;
    }

    public void setVitamin_s(String vitamin_s) {
        this.vitamin_s = vitamin_s;
    }

    public Boolean getSupplemen_b() {
        return supplemen_b;
    }

    public void setSupplemen_b(Boolean supplemen_b) {
        this.supplemen_b = supplemen_b;
    }

    public String getSupplemen_s() {
        return supplemen_s;
    }

    public void setSupplemen_s(String supplemen_s) {
        this.supplemen_s = supplemen_s;
    }

    public Boolean getRj_b() {
        return rj_b;
    }

    public void setRj_b(Boolean rj_b) {
        this.rj_b = rj_b;
    }

    public String getRj_s() {
        return rj_s;
    }

    public void setRj_s(String rj_s) {
        this.rj_s = rj_s;
    }

    public String getPengecualian_hdr() {
        return pengecualian_hdr;
    }

    public void setPengecualian_hdr(String pengecualian_hdr) {
        this.pengecualian_hdr = pengecualian_hdr;
    }

    public String getPengecualian_dtl() {
        return pengecualian_dtl;
    }

    public void setPengecualian_dtl(String pengecualian_dtl) {
        this.pengecualian_dtl = pengecualian_dtl;
    }

   
    
    
    
    
    
}
