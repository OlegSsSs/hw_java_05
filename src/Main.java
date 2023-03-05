//Учитывая два целочисленных массива nums1 и nums2, верните максимальную длину подмассива, который появляется в обоих массивах.
//
//Example 1:
//Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//Output: 3
//Explanation: Повторяющийся подмассив с максимальной длиной равен [3,2,1].
//
//Example 2:
//Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//Output: 5
//Explanation: Повторяющийся подмассив с максимальной длиной равен [0,0,0,0,0].

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,2,1};
        int[] array2 = {3,2,1,4,7};

        System.out.print(FindMaxLength(array1, array2));
    }

    static int FindMaxLength(int[] array1, int[] array2) {

        int[][] tempArr = new int[array1.length + 1][array2.length + 1];

        for (int i = array1.length - 1; i >= 0; i--) {
            for (int j = array2.length - 1; j >= 0; j--) {
                if (array1[i] == array2[j])
                    tempArr[i][j] = tempArr[i + 1][j + 1] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                max = Math.max(max, tempArr[i][j]);
            }
        }

        return max;
    }

}