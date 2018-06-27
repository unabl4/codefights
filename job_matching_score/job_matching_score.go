# https://codefights.com/challenge/pFMvFY3BQ683iRvFr

import "strings"

func jobMatchingScore(locations []string, criteria string) int {
    matchCount := 0
    
    criteriaSeq := strings.Split(criteria, ", ")
    n := len(criteriaSeq)
    
    // ---
    
    LOCATION_LOOP:
    for _, location := range locations {
        locationSeq := strings.Split(location, ", ")
        m := len(locationSeq)   // =3

        // from right to left
        for i := 0; i < n; i++ {
            if criteriaSeq[(n-1)-i] != locationSeq[(m-1)-i] {
                continue LOCATION_LOOP
            }       
        }

        matchCount++
    }
    
    return matchCount
}

