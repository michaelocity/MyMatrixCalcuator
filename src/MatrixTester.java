import java.util.Arrays;

public class MatrixTester {
    //instance arrays of matrices to test
    public static  final int [][] test1 = {{-2,-1,1,3},{-3,2,4,-2}};
    public static final int [] [] test2 ={{-1,0},{0,1}};
    //method to test if matricies are working correctly
    public static void main(String[] succQuestionMark)
    {
        System.out.println(Arrays.toString(succQuestionMark));

        Matrix2d matrix1 = new Matrix2d(test1), matrix2 = new Matrix2d(test2);
        System.out.println(matrix1+"  "+matrix2);
        System.out.println(matrix2);
        matrix2.multiply(matrix1);
        System.out.println(matrix2);

    }
}
