package Thread_test;

public class EnergyTransferTask implements Runnable{

    private EnergySystem energySystem;
    private int fromBox;
    private int DEALY=10;
    private double maxAmount;
    public EnergyTransferTask(EnergySystem energySystem,int from,double max)
    {
        this.energySystem=energySystem;
        this.maxAmount=max;
        this.fromBox=from;
    }
    public void run(){
        try{
            while (true) {
                int toBox=(int)(energySystem.getBoxesAmount()*Math.random());
                double amount=Math.random()*maxAmount;
                energySystem.transfer(fromBox,toBox,amount);
                Thread.sleep((int)(DEALY*Math.random()));
            }
            } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    }

