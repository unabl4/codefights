// https://app.codesignal.com/challenge/jfpd5fvP4rpx33bYN

String minSubstringWithAllChars(String s, String t) {
    // [0,x,x,1,x,2,x,x,x,1,0,x,2]

    int SL = s.length();
    int TL = t.length();

    int minStartIndex = 0;
    int minEndIndex = SL-1; // last possible index
    int minLength = SL; // guarantees

    if(minEndIndex <= 0) return "";

    // step 1: T analysis
    Set<Character> h = new HashSet<>();
    for(Character c: t.toCharArray()) h.add(c);

    // step 2: final
    for(int startIndex=0; startIndex < SL-TL; startIndex++) { // for each starting position
        Set<Character> ht = new HashSet<>(h);   // copy

        // find end index
        int endIndex = startIndex;
        while(endIndex < SL && !ht.isEmpty()) {
            char currentChar = s.charAt(endIndex);
            System.out.print(currentChar);

            if(ht.contains(currentChar)) ht.remove(currentChar);
            if(ht.isEmpty()) break;
            endIndex++;
        }

        if(!ht.isEmpty()) continue;

        int subStringLen = endIndex-startIndex;
        if(subStringLen < minLength) {
            // update
            minStartIndex = startIndex;
            minEndIndex = endIndex;
            minLength = subStringLen;
        }
    }

    return new StringBuilder(s).substring(minStartIndex, minEndIndex+1);
}
