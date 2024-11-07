import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int [][] matrix1 = {{1, 8, 3, 4, 0},{6, 7, 2, 7,0}};

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows: ");
        int row = sc.nextInt();

        System.out.println("Enter number of columns: ");
        int column = sc.nextInt();

        int [][] matrix = new int[row][column];

        for(int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                System.out.print("Enter element [" + i + "][" +  j + "]: ");
                matrix[i][j] = sc.nextInt();

            }
        }

        boolean isElementFind = false;

        /*
            find the lent of the array and use it to loop through
         */
        for(int i=0; i<matrix.length; i++){
            // Find the maximum number of each row
            int maxRow = matrix[i][0];
            for(int k=0; k<matrix[i].length; k++){
                if(maxRow < matrix[i][k]){
                    maxRow = matrix[i][k];
//                    indexRow = k;
                }
            }

            /* After finding the max loop through each row to find
                the element equal to max value
             */
            for(int k=0; k<matrix[i].length; k++){
                int indexRow = 0;

                // Check if max is equal to the element
                // then you loop through it colum to see if it is minimum
                // at it column

                if(maxRow == matrix[i][k]){
                    indexRow = k;

                    boolean isMinCol = true;

                    for(int j=0; j<matrix.length; j++){
                        int minCol = matrix[i][indexRow];

                        if(minCol > matrix[j][indexRow]){
                            isMinCol=false;
                            break;
                        }

                    }

                    if (isMinCol){
                        isElementFind = true;
                        System.out.println("("+i+"," + indexRow + ")" + " = " + matrix[i][indexRow]);
                    }

                }
            }
        }

       if(!isElementFind) System.out.println("no element found");

    }
}