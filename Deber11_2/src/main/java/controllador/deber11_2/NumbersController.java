package controllador.deber11_2;

import Modelo.Operations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.lang.reflect.InvocationTargetException;

public class NumbersController {
    private double n=0;
    private String numberS="";
    private String numberC="";
    private String option="";
    private  double n2=0;
    private double res;
    private String aux;

    @FXML
    private TextField txtData;

    @FXML
    private TextField txtOutCome;

    @FXML
    public void number(ActionEvent event) {
        txtData.clear();



        try{

            Button button = (Button) event.getSource();
            aux = button.getText();
            numberS = numberS+aux;
            if (numberS.indexOf(option) != 0) {

                numberC= numberC+aux;
                n2 = Double.parseDouble(numberC);
                res= Operations.Opera(option.charAt(0),n,n2);
                txtOutCome.setText(String.valueOf(res));

            }else{

                numberC = numberC+aux;
                n = Double.parseDouble(numberC);
                res=n;

            }

            txtData.setText(numberS);
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error!");
            alert.setContentText("Dato incorrecto");
            alert.showAndWait();
        }

    }

    @FXML
    void Operation(ActionEvent event) {
        Button button = (Button) event.getSource();
        option = button.getText();
        if(option.equals("=")==true){
            txtData.setText(String.valueOf(res));
            txtOutCome.setText(null);
            numberS = String.valueOf(res);
        }else {
            numberS = numberS + option;

            txtData.setText(numberS);
        }
        n=res;
        numberC="";
    }

    @FXML
    void Delet(ActionEvent event) {
        txtOutCome.clear();
        txtData.clear();
        numberS="";
        numberC="";
        option="";
        n2=0;
        res=0;
        n=0;

    }


    @FXML
    void Back(ActionEvent event) throws InvocationTargetException {

        if (numberS.length() >= 1) {
            numberS = numberS.substring(0, numberS.length() - 1);
            txtData.setText(numberS);


        }



        if(numberC.length() >1 && option.equals("")==false){

            numberC= numberC.substring(0,numberC.length()-1);
            n2 = Double.parseDouble(numberC);
            res=Operations.Opera(option.charAt(0),n,n2);
            txtOutCome.setText(String.valueOf(res));


        }else {

            numberC="";
            txtOutCome.setText(String.valueOf(res));
            res=n;
        }

    }

    @FXML
    void Easteregg(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Easter egg");
        alert.setContentText("\n\t\tRecuerda siempre tomar agua :)");
        alert.showAndWait();

    }
}