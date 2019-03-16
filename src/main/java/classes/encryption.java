package classes;

import java.security.Key;
import classes.RSAconstraints;

import javax.crypto.Cipher;
public class encryption {
    public static byte[] encrypt(String original, Key privateKey) {
        if (original != null && privateKey != null) {
            byte[] bs = original.getBytes();
            byte[] encData = convert(bs, privateKey, Cipher.ENCRYPT_MODE);
            return encData;
        }
        return null;
    }
    private static byte[] convert(byte[] data, Key key, int mode) {
        try {
            Cipher cipher = Cipher.getInstance(RSAconstraints.ALGORITHM);
            cipher.init(mode, key);
            byte[] newData = cipher.doFinal(data);
            return newData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] decrypt(byte[] encrypted, Key publicKey) {
        if (encrypted != null && publicKey != null) {
            byte[] decData = convert(encrypted, publicKey, Cipher.DECRYPT_MODE);
            return decData;
        }
        return null;
    }
    public static String byteToString(byte[] bytes){
        String newString = bytes.toString();
        return newString;
    }
    public static byte[] StringToBytes(String string){
        byte[] bytes = string.getBytes();
        return bytes;
    }

}
