
package com.example.hnino.consumingopendata.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CultivoIlicito {

    @SerializedName("_2001")
    @Expose
    private String _2001;
    @SerializedName("_2002")
    @Expose
    private String _2002;
    @SerializedName("_2003")
    @Expose
    private String _2003;
    @SerializedName("_2004")
    @Expose
    private String _2004;
    @SerializedName("_2005")
    @Expose
    private String _2005;
    @SerializedName("_2006")
    @Expose
    private String _2006;
    @SerializedName("cod_dane")
    @Expose
    private String codDane;
    @SerializedName("departamento")
    @Expose
    private String departamento;
    @SerializedName("municipio")
    @Expose
    private String municipio;

    public String get2001() {
        return _2001;
    }

    public void set2001(String _2001) {
        this._2001 = _2001;
    }

    public String get2002() {
        return _2002;
    }

    public void set2002(String _2002) {
        this._2002 = _2002;
    }

    public String get2003() {
        return _2003;
    }

    public void set2003(String _2003) {
        this._2003 = _2003;
    }

    public String get2004() {
        return _2004;
    }

    public void set2004(String _2004) {
        this._2004 = _2004;
    }

    public String get2005() {
        return _2005;
    }

    public void set2005(String _2005) {
        this._2005 = _2005;
    }

    public String get2006() {
        return _2006;
    }

    public void set2006(String _2006) {
        this._2006 = _2006;
    }

    public String getCodDane() {
        return codDane;
    }

    public void setCodDane(String codDane) {
        this.codDane = codDane;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

}
