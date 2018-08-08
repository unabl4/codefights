# https://app.codesignal.com/challenge/hb2kwpdWQBhcpW9p7

// with help of 'zero_cool' himself: https://www.twitch.tv/videos/294543671 :)

import "sort"
func rockClimbing(holds []int, friends []int) int {
    // find the max gap
    var maxGap int
    for i:=0; i < len(holds)-1; i++ {
        gap := holds[i+1]-holds[i]
        
        if gap > maxGap {
            maxGap = gap
        }
    }
    
    // sort the friends
    sort.Ints(friends)
    
    left := 0
    right := len(friends)-1
    var last, reachers int
    
    for i:=0; left <= right; i++ {
        if i % 2 == 0 { // start with the friend with the biggest reach
            if friends[right] + last >= maxGap {
                last = friends[right]
                reachers++
            }
            
            right--
        } else {
            for left < right && friends[left]+friends[right] < maxGap {
                left++
            }
            
            if friends[left] + last >= maxGap {
                last = friends[left]
                reachers++
            }
            
            left++
        }
    }
    
    return reachers
}

