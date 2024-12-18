import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock {
    public static void main(String[] args) {
        Thread clockThread = new Thread(() -> {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                String currentTime = timeFormat.format(new Date());
                
                System.out.print("\r"); 
                
                System.out.print("Current Time: " + currentTime);
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Clock thread interrupted!");
                    break;
                }
            }
        });

        clockThread.start();
    }
}
