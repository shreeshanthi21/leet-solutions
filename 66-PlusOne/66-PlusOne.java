// Last updated: 5/26/2026, 12:33:46 PM
class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] newDig=new int[n+1];
        newDig[0]=1;
        return newDig;
    }
}