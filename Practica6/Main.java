import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void Merge(Student[] A, int first, int last) {
        Student[] mas = new Student[last - first + 1];
        int middle = (first + last) / 2;
        int start = first;
        int fin = middle + 1;

        int j;
        for(j = first; j <= last; ++j) {
            if (start > middle || fin <= last && A[start].compare(A[fin]) != ">") {
                mas[j - first] = A[fin];
                ++fin;
            } else {
                mas[j - first] = A[start];
                ++start;
            }
        }

        for(j = first; j <= last; ++j) {
            A[j] = mas[j - first];
        }

    }

    public static void MergeSort(Student[] A, int first, int last) {
        if (first < last) {
            MergeSort(A, first, (first + last) / 2);
            MergeSort(A, (first + last) / 2 + 1, last);
            Merge(A, first, last);
        }

    }

    public static void main(String[] args) {
        System.out.print("Введите количество студентов: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Student[] arr = new Student[n];

        int i;
        for(i = 0; i < n; ++i) {
            System.out.print("Введите информацию о студенте №" + (i + 1) + ":\n");
            arr[i] = new Student();
        }

        MergeSort(arr, 0, arr.length - 1);

        for(i = 0; i < n; ++i) {
            System.out.println(arr[i].getName());
        }

    }
}