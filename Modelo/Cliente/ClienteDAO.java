/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Cliente;

import Modelo.Dao.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thyfa
 */
public class ClienteDAO extends Dao<ClienteDTO> {

    public ClienteDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean agregar(ClienteDTO dto) throws SQLException {
        if (dto == null) {
            return false;
        }
        String query = "INSERT INTO clientes (cedula, nombre_completo, direccion, telefono, correo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getCedula());
            stmt.setString(2, dto.getNombreCompleto());
            stmt.setString(3, dto.getDireccion());
            stmt.setString(4, dto.getTelefono());
            stmt.setString(5, dto.getCorreo());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public ClienteDTO read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "SELECT * FROM clientes WHERE cedula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, (String) id);  
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ClienteDTO(
                            rs.getString("cedula"),
                            rs.getString("nombre_completo"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("correo")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<ClienteDTO> readAll() throws SQLException {
        String query = "SELECT * FROM clientes";
        List<ClienteDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new ClienteDTO(
                        rs.getString("cedula"),
                        rs.getString("nombre_completo"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("correo")
                ));
            }
        }
        return list;
    }

    @Override
    public boolean actualizar(ClienteDTO dto) throws SQLException {
        if (dto == null || dto.getCedula() == null) {
            return false;
        }
        String query = "UPDATE clientes SET nombre_completo = ?, direccion = ?, telefono = ?, correo = ? WHERE cedula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getNombreCompleto());
            stmt.setString(2, dto.getDireccion());
            stmt.setString(3, dto.getTelefono());
            stmt.setString(4, dto.getCorreo());
            stmt.setString(5, dto.getCedula());  
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean eliminar(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }
        String query = "DELETE FROM clientes WHERE cedula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, (String) id);  
            return stmt.executeUpdate() > 0;
        }
    }
}
