class Solution {
    public String reverseWords(String s) {
     StringBuilder sbb = new StringBuilder();
     sbb.append(s);
     int n=sbb.length();
     StringBuilder sb=reverse(0,sbb.length()-1,sbb);
     int i=0; /// for character ya space check karne ke liye
     int l=0;
     int r=0;  // l and r jo string reverse karenge 
     while(i<n)
     {
        while(i<n && sb.charAt(i)!=' ')
        {
            sb.setCharAt(r,sb.charAt(i));
            i++;
            r++;
        }
        if(l<r)
        {
        reverse(l,r-1,sb);
        if(r<n)
        {
           sb.setCharAt(r,' ');
           r++;
        }
           l=r;
        }
        i++;
     }
    return sb.toString().substring(0,r).trim();
    }
    public static StringBuilder reverse(int left,int right,StringBuilder str)
    {
        while(left<right)
        {
            char chleft = str.charAt(left);
            char chright =str.charAt(right);
            str.setCharAt(left,chright);
            str.setCharAt(right,chleft);
            left++;
            right--;
        }
        return str;
    }
}