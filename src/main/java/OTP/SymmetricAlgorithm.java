package OTP;

import java.util.Random;
import java.util.Base64;

public class SymmetricAlgorithm {
    private Random keyGenerator;

    public SymmetricAlgorithm(Object seed) {
        keyGenerator = new Random();

        if (seed instanceof Integer) {
            keyGenerator.setSeed((int) seed);
        } else if (seed instanceof String) {
            keyGenerator.setSeed(((String) seed).hashCode());
        } else {
            throw new IllegalArgumentException("Seed duhet të jetë int ose String");
        }
    }
    private byte[] generateKeyStream(int length) {
        byte[] keyStream = new byte[length];
        keyGenerator.nextBytes(keyStream);
        return keyStream;
    }

    public byte[] encrypt(String plaintext) {
        byte[] plainBytes = plaintext.getBytes();
        byte[] keyStream = generateKeyStream(plainBytes.length);
        byte[] cipherBytes = new byte[plainBytes.length];

        for (int i = 0; i < plainBytes.length; i++) {
            cipherBytes[i] = (byte) (plainBytes[i] ^ keyStream[i]);
        }

        return cipherBytes;
    }

    public String decrypt(byte[] ciphertext) {
        byte[] keyStream = generateKeyStream(ciphertext.length);
        byte[] plainBytes = new byte[ciphertext.length];

        for (int i = 0; i < ciphertext.length; i++) {
            plainBytes[i] = (byte) (ciphertext[i] ^ keyStream[i]);
        }

        return new String(plainBytes);
    }

}








