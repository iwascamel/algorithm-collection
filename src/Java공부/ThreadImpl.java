package Java공부;

public class ThreadImpl extends Thread{

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
        ThreadImpl threadImpl1 = new ThreadImpl();
        ThreadImpl threadImpl2 = new ThreadImpl();

        threadImpl1.start();
        threadImpl2.start();
    }
}