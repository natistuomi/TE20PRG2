public class BinaryManipulation {

    public static void main(String[] args){
        char m = 'H';
        char k = '(';
        System.out.println((char)cryptInfo(m,k));
        System.out.println((char)decryptInfo(k,(char)cryptInfo(m,k)));
    }

    public static int cryptInfo(char m, char k) {
        return m^k;
    }

    public static int decryptInfo(char k, char c){
        return k^c;
    }

}
