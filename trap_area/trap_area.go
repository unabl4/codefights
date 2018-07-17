# https://app.codesignal.com/challenge/sGDJsXcFYhkoejcrq

import "math"

func trapArea(n int, p float32, r float32) int {
    z := float64(n) // to avoid repetition
    innerAngle := 2 * math.Pi / z    // split 360 deg equally (equiangularity)
    sideLength := float64(p) / z    // split the perimeter equally (equilaterality)
    rSmall := sideLength / (2 * math.Sin(innerAngle/2)) // from the sin definition (right triangle)
    
     // Triangle area = 1/2 * A * B * sin(deg(a,b))
    polyArea := func(s float64) float64 {
        return z * 0.5 * s * s * math.Sin(innerAngle)        
    }
    
    bigArea := polyArea(float64(r))
    smallArea := polyArea(rSmall)
    
    return int(math.Round(bigArea-smallArea))
}

