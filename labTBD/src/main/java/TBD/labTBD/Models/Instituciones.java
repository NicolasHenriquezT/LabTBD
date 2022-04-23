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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getCoordinadores() {
        return coordinadores;
    }

    public void setCoordinadores(List<String> coordinadores) {
        this.coordinadores = coordinadores;
    }

    public List<String> getClavesCoordinadores(List<String> claves_Coordinadores) {
        return this.claves_Coordinadores;
    }

    public void setClavesCoordinadores(List<String> claves_Coordinadores) {
        this.claves_Coordinadores = claves_Coordinadores;
    }
}
