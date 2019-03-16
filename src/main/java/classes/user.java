package classes;
import java.io.Serializable;
import java.util.regex.Pattern;

import java.security.Key;
import java.security.KeyPair;
import java.util.Arrays;

import classes.encryption;
import classes.RSAKeyPair;
public class user implements Serializable {
    private String username;
    private String password;
    private String Role;
    private String eMail;
    private KeyPair keyPair = RSAKeyPair.getKeyPair();
    private Key publicKey = keyPair.getPublic();
    private Key privateKey = keyPair.getPrivate();

    public String getUsername() {
        return username;
    }
    public boolean goodUsername(){
        boolean match =false;
        String regPattern ="[A-Z|az|0-9]";
        match = Pattern.matches(regPattern,username);
        return match;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void seteMail(String eMail)
    {
        this.eMail=eMail;
    }

    public String getPassword() {
        decryptPassword();
        return password;
    }

    public boolean goodPassword(){
        boolean match =false;
        String regPattern ="[A-Zaz0-9_]{8,}$";
        match = Pattern.matches(regPattern,password);
        return match;
    }
    public void encryptedPassword()
    {
        byte[] encrypted = encryption.encrypt(password, privateKey);
        String encrypedPword = encryption.byteToString(encrypted);
        password = encrypedPword;
    }
    public void decryptPassword()
    {
        byte[] bytes = password.getBytes();
        byte[] decrypted = encryption.decrypt(bytes, publicKey);
        password = encryption.byteToString(decrypted);
    }
    public void setPassword(String password) {
        this.password = password;
        encryptedPassword();
    }
    public boolean goodeMail(){
        boolean match =false;
        String regPattern ="[A-Zaz0-9]@[A-Za-z|]\\.[A-Aa-z]re{3}";
        match = Pattern.matches(regPattern,eMail);
        return match;
    }
    public String getMail(){
        return eMail;
    }
    public void setRole(){
        this.Role = "user";
    }

    public void setRole2(String role)
    {
        this.Role = role;
    }

    public String getRole(){
        return Role;
    }
    public boolean isValid()
    {
        boolean isGood =false;
       if (goodUsername() & goodPassword() & goodeMail())
       {
           isGood=true;
       }
       return isGood;
    }
}
