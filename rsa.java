import java.math.BigInteger;
import java.util.Scanner;

public class p7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the message to be encrypted:");
        int msg = scanner.nextInt();
        System.out.println("Enter the first prime number (p):");
        int p = scanner.nextInt();
        System.out.println("Enter the second prime number (q):");
        int q = scanner.nextInt();

        int n = p * q;
        int z = (p - 1) * (q - 1);
        int d = 0;
        int e = 0;

        // Finding d
        for (d = 2; d < z; d++) {
            if (gcd(d, z) == 1) {
                break;
            }
        }

        // Finding e
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % d == 0) {
                e = x / d;
                break;
            }
        }

        // Print z, d, e
        System.out.println("Value of z: " + z);
        System.out.println("Value of d: " + d);
        System.out.println("Value of e: " + e);

        BigInteger bigMsg = BigInteger.valueOf(msg);
        BigInteger bigN = BigInteger.valueOf(n);
        BigInteger encryptedMsg = bigMsg.modPow(BigInteger.valueOf(e), bigN);
        BigInteger decryptedMsg = encryptedMsg.modPow(BigInteger.valueOf(d), bigN);
        System.out.println("Encrypted message is : " + encryptedMsg);
        System.out.println("Decrypted message is : " + decryptedMsg);

        scanner.close();
    }

    static int gcd(int e, int z) {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }

}


/*
Enter the message to be encrypted:
25
Enter the first prime number (p):
7
Enter the second prime number (q):
11
Value of z: 60
Value of d: 7
Value of e: 43
Encrypted message is : 60
Decrypted message is : 25
*/