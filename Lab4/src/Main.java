import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, NoSuchElementException,IllegalArgumentException{
        try {
            File file = new File("c:\\Users\\NIKJOR\\Documents\\inputFile.txt");
            double[][] matrix1 = readFile(file);
            matrix1 = task2(matrix1, matrix1.length);
            printMatrix(matrix1);
        }
        catch (FileNotFoundException e1)
        {
            System.out.println(e1.getMessage());
        }
        catch (IllegalArgumentException e2)
        {
            System.out.println(e2.getMessage());
        }
        catch (NoSuchElementException e3)
        {
            System.out.println(e3.getMessage());
        }
    }
        public static double[][] readFile(File file) throws FileNotFoundException, NoSuchElementException,IllegalArgumentException
        {
            Scanner s = new Scanner(file);
            int RowsCount = s.nextInt();
            int ColumnsCount = s.nextInt();
            if(RowsCount <= 0 || ColumnsCount <= 0)
            {
                throw new IllegalArgumentException("Troubles with matrix elements!");
            }
            double[][] Matrix = new double[RowsCount][ColumnsCount];
            for(int i = 0;i < RowsCount;i ++)
                for(int j = 0;j < ColumnsCount;j++)
                    Matrix[i][j] = s.nextInt();
            if(s.hasNext())
            {
                throw new IllegalArgumentException("Error!");
            }
            return Matrix;
        }

    public static double[][] task2(double[][] matrix, int size) {
        double[][] identityMatrix = new double[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (i == j)
                    identityMatrix[i][i] = 1;
                else
                    identityMatrix[i][j] = 0;
            }
        for (int i = 0; i < size; i++) {
            double current = matrix[i][i];
            if(current != 1)
             for (int j = 0; j < size; j++) {
                identityMatrix[i][j] /= current;
                matrix[i][j] /= current;
            }
            for (int k = i + 1; k < size; k++) {
                current = -1.0*matrix[k][i];
                if(current != 0)
                 for (int j = 0; j < size; j++) {
                    matrix[k][j] += current * matrix[i][j];
                    identityMatrix[k][j] += current * identityMatrix[i][j];
                }
            }
        }
        for (int i = size - 1; i > 0; i--)
            for (int j = i - 1; j >= 0; j--) {
                double current = -1.0 * matrix[j][i];
                if(current != 0)
                 for (int k = 0; k < size; k++) {
                    matrix[j][k] += matrix[i][k] * current;
                    identityMatrix[j][k] += identityMatrix[i][k] * current;
                }
            }
        return identityMatrix;
    }
    public static void printMatrix(double[][] matrix)
    {
        for (double[] arr:matrix) {
            for (double j : arr) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
    }
}