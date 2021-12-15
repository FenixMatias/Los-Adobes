/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Matio_000
 */
public class Vivienda {
    
    private String codigo;
    private String rut;
    private String nombre;
    private int montopie;
    private double metros;
    private String tipovivienda;

    public Vivienda(String codigo, String rut, String nombre, int montopie, double metros, String tipovivienda) {
        this.codigo = codigo;
        this.rut = rut;
        this.nombre = nombre;
        this.montopie = montopie;
        this.metros = metros;
        this.tipovivienda = tipovivienda;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMontopie() {
        return montopie;
    }

    public void setMontopie(int montopie) {
        this.montopie = montopie;
    }

    public double getMetros() {
        return metros;
    }

    public void setMetros(double metros) {
        this.metros = metros;
    }

    public String getTipovivienda() {
        return tipovivienda;
    }

    public void setTipovivienda(String tipovivienda) {
        this.tipovivienda = tipovivienda;
    }
    
    public int vendervivienda(double valoruf)
    {
        int total=0;
        if(tipovivienda.compareToIgnoreCase("Departamento")==0)
            return total=(int)(metros*(valoruf*32)-montopie);
        if(tipovivienda.compareToIgnoreCase("Casa Pareada")==0)
            return total=(int)(metros*(valoruf*23.5)-montopie);
        if(tipovivienda.compareToIgnoreCase("Casa Aislada")==0)    
            return total=(int)(metros*(valoruf*26.8)-montopie); 
        if(tipovivienda.compareToIgnoreCase("Loft")==0) 
            return total=(int)(metros*(valoruf*28)-montopie);
        return total;           
    }
    
    
}
