/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.*;

public class Conection {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "adrian12";
    private static final String url = "jdbc:mysql://localhost:3306/prueba";
    
    public Conection(){
        try {
            conn =null;
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Conexion establecida");
        } catch (ClassNotFoundException e) {
            
        } catch (SQLException e) {
            System.out.println("Error al conectar");
        }
    }
    
    public int ejecutarSenctenciaSQL(String strSentenciaSQL){
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            return 0;
        }
    }
    
        public ResultSet consultarRegistros(String strSentenciaSQL){
       
        try {
             PreparedStatement pstm =  conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();

            return respuesta;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
}
