package personalProjects;

import java.util.Scanner;
import java.util.Set;

class SpecialCharacterException extends Exception{
	SpecialCharacterException(String message){
		super(message);
	}
}

public class PigLatin {

    public static void main(String[] args) throws SpecialCharacterException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text to translate:");
        String text = sc.nextLine();
        sc.close();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        String[] og_text = text.split(" ");
        String[] pigLatin = new String[og_text.length];
        
        for (int i = 0; i < og_text.length; i++) {
            boolean cap = Character.isUpperCase(og_text[i].charAt(0));
            String word = og_text[i].toLowerCase();
            
            if (vowels.contains(word.charAt(0))) {
                pigLatin[i] = word + "way";
            } else if (!vowels.contains(word.charAt(0)) && word.length() > 1 && !vowels.contains(word.charAt(1))) {
                pigLatin[i] = word.substring(2) + word.charAt(0) + word.charAt(1) + "ay";
            } else {
                pigLatin[i] = word.substring(1) + word.charAt(0) + "ay";
            }
            
            if (cap) {
                pigLatin[i] = Character.toUpperCase(pigLatin[i].charAt(0)) + pigLatin[i].substring(1);
            }
        }
        
        String specialCharacters = "0123456789!@#$%^&*()_+-=[]\\;',./<>?:\"|}{~`";
        
        try {
        	for(int j = 0; j < pigLatin.length; j++) {
        		for(int k = 0; k < pigLatin[j].length(); k++){
        			if(specialCharacters.contains(Character.toString(pigLatin[j].charAt(k)))) {
        				throw new SpecialCharacterException("Text should be purely alphabetic");
        			}
        		}
        	}
        	
        	System.out.println("Pig Latin:");
            for (String word : pigLatin) {
                System.out.print(word + " ");
            }
        }
        catch(SpecialCharacterException e) {
        	System.out.println(e.getMessage());
        }
    }
}