// https://app.codesignal.com/challenge/K2pc9T4GzBxvQ6aH2


void goNextMonth(Integer[] date) {
    date[0]++; // start from the next month
    if(date[0] > 12) {
        date[0] = 1;    // reset back to January
        date[1]++;      // increment the year
    }
}

String regularMonths(String currMonth) {
    Integer[] d = Stream.of(currMonth.split("-"))
        .map(Integer::parseInt)
        .toArray(Integer[]::new);

    goNextMonth(d); // the current does NOT count

    while(true) {
        Calendar c = Calendar.getInstance();

        c.set(Calendar.YEAR, d[1]);
        c.set(Calendar.MONTH, d[0]-1);  // 1..12 -> 0..11
        c.set(Calendar.DATE, 1);

        // Get the weekday and print it
        int dow = c.get(c.DAY_OF_WEEK);
        if(dow == c.MONDAY) break;   // found it -> stop
    
        goNextMonth(d);
    }

    return String.format("%02d-%d", d[0],d[1]);
}

