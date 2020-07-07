// https://app.codesignal.com/challenge/R2bwd8Zf5pi5cDRdX

// int countInversions(int[] a) {
//     int m = 1000000007;
//     int c = 0;
//     int n = a.length;
    
//     for(int i=0; i < n; i++) {
//         for(int j=i+1; j < n; j++) {
//             if(a[j] < a[i]) c = (c % m) + 1;
//         }
//     }
    
//     return c % m;
// }

int M = 1000000007;  

int countInversions(int[] a) {
    return mergeSortAndCount(a, 0, a.length-1) % M;
}

int mergeAndCount(int[] arr, int l, int m, int r) { 

    // Left subarray 
    int[] left = Arrays.copyOfRange(arr, l, m + 1); 

    // Right subarray 
    int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 

    int i = 0, j = 0, k = l, swaps = 0; 

    while (i < left.length && j < right.length) { 
        if (left[i] <= right[j]) 
            arr[k++] = left[i++]; 
        else { 
            arr[k++] = right[j++]; 
            swaps += (m + 1) - (l + i); 
        } 
    } 

    // Fill from the rest of the left subarray 
    while (i < left.length) 
        arr[k++] = left[i++]; 

    // Fill from the rest of the right subarray 
    while (j < right.length) 
        arr[k++] = right[j++]; 

    return swaps; 
} 

// Merge sort function 
int mergeSortAndCount(int[] arr, int l, int r) { 
    // Keeps track of the inversion count at a 
    // particular node of the recursion tree 
    int count = 0; 

    if (l < r) { 
        int m = (l + r) / 2; 

        // Total inversion count = left subarray count 
        // + right subarray count + merge count 

        // Left subarray count 
        count = (count % M) + (mergeSortAndCount(arr, l, m) % M); 

        // Right subarray count 
        count = (count % M) + (mergeSortAndCount(arr, m + 1, r) % M); 

        // Merge count 
        count = (count % M) + (mergeAndCount(arr, l, m, r) % M); 
    } 

    return count % M; 
} 

// int countInversionsInner(int[] a, int L, int R) {
//     int N = R-L+1;
//     if(N <= 1) {
//         return 0;
//     }
    
//     int M = L+(N/2);
//     int A = countInversionsInner(a, L, M-1);
//     int B = countInversionsInner(a, M, R);
    
//     int C = A+B;    
    
//     // merge
    
//     int i=L;
//     int j=M;
//     while(i < (M-L) && j < (R-M)) {
//         if(a[i] <= a[j]) {
            
//         }
//     }
// }
