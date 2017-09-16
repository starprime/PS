public class Anagram {
    public static void main(String []args){
        System.out.println(checkAnagram("CAT","tac"));
    }
    static public boolean checkAnagram(String stringOne , String stringTwo){
        String s1 = stringOne.replaceAll("\\s", "").toLowerCase();
        String s2 = stringTwo.replaceAll("\\s", "").toLowerCase();



        char[] first = stringOne.toLowerCase().toCharArray();
        char[] second = stringTwo.toLowerCase().toCharArray();

        int[] counts = new int[26];
        for (int i = 0; i < first.length; i++){
            counts[first[i]-97]++;
            counts[second[i]-97]--;
        }
        for (int i = 0; i<26; i++)
            if (counts[i] != 0)
                return false;
        return true;
    }
}
