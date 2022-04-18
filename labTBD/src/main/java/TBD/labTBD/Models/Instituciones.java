package TBD.labTBD.Models;
import java.util.List;

public class Instituciones {
    private int id;
    private String nombre;
    private List<String> coordinadores;
    private List<String> claves_Coordinadores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List getCoordinadores() {
        return coordinadores;
    }

    public List setCoordinadores(List coordinadores) {
        this.coordinadores = coordinadores;
    }

    public List getClavesCoordinadores(List claves_Coordinadores) {
        return claves_Coordinadores;
    }

    public List setClavesCoordinadores(List claves_Coordinadores) {
        this.claves_Coordinadores = claves_Coordinadores;
    }
}
