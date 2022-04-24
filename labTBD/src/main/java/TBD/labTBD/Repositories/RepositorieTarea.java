package TBD.labTBD.Repositories;
import java.util.List;
import TBD.labTBD.Models.Tarea;

//Interfaz que define los metodos del CRUD
public interface RepositorieTarea{
    public Integer getId(); // read
    public List<Tarea> getAll(); // read
    public void update(Tarea tareaModificada);
    public void delete(int id);
    public Tarea createTarea(Tarea habilidadNew);
    public Tarea getById(int id);
}
