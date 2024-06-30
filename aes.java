import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class AES {
    
    private SecretKeySpec secretKeySpec;

    public AES(String secretKey) throws Exception {
        this.secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
    }

    public String encrypt(String text) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String encryptedText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a secret key (16, 24, or 32 characters): ");
        String secretKey = scanner.nextLine();
        System.out.print("Enter the text to encrypt: ");
        String textToEncrypt = scanner.nextLine();
        AES aes = new AES(secretKey);
        String encryptedText = aes.encrypt(textToEncrypt);
        System.out.println("\nEncrypted Text: " + encryptedText);
        String decryptedText = aes.decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
