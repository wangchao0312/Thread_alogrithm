package Sword;

public class Left_String {
    public  String LeftRotateString(String str,int n) {

        if(str.length()<n)
            return "";

        char[] chars=str.toCharArray();
        chars=Reverse(chars,0,n-1);
        chars=Reverse(chars,n,chars.length-1);
        chars=Reverse(chars,0,chars.length-1);
        return new String(chars);

    }
    public  char[] Reverse(char[] chars,int start,int end){
        int i=start;
        int j=end;
        while(i<j)
        {
            char temp=chars[j];
            chars[j]=chars[i];
            chars[i]=temp;
            i++;j--;
        }
        return chars;
    }
    public static void main(String[] args){
    }
}
