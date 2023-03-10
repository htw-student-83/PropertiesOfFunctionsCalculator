package ui;

import businesslogic.Calculation;
import java.util.Scanner;

public class UI {
    Scanner eingabe = new Scanner(System.in);
    Calculation calculator = new Calculation();
    private void startMenu(double gradien_F, double yValue_F, double gradien_F2, double yValue_F2){
        final String INTERFACE_X_AXIS = "1";
        final String INTERFACE_Y_AXIS = "2";
        final String GRADIEND = "3";
        final String INTERFACE_OF_FUNCTIONS = "4";
        final String ANGEL_OF_GRADIEND = "5";
        final String ANGEL_BETWEEN_FUNCTION = "6";
        final String ORTHOGONAL_FUNCTION = "7";
        final String PARALLEL_FUNCTION = "8";
        final String ALL_PROPERTIES = "9";

        System.out.println("Which of the following properties should calculate?");
        System.out.println("(1) - interface with X-Axis");
        System.out.println("(2) - interface with Y-Axis");
        System.out.println("(3) - gradiend");
        System.out.println("(4) - interface of functions");
        System.out.println("(5) - angel of gradiend");
        System.out.println("(6) - angel between functions");
        System.out.println("(7) - orthogonal function");
        System.out.println("(8) - parallelim function");
        System.out.println("(9) - all properties");
        String option = eingabe.next();
        switch (option) {
            case INTERFACE_X_AXIS:
                System.out.println("Interface X_Axis of function 1: " + "(" + toDataForCalculatinInterfaceWithXaxis(gradien_F, yValue_F)+"/0)");
                System.out.println("Interface X_Axis of function 2: " + "(" + toDataForCalculatinInterfaceWithXaxis(gradien_F2, yValue_F2)+"/0)");
                break;
            case INTERFACE_Y_AXIS:
                System.out.println("Interface Y_Axis of function 1: (0/" + toDataForCalculatinInterfaceWithYaxis(yValue_F)+")");
                System.out.println("Interface Y_Axis of function 2: (0/" + toDataForCalculatinInterfaceWithYaxis(yValue_F2)+")");
                break;
            case GRADIEND:
                System.out.println("Gradiend of function 1: " + toDataForCalculatinTheGradiend(gradien_F));
                System.out.println("Gradiend of function 2: " + toDataForCalculatinTheGradiend(gradien_F2));
                break;
            case INTERFACE_OF_FUNCTIONS:
                System.out.println("Interface_Point: " + toDataForCalculatinTheInteraceOfFunctions(gradien_F, gradien_F2, yValue_F, yValue_F2));
                break;
            case ANGEL_OF_GRADIEND:
                System.out.println("Angel of function 1: " + toDataForCalculatinTheAngel(gradien_F)+"°");
                System.out.println("Angel of function 2: " + toDataForCalculatinTheAngel(gradien_F2)+"°");
                break;
            case ANGEL_BETWEEN_FUNCTION:
                System.out.println("Angel between functions: " + toDataForCalculatinTheAngelBetweenFunctions(gradien_F, gradien_F2)+"°");
                break;
            case ORTHOGONAL_FUNCTION:
                System.out.println("Wie lautet der Punkt durch die neue Funktion gehen soll?");
                Scanner eingabe = new Scanner(System.in);
                String coordinates = eingabe.nextLine();
                String [] coordinateArray = coordinates.split(" ");
                String x = coordinateArray[0];
                String y = coordinateArray[1];
                double x_pointD = Double.parseDouble(x);
                double y_pointD = Double.parseDouble(y);
                System.out.println("Orthogonal function to function 1: " + toDataForCalculatinTheOrthogonalFunction(gradien_F, x_pointD, y_pointD));
                break;
            case PARALLEL_FUNCTION:
                System.out.println("Wie lautet der Punkt durch die neue Funktion gehen soll?");
                Scanner eingabe2 = new Scanner(System.in);
                String coordinates2 = eingabe2.nextLine();
                String [] coordinateArray2 = coordinates2.split(" ");
                String x2 = coordinateArray2[0];
                String y2 = coordinateArray2[1];
                double x_pointD2 = Double.parseDouble(x2);
                double y_pointD2 = Double.parseDouble(y2);
                System.out.println("A parallel function to function 1: " + toDataForCalculatinTheParallelFunction(gradien_F, x_pointD2, y_pointD2));
                break;
            case ALL_PROPERTIES:
                toDataForCalculatAllProperties(gradien_F, gradien_F2, yValue_F, yValue_F2);
                break;
            default:
                System.out.println("unvalid input.");
        }
    }

