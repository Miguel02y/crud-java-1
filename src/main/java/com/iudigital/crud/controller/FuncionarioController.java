package com.iudigital.crud.controller;

import com.iudigital.crud.dao.FuncionarioDao;
import com.iudigital.crud.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {

    // logica de negocio
    private FuncionarioDao funcionarioDao;

    public FuncionarioController() {
        funcionarioDao = new FuncionarioDao();
    }

    //creamos la funcion para obteer los carros
    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        return funcionarioDao.obtenerFuncionarios();
    }

    public void crear(Funcionario funcionario) throws SQLException {
        funcionarioDao.crear(funcionario);

    }

    public Funcionario obtenerFuncionario(int id) throws SQLException {
        return funcionarioDao.obtenerFuncionario(id);

    }

    public void actualizarFuncionario(int id, Funcionario funcionario) throws SQLException {
        funcionarioDao.actualizarFuncionario(id, funcionario);

    }

    public void eliminarFuncionario(int id) throws SQLException {
        funcionarioDao.eliminarFuncionario(id);

    }
}
