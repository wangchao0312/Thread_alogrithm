package Sword;

public class isNumer {
    public  boolean isNumeric(char[] str) {
        boolean hase=false;
        boolean sign=false;
        boolean demical=false;
        for(int i=0;i<str.length;i++)
        {
            if(str[i]=='e'||str[i]=='E')
            {
                if(i==str.length-1)
                    return false;
                if(hase)
                    return false;
                hase=true;
            }
            else if(str[i]=='+'||str[i]=='-')
            {
                if (sign && str[i-1] != 'e' && str[i-1] != 'E')
                    return false;
                if(!sign&&i>0&&str[i-1] != 'e' && str[i-1] != 'E')
                    return false;
                sign=true;
            }
            else if(str[i]=='.')
            {
                if(demical)
                    return false;
                if(hase)
                    return  false;
                demical=true;
            }
            else if(str[i]<'0'||str[i]>'9')
                return false;

        }
        return true;
    }

    public static void main(String[] args){
        ;

    }
}
