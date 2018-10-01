# https://app.codesignal.com/challenge/awYrzSPtNqd4mf7d3

import "math"

type f = float64
func curveGrades(percentages []int) []string {
    n := len(percentages)
    
    mean := 0.0
    for _, percentage := range percentages {
        mean += f(percentage)
    }
    mean /= f(n)
    
    stddev := 0.0
    for _, percentage := range percentages {
        dev := mean-f(percentage)
        stddev += dev*dev
    }
    
    stddev /= f(n-1)
    stddev = math.Sqrt(stddev)
    
    var grades = make([]string, n)
    for i:=0; i < n; i++ {
        percent := f(percentages[i])
        if percent > (mean+stddev) {
            grades[i] = "A"
        } else if percent > mean {
            grades[i] = "B"
        } else if percent > (mean-stddev) {
            grades[i] = "C"
        } else if percent > (mean-stddev*2) {
            grades[i] = "D"
        } else {    // < mean-2*stddev
            grades[i] = "F"
        }
    }
    
    return grades
}
