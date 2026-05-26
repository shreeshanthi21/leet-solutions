// Last updated: 5/26/2026, 12:31:48 PM
class Solution {
    public int lengthOfLIS(int[] arr) {
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        int n=arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size() - 1)) {
                temp.add(arr[i]);
            } else {
                int ind = Collections.binarySearch(temp, arr[i]);
                if (ind < 0) ind = -(ind + 1); // If not found, get insertion point
                temp.set(ind, arr[i]);
            }
        }

        return temp.size();
    }
}