# https://codefights.com/challenge/sJmte92n67bjGzFLY

func makingCents(change int) int {
    m := int(1e9+7)    // modulo
    amount := change-1 // reserve one penny (the main trick)
    coins := []int{1,5,10,25,100,200}   // available coins
    
    coinCount := len(coins)
    dp := make([][]int, coinCount+1)
    for i := 0; i <= len(coins); i++ {
        dp[i] = make([]int, amount+1)
        dp[i][0] = 1    // 0-th column
    }
    
    // ---
    
    for i:= 1; i <= coinCount; i++ {
        for j := 1; j <= amount; j++ {
            currentCoin := coins[i-1]
            
            dp[i][j] = dp[i-1][j] % m
            if currentCoin <= j {
                dp[i][j] += dp[i][j-currentCoin] % m
            }
        }
    }
    
    return dp[coinCount][amount] % m
}
