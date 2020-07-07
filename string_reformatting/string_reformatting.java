// https://app.codesignal.com/challenge/muY5LpDT474LCuf7x

String stringReformatting(String s, int k) {
    String clearString = s.replaceAll("-", ""); // remove the dashes    
    StringBuilder sb = new StringBuilder();
    
    int c = 0;
    // start from the end of the string
    for(int i=clearString.length()-1; i >= 0; i--) {
        if(c >= k) {
            sb.append("-");
            c = 0;  // reset
        } 
            
        sb.append(clearString.charAt(i));
        c++;
    }
    
    return sb.reverse().toString();
}
