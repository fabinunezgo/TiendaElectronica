/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Producto;

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
public class ProductoDAO extends Dao<ProductoDTO> {

    public ProductoDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean agregar(ProductoDTO dto) throws SQLException {
        if (dto == null) {
            return false;
        }
        String query = "INSERT INTO productos (codigo, nombre, categoria, precio, cantidadDisponible, proveedor) "
                     + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getCodigo());
            stmt.setString(2, dto.getNombre());
            stmt.setString(3, dto.getCategoria());
            stmt.setDouble(4, dto.getPrecio());
            stmt.setInt(5, dto.getCantidadDisponible());
            stmt.setString(6, dto.getProveedor());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public ProductoDTO read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "SELECT * FROM productos WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, (Integer) id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ProductoDTO(
                            rs.getInt("codigo"),
                            rs.getString("nombre"),
                            rs.getString("categoria"),
                            rs.getDouble("precio"),
                            rs.getInt("cantidadDisponible"),
                            rs.getString("proveedor")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<ProductoDTO> readAll() throws SQLException {
        String query = "SELECT * FROM productos";
        List<ProductoDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new ProductoDTO(
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("cantidadDisponible"),
                        rs.getString("proveedor")
                ));
            }
        }
        return list;
    }

    @Override
    public boolean actualizar(ProductoDTO dto) throws SQLException {
        if (dto == null || dto.getCodigo() == 0) {
            return false;
        }
        String query = "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, cantidadDisponible = ?, proveedor = ? "
                     + "WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getNombre());
            stmt.setString(2, dto.getCategoria());
            stmt.setDouble(3, dto.getPrecio());
            stmt.setInt(4, dto.getCantidadDisponible());
            stmt.setString(5, dto.getProveedor());
            stmt.setInt(6, dto.getCodigo());  
            return stmt.executeUpdate() > 0;  
        }
    }

    @Override
    public boolean eliminar(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }

        String query = "DELETE FROM productos WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, (Integer) id);  
            return stmt.executeUpdate() > 0;  
        }
    }
}
