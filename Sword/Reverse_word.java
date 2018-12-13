package Sword;

public class Reverse_word {
    public  String ReverseSentence(String str) {
        char[] chars=str.toCharArray();
        chars=Reverse(chars,0,chars.length-1);
        int begin=0;
        for(int i=0;i<chars.length;i++)
        {
            if(chars[i]==' ')
            {
                Reverse(chars,begin,i-1);
                begin=i+1;
            }
        }
        Reverse(chars,begin,chars.length-1);
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
