package TBD.labTBD.Models;

public class Voluntario 
{
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private String direccion;
    private String rut;
    private Boolean saludable;

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
        return this.contraseña;
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

    public Boolean getSaludable()
    {
        return this.saludable;
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

    public void setContraseña(String contraseña)
    {
        this.contraseña = contraseña;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public void setRut(String rut)
    {
        this.rut = rut;
    }

    public void setSaludable(Boolean saludable)
    {
        this.saludable = saludable;
    }
}










