package org.example;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PeliculaDAO dao = new PeliculaDAO();

        int opcion = 0;

        while (opcion != 6) {
            System.out.println("///MENÚ PELÍCULAS///");
            System.out.println("1. Insertar película");
            System.out.println("2. Mostrar película");
            System.out.println("3. Actualizar película");
            System.out.println("4. Eliminar película");
            System.out.println("5. Mostrar película por ID");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            try {
                switch (opcion) {

                    // OPCIÓN 1 --> INSERTAR DE NUEVAS PELÍCULAS
                    case 1 -> {
                        PeliculasModelo pel = new PeliculasModelo();

                        System.out.print("ID de la película: ");
                        pel.setId_pelicula(sc.nextInt());
                        sc.nextLine();

                        System.out.print("Título: ");
                        pel.setTitulo(sc.nextLine());

                        System.out.print("Duración (minutos): ");
                        pel.setDuracion_minutos(sc.nextInt());
                        sc.nextLine();

                        System.out.print("Género: ");
                        pel.setGenero(sc.nextLine());

                        System.out.print("Clasificación: ");
                        pel.setClasificacion(sc.nextLine());

                        System.out.print("Director: ");
                        pel.setDirector(sc.nextLine());

                        System.out.print("Sinopsis: ");
                        pel.setSinopsis(sc.nextLine());

                        pel.setFechaEstreno(new Date(System.currentTimeMillis()));

                        System.out.print("Popularidad (número): ");
                        pel.setPopularidad(sc.nextInt());
                        sc.nextLine();

                        System.out.print("Activa (true/false): ");
                        pel.setActiva(sc.nextBoolean());
                        sc.nextLine();

                        pel.setFechaBaja(null);

                        dao.insertar(pel);
                        System.out.println("Película insertada exitosamente.");
                    }
                    //LA OPCIÓN 2 --> MUESTRA TODAS LAS PELIS
                    case 2 -> {
                        List<PeliculasModelo> lista = dao.obtenerPelis();
                        System.out.println("///LISTA DE PELÍCULAS///");
                        for (PeliculasModelo p : lista) {
                            System.out.println(
                                    p.getId_pelicula() + " | " +
                                            p.getTitulo() + " | " +
                                            p.getDuracion_minutos() + " min | " +
                                            p.getGenero() + " | " +
                                            p.getClasificacion() + " | " +
                                            p.getDirector() + " | " +
                                            p.getSinopsis() + " | " +
                                            p.getFechaEstreno() + " | " +
                                            "Popularidad: " + p.getPopularidad() + " | " +
                                            "Activa: " + p.isActiva() + " | " +
                                            "Fecha Baja: " + p.getFechaBaja()
                            );
                        }
                    }

                    // OPCIÓN 3 --> ACTUALIZAR PELÍCULAS
                    case 3 -> {
                        System.out.print("ID de la película a actualizar: ");
                        int idAct = sc.nextInt();
                        sc.nextLine();

                        // Obtener lista de películas
                        List<PeliculasModelo> lista = dao.obtenerPelis();
                        PeliculasModelo peli = lista.stream()
                                .filter(x -> x.getId_pelicula() == idAct)
                                .findFirst()
                                .orElse(null);

                        if (peli == null) {
                            System.out.println("Película no encontrada.");
                            break;
                        }

                        System.out.print("Nuevo título (" + peli.getTitulo() + "): ");
                        String titulo = sc.nextLine();
                        if (!titulo.isEmpty()) peli.setTitulo(titulo);

                        System.out.print("Nueva duración en minutos (" + peli.getDuracion_minutos() + "): ");
                        String durStr = sc.nextLine();
                        if (!durStr.isEmpty()) {
                            try {
                                peli.setDuracion_minutos(Integer.parseInt(durStr));
                            } catch (NumberFormatException e) {
                                System.out.println("Duración inválida, se mantiene el valor anterior.");
                            }
                        }

                        System.out.print("Nuevo género (" + peli.getGenero() + "): ");
                        String genero = sc.nextLine();
                        if (!genero.isEmpty()) peli.setGenero(genero);

                        System.out.print("Nueva clasificación (" + peli.getClasificacion() + "): ");
                        String clasif = sc.nextLine();
                        if (!clasif.isEmpty()) peli.setClasificacion(clasif);

                        System.out.print("Nuevo director (" + peli.getDirector() + "): ");
                        String director = sc.nextLine();
                        if (!director.isEmpty()) peli.setDirector(director);

                        System.out.print("Nueva sinopsis (" + peli.getSinopsis() + "): ");
                        String sinopsis = sc.nextLine();
                        if (!sinopsis.isEmpty()) peli.setSinopsis(sinopsis);

                        System.out.print("Nueva fecha de estreno (yyyy-mm-dd) (" + peli.getFechaEstreno() + "): ");
                        String fechaStr = sc.nextLine();
                        if (!fechaStr.isEmpty()) {
                            try {
                                java.sql.Date fecha = java.sql.Date.valueOf(fechaStr);
                                peli.setFechaEstreno(fecha);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Fecha inválida, se mantiene el valor anterior.");
                            }
                        }

                        System.out.print("Nueva popularidad (" + peli.getPopularidad() + "): ");
                        String popStr = sc.nextLine();
                        if (!popStr.isEmpty()) {
                            try {
                                peli.setPopularidad(Integer.parseInt(popStr));
                            } catch (NumberFormatException e) {
                                System.out.println("Popularidad inválida, se mantiene el valor anterior.");
                            }
                        }

                        System.out.print("¿Está activa? (" + peli.isActiva() + ") (true/false): ");
                        String actStr = sc.nextLine();
                        if (!actStr.isEmpty()) {
                            peli.setActiva(Boolean.parseBoolean(actStr));
                        }

                        dao.actualizar(peli);
                        System.out.println("Película actualizada correctamente.");
                    }

                    // LA OPCIÓN 4 --> ELIMINA UNA PELÍCULA
                    case 4 -> {
                        System.out.print("ID de la película que deseas eliminar: ");
                        int idDel = sc.nextInt();

                        dao.eliminar(idDel); // Asegúrate de que PeliculaDAO tenga un método eliminar(int id)
                        System.out.println("Película eliminada.");
                    }

                    // LA OPCIÓN 5 --> MUESTRA UNA PELÍCULA POR ID
                    case 5 -> {
                        System.out.print("ID de la película a buscar: ");
                        int idBus = sc.nextInt();

                        PeliculasModelo peli = dao.obtenerPorId(idBus); // Asegúrate de que PeliculaDAO tenga este método

                        if (peli == null) {
                            System.out.println("Película no encontrada.");
                        } else {
                            System.out.println("ID: " + peli.getId_pelicula());
                            System.out.println("Título: " + peli.getTitulo());
                            System.out.println("Duración (minutos): " + peli.getDuracion_minutos());
                            System.out.println("Género: " + peli.getGenero());
                            System.out.println("Clasificación: " + peli.getClasificacion());
                            System.out.println("Director: " + peli.getDirector());
                            System.out.println("Sinopsis: " + peli.getSinopsis());
                            System.out.println("Fecha de estreno: " + peli.getFechaEstreno());
                            System.out.println("Popularidad: " + peli.getPopularidad());
                            System.out.println("Activa: " + peli.isActiva());
                            System.out.println("Fecha de baja: " + peli.getFechaBaja());
                        }
                    }


                    // OPCIÓN 6 --> SALIR
                    case 6 -> System.out.println("Cerrando el programa");

                    default -> System.out.println("Opción inválida.");




                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