    public void configuration_input() {
        String coefficients = "";
        System.out.println("Please input the coefficients of the first function..");
        coefficients = eingabe.nextLine();
        String[] coefficientsArray = coefficients.split(" ");

        System.out.println("Please input the coefficients of the second function..");
        coefficients = eingabe.nextLine();
        String[] coefficientsArray2 = coefficients.split(" ");

        String firstNumber_f = "";
        String secondNumber_f = "";
        String firstNumber_f2 = "";
        String secondNumber_f2 = "";
        for(int i = 0; i<coefficientsArray.length; i++){
            firstNumber_f = coefficientsArray[0];
            secondNumber_f = coefficientsArray[1];
        }

        double gradien_F = Double.parseDouble(firstNumber_f);
        double yValue_F = Double.parseDouble(secondNumber_f);

        for(int i = 0; i<coefficientsArray2.length; i++){
            firstNumber_f2 = coefficientsArray2[0];
            secondNumber_f2 = coefficientsArray2[1];
        }

        double gradien_F2 = Double.parseDouble(firstNumber_f2);
        double yValue_F2 = Double.parseDouble(secondNumber_f2);
        startMenu(gradien_F, yValue_F, gradien_F2, yValue_F2);
    }

    private double toDataForCalculatinInterfaceWithXaxis(double y_axis_f, double gradient_f) {
        return calculator.calculateTheIntersectionWithXaxis(y_axis_f, gradient_f);
    }

    private double toDataForCalculatinInterfaceWithYaxis(double y_axis_f) {
        return calculator.calculateTheIntersectionWithYaxis(y_axis_f);
    }

    private double toDataForCalculatinTheGradiend(double gradiend) {
        return calculator.calculateTheIntersectionWithYaxis(gradiend);
    }

    private String toDataForCalculatinTheInteraceOfFunctions(double gradien_F, double gradien_F2, double yValue_F, double yValue_F2) {
        return calculator.calculateTheInterface(yValue_F, yValue_F2, gradien_F, gradien_F2);
    }

    private double toDataForCalculatinTheAngel(double gradien_F) {
        return calculator.calculateTheAngleToXaxis(gradien_F);
    }

    private double toDataForCalculatinTheAngelBetweenFunctions(double gradien_F, double gradiend_F2) {
        return calculator.calculateTheAngleEpsilon(gradien_F,gradiend_F2);
    }

    private String toDataForCalculatinTheOrthogonalFunction(double gradien_F, double x_Point, double y_value) {
        return calculator.calculateTheOrthogonalLine(gradien_F, x_Point, y_value);
    }

    private String toDataForCalculatinTheParallelFunction(double gradien_F, double x_Point, double y_value) {
        return calculator.calculateTheParallelFunction(gradien_F, x_Point, y_value);
    }

    private void toDataForCalculatAllProperties(double gradien_F, double gradien_F2, double yValue_F, double yValue_F2) {
        System.out.println("Wie lautet der Punkt durch die die orthogonale Funktion gehen soll?");
        Scanner eingabe = new Scanner(System.in);
        String coordinates = eingabe.nextLine();
        String [] coordinateArray = coordinates.split(" ");
        String x = coordinateArray[0];
        String y = coordinateArray[1];
        double x_pointD = Double.parseDouble(x);
        double y_pointD = Double.parseDouble(y);
        //TODO alle Properties sollen berechnet und ausgegeben werden
        System.out.println("The following properties in the view:");
        System.out.println("Interface X_Axis of function 1: " + "(" + toDataForCalculatinInterfaceWithXaxis(gradien_F, yValue_F)+"/0)");
        System.out.println("Interface X_Axis of function 2: " + "(" + toDataForCalculatinInterfaceWithXaxis(gradien_F2, yValue_F2)+"/0)");
        System.out.println("Interface Y_Axis of function 1: (0/" + toDataForCalculatinInterfaceWithYaxis(yValue_F)+")");
        System.out.println("Interface Y_Axis of function 2: (0/" + toDataForCalculatinInterfaceWithYaxis(yValue_F2)+")");
        System.out.println("Gradiend of function 1: " + toDataForCalculatinTheGradiend(gradien_F));
        System.out.println("Gradiend of function 2: " + toDataForCalculatinTheGradiend(gradien_F2));
        System.out.println("Interface_Point: " + toDataForCalculatinTheInteraceOfFunctions(gradien_F, gradien_F2, yValue_F, yValue_F2));
        System.out.println("Angel of function 1: " + toDataForCalculatinTheAngel(gradien_F)+"°");
        System.out.println("Angel of function 2: " + toDataForCalculatinTheAngel(gradien_F2)+"°");
        System.out.println("Orthogonal function to function 1: " + toDataForCalculatinTheOrthogonalFunction(gradien_F, x_pointD, y_pointD));
        System.out.println("A parallel function to function 1: " + toDataForCalculatinTheParallelFunction(gradien_F, x_pointD, y_pointD));
    }
}
