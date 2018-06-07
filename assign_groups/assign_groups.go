# https://codefights.com/challenge/ogcRDybjWMDEbph8W

import "sort"

func assignGroups(timeEstimates []int, groupSize int) int {
    timeTotal := 0  // total time estimate
    sort.Sort(sort.Reverse(sort.IntSlice(timeEstimates)))
    
    for i := 0; i < len(timeEstimates); i += groupSize {
        timeTotal += timeEstimates[i]
    }
    
    return timeTotal
}
