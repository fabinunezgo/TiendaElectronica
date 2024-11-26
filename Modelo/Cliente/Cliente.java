package Modelo.Cliente;

public class Cliente {
    private String cedula;
    private String nombreCompleto;
    private String direccion;
    private String telefono;
    private String correo;

   
    public String getCedula() {
        return cedula;
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }


  
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

   

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Cliente(String cedula, String nombreCompleto, String direccion, String telefono, String correo) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }
    
   
}
