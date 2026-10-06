import java.util.Arrays;

public class RadixSort {

    public static void radixSort(int[] arr){
        int max = maior(arr);
        for (int exp = 1; max / exp > 0; exp *= 10){
            countingSortPorDigito(arr,exp);
        }
    }

    public static int maior(int[] arr){
        int maior = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > maior){
                maior = arr[i];
            }
        }
        return maior;
    }

    public static void countingSortPorDigito(int[] arr, int exp){
        int n = arr.length;
        int[] saida = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++){
            int digito = (arr[i] / exp) % 10;
            count[digito]++;
        }
        
        for (int i = 1; i < 10; i++){
            count[i] += count[i-1];
        }

        for (int i = n -1; i >= 0; i--){
            int digito = (arr[i] / exp) % 10;
            saida[count[digito]-1] = arr[i];
            count[digito]--;
        }
        System.arraycopy(saida, 0, arr, 0, n);
    }


    public static void main(String[] args) {
        int[] dados = {170, 45, 75, 90, 802, 24, 2, 66};
        
        System.out.println("Array original: " + Arrays.toString(dados));
        
        radixSort(dados);
        
        System.out.println("Array ordenado: " + Arrays.toString(dados));

    }
}

