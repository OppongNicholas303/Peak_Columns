import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Receive user input for matrix dimensions
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows: ");
        if(!sc.hasNextInt()) System.out.println("Invalid integer restart the Application!");
        int row = sc.nextInt();

        System.out.println("Enter number of columns: ");
        if(!sc.hasNextInt()) System.out.println("Invalid integer restart the Application!");
        int column = sc.nextInt();

        //Set matrix dimension with user defined input
        int [][] matrix = new int[row][column];

        // Insert rows and columns into the matrix
        inputFunction(matrix);

        // Check if no element meet the peak column rule
        boolean isElementFind = false;

        // Loop through the array with the array length
        for(int i=0; i<matrix.length; i++){
            // Find the maximum number of each row

           int maxRow =  maxNumberInRow(matrix, i);
            /* After finding the max loop through each row to find
                the element equal to max value
             */

            for(int k=0; k<matrix[i].length; k++){
                int rowIndex = 0;

                /* Check if max is equal to the element
                   then you loop through it colum to see if it is minimum
                   at it column
                */

                if(maxRow == matrix[i][k]){
                    rowIndex = k;

                    boolean isMinColumn = true;

                    for(int j=0; j<matrix.length; j++){
                        int minColumn = matrix[i][rowIndex];

                        if(minColumn > matrix[j][rowIndex]){
                            isMinColumn=false;
                            break;
                        }
                    }

                    if (isMinColumn){
                        isElementFind = true;
                        System.out.println("("+i+"," + rowIndex + ")" + " = " + matrix[i][rowIndex]);
                    }
                }
            }
        }

       if(!isElementFind) System.out.println("no element found");

    }

    public static void inputFunction(int [][] matrix){
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<matrix.length; i++){
            // matrix [1][0] =

            for (int j=0; j<matrix[0].length; j++){
                System.out.print("Enter element [" + i + "][" +  j + "]: ");
                if(!sc.hasNextInt()) System.out.println("Invalid integer restart the Application!");
                matrix[i][j] = sc.nextInt();
            }
        }

    }

    public static int maxNumberInRow(int [][] row, int index){
        int maxRow = row[index][0];

        for(int t=0; t<row[index].length; t++){
            if(maxRow < row[index][t]){
                maxRow = row[index][t];
            }
        }

        return maxRow;
    }
}