// Last updated: 5/26/2026, 12:32:17 PM
class Solution {
    public boolean isHappy(int n) {
        if(n==1 || n==7) return true;
        while(n>=10){
            int temp=n;int sum=0;
            while(temp>0){
                int dig=temp%10;
                temp/=10;
                sum+=dig*dig;
            }
            n=sum;     
        }
        return n==1||n==7;
    }
}