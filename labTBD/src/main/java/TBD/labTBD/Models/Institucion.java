package TBD.labTBD.Models;
import java.util.List;

public class Institucion {
    private int id;
    private String nombre;
    private String coordinadores;
    private String claves_Coordinadores;

    //Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCoordinadores() {
        return coordinadores;
    }

    public String getClavesCoordinadores() {
        return this.claves_Coordinadores;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCoordinadores(String coordinadores) {
        this.coordinadores = coordinadores;
    }

    public void setClavesCoordinadores(String claves_Coordinadores) {
        this.claves_Coordinadores = claves_Coordinadores;
    }

}
