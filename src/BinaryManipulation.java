import java.io.*;

public class BinaryManipulation {

    public static void main(String[] args){
        char m = 'H';
        char k = ')';
        System.out.println((char)cryptChar(m,k));
        System.out.println((char)decryptChar(k,(char)cryptChar(m,k)));
        String message = "hej";
        String key = "(((";
        int keyLength = key.length();
        System.out.println(cryptString(message, key, keyLength));
        System.out.println(decryptString(key, cryptString(message, key, keyLength), keyLength));
        System.out.println(cryptStringHex(message, key, keyLength));
    }

    public static int decryptChar(char k, char c){
        return k^c;
    }

    public static int cryptChar(char m, char k) {
        return m^k;
    }

    public static String cryptString(String m, String k, int keyLength){
        String s = "";
        for(int i = 0; i < m.length(); i++){
            char x = m.charAt(i);
            char y = k.charAt(i%keyLength);
            s = s + (char)cryptChar(x,y);
        }
        return s;
    }

    public static String decryptString(String k, String c, int keyLength){
        String s = "";
        for(int i = 0; i < c.length(); i++){
            char x = c.charAt(i);
            char y = k.charAt(i%keyLength);
            s = s + (char)cryptChar(x,y);
        }
        return s;
    }

    public static String cryptStringHex(String m, String k, int keyLength){
        String s = "";
        for(int i = 0; i < m.length(); i++){
            char x = m.charAt(i);
            char y = k.charAt(i%keyLength);
            s = s + Integer.toHexString(cryptChar(x,y)) + " ";
        }
        return s;
    }



}
