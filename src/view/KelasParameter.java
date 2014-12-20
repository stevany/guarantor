
package view;


public class KelasParameter {
private String idAsuransi, kdAsuransi, nmAsuransi, idPerusahaan, kdPerusahaan, nmPerusahaan, idHdr, idDtl, user, kodeTabel, pengecualianHdr, pengecualianDtl;
private Boolean tambahHdr = false , tambahDtl = false, otorisasi=false, hdr=false, dtl=false, tampil = true;
private KerjaSama kerjasama;

    public String getIdAsuransi() {
        return idAsuransi;
    }

    public void setIdAsuransi(String idAsuransi) {
        this.idAsuransi = idAsuransi;
    }

    public String getIdPerusahaan() {
        return idPerusahaan;
    }

    public void setIdPerusahaan(String idPerusahaan) {
        this.idPerusahaan = idPerusahaan;
    }

    public Boolean getTambahHdr() {
        return tambahHdr;
    }

    public void setTambahHdr(Boolean tambahHdr) {
        this.tambahHdr = tambahHdr;
    }

    public Boolean getTambahDtl() {
        return tambahDtl;
    }

    public void setTambahDtl(Boolean tambahDtl) {
        this.tambahDtl = tambahDtl;
    }

    public String getIdHdr() {
        return idHdr;
    }

    public void setIdHdr(String idHdr) {
        this.idHdr = idHdr;
    }

    public String getIdDtl() {
        return idDtl;
    }

    public void setIdDtl(String idDtl) {
        this.idDtl = idDtl;
    }

    public KerjaSama getKerjasama() {
        return kerjasama;
    }

    public void setKerjasama(KerjaSama kerjasama) {
        this.kerjasama = kerjasama;
    }

    public String getNmAsuransi() {
        return nmAsuransi;
    }

    public void setNmAsuransi(String nmAsuransi) {
        this.nmAsuransi = nmAsuransi;
    }

    public String getNmPerusahaan() {
        return nmPerusahaan;
    }

    public void setNmPerusahaan(String nmPerusahaan) {
        this.nmPerusahaan = nmPerusahaan;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getKodeTabel() {
        return kodeTabel;
    }

    public void setKodeTabel(String kodeTabel) {
        this.kodeTabel = kodeTabel;
    }

    public String getKdAsuransi() {
        return kdAsuransi;
    }

    public void setKdAsuransi(String kdAsuransi) {
        this.kdAsuransi = kdAsuransi;
    }

    public String getKdPerusahaan() {
        return kdPerusahaan;
    }

    public void setKdPerusahaan(String kdPerusahaan) {
        this.kdPerusahaan = kdPerusahaan;
    }

    public Boolean getOtorisasi() {
        return otorisasi;
    }

    public void setOtorisasi(Boolean otorisasi) {
        this.otorisasi = otorisasi;
    }

    public String getPengecualianHdr() {
        return pengecualianHdr;
    }

    public void setPengecualianHdr(String pengecualianHdr) {
        this.pengecualianHdr = pengecualianHdr;
    }

    public String getPengecualianDtl() {
        return pengecualianDtl;
    }

    public void setPengecualianDtl(String pengecualianDtl) {
        this.pengecualianDtl = pengecualianDtl;
    }

    
    public Boolean getHdr() {
        return hdr;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public Boolean getDtl() {
        return dtl;
    }

    public void setDtl(Boolean dtl) {
        this.dtl = dtl;
    }

    public Boolean getTampil() {
        return tampil;
    }

    public void setTampil(Boolean tampil) {
        this.tampil = tampil;
    }
    
   
    
}
