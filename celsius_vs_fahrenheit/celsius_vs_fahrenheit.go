# https://app.codesignal.com/challenge/TzKF8iDGrE2kCYJ48

type f float64  // type alias

func celsiusVsFahrenheit(yourTemps []int, friendsTemps []int) int {
    var c int   // counter
    n := len(yourTemps)
    
    for i:=0; i < n; i++ {
        // celcius -> fahrenheit conversion
        t := 9 * f(yourTemps[i]) / 5 + 32
        
        if f(friendsTemps[i]) > t {
            c++
        }
    }
    
    return c
}

