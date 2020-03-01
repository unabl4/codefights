// https://app.codesignal.com/challenge/eXhrnce6nJixhbd33

static Map<Integer, String> M = new HashMap<>();
static Map<Integer, String> D = new HashMap<>();
static {
    M.put(9, "Billion");
    M.put(6, "Million");
    M.put(3, "Thousand");
} // suffixes 

static {
    D.put(1, "One");
    D.put(2, "Two");
    D.put(3, "Three");
    D.put(4, "Four");
    D.put(5, "Five");
    D.put(6, "Six");
    D.put(7, "Seven");
    D.put(8, "Eight");
    D.put(9, "Nine");
    // ---
    D.put(10, "Ten");
    D.put(11, "Eleven");
    D.put(12, "Twelve");
    D.put(13, "Thirteen");
    D.put(14, "Fourteen");
    D.put(15, "Fifteen");
    D.put(16, "Sixteen");
    D.put(17, "Seventeen");
    D.put(18, "Eighteen");
    D.put(19, "Nineteen");
    // ---
    D.put(20, "Twenty");
    D.put(30, "Thirty");
    D.put(40, "Forty");
    D.put(50, "Fifty");
    D.put(60, "Sixty");
    D.put(70, "Seventy");
    D.put(80, "Eighty");
    D.put(90, "Ninety");
}

String integerToEnglishWords(int n) {
    if(n == 0) return "Zero";   // edge case

    StringBuilder sb = new StringBuilder();
    for(int i = 9; i >= 0; i -= 3) {
        int d = (int)Math.pow(10,i);    // divider
        int p = n / d;

        if(p <= 0) continue;    // ignore this portion

        if(sb.length() > 0) sb.append(" ");
        sb.append(decodeComponent(p));
        if(M.containsKey(i)) {
            sb.append(" " + M.get(i));
        }

        n %= d;
    }

    return sb.toString();
}

// xxx -> <string> 
String decodeComponent(int n) {
    StringBuilder sb = new StringBuilder();

    // hundreds
    int hundreds = n / 100;
    if(hundreds > 0) {
        sb.append(D.get(hundreds));
        sb.append(" Hundred");  // add suffix (if applicable)
    }
    n %= 100;   // rem
    
    // tens and units immediately
    if(n >= 10 && n <= 19) {    // 10..19
        if(sb.length() > 0) sb.append(" ");
        sb.append(D.get(n));
        return sb.toString();  // stop
    }

    int tens = n-(n%10);
    if(tens > 0) {
        if(sb.length() > 0) sb.append(" ");
        sb.append(D.get(tens));
        n %= tens;
    } 
    if(n > 0) { // units
        if(sb.length() > 0) sb.append(" ");
        sb.append(D.get(n));  // unit
    }

    return sb.toString();
}
