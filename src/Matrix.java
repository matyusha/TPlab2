import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Matrix {


    private double[][] m = new double[2][2];

    public Matrix(){}

    public Matrix(double[][] m){
        this.m = m;
    }

    public double getElement(int row, int column) throws ArrayIndexOutOfBoundsException{
        if(row < 0 || column < 0 || row >= 2 || column >= 2) {
            throw new ArrayIndexOutOfBoundsException("Выход за границы матрицы");
        }
        return this.m[row][column];
    }

    @XmlElement
    public void setMatrix(double[][] a){
        m = a;
    }

    public double[][] getMatrix(){
        return m;
    }

   public void sumMatrix(Matrix matrix) throws JAXBException {
        m[0][0] += matrix.getElement(0,0);
        m[0][1] += matrix.getElement(0,1);
        m[1][0] += matrix.getElement(1,0);
        m[1][1] += matrix.getElement(1,1);
    }

    public void multMatrix(Matrix matrix) throws JAXBException {
        double[][] newMatrix = new double[2][2];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    newMatrix[i][j] += m[i][k]*matrix.getElement(k,j);
                }
            }
        }
        m = newMatrix;
    }

    public void printMatrix(){
        System.out.println(m[0][0] + " " + m[0][1]);
        System.out.println(m[1][0] + " " + m[1][1]);
    }
}
