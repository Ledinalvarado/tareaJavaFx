package sample;

import java.sql.*;

public class validaciones {
    static Connection conexion;

    public String muni(int muni, int depa){
        DataBase base = DataBase.abrirConexion();
        String municipios = null;


        try{
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/honduras",
                    "root", "K17OACX");
            String sql = "SELECT * FROM municipios where id_departamento = "+depa+" and id_municipios = "+muni+"";

            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            while (resultado.next()){
               municipios = resultado.getString("municipios");
            }
            if (municipios == null){
                municipios = "El municipio no Existe";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return municipios;
    }
    public String depar(int depa){
        //DataBase base = DataBase.abrirConexion();
        String departamentos = null;
        try{

            String sql2 = "SELECT * FROM departamentos WHERE id_departamento = "+depa+"";
            Statement sentencia2 = conexion.createStatement();
            ResultSet resultado2 = sentencia2.executeQuery(sql2);
            while (resultado2.next()){
                departamentos = resultado2.getString("nombre_departamento");
            }
            if (departamentos == null){
                departamentos = "El Departamento no Existe";
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return departamentos;
    }
}
