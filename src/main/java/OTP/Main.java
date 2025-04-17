package OTP;



import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String message = "Pershendetje, ky kod eshte i dekriptuar";
        String seed = "12345"; 
        String message = "Pershendetje, ky kod eshte i dekriptuar.";
        String seed = "12345";

        SymmetricAlgorithm otpEncrypt = new SymmetricAlgorithm(seed);
        byte[] encryptedBytes = otpEncrypt.encrypt(message);

        String encodedCipher = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted (Base64): " + encodedCipher);

        SymmetricAlgorithm otpDecrypt = new SymmetricAlgorithm(seed);
        byte[] decodedCipher = Base64.getDecoder().decode(encodedCipher);
        String decrypted = otpDecrypt.decrypt(decodedCipher);

        System.out.println("Decrypted: " + decrypted);

        FileSaver.saveToFile("encrypted_message.txt", encodedCipher);
    }
}