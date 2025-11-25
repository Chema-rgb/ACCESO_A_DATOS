package org.example;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpleadoDAO dao = new EmpleadoDAO();

        int opcion = 0;

        while (opcion != 6) {
            System.out.println("///MENÚ EMPLEADOS///");
            System.out.println("1. Insertar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Actualizar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Mostrar empleado por ID");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {

                    //LA OPCIÓN 1 --> INSERCIÓN DE NUEVOS EMPLEADOS
                    case 1 -> {
                        EmpleadoModelo emp = new EmpleadoModelo();

                        System.out.print("Nombre: ");
                        emp.setNombre(sc.nextLine());

                        System.out.print("Puesto: ");
                        emp.setPuesto(sc.nextLine());

                        System.out.print("Tipo de jornada: ");
                        emp.setTipoJornada(sc.nextLine());

                        System.out.print("Email: ");
                        emp.setEmail(sc.nextLine());

                        System.out.print("Teléfono: ");
                        emp.setTelefono(sc.nextLine());

                        System.out.print("Salario por hora: ");
                        emp.setSalarioHora(sc.nextBigDecimal());

                        System.out.print("Activo (true/false): ");
                        emp.setActivo(sc.nextBoolean());

                        emp.setFechaContratacion(new Date(System.currentTimeMillis()));

                        dao.insertar(emp);
                        System.out.println("Empleado insertado exitosamente.");
                    }
                    //LA OPCIÓN 2 --> MUESTRA TODOS LOS EMPLEADOS
                    case 2 -> {
                        List<EmpleadoModelo> lista = dao.obtenerTodos();
                        System.out.println("///LISTA DE EMPLEADOS///");
                        for (EmpleadoModelo e : lista) {
                            System.out.println(e.getIdEmpleado() + " | " +
                                    e.getNombre() + " | " +
                                    e.getPuesto() + " | " +
                                    e.getEmail());
                        }
                    }
                    //LA OPCIÓN 3 -->ACTULIZA UNO DE LOS EMPLEADOS CREADOS
                    case 3 -> {
                        System.out.print("ID del empleado a actualizar: ");
                        int idAct = sc.nextInt();
                        sc.nextLine();

                        // Obtener datos actuales del empleado
                        List<EmpleadoModelo> lista = dao.obtenerTodos();
                        EmpleadoModelo emp = lista.stream()
                                .filter(x -> x.getIdEmpleado() == idAct)
                                .findFirst()
                                .orElse(null);

                        if (emp == null) {
                            System.out.println("Empleado no encontrado.");
                            break;
                        }

                        System.out.print("Nuevo nombre (" + emp.getNombre() + "): ");
                        String nombre = sc.nextLine();
                        if (!nombre.isEmpty()) emp.setNombre(nombre);

                        System.out.print("Nuevo puesto (" + emp.getPuesto() + "): ");
                        String puesto = sc.nextLine();
                        if (!puesto.isEmpty()) emp.setPuesto(puesto);

                        System.out.print("Nuevo tipo jornada (" + emp.getTipoJornada() + "): ");
                        String jornada = sc.nextLine();
                        if (!jornada.isEmpty()) emp.setTipoJornada(jornada);

                        System.out.print("Nuevo email (" + emp.getEmail() + "): ");
                        String email = sc.nextLine();
                        if (!email.isEmpty()) emp.setEmail(email);

                        System.out.print("Nuevo teléfono (" + emp.getTelefono() + "): ");
                        String tel = sc.nextLine();
                        if (!tel.isEmpty()) emp.setTelefono(tel);

                        System.out.print("Nuevo salario por hora (" + emp.getSalarioHora() + "): ");
                        String salarioStr = sc.nextLine();
                        if (!salarioStr.isEmpty()) emp.setSalarioHora(new BigDecimal(salarioStr));

                        dao.actualizar(emp);
                        System.out.println("Empleado actualizado correctamente.");
                    }

                    //LA OPCIÓN 4 --> ELIMINA A UN EMPLEADOSS
                    case 4 -> {
                        System.out.print("ID del empleado que deseas eliminar: ");
                        int idDel = sc.nextInt();

                        dao.eliminar(idDel);
                        System.out.println("Empleado eliminado.");
                    }

                    //LA OPCIÓN 5 --> MUESTRA A UN EMPLEADO POR ID
                    case 5 -> {
                        System.out.print("ID del empleado a buscar: ");
                        int idBus = sc.nextInt();

                        EmpleadoModelo emp = dao.obtenerPorId(idBus);

                        if (emp == null) {
                            System.out.println("Empleado no encontrado.");
                        } else {
                            System.out.println("ID: " + emp.getIdEmpleado());
                            System.out.println("Nombre: " + emp.getNombre());
                            System.out.println("Puesto: " + emp.getPuesto());
                            System.out.println("Email: " + emp.getEmail());
                            System.out.println("Teléfono: " + emp.getTelefono());
                            System.out.println("Salario por hora: " + emp.getSalarioHora());
                            System.out.println("Fecha contratación: " + emp.getFechaContratacion());
                        }
                    }
                    default -> System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

        sc.close();
    }
}
