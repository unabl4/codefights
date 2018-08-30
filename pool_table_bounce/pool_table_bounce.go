# https://app.codesignal.com/challenge/thbu5Wpoaz8CNhKj7

type Point struct {
    X int
    Y int
}

func min(a,b int) int {
    if a < b {
        return a
    }
    
    return b
}

// ---

func poolTableBounce(width int, height int) int {
    // step 1: find all pockets (map)
    pockets := map[Point]int {
        Point {0,0}: 0, // starting point
        Point {0,height}: 1,
        Point {width/2, height}: 2,
        Point {width, height}: 3,
        Point {width, 0}: 4,
        Point {width/2, 0}: 5,
    }
    // step 2: initialize the ball point state
    currentPoint := Point { 0, 0 }
    // step 3: run the simulation loop
    DX := 1  // move to the right
    DY := 1  // move up
    var distToXEnd, distToYEnd int
    for i:=0; ; i++ {
        if DX > 0 {  // left-to-right
            distToXEnd = width - currentPoint.X
        } else {    // right-to-left (reverse)
            distToXEnd = currentPoint.X
        }
        
        if DY > 0 {
            distToYEnd = height - currentPoint.Y
        } else {
            distToYEnd = currentPoint.Y
        }
        
        maxDelta := min(distToXEnd, distToYEnd) // max possible delta to be done
        currentPoint.X += DX * maxDelta
        currentPoint.Y += DY * maxDelta

        // check if we are in the pocket
        if pocketIdx, isInPocket := pockets[currentPoint]; isInPocket {
            return pocketIdx    // found it
        }
        
        // ---
        
        // special case bounce handlers
        if currentPoint.Y == 0 || currentPoint.Y == height {
            DY *= -1    // switch directions            
        }

        if currentPoint.X == 0 || currentPoint.X == width {
            DX *= -1    // switch directions
        }
    }
}

