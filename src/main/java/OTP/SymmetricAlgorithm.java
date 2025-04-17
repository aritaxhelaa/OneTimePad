package OTP;


public class SymmetricAlgorithm {
    private String seed;

    public SymmetricAlgorithm(String seed) {
        this.seed = seed;
    }

    public byte[] encrypt(String message) {
        byte[] messageBytes = message.getBytes();
        byte[] seedBytes = seed.getBytes();
        byte[] encrypted = new byte[messageBytes.length];

        for (int i = 0; i < messageBytes.length; i++) {
            encrypted[i] = (byte) (messageBytes[i] ^ seedBytes[i % seedBytes.length]);
        }

        return encrypted;
    }

    public String decrypt(byte[] decodedCipher) {
        byte[] seedBytes = seed.getBytes();
        byte[] decrypted = new byte[decodedCipher.length];

        for (int i = 0; i < decodedCipher.length; i++) {
            decrypted[i] = (byte) (decodedCipher[i] ^ seedBytes[i % seedBytes.length]);
        }

        return new String(decrypted);
    }
}