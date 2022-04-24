package TBD.labTBD.Models;
import java.util.List;

public class Institucion {
    private int id;
    private String nombre;
    private List<String> coordinadores;
    private List<String> claves_Coordinadores;

    //Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getCoordinadores() {
        return coordinadores;
    }

    public List<String> getClavesCoordinadores() {
        return this.claves_Coordinadores;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCoordinadores(List<String> coordinadores) {
        this.coordinadores = coordinadores;
    }

    public void setClavesCoordinadores(List<String> claves_Coordinadores) {
        this.claves_Coordinadores = claves_Coordinadores;
    }

}
