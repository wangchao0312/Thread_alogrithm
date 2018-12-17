package Sword;

public class FirstAppearing {
    int[] hashTable=new int[256];
    StringBuffer str=new StringBuffer();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        str.append(ch);
        if(hashTable[ch]==0)
            hashTable[ch]=1;
        else
            hashTable[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] s=str.toString().toCharArray();
        for(char c:s)
        {
            if(hashTable[c]==1)
                return c;
        }
        return '#';
    }
}
