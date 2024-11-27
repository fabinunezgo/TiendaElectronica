/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Cliente;

/**
 *
 * @author thyfa
 */
public class ClienteDTO {
    private String cedula;
    private String nombreCompleto;
    private String direccion;
    private String telefono;
    private String correo;

<<<<<<< HEAD
    public ClienteDTO(String cedula, String nombreCompleto, String direccion, String telefono, String correo) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
=======
        public String getCedula() {
            return cedula;
        }

        public String getNombreCompleto() {
            return nombreCompleto;
        }

        public String getDireccion() {
            return direccion;
        }

        public String getTelefono() {
            return telefono;
        }

        public String getCorreo() {
            return correo;
        }

    
        public Cliente(String cedula, String nombreCompleto, String direccion, String telefono, String correo) {
            this.cedula = cedula;
            this.nombreCompleto = nombreCompleto;
            this.direccion = direccion;
            this.telefono = telefono;
            this.correo = correo;
        }
        
        

>>>>>>> 8c78f002758818009b01d835899eda407b7882f3
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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
}