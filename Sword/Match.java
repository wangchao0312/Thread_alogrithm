package Sword;

public class Match {
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null) {
            return false;
        }
        return matchAssist(str,0,pattern,0);
    }
    //判断开始点为strstart和patternstart 的俩个数组是否可以匹配！！
    public boolean matchAssist(char[] str,int strstart,char[] pattern,int patternstart){

        if(strstart==str.length&&patternstart==pattern.length)
            return true;

        if(strstart!=str.length&&patternstart==pattern.length)
            return false;

        if(patternstart!=pattern.length-1&&pattern[patternstart+1]=='*')
        {
            if((strstart!=str.length&&str[strstart]==pattern[patternstart])||(strstart!=str.length&&pattern[patternstart]=='.'))
            {
                return matchAssist(str,strstart+1,pattern,patternstart)||matchAssist(str,strstart+1,pattern,patternstart+2)
                        ||matchAssist(str,strstart,pattern,patternstart+2);

            }
            else
            {
                return matchAssist(str,strstart,pattern,patternstart+2);
            }
        }

        if((strstart!=str.length&&pattern[patternstart]==str[strstart]||(strstart!=str.length&&pattern[patternstart]=='.')))
            return matchAssist(str,strstart+1,pattern,patternstart+1);
        else
            return false;
    }
}

