package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;

public class Controller {
    public Button btnValidar;
    public TextField txtIdenidad;
    public Label lblMessage;
    public Label lblMessage1;


    public void validar(ActionEvent actionEvent) throws SQLException {
        validaciones valida = new validaciones();
        try{

            String identidad = txtIdenidad.getText();
            int departamento = Integer.parseInt(identidad.substring(0, 2));
            int municipio = Integer.parseInt(identidad.substring(2,4));
            int añoValido = Integer.parseInt(identidad.substring(4, 8));
//            int numero = Integer.parseInt(identidad.substring(8, 13));



           if (identidad.length()>12  && identidad.length()<14){

                   if (añoValido>2018){
                       lblMessage.setText("El año dado no es permitido");

                   }
                   else{
                       lblMessage.setText("El municipio es "+valida.muni(municipio, departamento));
                       lblMessage1.setText("El departamento es "+ valida.depar(departamento));

                   }

           }else{
               lblMessage.setText("La cantidad de digitos ingresados no son  permitidos");

           }

        }catch (Exception e){
            System.err.println("Fallo por: " + e.getMessage());
        }

    }
}
