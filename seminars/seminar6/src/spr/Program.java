package spr;

public class Program {

    public static void main(String[] args) {

        Square square = new Square(new Point(1, 1), 5);
        System.out.printf("Площадь фигуры: %d \n", square.getArea());
        SquareDrawer squareDrawer = new SquareDrawer(square);
        squareDrawer.draw(3);

    }

}
