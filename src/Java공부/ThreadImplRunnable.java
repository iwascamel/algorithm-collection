package Java공부;

/**
 * date: 22.06.06
 */

public class ThreadImplRunnable implements Runnable{

    @Override
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println(i);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
            }
        }
    }

    public static void main(String[] args) {
        ThreadImplRunnable threadImplRunnable = new ThreadImplRunnable();
        Thread myThread = new Thread(threadImplRunnable);
        myThread.start();
    }
}