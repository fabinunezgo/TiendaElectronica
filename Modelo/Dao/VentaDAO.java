package Modelo.Dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
import Modelo.Ventas.Venta;
import java.util.List;
import java.sql.SQLException;
/**
 *
 * @author thyfa
 */


public interface VentaDAO {
    void insertarVenta(Venta venta) throws SQLException;
    Venta obtenerVentaPorId(int id) throws SQLException;
    List<Venta> obtenerTodasLasVentas() throws SQLException;
    void actualizarVenta(Venta venta) throws SQLException;
    void eliminarVenta(int id) throws SQLException;
}


