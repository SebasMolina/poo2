/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comprobante;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author sebas
 */
public class RepositorioComprobante {
    private final Connection conexion;

    public RepositorioComprobante (Connection connection) throws SQLException {
        this.conexion = connection;
        var consulta = connection.createStatement();
        consulta.execute("");
        consulta.close();
    }  
      
}
