import com.sun.istack.internal.NotNull;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Matrix2d {
    //int array to store the int value of the matrix
    private int[][] matrix;
    //constructor
    public Matrix2d(int[][] matrix)
    {
        this.matrix=matrix;
    }

    //multiplies this matrix with a scalar and sets the value of this matrix as the solution
    public void multiply(int scalar)
    {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c]*=scalar;
            }
        }
    }

    //multiplies this matrix with a matrix in an int array and sets the value of this matrix as the solution
    public void multiply(int[][] otherMatrix)
    {
        if(otherMatrix.length!=matrix[0].length)
        {
            matrixHasUnequalRowCol(otherMatrix.length,matrix[0].length);
            return;
        }
        int[][] newMatrix = new int[matrix.length][otherMatrix[0].length];
        for (int r = 0; r < newMatrix.length; r++) {
            for (int c = 0; c < newMatrix[0].length; c++) {
                newMatrix[r][c] = computeMultiplication(r,c,matrix, otherMatrix);
            }
        }
        matrix=newMatrix;
    }
    //helper method to compute the value of a matrix at an index
    private int computeMultiplication(int row, int col, int[][]firstMatrix, int[][] secondMatrix)
    {
        int [] firstMatrixRows = firstMatrix[row];
        int total =0;
        for (int i = 0; i < firstMatrixRows.length; i++) {
            total+=firstMatrixRows[i]*secondMatrix[i][col];
        }
        return total;
    }


    //multiplies this matrix with a matrix and sets the value of this matrix as the solution
    public void multiply(Matrix2d otherMatrix)
    {
        multiply(otherMatrix.getMatrix());
    }


    //adds this matrix with a matrix in an int array and sets the value of this matrix as the solution
    public void add(int[][] otherMatrix)
    {
        if(matrix.length!=otherMatrix.length||matrix[0].length!=otherMatrix[0].length)
        {
            matrixUnequalDimensions();
            return;
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c]+=otherMatrix[r][c];
            }
        }

    }


    //multiplies this matrix with a matrix and sets the value of this matrix as the solution
    public void add(@NotNull Matrix2d otherMatrix)
    {
        add(otherMatrix.getMatrix());
    }

    //adss negatively to this matrix the other matrix
    public void subtract(int[][] matrix)
    {
        add(Matrix2d.negate(matrix));
    }


    //adss negatively to this matrix the other matrix
    public void subtract(@NotNull Matrix2d otherMatrix)
    {
        subtract(otherMatrix.getMatrix());
    }

    //getter method for the matrix
    public int[][] getMatrix() {
        return matrix;
    }

    //multiplies every indice in the matrix by -1
    public static int[][] negate(int[][] matrix)
    {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[r][c]*=-1;
            }

        }
        return matrix;
    }
    //error message for unequal rows  can cols
    public void matrixHasUnequalRowCol(int row, int col)
    {
        System.out.println(row+" does not equal "+col+"  The matrices row and column do not match.");
    }
    //error message for unequal dimentions
    public void matrixUnequalDimensions()
    {
        System.out.println("Matrices do not have the same dimensions");
    }

    //to string method that prints out the matrix elements
    @Override
    public String toString() {
        return Arrays.deepToString(matrix);
    }
}
