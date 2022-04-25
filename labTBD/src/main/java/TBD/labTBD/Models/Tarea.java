package TBD.labTBD.Models;

import java.sql.Timestamp;


public class Tarea {
    int id;
    Timestamp fechaInicio;
    String estado, nombre, descripcion;
    String ubicacion;
    String listaHabilidades;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getListaHabilidades() {
        return listaHabilidades;
    }
    public void setListaHabilidades(String listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }
    
}
