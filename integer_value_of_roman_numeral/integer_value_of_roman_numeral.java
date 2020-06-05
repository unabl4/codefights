// https://app.codesignal.com/challenge/CqXTeBAbeYgeK6L27

Set<String> M = new HashSet<>(List.of("IV", "IX", "XL", "XC", "CD", "CM"));

int integerValueOfRomanNumeral(String S) {
    int N = S.length();
    int A = 0;  // arabic number
    int R = 1;  // repetition
    
    for(int i=0; i < N; i++) {
        int currentNumber = letterToNumber(S.charAt(i));
        
        if(i+1 >= N) {         
            // the next number is out of range -> just add the number
            A += currentNumber;
        } else {
            int nextNumber = letterToNumber(S.charAt(i+1));
            
            // e.g IV, IX
            if(currentNumber < nextNumber) {
                R = 1; // reset
                if(!isValidSubtraction(S.charAt(i), S.charAt(i+1))) return -1;
        
                A += (nextNumber-currentNumber);
                i++;    // skip the next number as an individual unit
            } else if(currentNumber > nextNumber) {
                R = 1;  // reset
                A += currentNumber;
            } else {
                if(!isRepeatable(S.charAt(i))) return -1;   // VV, DD, LL
                
                // III
                A += currentNumber;
                if(S.charAt(i) != 'M' && ++R > 3) return -1;
            }
        }
    }
    
    // sanity check
    if(!(toRoman(A).equals(S))) return -1;  
    
    return A;
}

boolean isRepeatable(char C) {
    return C == 'I' || C == 'X' || C == 'C' || C == 'M';    // V,L,D are not repeatable
}

boolean isValidSubtraction(char A, char B) {
    String C=new StringBuilder().append(A).append(B).toString();
    return M.contains(C);
}

int letterToNumber(char letter) {
    switch(letter) {
        case 'I':  return 1;
        case 'V':  return 5;
        case 'X':  return 10;
        case 'L':  return 50;
        case 'C':  return 100;
        case 'D':  return 500;
        case 'M':  return 1000;
        default:   return -1;
    }
}

String toRoman(int arab) {
    int[] ints = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] nums = { "M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I" };
    
    StringBuilder sb = new StringBuilder();
    for(int i=0; i < ints.length; i++) {
        int c = arab / ints[i];
        for(int j=0; j < c; j++) sb.append(nums[i]);
        arab -= (c * ints[i]);
    }
    
    return sb.toString();
}
