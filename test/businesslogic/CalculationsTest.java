package businesslogic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculationsTest {

    Vertrag calulator = new Calculation();

    @Test
    void calculateTheIntersectionWithXaxisTest() {
        double steigung = 2.0;
        double intersection_yAxis = 1.0;
        double intersection_x = calulator.calculateTheIntersectionWithXaxis(steigung, intersection_yAxis);
        Assert.assertEquals(intersection_x, -0.5);
    }


    @Test
    void calculateTheIntersectionWithXaxisTest2() {
        double steigung = 2.0;
        double intersection_yAxis = -1.0;
        double intersection_x = calulator.calculateTheIntersectionWithXaxis(steigung, intersection_yAxis);
        Assert.assertEquals(intersection_x, 0.5);
    }


    @Test
    void calculateTheIntersectionWithXaxis3() {
        double steigung = -2.0;
        double intersection_yAxis = 1.0;
        double intersection_x = calulator.calculateTheIntersectionWithXaxis(steigung, intersection_yAxis);
        Assert.assertEquals(intersection_x, 0.5);
    }

    @Test
    void calculateTheIntersectionWithXaxis4() {
        double steigung = -2.0;
        double intersection_yAxis = -1.0;
        double intersection_x = calulator.calculateTheIntersectionWithXaxis(steigung, intersection_yAxis);
        Assert.assertEquals(intersection_x, -0.5);
    }

    @Test
    void calculateTheIntersectionWithXaxis5() {
        double steigung = -2.5;
        double intersection_yAxis = -1.5;
        double intersection_x = calulator.calculateTheIntersectionWithXaxis(steigung, intersection_yAxis);
        Assert.assertEquals(intersection_x, -0.6);
    }

    @Test
    void calculateTheIntersectionWithXaxis6() {
        double steigung = -2.5;
        double intersection_yAxis = -1.0;
        double intersection_x = calulator.calculateTheIntersectionWithXaxis(steigung, intersection_yAxis);
        Assert.assertEquals(intersection_x, -0.4);
    }

    @Test
    void calculateTheIntersectionWithXaxis7() {
        double steigung = -2.0;
        double intersection_yAxis = -1.5;
        double intersection_x = calulator.calculateTheIntersectionWithXaxis(steigung, intersection_yAxis);
        Assert.assertEquals(intersection_x, -0.75);
    }

    @Test
    void calculateTheInterfaceTest() {
        double intersection_yAxis_f1 = 1.0;
        double intersection_yAxis_f2 = 3.0;
        double gradient_f1 = 2.0;
        double gradient_f2 = 4.0;
        String result = calulator.calculateTheInterface(intersection_yAxis_f1, intersection_yAxis_f2,
                gradient_f1, gradient_f2);
        Assert.assertEquals(result,"(-1.0/-1.0)");
    }


    @Test
    void calculateTheInterfaceTest2() {
        double intersection_yAxis_f1 = -1.0;
        double intersection_yAxis_f2 = -3.0;
        double gradient_f1 = -2.0;
        double gradient_f2 = -4.0;
        String result = calulator.calculateTheInterface(intersection_yAxis_f1, intersection_yAxis_f2,
                gradient_f1, gradient_f2);
        Assert.assertEquals(result,"(-1.0/1.0)");
    }


    @Test
    void calculateTheInterfaceTest5() {
        double intersection_yAxis_f1 = -1.5;
        double intersection_yAxis_f2 = -3.5;
        double gradient_f1 = 2.0;
        double gradient_f2 = -4.0;
        String result = calulator.calculateTheInterface(intersection_yAxis_f1, intersection_yAxis_f2,
                gradient_f1, gradient_f2);
       Assert.assertEquals(result,"(-0.3/-2.2)");
    }


    @Test
    void calculateTheIntersectionOfFunctionsTest7() {
        double gradient_f1 = 2.0;
        double gradient_f2 = 2.0;
        double intersection_yAxis_f1 = -1.5;
        double intersection_yAxis_f2 = -3.5;
        String result = calulator.calculateTheInterface(intersection_yAxis_f1, intersection_yAxis_f2,
                gradient_f1, gradient_f2);
        Assert.assertEquals(result, "No value exists.");
    }

    @Test
    void calculateTheParallelism() {
        double gradient_f1 = -2.2;
        double gradient_f2 = -2.2;
        double intersection_yAxis_f1 = -1.5;
        double intersection_yAxis_f2 = -3.5;
        String result = calulator.calculateTheInterface(intersection_yAxis_f1, intersection_yAxis_f2,
                gradient_f1, gradient_f2);
        Assert.assertEquals(result, "No value exists.");
    }

    @Test
    void calculateTheGradient() {
        double gradient_f = -2.4;
        double gradient = calulator.calculateTheGradient(gradient_f);
        Assert.assertEquals(gradient, -2.4);
    }


    @Test
    void calculateTheGradient2() {
        double gradient_f = -2.0;
        double gradient = calulator.calculateTheGradient(gradient_f);
        Assert.assertEquals(gradient, -2.0);
    }

    @Test
    void calculateTheGradient3() {
        double gradient_f = 2.0;
        double gradient = calulator.calculateTheGradient(gradient_f);
        Assert.assertEquals(gradient, 2.0);
    }


    @Test
    void calculateTheGradient4() {
        double gradient_f = -2.2;
        double gradient = calulator.calculateTheGradient(gradient_f);
        Assert.assertEquals(gradient, -2.2);
    }

    @Test
    void calculateTheAngle() {
        double gradient_f = 2.0;
        double angelBetweenFunctions = calulator.calculateTheAngleToXaxis(gradient_f);
        Assert.assertEquals(angelBetweenFunctions, 63.43);
    }

    @Test
    void calculateTheAngle3() {
        double gradient_f = -2.0;
        double gradient_g = -3.0;
        double angelEpsilon = calulator.calculateTheAngleEpsilon(gradient_f, gradient_g);
        Assert.assertEquals(angelEpsilon,8.14);
    }

    @Test
    void calculateTheAngle4() {
        double gradient_f = 2.0;
        double gradient_g = 3.0;
        double angelEpsilon = calulator.calculateTheAngleEpsilon(gradient_f, gradient_g);
        Assert.assertEquals(angelEpsilon, 8.14);
    }


    @Test
    void calculateTheParallelism2() {
        double gradient_f1 = -2.1;
        double gradient_f2 = -2.2;
        double intersection_yAxis_f1 = -1.5;
        double intersection_yAxis_f2 = -3.5;
        String result = calulator.calculateTheInterface(intersection_yAxis_f1, intersection_yAxis_f2,
                gradient_f1, gradient_f2);
        Assert.assertEquals(result, "(-20.0/40.5)");
    }

    @Test
    void calculateTheIntersectionWithYaxisTest() {
        double intersection_yAxis_f = 1.0;
        double intersectionPoint = calulator.calculateTheIntersectionWithYaxis(intersection_yAxis_f);
        Assert.assertEquals(intersectionPoint, 1.0);
    }

    @Test
    void calculateTheIntersectionWithYaxisTest2() {
        double intersection_yAxis_f = -1.0;
        double intersectionPoint = calulator.calculateTheIntersectionWithYaxis(intersection_yAxis_f);
        Assert.assertEquals(intersectionPoint, -1.0);
    }


    @Test
    void calculateTheIntersectionWithYaxisTest3() {
        double intersection_yAxis_f = 1.5;
        double intersectionPoint = calulator.calculateTheIntersectionWithYaxis(intersection_yAxis_f);
        Assert.assertEquals(intersectionPoint, 1.5);
    }


    @Test
    void calculateTheIntersectionWithYaxisTest4() {
        double intersection_yAxis_f = -1.5;
        double intersectionPoint = calulator.calculateTheIntersectionWithYaxis(intersection_yAxis_f);
        Assert.assertEquals(intersectionPoint, -1.5);
    }

    @Test
    void calculateTheOrthogonalLine1() {
        double gradient_f = 2.0;
        double y_value = 0.0;
        double x_value = 4.0;
        String orthogonalFunction = calulator.calculateTheOrthogonalLine(gradient_f, x_value, y_value);
        Assert.assertEquals(orthogonalFunction, "-0.5x+2.0");
    }

    @Test
    void calculateTheParalismLine1() {
        double gradient_f = 2.0;
        double y_value = 0.0;
        double x_value = 4.0;
        String parallelismFunction = calulator.calculateTheParallelFunction(gradient_f, x_value, y_value);
        Assert.assertEquals(parallelismFunction, "2.0x-8.0");
    }
}