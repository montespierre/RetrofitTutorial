package com.weimont.retrofittutorial;

import java.util.List;

public class Indicador {
    private String version;
    private String autor;
    private String codigo;
    private String nombre;
    private String unidad_medida;
    private List<ValorIndicador> serie;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public List<ValorIndicador> getSerie() {
        return serie;
    }

    public void setSerie(List<ValorIndicador> serie) {
        this.serie = serie;
    }
}
