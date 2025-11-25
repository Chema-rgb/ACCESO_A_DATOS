package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    // INSERT
    public void insertar(EmpleadoModelo emp) throws Exception {
        String sql = """
            INSERT INTO empleados 
            (nombre, puesto, tipo_jornada, email, telefono, fecha_contratacion, salario_hora, activo)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.getNombre());
            stmt.setString(2, emp.getPuesto());
            stmt.setString(3, emp.getTipoJornada());
            stmt.setString(4, emp.getEmail());
            stmt.setString(5, emp.getTelefono());
            stmt.setDate(6, emp.getFechaContratacion());
            stmt.setBigDecimal(7, emp.getSalarioHora());
            stmt.setBoolean(8, emp.isActivo());

            stmt.executeUpdate();
        }
    }

    // READ PARA OBTENER TODOS
    public List<EmpleadoModelo> obtenerTodos() throws Exception {
        List<EmpleadoModelo> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados ORDER BY id_empleado";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                EmpleadoModelo emp = new EmpleadoModelo();

                emp.setIdEmpleado(rs.getInt("id_empleado"));
                emp.setNombre(rs.getString("nombre"));
                emp.setPuesto(rs.getString("puesto"));
                emp.setTipoJornada(rs.getString("tipo_jornada"));
                emp.setEmail(rs.getString("email"));
                emp.setTelefono(rs.getString("telefono"));
                emp.setFechaContratacion(rs.getDate("fecha_contratacion"));
                emp.setSalarioHora(rs.getBigDecimal("salario_hora"));
                emp.setActivo(rs.getBoolean("activo"));

                lista.add(emp);
            }
        }
        return lista;
    }

    // READ por ID
    public EmpleadoModelo obtenerPorId(int id) throws Exception {
        EmpleadoModelo emp = null;
        String sql = "SELECT * FROM empleados WHERE id_empleado = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    emp = new EmpleadoModelo();
                    emp.setIdEmpleado(rs.getInt("id_empleado"));
                    emp.setNombre(rs.getString("nombre"));
                    emp.setPuesto(rs.getString("puesto"));
                    emp.setTipoJornada(rs.getString("tipo_jornada"));
                    emp.setEmail(rs.getString("email"));
                    emp.setTelefono(rs.getString("telefono"));
                    emp.setFechaContratacion(rs.getDate("fecha_contratacion"));
                    emp.setSalarioHora(rs.getBigDecimal("salario_hora"));
                    emp.setActivo(rs.getBoolean("activo"));
                }
            }
        }
        return emp;
    }

    // UPDATE
    public void actualizar(EmpleadoModelo emp) throws Exception {
        String sql = """
            UPDATE empleados SET
                nombre = ?, puesto = ?, tipo_jornada = ?, email = ?, telefono = ?, 
                fecha_contratacion = ?, salario_hora = ?, activo = ?
            WHERE id_empleado = ?
        """;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.getNombre());
            stmt.setString(2, emp.getPuesto());
            stmt.setString(3, emp.getTipoJornada());
            stmt.setString(4, emp.getEmail());
            stmt.setString(5, emp.getTelefono());
            stmt.setDate(6, emp.getFechaContratacion());
            stmt.setBigDecimal(7, emp.getSalarioHora());
            stmt.setBoolean(8, emp.isActivo());
            stmt.setInt(9, emp.getIdEmpleado());

            stmt.executeUpdate();
        }
    }

    // DELETE
    public void eliminar(int idEmpleado) throws Exception {
        String sql = "DELETE FROM empleados WHERE id_empleado = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEmpleado);
            stmt.executeUpdate();
        }
    }

}

/*

-- NOTAS PROFESOR (APARTADO READ por ID) --
Prposito: Sustituir uso de rs,getters y setters para imprimir informaciob de un empleado.
Con StringBoot conseguir que traiga la tabla, y nos la transforme en un clase directamente evitando el
tener que usar Getters/Setters para interpretar el RS obtenido de una consulta

--CODIGOS DEL PROFESOR--

Empleado empleados =  emp.find()
System.out.println(rs);

 */


