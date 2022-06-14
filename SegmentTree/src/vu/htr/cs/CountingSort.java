package vu.htr.cs;

public class CountingSort {
    public void sort(char arr[]) {
        int n = arr.length;
        char output[] = new char[n];
        int max = arr[0] - 'a';
        for (int i = 0; i < n; i++) {
            if (max < arr[i] - 'a') {
                max = arr[i] - 'a';
            }
        }
        max++;
        int count[] = new int[max];
        for (int i = 0; i < max; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            count[arr[i] - 'a']++;
        }
        for (int i = 1; i < max; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < n; i++) {
            output[count[arr[i] - 'a'] - 1] = arr[i];
            count[arr[i] - 'a']--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
