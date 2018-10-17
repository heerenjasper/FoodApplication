package com.example.a11502021.foodapplication.models;

/**
 * Created by 11502021 on 10/10/2018.
 */

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ENERC_KCAL",
        "FAT",
        "FASAT",
        "CHOCDF",
        "FIBTG",
        "PROCNT",
        "CHOLE",
        "NA",
        "CA",
        "MG",
        "K",
        "FE",
        "ZN",
        "P",
        "VITA_RAE",
        "VITC",
        "THIA",
        "RIBF",
        "NIA",
        "VITB6A",
        "FOLDFE",
        "VITB12",
        "VITD",
        "TOCPHA",
        "VITK1"
})
public class TotalDaily {

    @JsonProperty("ENERC_KCAL")
    private ENERCKCAL_ eNERCKCAL;
    @JsonProperty("FAT")
    private FAT_ fAT;
    @JsonProperty("FASAT")
    private FASAT_ fASAT;
    @JsonProperty("CHOCDF")
    private CHOCDF_ cHOCDF;
    @JsonProperty("FIBTG")
    private FIBTG_ fIBTG;
    @JsonProperty("PROCNT")
    private PROCNT_ pROCNT;
    @JsonProperty("CHOLE")
    private CHOLE_ cHOLE;
    @JsonProperty("NA")
    private NA_ nA;
    @JsonProperty("CA")
    private CA_ cA;
    @JsonProperty("MG")
    private MG_ mG;
    @JsonProperty("K")
    private K_ k;
    @JsonProperty("FE")
    private FE_ fE;
    @JsonProperty("ZN")
    private ZN_ zN;
    @JsonProperty("P")
    private P_ p;
    @JsonProperty("VITA_RAE")
    private VITARAE_ vITARAE;
    @JsonProperty("VITC")
    private VITC_ vITC;
    @JsonProperty("THIA")
    private THIA_ tHIA;
    @JsonProperty("RIBF")
    private RIBF_ rIBF;
    @JsonProperty("NIA")
    private NIA_ nIA;
    @JsonProperty("VITB6A")
    private VITB6A_ vITB6A;
    @JsonProperty("FOLDFE")
    private FOLDFE_ fOLDFE;
    @JsonProperty("VITB12")
    private VITB12_ vITB12;
    @JsonProperty("VITD")
    private VITD_ vITD;
    @JsonProperty("TOCPHA")
    private TOCPHA_ tOCPHA;
    @JsonProperty("VITK1")
    private VITK1_ vITK1;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ENERC_KCAL")
    public ENERCKCAL_ getENERCKCAL() {
        return eNERCKCAL;
    }

    @JsonProperty("ENERC_KCAL")
    public void setENERCKCAL(ENERCKCAL_ eNERCKCAL) {
        this.eNERCKCAL = eNERCKCAL;
    }

    @JsonProperty("FAT")
    public FAT_ getFAT() {
        return fAT;
    }

    @JsonProperty("FAT")
    public void setFAT(FAT_ fAT) {
        this.fAT = fAT;
    }

    @JsonProperty("FASAT")
    public FASAT_ getFASAT() {
        return fASAT;
    }

    @JsonProperty("FASAT")
    public void setFASAT(FASAT_ fASAT) {
        this.fASAT = fASAT;
    }

    @JsonProperty("CHOCDF")
    public CHOCDF_ getCHOCDF() {
        return cHOCDF;
    }

    @JsonProperty("CHOCDF")
    public void setCHOCDF(CHOCDF_ cHOCDF) {
        this.cHOCDF = cHOCDF;
    }

    @JsonProperty("FIBTG")
    public FIBTG_ getFIBTG() {
        return fIBTG;
    }

    @JsonProperty("FIBTG")
    public void setFIBTG(FIBTG_ fIBTG) {
        this.fIBTG = fIBTG;
    }

    @JsonProperty("PROCNT")
    public PROCNT_ getPROCNT() {
        return pROCNT;
    }

    @JsonProperty("PROCNT")
    public void setPROCNT(PROCNT_ pROCNT) {
        this.pROCNT = pROCNT;
    }

    @JsonProperty("CHOLE")
    public CHOLE_ getCHOLE() {
        return cHOLE;
    }

