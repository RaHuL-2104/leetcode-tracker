import java.util.*;
class Solution {
    public boolean isPalindrome(int x) {
        int r=x,d,rev=0;
        while(x>0){
            d=x%10;
            rev=(rev*10)+d;
            x=x/10;
        }
        if(r==rev){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Solution ob=new Solution();
        System.out.println(ob.isPalindrome(n));
    }
}