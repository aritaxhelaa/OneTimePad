package OPT;
import java.util.Scanner;
public class MessageInput {

    public static String getUserMessage() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Shkruaj mesazhin për enkriptim: ");
            return scanner.nextLine();
        }

        public static String getSeed() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Shkruaj seed (int ose string): ");
            return scanner.nextLine();
        }
    }

