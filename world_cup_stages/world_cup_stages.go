# https://codefights.com/challenge/fHMuKwFnuqMZip7Ff

import "strings"

func worldCupStages(results [][]string) []string {
    output := make([]string,2)  // 2 rows of formatted strings
    teamPairs := make([][2]string,8)   // exactly 8 pairs
    
    var otherTeam string
    
    // 1) collect pairs
    for idx, teamNameSet := range results {
        teamName := teamNameSet[0]
        
        if idx % 2 == 0 {
            otherTeam = results[idx+1][1]
        } else {
            otherTeam = results[idx-1][1]
        }
        
        // equalize string lengths
        commonLen := max(len(teamName), len(otherTeam))
        teamPair := [2]string{
            alignedTeamName(teamName, commonLen), 
            alignedTeamName(otherTeam, commonLen),
        }
        teamPairs[idx] = teamPair
    }
    
    // ---
    // 2) output (-> string)
    teamSet := make([]string, 8)
    for row := 0; row < 2; row++ {    
        for teamPairIdx := range teamPairs {
            teamSet[teamPairIdx] = teamPairs[teamPairIdx][row]
        }
        
        output[row] = formatTeamLine(teamSet)
    } 
    
    return output
}

// ---

func formatTeamLine(teamSet []string) string {
    return "|" + strings.Join(teamSet, "|") + "|"
}

func alignedTeamName(input string, requiredLen int) string {
    n := requiredLen-len(input)
    // TODO: optimize (buffer)
    for i:=0; i < n; i++ {
        input += " "
    }
    
    return input
}

func max(a,b int) int {
    if a > b {
        return a
    }
    
    return b
}

