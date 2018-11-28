package Thread_test;

public class EnergySystem {
    private final double[] energyBoxes;


    /**
     * n代表能量盒子的长度
     * initialEnergy表示每个盒子初始的能量。。。
     * @param n
     * @param initialEnergy
     */
    public EnergySystem(int n,double initialEnergy){
        energyBoxes=new double[n];
        for(int i=0;i<energyBoxes.length;i++)
            energyBoxes[i]=initialEnergy;
    }
    /**
     * 能力转移函数。。。
     *
     */
    public void transfer(int from,int to,double amount){
        if(energyBoxes[from]<amount)
            return;
        System.out.print(Thread.currentThread().getName());
        energyBoxes[from]-=amount;
        System.out.printf("从%d转移%10.2f单位能量到%d",from,amount,to);
        energyBoxes[to]+=amount;
        System.out.printf("能量总和为%10.2f%n",getTotalEnergies());
    }
    public double getTotalEnergies(){
        double sum=0;
        for(double dou:energyBoxes)
            sum+=dou;
        return sum;
    }
    public int getBoxesAmount(){
        return energyBoxes.length;
    }
}
