package com.iudigital.crud.presentacion;

import com.iudigital.crud.controller.FuncionarioController;
import com.iudigital.crud.domain.Funcionario;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

public class CrudFuncionario {

    public static void obtenerFuncionarios(FuncionarioController funcionarioController) {
        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {

            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("id: " + funcionario.getId());
                    System.out.println("Tipo  de identificacion: " + funcionario.getTipo_identificacion());
                    System.out.println("Numero de identificacion" + funcionario.getNumero_identificacion());
                    System.out.println("Nombres" + funcionario.getNombres());
                    System.out.println("Apellidos" + funcionario.getApellidos());
                    System.out.println("Estado civil = " + funcionario.getEstado_civil());
                    System.out.println("sexo" + funcionario.getSexo());
                    System.out.println("Direccion" + funcionario.getDireccion());
                    System.out.println("Telefono" + funcionario.getTelefono());
                    DateTimeFormatter format = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();
                    LocalDate fecha = LocalDate.parse(funcionario.getFecha_nacimiento(), format);
                    System.out.println("Fecha de nacimiento" + fecha);
                    System.out.println("------------------------------ ");

                });
            }
            System.out.println("No hay carros ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();
        obtenerFuncionarios(funcionarioController);
    }
}
