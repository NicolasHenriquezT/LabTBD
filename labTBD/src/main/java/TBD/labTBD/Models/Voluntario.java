package TBD.labTBD.Models;

import java.util.*;

public class Voluntario 
{
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String direccion;
    private String rut;
    private List<String> estado;

    //Getters
    public int getId()
    {
        return this.id;
    }
    public String getNombre()
    {
        return this.nombre;
    }

    public String getApellido()
    {
        return this.apellido;
    }

    public String getContraseña()
    {
        return this.contrasena;
    }

    public String getCorreo()
    {
        return this.correo;
    }

    public String getDireccion()
    {
        return this.direccion;
    }

    public String getRut()
    {
        return this.rut;
    }

    public List<String> getEstado()
    {
        return this.estado;
    }

    //Setters
    public void setId(int id)
    {
        this.id = id;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }
    
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    public void setContraseña(String contrasena)
    {
        this.contrasena = contrasena;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public void setRut(String rut)
    {
        this.rut = rut;
    }

    public void setEstado(List<String> estado)
    {
        this.estado = estado;
    }
}










