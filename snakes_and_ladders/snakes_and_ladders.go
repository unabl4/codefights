# https://app.codesignal.com/challenge/XhM57PadXEn3FfXte

type playerState struct {
    Y int
    X int
    Direction int   // direction sign: -1 (left), (+1) right
}

func (ps *playerState) moveSteps(steps int) {
    newX := ps.X + (ps.Direction * steps)
    
    // bounce-back edge case
    if ps.Y == 0 && newX < 0 {  // overshoot condition
        (*ps).X = steps - ps.X
        // the direction remains the same
        return
    }
    
    // ---
    
    if newX < 0 || newX > 9 {   // edge cases
        // border case
        
        (*ps).Y--  // move up
        (*ps).X = 9-mod(newX, 10)  // mirrored value
        (*ps).Direction *= -1  // switch the X-axis direction
    } else {
        (*ps).X = newX
    }
}

func (ps *playerState) moveToTile(tileNumber int) {
    idx := tileNumber-1 // X-axis index
    newY := 9-(idx/10)
    
    (*ps).Y = newY
    if newY % 2 == 0 {  // even
        (*ps).X = 9-(idx % 10)
        (*ps).Direction = -1
    } else {
        (*ps).X = (idx % 10)
        (*ps).Direction = 1
    }
}

// convert <x,y> coordinate into a tile number
func (ps playerState) getTileNumber() int {
    var offset int
    if ps.Y % 2 == 0 {
        // <8,0> -> 20
        // <8,9> -> 11
        offset = 9-ps.X
    } else {
        offset = ps.X
    }
    return (9-ps.Y)*10+offset+1
}

// check if we are at the 100th tile
func (ps playerState) atTheEndTile() bool {
    return ps.X == 0 && ps.Y == 0   // top left corner
}

// modulo helper function
// because Go's modulo operator is "incorrect" for negative numbers (x)
func mod(x,y int) int {
    return ((x % y) + y) % y
}

// ---

func snakesAndLadders(board [][]int, dieRolls []int, players int) []int {
    // step 1: declare positions vector and state
    var endPositions = make([]int, players)
    var playerStates = make([]*playerState, players)
    
    for i:=0; i < players; i++ {
        playerStates[i] = &playerState { 9, 0, 1 }    // bottom left corner
    }
        
    // step 2: run the game
    var currentPlayerIdx = 0   // start with player 1 (0-based) | 0..N-1
    MAIN_LOOP:
    for {
        for _, roll := range dieRolls {
            // 1) observe the value
            // 2) react appropriately
            
            currentPlayer := playerStates[currentPlayerIdx] // ?
            (*currentPlayer).moveSteps(roll)  // move
            if currentPlayer.atTheEndTile() {
                // done -> end of the game
                break MAIN_LOOP
            }
            
            boardValue := board[currentPlayer.Y][currentPlayer.X]
            if boardValue != -1 {
                currentPlayer.moveToTile(boardValue)
            }
            
            if roll != 6 {
                // pass the control to the next player
                currentPlayerIdx = (currentPlayerIdx+1) % players
            }
        }
        
        // --- 
        // die rolls have been exhausted -> end the game (no win)
        break
    }
    
    for i:=0; i < players; i++ {
        endPositions[i] = playerStates[i].getTileNumber()
    }
    return endPositions
}

