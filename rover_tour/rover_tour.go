# https://codefights.com/challenge/4oRAnJXGqnL9K7Rdf

func roverTour(terrainDifficulty []int, energy int) int {
    var a,b,s int // zero
    
    for i := 0; i < len(terrainDifficulty); i++ {
        if s+terrainDifficulty[i] <= energy {
            s += terrainDifficulty[i]
            b += 1
        } else {
            s -= terrainDifficulty[a]
            s += terrainDifficulty[i]
            a += 1
        }
    }
    
    return b
}

