# https://codefights.com/challenge/XhX2WCaGz3YkLHraq

func kitColors(first []string, second []string) [][2]string {
    var colorDistance, maxColorDistance int
    var h = make(map[int][][2]string)
    
    for _, firstColor := range first {
        for _, secondColor := range second {
            colorDistance = distanceColors(firstColor,secondColor)
            colorPair := [2]string{firstColor, secondColor}
            h[colorDistance] = append(h[colorDistance], colorPair)
            
            if colorDistance > maxColorDistance {
                maxColorDistance = colorDistance
            }
        }
    }
    
    return h[maxColorDistance]
}

// ---

func distanceColors(color1, color2 string) int {
    var distance int    // 0
    
    // skip the sharp sign
    for i:=1;i<6;i+=2 {
        a, _ := strconv.ParseInt(color1[i:i+2], 16, 64)
        b, _ := strconv.ParseInt(color2[i:i+2], 16, 64)
        
        diff := int(a-b)    // int64 -> int
        distance += abs(diff)
    }
    
    return distance
}

// helper function
func abs(x int) int {
    if x < 0 {
        return -x
    }
    
    return x
}

