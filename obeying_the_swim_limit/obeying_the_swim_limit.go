# https://app.codesignal.com/challenge/EPsFtkaT2sXgxcNiE

var foodCalories = map[string]int {
    "Banana": 100,
    "Apple": 80,
    "Pizza": 300,
    "Chocolate": 500,
    "Roast Beef": 850,
    "Milk": 110,
    "Chicken": 300,
    "Deluxe Burger": 1000,
}

// ---

func obeyingTheSwimLimit(intake []string) int {
    var caloriesConsumed int
    
    for _, food := range intake {
        caloriesConsumed += foodCalories[food]
    }
    
    if caloriesConsumed <= 600 {
        return 0
    } else if caloriesConsumed <= 1400 {
        return 15
    } else if caloriesConsumed <= 2000 {
        return 30
    } else {
        return 60
    }
}

