package com.iudigital.crud.dao;
import com.iudigital.crud.domain.Funcionario;
import com.iudigital.crud.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

    private static final String GET_FUNCIONARIOS = "SELECT * FROM funcionarios";

    private static final String CREATE_FUNCIONARIOS = "INSERT INTO funcionarios (tipo_identificacion, numero_identificacion, nombres, apellidos, sexo,direccion, telefono, fecha_nacimiento, estado_civil)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_FUNCIONARIO_BY_ID = "SELECT * FROM funcionarios WHERE id = ? ";

    private static final String UPDATE_FUNCIONARIO = "UPDATE funcionarios SET tipo_identificacion = ?, "
            + "numero_identificacion = ?, nombres = ?, apellidos = ?, sexo = ?, direccion = ?, telefono = ?, fecha_nacimiento = ? ,estado_civil = ? WHERE id = ?";

    private static final String DELETE_FUNCIONARIO = "DELETE FROM funcionarios WHERE id = ? ";

    public List<Funcionario> obtenerFuncionarios() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setTipo_identificacion(resultSet.getString("tipo_identificacion"));
                funcionario.setNumero_identificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
                funcionario.setEstado_civil(resultSet.getString("estado_civil"));
                funcionarios.add(funcionario);

            }
            return funcionarios;

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void crear(Funcionario funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIOS);
            preparedStatement.setString(1, funcionario.getTipo_identificacion());
            preparedStatement.setString(2, funcionario.getNumero_identificacion());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setString(5, funcionario.getSexo());
            preparedStatement.setString(6, funcionario.getDireccion());
            preparedStatement.setString(7, funcionario.getTelefono());
            /* DateTimeFormatter format = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();
            LocalDate fecha = LocalDate.parse(funcionario.getFecha_nacimiento(), format);
            preparedStatement.setObject(8, fecha); */// tener cuidado con esta linea de codigo ya que en la bd esta como tipo date y aca la seteamos como string
            preparedStatement.setString(8, funcionario.getFecha_nacimiento());
            preparedStatement.setString(9, funcionario.getEstado_civil());
            preparedStatement.executeUpdate();
            //preparedStatement.setString(funcionario.getTipo_identificacion());
        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Funcionario obtenerFuncionario(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setTipo_identificacion(resultSet.getString("tipo_identificacion"));
                funcionario.setNumero_identificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
                funcionario.setEstado_civil(resultSet.getString("estado_civil"));

            }
            return funcionario;

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void actualizarFuncionario(int id, Funcionario funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getTipo_identificacion());
            preparedStatement.setString(2, funcionario.getNumero_identificacion());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setString(5, funcionario.getSexo());
            preparedStatement.setString(6, funcionario.getDireccion());
            preparedStatement.setString(7, funcionario.getTelefono());
            /*DateTimeFormatter format = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();
            LocalDate fecha = LocalDate.parse(funcionario.getFecha_nacimiento(), format);
            preparedStatement.setObject(8, fecha);*/
            preparedStatement.setObject(8, funcionario.getFecha_nacimiento());
            preparedStatement.setString(9, funcionario.getEstado_civil());
            preparedStatement.setInt(10, id);
            preparedStatement.executeUpdate();

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void eliminarFuncionario(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
