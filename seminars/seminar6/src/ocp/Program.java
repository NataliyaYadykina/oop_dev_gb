package ocp;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<>();
        shapes.add(new RightTriangle(2, 3));
        shapes.add(new Square(3));
        shapes.add(new Circle(5));
        double sumArea = 0;
        for(Shape shape : shapes){
            sumArea += shape.getArea();
            /*if (shape instanceof RightTriangle){
                RightTriangle triangle = (RightTriangle) shape;

            }
            if (shape instanceof Square){
                Square square = (Square) shape;

            }*/
        }

        System.out.printf("Сумма площадей фигур равна %f \n", sumArea);

    }

}
