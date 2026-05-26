// Last updated: 5/26/2026, 12:34:52 PM
bool isPalindrome(int x) {
    long int n=x,i=0,r;
    if(x<0) return false;
    while(x!=0)
    {
        r=x%10;
        i=i*10+r;
        x/=10;
    }
    if(n==i) return true;
    return false;
}