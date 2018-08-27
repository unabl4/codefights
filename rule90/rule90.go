# https://app.codesignal.com/challenge/2Aj9SuWGcP7cTGddu

func rule90(seed string, iterations int) []string {
    n := len(seed)
    output := make([]string, iterations+1)
    output[0] = seed
    
    for i:=1; i <= iterations; i++ {
        s := make([]byte, n)
        for j := 0; j < n; j++ {
            if j == 0 {
                s[j] = xor(output[i-1][1], output[i-1][n-1])
            } else if j == n-1 {
                s[j] = xor(output[i-1][j-1], output[i-1][0])
            } else {
                s[j] = xor(output[i-1][j-1], output[i-1][j+1])
            }
        }
        
        output[i] = string(s)
    }
    
    return output
}

func xor(a,b byte) byte {
    if a != b {
        return '1'
    }
    
    return '0'
}

