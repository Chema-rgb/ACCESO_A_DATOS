package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    // INSERT
    public void insertar(PeliculasModelo pel) throws Exception {
        String sql = """
            INSERT INTO peliculas 
            (id_pelicula, titulo, duracion_minutos, genero, clasificacion, director, sinopsis, fecha_estreno, 
            popularidad, activa, fecha_baja)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pel.getId_pelicula());
            stmt.setString(2, pel.getTitulo());
            stmt.setInt(3, pel.getDuracion_minutos());
            stmt.setString(4, pel.getGenero());
            stmt.setString(5, pel.getClasificacion());
            stmt.setString(6, pel.getDirector());
            stmt.setString(7, pel.getSinopsis());
            stmt.setDate(8, pel.getFechaEstreno());
            stmt.setInt(9, pel.getPopularidad());
            stmt.setBoolean(10, pel.isActiva());
            stmt.setDate(11, pel.getFechaBaja());

            stmt.executeUpdate();
        }
    }

    // READ PARA OBTENER TODOS
    public List<PeliculasModelo> obtenerPelis() throws Exception {
        List<PeliculasModelo> lista = new ArrayList<>();
        String sql = "SELECT * FROM peliculas ORDER BY id_pelicula";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                PeliculasModelo peli = new PeliculasModelo();

                peli.setId_pelicula(rs.getInt("id_pelicula"));
                peli.setTitulo(rs.getString("titulo"));
                peli.setDuracion_minutos(rs.getInt("duracion_minutos"));
                peli.setGenero(rs.getString("genero"));
                peli.setClasificacion(rs.getString("clasificacion"));
                peli.setDirector(rs.getString("director"));
                peli.setSinopsis(rs.getString("sinopsis"));
                peli.setFechaEstreno(rs.getDate("fecha_estreno"));
                peli.setPopularidad(rs.getInt("popularidad"));
                peli.setActiva(rs.getBoolean("activa"));
                peli.setFechaBaja(rs.getDate("fecha_baja"));

                lista.add(peli);
            }
        }

        return lista;
    }

    // UPDATE
    public void actualizar(PeliculasModelo peli) throws Exception {
        String sql = """
            UPDATE peliculas SET
                titulo = ?, duracion_minutos = ?, genero = ?, clasificacion = ?, 
                director = ?, sinopsis = ?, fecha_estreno = ?, popularidad = ?, 
                activa = ?, fecha_baja = ?
            WHERE id_pelicula = ?
        """;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, peli.getTitulo());
            stmt.setInt(2, peli.getDuracion_minutos());
            stmt.setString(3, peli.getGenero());
            stmt.setString(4, peli.getClasificacion());
            stmt.setString(5, peli.getDirector());
            stmt.setString(6, peli.getSinopsis());
            stmt.setDate(7, peli.getFechaEstreno());
            stmt.setInt(8, peli.getPopularidad());
            stmt.setBoolean(9, peli.isActiva());
            stmt.setDate(10, peli.getFechaBaja());
            stmt.setInt(11, peli.getId_pelicula());

            stmt.executeUpdate();
        }
    }
    // ELIMINAR
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM peliculas WHERE id_pelicula = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas == 0) {
                System.out.println("No se encontró la película con ID " + id);
            }
        }
    }
    // LEER POR ID
    public PeliculasModelo obtenerPorId(int id) throws Exception {
        String sql = "SELECT * FROM peliculas WHERE id_pelicula = ?";
        PeliculasModelo peli = null;

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    peli = new PeliculasModelo();
                    peli.setId_pelicula(rs.getInt("id_pelicula"));
                    peli.setTitulo(rs.getString("titulo"));
                    peli.setDuracion_minutos(rs.getInt("duracion_minutos"));
                    peli.setGenero(rs.getString("genero"));
                    peli.setClasificacion(rs.getString("clasificacion"));
                    peli.setDirector(rs.getString("director"));
                    peli.setSinopsis(rs.getString("sinopsis"));
                    peli.setFechaEstreno(rs.getDate("fecha_estreno"));
                    peli.setPopularidad(rs.getInt("popularidad"));
                    peli.setActiva(rs.getBoolean("activa"));
                    peli.setFechaBaja(rs.getDate("fecha_baja"));
                }
            }
        }

        return peli;
    }

}
