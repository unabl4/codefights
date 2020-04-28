// https://app.codesignal.com/challenge/BE3XTXiPEbHSin2oQ

String wordHash(String word) {
    char[] ch = word.toCharArray();
    Arrays.sort(ch);
    return new String(ch);
}

int groupsOfAnagrams(String[] words) {
    Set<String> s = new HashSet<>();
    for(String w: words) s.add(wordHash(w));
    return s.size();
}
