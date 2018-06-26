# https://codefights.com/challenge/94h3yuGxe5g6bE5Pm

func isPalindrome(str string) bool {
    n := len(str)
    for i := 0; i < n/2; i++ {
        if str[i] != str[(n-1)-i] {
            return false
        }
    }
    return true
}

func mirrorBase(number string, base1 int, base2 int) bool {
    a, _ := strconv.ParseInt(number, base1, 64) // source base -> base 10
    b := strconv.FormatInt(a, base2)    // base 10 -> destination base
    return isPalindrome(b)
}

