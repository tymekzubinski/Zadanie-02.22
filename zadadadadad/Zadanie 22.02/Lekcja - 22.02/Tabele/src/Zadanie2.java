import java.util.Random;

public class Zadanie2 {
    public static void main(String args[]){
        int[][] some_array = Tabela2D();
        Tabela(some_array);

        MaxDwa two_max_values_res = ZnajdzDwaMax(some_array);
        System.out.println("Dwie największe liczby: " + two_max_values_res.getMax() + " " + two_max_values_res.getMax2());


        System.out.println("Stosunek sumy liczb w komórkach o parzystych indeksach wierszy i nieparzystych indeksach kolumn: " + ParzysteINie(some_array));


        System.out.println("Liczba komórek, których wartość jest mniejsza od iloczynu indeksu wiersza i kolumny: " + Zlicz(some_array));
    }

    public static void Tabela(int[][] matrix){
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
    }

    public static int[][] Tabela2D(){
        Random random = new Random();
        int size = random.nextInt(10,20);
        int[][] array = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i == j){
                    array[i][j] = random.nextBoolean() ? 1 : -1;
                }
                else{
                    array[i][j] = random.nextInt(-100, 100);
                }
            }
        }
        return array;
    }

    static class MaxDwa {
        private int max;
        private int max2;

        public MaxDwa(int max, int max2) {
            this.max = max;
            this.max2 = max2;
        }

        public int getMax() {
            return max;
        }

        public int getMax2() {
            return max2;
        }
    }

    public static MaxDwa ZnajdzDwaMax(int[][] array){
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int[] row : array){
            for(int value : row){
                if(value > max){
                    max2 = max;
                    max = value;
                } else if (value > max2) {
                    max2 = value;
                }
            }
        }
        return new MaxDwa(max, max2);
    }

    public static float ParzysteINie(int[][] array){
        return (float) Suma(array) / SumaNieparzystych(array);
    }

    public static int Suma(int[][] array){
        int sum = 0;
        for(int i = 0; i < array.length; i+=2){
            for(int j = 0; j < array[0].length; j++){
                sum += array[i][j];
            }
        }
        return sum;
    }

    public static int SumaNieparzystych(int[][] array){
        int sum = 0;
        for(int j = 1; j < array[0].length; j+=2){
            for(int i = 0; i < array.length; i++){
                sum += array[i][j];
            }
        }
        return sum;
    }
    public static int Zlicz(int[][] array){
        int count = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                int number = array[i][j];
                if(number < j * i){
                    count++;
                }
            }
        }
        return count;
    }
}
