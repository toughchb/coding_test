package yanolja;

public class Inverter {

    public static String invert(String input){
        if (input.length() == 0 || input == null) {
            return "";
        } else if (input.length() == 1) {
            return input;
        }
        char[] in = input.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }
}
