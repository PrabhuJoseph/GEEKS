package javainternals;

public class Regex {
    public static void main(String[] args){
        String input = args[0];
        // String input = "a=b\\,c,d=e";
        System.out.println("INPUT="+input);
        for(String output : input.split("(?<!\\\\),")){
            output=output.replace("\\","");
            System.out.println(output);
        }
    }
}