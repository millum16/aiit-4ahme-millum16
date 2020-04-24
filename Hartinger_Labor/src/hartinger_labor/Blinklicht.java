package hartinger_labor;

/**
 *
 * @author lukasmilhalm
 */
public class Blinklicht {

    public static void main(String[] args) throws InterruptedException {

        RS232ex rs232 = new RS232ex();
        int count = 0;

        while (true) {
            count++;
            rs232.setRTS(true);
            System.out.println("LED1 on --- LED2 off \n");

            Thread.sleep(500);

            if (rs232.isRT() == true) {
                break;
            }
        }
    }
}
