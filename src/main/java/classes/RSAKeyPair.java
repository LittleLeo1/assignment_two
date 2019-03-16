package classes;
import classes.RSAconstraints;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
public class RSAKeyPair {
    public static KeyPair getKeyPair() {
        KeyPairGenerator generator = null;
        try {
            generator = KeyPairGenerator.getInstance(RSAconstraints.ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (generator != null) {
            generator.initialize(RSAconstraints.ALGORITHM_BITS);
            KeyPair keyPair = generator.genKeyPair();
            return keyPair;
        }
        return null;
    }
}
