# https://app.codesignal.com/challenge/JGQDuEvM7P4iBjHSR


type I = []int
type f = float64


func offsetProduct(x int, a int) int {
    t := 1
    for ; x > 0; x /= 10 {
        t *= x % 10 + a
    }
    
    return t
}

// ---

func multiplyToSingleDigit(addend int, limit int) I {
    dangerous := make(I,0)
    
    for i:=10; i <= limit; i++ {
        mem := make(map[int]bool)
        for x:=i; x > 9; x=offsetProduct(x,addend) {
            _, isMarked := mem[x]
            if isMarked || x > limit {
                dangerous = append(dangerous,i)
                break
            }
            mem[x] = true
        }
    }
    
    return dangerous
}

