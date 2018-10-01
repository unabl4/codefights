# https://app.codesignal.com/challenge/TgCWyhmmB9rBnf2uY

type f = float64
func studyOrSleep(initFamiliarity int, hoursRemaining int) int {
    endResult := f(initFamiliarity)-sleepPenalty(hoursRemaining)
    
    var maxHours int
    var familiarity f = f(initFamiliarity)
    for hours:=1; hours <= hoursRemaining; hours++ {
        // calculate new familiarity
        familiarity = 20.0+0.8*familiarity
        
        // calculate penalty
        hoursToSleep := hoursRemaining-hours
        penalty := sleepPenalty(hoursToSleep)
        
        newEndResult := familiarity-f(penalty)
        if newEndResult <= endResult {  // we've reached the maximum
            return maxHours // = hours-1 (break)
        } else {    // >=
            // update
            maxHours = hours
            endResult = newEndResult  
        }
    }
    
    return maxHours
}

func sleepPenalty(hoursToSleep int) f {
    var missingHours int
    if hoursToSleep >= 8 {
        missingHours = 0
    } else {
        missingHours = 8-hoursToSleep
    }
    return 5.0*f(missingHours)
}

