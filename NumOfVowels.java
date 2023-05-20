import java.util.regex.Pattern;

public class NumOfVowels {

    public static Integer countVowels(String s) {

        Pattern VOWELS = Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE);
        int num = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(VOWELS.matcher(String.valueOf(s.charAt(i))).matches()){
                // System.out.print(s.charAt(i));
                num++;
            }
        }
        System.out.println("This string (" + s + ") has " + num + " vowels");
        return num; 
    } 

    public static void main(String[] args) {
        countVowels("Hello, how are you?");
    }
    
}
