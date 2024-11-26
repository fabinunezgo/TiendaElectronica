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

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public Cliente(String cedula, String nombreCompleto, String direccion, String telefono, String correo) {
            this.cedula = cedula;
            this.nombreCompleto = nombreCompleto;
            this.direccion = direccion;
            this.telefono = telefono;
            this.correo = correo;
        }
        
        

    }
}
