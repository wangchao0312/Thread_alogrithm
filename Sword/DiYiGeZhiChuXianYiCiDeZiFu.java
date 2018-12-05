package Sword;


import java.util.LinkedHashMap;

public class DiYiGeZhiChuXianYiCiDeZiFu {
    public static int FirstNotRepeatingChar(String str) {

        char[] array=str.toCharArray();
        int[] flag=new int[str.length()];
        int max;
        for(int i=0;i<=array.length-1;i++)
        {
            max=0;
            if(flag[i]==1)
                continue;
            else {
                for (int j = 0; j <= array.length-1; j++) {
                    if(j!=i) {
                        if (array[j] == array[i])
                        {
                            flag[j]=1;
                            max++;
                        }
                    }
                }
            }
            if(max==0)
                return i;
        }
        return -1;
    }

    //hashmap实现
    public static int FirstNotRepeatingChar1(String str) {

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            else
                map.put(str.charAt(i), 1);
        }

        for (int i = 0; i < str.length(); i++)
        {
            char c=str.charAt(i);
            if(map.get(c)==1)
                return i;
        }
            return -1;
    }
    public static void main(String[] args){
        System.out.println(FirstNotRepeatingChar1("abcdefabcde1611651"));
    }
}
