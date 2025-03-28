package com.learn.service.strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class StringService {
    
    public String reverseWordsOrder(String input){
        List<String> words = List.of(input.split(" "));
        String result = new String();
        for(int i = words.size()-1; i>=0 ;i--){
            System.out.println(i);
            result = result.concat(words.get(i));
            if(i!=0){
                result = result.concat(" ");
            }
        }
        return result;
    }

    public boolean checkIfPalindormIgnoreCasesAndSpacesAndPunctuation(String str){
        String cleanString = new String(str);
        cleanString = cleanString.replace(" ", "").replaceAll("[,.?/!]", "").toLowerCase();
        int length = cleanString.length();
        for(int i = 0; i<length/2;i++){
            if(cleanString.charAt(i)!=cleanString.charAt(length - i - 1)){
                return false;
            }
        }
        return true;
    }

    public char findTheFirstLetterThatAppearOnce(String str){
        HashMap<Character, Integer> hashForLetterOccurance = new HashMap<>();
        for(int i = 0; i<str.length();i++){
            hashForLetterOccurance.put(str.charAt(i), hashForLetterOccurance.getOrDefault(str.charAt(i), 0) + 1);
        }

        for(char c:str.toCharArray()){
            if(hashForLetterOccurance.get(c) == 1){
                return c;
            }
        }

        return '0';
    }

    public String replaceConsecutiveRepeatingCharacters(String str){
        StringBuilder stringBuilder = new StringBuilder();
        char currentChar = str.charAt(0);
        int count = 0;
        for(char c:str.toCharArray()){
            if(c == currentChar){
                count++;
            }else{
                stringBuilder.append(String.valueOf(currentChar) + String.valueOf(count));
                currentChar = c;
                count = 1;
            }
        }
        stringBuilder.append(String.valueOf(currentChar) + String.valueOf(count));

        return stringBuilder.toString();
    }

    public boolean checkParanteses(String str){
        Map<Character,Character> parantesesKey = new HashMap<>();
        parantesesKey.put(')', '(');
        parantesesKey.put('(', ')');
        parantesesKey.put('}', '{');
        parantesesKey.put('{', '}');
        parantesesKey.put(']', '[');
        parantesesKey.put('[', ']');
        Stack<Character> charactersWithoutPair = new Stack<>();
        for(char c:str.toCharArray()){
            if(charactersWithoutPair.empty() && !checkIfSecondParantese(c)){
                charactersWithoutPair.add(c);
            }else if(charactersWithoutPair.empty() && checkIfSecondParantese(c)){
                return false;
            }else if(!charactersWithoutPair.empty() && checkIfSecondParantese(c)){
                if(charactersWithoutPair.pop() != parantesesKey.get(c)){
                    return false;
                }
            }else if(!checkIfSecondParantese(c)){
                charactersWithoutPair.add(c);
            }
            System.out.println(charactersWithoutPair.toString());
        }
        return (charactersWithoutPair.empty())? true : false;
    }

    private boolean checkIfSecondParantese(char c){
        if(c == ')' || c == '}' || c == ']'){
            return true;
        }
        return false;
    }

    public String decodeString(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>'0' && str.charAt(i)<='9'){
                int howMAnyTimes = Character.getNumericValue(str.charAt(i));
                System.out.println(howMAnyTimes);
                i+=2;
                StringBuilder currentStringForDuplicate = new StringBuilder();
                while(str.charAt(i)>='a' && str.charAt(i)<='z'){
                    currentStringForDuplicate.append(str.charAt(i));
                    i++;
                }
                for(int j=1; j<=howMAnyTimes;j++){
                    sb.append(currentStringForDuplicate);
                }
            }else {
                sb.append(str.charAt(i));
            }


            if(i>=str.length()) break;
        }
        return sb.toString();
    }

    public String smallestWindowContainAllCharacters(String str, String characters){
        String result = str;
        int lengthToSearch = str.length() - characters.length();
        for(int i = 0;i<=lengthToSearch;i++){
            for(int j = characters.length()+i;j<=str.length();j++){
                String stringToLookUpFor = str.substring(i, j);
                if(checkIfContainsAllLetters(stringToLookUpFor, characters)){
                    if(stringToLookUpFor.length()<result.length()){
                        result = stringToLookUpFor;
                    }
                }
            }
        }
        return result;
    }

    private boolean checkIfContainsAllLetters(String strToSearchIn, String characters){
        for(char c:characters.toCharArray()){
            if(!strToSearchIn.contains(String.valueOf(c))){
                return false;
            }
        }
        return true;
    }

    public String smallestWindowContainAllCharacterGPT(String str, String t){
        if (str.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int required = charCount.size();
        int left = 0, right = 0, formed = 0;
        int minLen = Integer.MAX_VALUE, minLeft = 0;
        Map<Character, Integer> windowCount = new HashMap<>();

        while (right < str.length()) {
            char c = str.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if (charCount.containsKey(c) && windowCount.get(c).intValue() == charCount.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = str.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);

                if (charCount.containsKey(leftChar) && windowCount.get(leftChar) < charCount.get(leftChar)) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : str.substring(minLeft, minLeft + minLen);
    }

    public String getLongestPrefix(String[] words){
        StringBuilder sb = new StringBuilder();
        boolean allHasTheSamePrefix = true;
        int index = 0;
        while(allHasTheSamePrefix && index < words[0].length()){
            sb.append(words[0].charAt(index));
            for(String word:words){
                if(word.indexOf(sb.toString()) != 0){
                    allHasTheSamePrefix = false;
                    return sb.deleteCharAt(index).toString();
                }
            }
            index++;
        }

        return sb.toString();
    }
}