    @JsonProperty("CHOLE")
    public void setCHOLE(CHOLE_ cHOLE) {
        this.cHOLE = cHOLE;
    }

    @JsonProperty("NA")
    public NA_ getNA() {
        return nA;
    }

    @JsonProperty("NA")
    public void setNA(NA_ nA) {
        this.nA = nA;
    }

    @JsonProperty("CA")
    public CA_ getCA() {
        return cA;
    }

    @JsonProperty("CA")
    public void setCA(CA_ cA) {
        this.cA = cA;
    }

    @JsonProperty("MG")
    public MG_ getMG() {
        return mG;
    }

    @JsonProperty("MG")
    public void setMG(MG_ mG) {
        this.mG = mG;
    }

    @JsonProperty("K")
    public K_ getK() {
        return k;
    }

    @JsonProperty("K")
    public void setK(K_ k) {
        this.k = k;
    }

    @JsonProperty("FE")
    public FE_ getFE() {
        return fE;
    }

    @JsonProperty("FE")
    public void setFE(FE_ fE) {
        this.fE = fE;
    }

    @JsonProperty("ZN")
    public ZN_ getZN() {
        return zN;
    }

    @JsonProperty("ZN")
    public void setZN(ZN_ zN) {
        this.zN = zN;
    }

    @JsonProperty("P")
    public P_ getP() {
        return p;
    }

    @JsonProperty("P")
    public void setP(P_ p) {
        this.p = p;
    }

    @JsonProperty("VITA_RAE")
    public VITARAE_ getVITARAE() {
        return vITARAE;
    }

    @JsonProperty("VITA_RAE")
    public void setVITARAE(VITARAE_ vITARAE) {
        this.vITARAE = vITARAE;
    }

    @JsonProperty("VITC")
    public VITC_ getVITC() {
        return vITC;
    }

    @JsonProperty("VITC")
    public void setVITC(VITC_ vITC) {
        this.vITC = vITC;
    }

    @JsonProperty("THIA")
    public THIA_ getTHIA() {
        return tHIA;
    }

    @JsonProperty("THIA")
    public void setTHIA(THIA_ tHIA) {
        this.tHIA = tHIA;
    }

    @JsonProperty("RIBF")
    public RIBF_ getRIBF() {
        return rIBF;
    }

    @JsonProperty("RIBF")
    public void setRIBF(RIBF_ rIBF) {
        this.rIBF = rIBF;
    }

    @JsonProperty("NIA")
    public NIA_ getNIA() {
        return nIA;
    }

    @JsonProperty("NIA")
    public void setNIA(NIA_ nIA) {
        this.nIA = nIA;
    }

    @JsonProperty("VITB6A")
    public VITB6A_ getVITB6A() {
        return vITB6A;
    }

    @JsonProperty("VITB6A")
    public void setVITB6A(VITB6A_ vITB6A) {
        this.vITB6A = vITB6A;
    }

    @JsonProperty("FOLDFE")
    public FOLDFE_ getFOLDFE() {
        return fOLDFE;
    }

    @JsonProperty("FOLDFE")
    public void setFOLDFE(FOLDFE_ fOLDFE) {
        this.fOLDFE = fOLDFE;
    }

    @JsonProperty("VITB12")
    public VITB12_ getVITB12() {
        return vITB12;
    }

    @JsonProperty("VITB12")
    public void setVITB12(VITB12_ vITB12) {
        this.vITB12 = vITB12;
    }

    @JsonProperty("VITD")
    public VITD_ getVITD() {
        return vITD;
    }

    @JsonProperty("VITD")
    public void setVITD(VITD_ vITD) {
        this.vITD = vITD;
    }

    @JsonProperty("TOCPHA")
    public TOCPHA_ getTOCPHA() {
        return tOCPHA;
    }

    @JsonProperty("TOCPHA")
    public void setTOCPHA(TOCPHA_ tOCPHA) {
        this.tOCPHA = tOCPHA;
    }

    @JsonProperty("VITK1")
    public VITK1_ getVITK1() {
        return vITK1;
    }

    @JsonProperty("VITK1")
    public void setVITK1(VITK1_ vITK1) {
        this.vITK1 = vITK1;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}