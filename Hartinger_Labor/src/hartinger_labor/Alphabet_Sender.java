package hartinger_labor;

/**
 *
 * @author lukasmilhalm
 */
public class Alphabet_Sender {

    public static void main(String[] args) {

        RS232ex rs232 = new RS232ex();

        rs232.setRTS(true);
        rs232.setDTR(false);

        while (true) {
            long timePassed;
            long time = System.currentTimeMillis();

            if (time == System.currentTimeMillis() - 250) {
                char abc = 'A';
                System.out.println(abc);
                abc = abc++;

                if (abc == 'Z') {
                    System.out.println('\r');
                    System.out.println('\n');
                }

                if (rs232.isRI() == true) {
                    break;
                }
            }
        }
    }
}
