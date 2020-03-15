// https://app.codesignal.com/challenge/9TMYWHjjAr5GAjAxy

boolean streamValidation(int[] stream) {
    int m = 0;  // stack size

    for(int i: stream) {
        // base 10 -> base 2
        String s = String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0');   

        if(m == 0) {
            // reading the first block (byte)
            if((~i & (1 << 7)) > 0) {
                // the first bit is 0 (false) -> 1-byte character
                continue;
            } else {
                // multibyte

                int j = 0;
                while(j < 8 && s.charAt(j) == '1') j++;

                // multibyte '10' as well as '11111x' are invalid
                if(j <= 1 || j >= 5) return false;  
                m += j-1;
            }
        } else {
            // s > 0, decoding the remaining bytes (tail)
            if(!(((i & (2 << 6)) >> 6) == 2)) return false; // '10x' prefix check
            m--;    // byte decoding successful
        }
    }

    return m == 0;
}

