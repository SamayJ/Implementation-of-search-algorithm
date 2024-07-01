import java.util.*;

public class KMP {

    public static int[] computePrefix(String pattern){
        int[] prefix = new int[pattern.length()];
        int j = 0;
        for(int i = 1; i < pattern.length(); i++ ){
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = prefix[j-1];

            }
            if(pattern.charAt(i) == pattern.charAt(j)){
                j++;
            }
            prefix[i] = j;

        }
        return prefix;
    }

    public static int kmpSearch(String text, String pattern){
        int[] prefix = computePrefix(pattern);
        int occurence = 0;
        int j = 0;
        for(int i = 0;i<text.length();i++){
            while(j>0 && text.charAt(i) != pattern.charAt(j)){
                j = prefix[j-1];
            }

        if(text.charAt(i) == pattern.charAt(j)){
            j++;
        }

        if (j == pattern.length()){
            occurence++;
            j = prefix[j-1];
        }
        }
        return occurence;
    }    


public static void main(String[] args) {
    String[] testStrings = {
        "AABAACAADAABAABA",
        "AAAAAAAAAA",
        "heyihey"
    };
    String[] patterns = {
        "AABA",
        "AAA",
        "heyi"
    };

    for (int i = 0; i < testStrings.length; i++) {
        int occurrences = kmpSearch(testStrings[i], patterns[i]);
        System.out.println("Number of occurrences of '" + patterns[i] + "' in '" + testStrings[i] + "': " + occurrences);
    }
}
}
