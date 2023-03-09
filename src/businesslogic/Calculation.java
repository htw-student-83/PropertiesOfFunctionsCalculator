package businesslogic;

public class Calculation implements Vertrag {

    // Hinweis: gilt erstmal nur für die 1. Dimension

    @Override
    public double calculateTheIntersectionWithXaxis(double gradient_f, double n) {
        return -n/gradient_f;
    }

    @Override
    public String calculateTheInterface(double n_f1, double m_f2, double gradiend_f1, double gradiend_f2) {
        if(!isParallel(gradiend_f1, gradiend_f2)){
            double x_point = (m_f2 - n_f1)/(gradiend_f1 - gradiend_f2);
            double y_point = calculateTheValueOfFunktion(gradiend_f1, n_f1, x_point);
            // Ergebnisse werden auf 1 Stelle nach dem Komma gerundet.
            return "(" + Math.round(x_point * 10) / 10. + "/" + Math.round(y_point * 10) / 10. + ")";
        }else{
            return "No value exists.";
        }
    }

    private double calculateTheValueOfFunktion(double gradiend_f1, double n_f1, double x_point) {
        //Syntax: 2 * x + n
        return gradiend_f1*x_point + n_f1;
    }

    @Override
    public double calculateTheGradient(double gradient_f) {
        return gradient_f;
    }


    private boolean isParallel(double gradient_f1, double gradient_f2) {
        return gradient_f1 == gradient_f2;
    }

    @Override
    public double calculateTheIntersectionWithYaxis(double intersection_yAxis_f) {
        return intersection_yAxis_f;
    }

    @Override
    public double calculateTheAngleToXaxis(double gradient_f) {
        // ist die Steigung als Winkel < 0?
        // dann [180° - die Steigung als Winkel] anwenden
        if(gradient_f<0){
            double radiend = Math.atan(gradient_f);
            double angel = Math.toDegrees(radiend);
            double angelRound = Math.round(angel*100)/100.;
            double postiveAngelRound = angelRound*(-1);
            return  180 - postiveAngelRound;
        }else{
            double radiend = Math.atan(gradient_f);
            double angel = Math.toDegrees(radiend);
            return Math.round(angel*100)/100.;
        }
    }

    @Override
    public double calculateTheAngleEpsilon(double gradient_f, double gradient_g) {
        double angelBetweenFunction = 0.0;
        double angeldifferent = 0.0;
        double angleToXaxis_f = calculateTheAngleToXaxis(gradient_f);
        double angleToXaxis_g = calculateTheAngleToXaxis(gradient_g);
        if(angleToXaxis_f > angleToXaxis_g){
            angeldifferent = angleToXaxis_f - angleToXaxis_g;
            angelBetweenFunction = Math.round(angeldifferent * 100) / 100.;
        }else {
            angeldifferent =  angleToXaxis_g - angleToXaxis_f;
            angelBetweenFunction = Math.round(angeldifferent * 100) / 100.;
        }
        return angelBetweenFunction;
    }

    @Override
    public String calculateTheOrthogonalLine(double gradient_f, double x_value, double y_value) {
        double reziprokeValue = -1/gradient_f;
        double y_intersection =  y_value - (reziprokeValue * x_value);
        return reziprokeValue + "x+" + y_intersection;
    }

    @Override
    public String calculateTheParallelFunction(double gradient_f, double x_value, double y_value) {
        double y_intersection = y_value - (gradient_f * x_value);
        if(y_intersection<0){
            return gradient_f + "x" + y_intersection;
        }else{
            return gradient_f + "x + " + y_intersection;
        }
    }
}
