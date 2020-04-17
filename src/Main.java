import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, JAXBException {
        System.out.println("Application: matrix calculator. You can add and multiply 2 * 2 matrices.");
        System.out.println("Please, enter matrix");
        Scanner br = new Scanner(System.in);
        double[][] a = new double[2][2];
        Matrix matrix1 = new Matrix(readMatrix(a, br));
        ParseMatrix parseMatrix = new ParseMatrix();
        parseMatrix.WriteMatrix(matrix1);
        Matrix matrix2 = new Matrix();

        System.out.println("What do you want to do? \n" +
                "Enter 1 to add the matrix to another matrix, \n" +
                "Enter 2 to multiply the matrix by another matrix, \n" +
                "Enter 0 to exit");
        int b = readChoice(br);
        double[][] a1 = new double[2][2];

        while (b != 0) {
            System.out.println("Enter second matrix:");
            a1 = readMatrix(a1, br);
            matrix2.setMatrix(a1);

            if (b == 1){
                matrix1.printMatrix();
                System.out.println("+");
                matrix2.printMatrix();
                System.out.println("=");
                matrix1.sumMatrix(matrix2);
                matrix1.printMatrix();

                parseMatrix.WriteMatrix(matrix1);
            }
            if (b == 2){
                matrix1.printMatrix();
                System.out.println("*");
                matrix2.printMatrix();
                System.out.println("=");
                matrix1.multMatrix(matrix2);
                matrix1.printMatrix();

                parseMatrix.WriteMatrix(matrix1);
            }
            System.out.println("What do you want to do? \n" +
                    "Enter 1 to add the matrix to another matrix, \n" +
                    "Enter 2 to multiply the matrix by another matrix, \n" +
                    "Enter 0 to exit");
            b = readChoice(br);
        }
    }

    private static double[][] readMatrix(double[][] a, Scanner br){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                try{
                    a[i][j] = br.nextDouble();
                }
                catch (InputMismatchException e){
                    System.out.println("Enter double");
                    br.nextLine();
                    j--;
                }
            }
        }
        br.nextLine();
        return a;
    }

    private static int readChoice(Scanner br){
        int b = 0;
        boolean f = true;
        while (f) {
            try {
                b = br.nextInt();
                f = false;
            } catch (InputMismatchException e) {
                System.out.println("You entered incorrect choice \n" +
                        "What do you want to do? \n" +
                        "Enter 1 to add the matrix to another matrix, \n" +
                        "Enter 2 to multiply the matrix by another matrix, \n" +
                        "Enter 0 to exit");
                br.nextLine();
                f = true;
                b =0;
            }
            if (b < 0 || b > 2){
                System.out.println("You entered incorrect choice \n" +
                        "What do you want to do? \n" +
                        "Enter 1 to add the matrix to another matrix, \n" +
                        "Enter 2 to multiply the matrix by another matrix, \n" +
                        "Enter 0 to exit");
                f = true;
            }
        }
        return b;
    }
}
