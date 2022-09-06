import java.io.*;
import java.util.*;

/**
 * Клас Lab2YurchukKi34 реалізує код до лабораторної роботи №2
 *
 * @author Nazar Yurchuk
 * @version 1.0
 * @since version 1.0
 */


public class Lab2YurchukKi34 {
    /**
     * Статичний метод main є точкою входу в програму
     *
     * @param args
     * @throws FileNotFoundException
     */

    public static void main(String[] args) throws FileNotFoundException {
        int rows;
        char[][] array;
        String symbol;
        Scanner sc = new Scanner(System.in);
        File dataFile = new File("Array.txt");
        PrintWriter fout = new PrintWriter(dataFile);
        System.out.print("Enter array size: ");
        rows = sc.nextInt();
        sc.nextLine();
        array = new char[rows][];
        for (int i = 0; i < rows; i++) {
            if (i < rows / 2) {
                array[i] = new char[rows-2*i];
            } else {
                array[i] = new char[2*i+2-rows];
            }
        }
        System.out.print("\nEnter a symbol: ");
        symbol = sc.nextLine();
        if (symbol.length() == 1) {
            for (int i = 0; i < rows; i++) {
                for(int k=0;k<(rows-array[i].length)/2;k++) {
                    System.out.print("\t");
                    fout.print("\t");
                }
                for (int j = 0; j < rows; j++) {
                    if(j<array[i].length) {
                        array[i][j] =(char) symbol.codePointAt(0);
                        System.out.print(array[i][j] + "\t");
                        fout.print(array[i][j] + "\t");
                    }
                    else{
                        System.out.print("\t");
                        fout.print("\t");
                    }
                }
                System.out.print("\n");
                fout.print("\n");
            }
        } else {
            System.out.print("\nСимвол-заповнювач введено не вірно");
            System.exit(0);
        }
        fout.flush();
        fout.close();
    }
}
