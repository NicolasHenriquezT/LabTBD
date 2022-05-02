package TBD.labTBD.Services;

import TBD.labTBD.Models.*;
import java.util.*;
import TBD.labTBD.Repositories.RepositorieHabilidad;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import TBD.labTBD.Repositories.RepositorieEmergencia;

public class ServiceEmergencia {
    private final RepositorieEmergencia repositorieEmergencia;

    ServiceEmergencia(RepositorieEmergencia repositorieEmergencia) {
        this.repositorieEmergencia = repositorieEmergencia;
    }

    // Metodo leer
    @RequestMapping(value = "/emergencias", method = RequestMethod.GET)
    public List<TBD.labTBD.Models.Emergencia> getAllEmergencia() {
        return repositorieEmergencia.getAll();
    }

    // Metodo actualizar
    @RequestMapping(value = "/emergencia/actualizar", method = RequestMethod.PUT)
    public void actualizarEmergencia(@RequestBody Emergencia emergencia) {
        repositorieEmergencia.update(emergencia);
    }

    // Metodo crear
    @RequestMapping(value = "/newEmergencia", method = RequestMethod.POST)
    public Emergencia createFilm(@RequestBody Emergencia emergencia) {
        return repositorieEmergencia.crearEmergencia(emergencia);
    }

    // Metodo eliminar
    @DeleteMapping(value = "/emergencia/eliminar/{id}")
    public void eliminar(@PathVariable(value = "id") int id) {
        repositorieEmergencia.delete(id);
    }

    // Metodo eliminar
    @RequestMapping(value = "/emergencia/{id}", method = RequestMethod.GET)
    public Emergencia getById(@PathVariable int id) {
        return repositorieEmergencia.getById(id);
    }
}
