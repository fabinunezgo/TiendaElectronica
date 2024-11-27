package Modelo.Proveedor;



public class Proveedor {
    private int id;
    private String nombre;
    private String contacto;
    private String direccion;
   
     public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    

    public Proveedor(int id, String nombre, String contacto, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.direccion = direccion;
    }
}
