# https://app.codesignal.com/challenge/JhtBKjkeDwaaERovM

func greedyDecoding(message string) (decodedMessage string) {    
    n := len(message)
    for i:=0; i < n; i++ {
        idxWidth := 1
        if i+1 < n {
            idxWidth = 2
        }
        chunk := message[i:i+idxWidth]
        chunkInt, _ := strconv.Atoi(chunk)
        
        if chunkInt <= 26 {
            decodedMessage += string(chunkInt+64)
            i++
        } else {
            smallChunk := message[i:i+1]
            smallChunkInt, _ := strconv.Atoi(smallChunk)
            decodedMessage += string(smallChunkInt+64)
        }
    }
    
    return
}

