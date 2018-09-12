# https://app.codesignal.com/challenge/XanxRWkdG5vKryKxo

type S = []string

func productionSeriesInfo(ingredients int, recipe1 int, recipe2 int, productionSeries []int) []string {
    var totalDemand int // demand per series
    for i:=0; i < len(productionSeries); i++ {
        if productionSeries[i] == 1 {
            totalDemand += recipe1
        } else if productionSeries[i] == 2 {
            totalDemand += recipe2
        } else {
            totalDemand += productionSeries[i]
        }
    }
    
    // ---
    
    if totalDemand > ingredients {
        // shortage (not enough)
        missingCount := totalDemand - ingredients
        missingStr := fmt.Sprintf("Missing %d ingredients", missingCount)
        return S {"Out of ingredients!", missingStr}
    } else if ingredients >= totalDemand * 2 {  // at least 2 times
        // more than needed
        moreSeries := (ingredients - totalDemand) / totalDemand
        moreSeriesStr := fmt.Sprintf("Ingredients for %d more series", moreSeries) 
        return S {"Ok", moreSeriesStr}
    } else {    // totalDemand <= ingredients < totalDemand * 2
        return S {"Ok"}
    }
}

