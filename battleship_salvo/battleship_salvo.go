# https://app.codesignal.com/challenge/9LJLixMkCr4vFuBkA

// calculate shot indices
func shotPos(shotCode string) (int, int) {
    row := int(shotCode[0])-65  // "A" -> 0, "B" -> 1, ...
    col, _ := strconv.Atoi(shotCode[1:len(shotCode)])
    return row,col-1
}

// boat types available
var boatTypes = map[string]string {
    "A": "Carrier",
    "B": "Battleship",
    "D": "Destroyer",
    "S": "Submarine",
    "P": "Patrol Boat",
}

var boatSizes = map[string]int { "A": 5, "B": 4, "D": 3, "S": 3, "P": 2, }

type playerState struct {
    Boats map[string]int    // count
    Board []string
    History map[string]bool
}

func (ps playerState) BoatsLeft() int {
    var count int
    for _, boatSize := range ps.Boats { // copy
        if boatSize > 0 {
            count++ // +1 boat alive
        }
    }
    
    return count
}

func initPlayerState(board []string) playerState {
    state := playerState { Board: board }
    state.Boats = make(map[string]int)  // allocate memory
    state.History = make(map[string]bool)
    for boatType, boatSize := range boatSizes { // 'copy' the boats
        state.Boats[boatType] = boatSize
    }
    return state
}

func hitReport(playerIndex int, boatType, hitType string) string {
    playerId := playerIndex+1
    boat := boatTypes[boatType]
    return fmt.Sprintf("Player %d %s %s!", playerId, boat, hitType)
}

// ---

func battleshipSalvo(player1Board []string, player2Board []string, shotsFired []string) []string {
    m := 2   // modulo
    players := make([]playerState, m)   // 2 players
    players[0] = initPlayerState(player1Board)
    players[1] = initPlayerState(player2Board)
    
    var currentPlayer, oppositePlayer int   // player 1 starts
    var shotsCounter int    // =0
    var shotReports = make([]string, 0)
    MAIN_LOOP:
    for {
        oppositePlayer = (currentPlayer+1) % m  // 0->1->0
        
        // number of shots = number of boats left
        for i:=0; i < players[currentPlayer].BoatsLeft(); i++ {
            if shotsCounter > len(shotsFired)-1 {  // EOG -> all shots fired
                break MAIN_LOOP
            }
            
            shotCode := shotsFired[shotsCounter]
            shotsCounter++  // record fired
            // check if haven't shot previously at the same position
            if _, ok := players[currentPlayer].History[shotCode]; ok {
                continue
            }
            shotRow, shotCol := shotPos(shotCode)
            players[currentPlayer].History[shotCode] = true
            cellCnt := string(players[oppositePlayer].Board[shotRow][shotCol])
            if cellCnt == "." { // miss?
                continue    // do nothing
            }
            
            players[oppositePlayer].Boats[cellCnt]--    // decrement
            if players[oppositePlayer].Boats[cellCnt] <= 0 {
                // report sunk
                shotReports = append(shotReports, hitReport(oppositePlayer, cellCnt, "sunk"))
            } else {
                // report hit
                shotReports = append(shotReports, hitReport(oppositePlayer, cellCnt, "hit"))
            }

            // ---

            if players[oppositePlayer].BoatsLeft() <= 0 { // EOG?
                // win condition?
                winStr := fmt.Sprintf("Player %d wins!", currentPlayer+1)
                shotReports = append(shotReports, winStr)
                return shotReports // end the game
            }
        }
        
        // switch player
        currentPlayer = oppositePlayer
    }
    
    return shotReports
}

