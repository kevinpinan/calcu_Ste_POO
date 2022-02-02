package Modelo;


public class Operations {
    public static double Opera (char o, double n1, double n2){

        double res=0;
        switch (o){
            case '+':
                res=n1+n2;
                break;
            case '-':
                res=n1-n2;
                break;
            case 'x':
                res=n1*n2;
                break;
            case '÷':
                res=n1/n2;

                break;

        }

        return res;
    }
}
