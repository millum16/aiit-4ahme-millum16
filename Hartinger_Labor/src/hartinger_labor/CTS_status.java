package hartinger_labor;

/**
 *
 * @author lukasmilhalm
 */
public class CTS_status {

    public static void main(String[] args) throws InterruptedException {

        RS232ex rs232 = new RS232ex();

        rs232.setRTS(true);
        rs232.setDTR(false);

        while (true) {
            boolean ctsStatus;
            String stringCtsStatus;

            ctsStatus = rs232.isCTS();
            stringCtsStatus = String.valueOf(ctsStatus);
            System.out.println("Status des CTS-Leitung: " + stringCtsStatus);
            Thread.sleep(300);

            if (rs232.isRI() == true) {
                break;
            }
        }
    }
}
