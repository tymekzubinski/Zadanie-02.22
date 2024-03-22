import java.util.HashSet;
import java.util.Random;

public class Zadanie1 {
    public static void main(String args[]){
        int[][] some_array = RandomTabela(100, 10);
        Tabela(some_array);
        System.out.println(SredniaElementow(some_array, 8080));
    }
    public static void Tabela(int[][] matrix){
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%3d", value);
            }
            System.out.println();
        }
    }

    public static int[][] RandomTabela(int rows, int columns){
        Random random = new Random();
        int[][] array = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                array[i][j] = random.nextInt(100);
            }
        }
        return array;
    }

    public static float SredniaElementow(int[][] table, int number){
        HashSet<Integer> uniqueDigits = Rozdziel(number);
        int sum = 0;
        int count = 0;
        for(int i = 0; i < table.length; i += 2){
            for(int j : uniqueDigits){
                if(j >= 0 && j < table[i].length){
                    sum += table[i][j];
                    count++;
                }
            }
        }
        return count > 0 ? (float) sum / count : 0; //
    }

    public static HashSet<Integer> Rozdziel(int number){
        HashSet<Integer> uniqueDigits = new HashSet<>();
        while (number > 0) {
            uniqueDigits.add(number % 10);
            number /= 10;
        }
        return uniqueDigits;
    }
}
