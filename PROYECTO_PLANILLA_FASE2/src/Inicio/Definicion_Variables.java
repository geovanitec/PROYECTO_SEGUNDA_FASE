/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

/**
 *
 * @author Geovani
 */
public class Definicion_Variables {

    
    private int intCodigo;
    private String strNombre;
    private String strPuesto;
    private Float fltSueldo;
   private Float fltSalarioExtraordinario;
    private Float fltBonificacion;
    private Float fltComision;
    private Float fltOtros;
    private Float fltTotalDevengado;
    private Float fltIgss;
    private Float fltIsr;
    private Float fltAnticipos;
    private Float fltDescuentosJudiciales;
    private Float fltOtrosDescuentos;
    private Float fltTotalDescuentos;
    private Float fltTotalLiquido;

    public int getIntCodigo() {
        return intCodigo;
    }

    public void setIntCodigo(int intCodigo) {
        this.intCodigo = intCodigo;
    }

    public String getStrNombre() {
        return strNombre;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public String getStrPuesto() {
        return strPuesto;
    }

    public void setStrPuesto(String strPuesto) {
        this.strPuesto = strPuesto;
    }

    public Float getFltSueldo() {
        return fltSueldo;
    }

    public void setFltSueldo(Float fltSueldo) {
        this.fltSueldo = fltSueldo;
    }

    public Float getFltSalarioExtraordinario() {
        return fltSalarioExtraordinario;
    }

    public void setFltSalarioExtraordinario(Float fltSalarioExtraordinario) {
        this.fltSalarioExtraordinario = fltSalarioExtraordinario;
    }

    public Float getFltBonificacion() {
        return fltBonificacion;
    }

    public void setFltBonificacion(Float fltBonificacion) {
        this.fltBonificacion = fltBonificacion;
    }

    public Float getFltComision() {
        return fltComision;
    }

    public void setFltComision(Float fltComision) {
        this.fltComision = fltComision;
    }

    public Float getFltOtros() {
        return fltOtros;
    }

    public void setFltOtros(Float fltOtros) {
        this.fltOtros = fltOtros;
    }

    public Float getFltTotalDevengado() {
        return fltTotalDevengado;
    }

    public void setFltTotalDevengado(Float fltTotalDevengado) {
        this.fltTotalDevengado = fltTotalDevengado;
    }

    public Float getFltIgss() {
        return fltIgss;
    }

    public void setFltIgss(Float fltIgss) {
        this.fltIgss = fltIgss;
    }

    public Float getFltIsr() {
        return fltIsr;
    }

    public void setFltIsr(Float fltIsr) {
        this.fltIsr = fltIsr;
    }

    public Float getFltAnticipos() {
        return fltAnticipos;
    }

    public void setFltAnticipos(Float fltAnticipos) {
        this.fltAnticipos = fltAnticipos;
    }

    public Float getFltDescuentosJudiciales() {
        return fltDescuentosJudiciales;
    }

    public void setFltDescuentosJudiciales(Float fltDescuentosJudiciales) {
        this.fltDescuentosJudiciales = fltDescuentosJudiciales;
    }

    public Float getFltOtrosDescuentos() {
        return fltOtrosDescuentos;
    }

    public void setFltOtrosDescuentos(Float fltOtrosDescuentos) {
        this.fltOtrosDescuentos = fltOtrosDescuentos;
    }

    public Float getFltTotalDescuentos() {
        return fltTotalDescuentos;
    }

    public void setFltTotalDescuentos(Float fltTotalDescuentos) {
        this.fltTotalDescuentos = fltTotalDescuentos;
    }

    public Float getFltTotalLiquido() {
        return fltTotalLiquido;
    }

    public void setFltTotalLiquido(Float fltTotalLiquido) {
        this.fltTotalLiquido = fltTotalLiquido;
    }

    
    
    

    
    
    
    
    
    
    public Definicion_Variables(int intCodigo, String strNombre, String strPuesto, Float fltSueldo, Float fltSalarioExtraordinario, Float fltBonificacion, Float fltComision, Float fltOtros, Float fltTotalDev , Float fltigss, Float fltisr, Float fltAnticipos, Float fltDescuentosJudiciales, Float fltOtrosDescuentos , Float fltTotaldes, Float fltTotalliq) {
        this.intCodigo = intCodigo;
        this.strNombre = strNombre;
        this.strPuesto = strPuesto;
        this.fltSueldo = fltSueldo;
        this.fltSalarioExtraordinario = fltSalarioExtraordinario;
        this.fltBonificacion = fltBonificacion;
        this.fltComision = fltComision;
        this.fltOtros = fltOtros;
        this.fltTotalDevengado = fltTotalDev;
        this.fltIgss = fltigss;
        this.fltIsr = fltisr;
        this.fltAnticipos = fltAnticipos;
        this.fltDescuentosJudiciales = fltDescuentosJudiciales;
        this.fltOtrosDescuentos = fltOtrosDescuentos;
        this.fltTotalDescuentos = fltTotaldes;
        this.fltTotalLiquido = fltTotalliq;
    }
    
    
    public Definicion_Variables(){
        
    }
     public String toString() {
        return this.strNombre;
    }

    
}
