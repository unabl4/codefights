// https://app.codesignal.com/challenge/C5sL6RNZgqBM84H6j

int holiday(int x, String w, String m, int y) {
    int monthIndex = List.of("January", "February","March", "April", "May", "June","July", "August", "September","October", "November", "December").indexOf(m);
    int weekDayIndex = List.of("Sunday", "Monday", "Tuesday","Wednesday", "Thursday", "Friday","Saturday").indexOf(w)+1;

    Calendar c = Calendar.getInstance();
    c.set(c.YEAR, y);
    c.set(c.MONTH, monthIndex);
    c.set(c.DAY_OF_MONTH, 1);

    while(true){
        if(c.get(Calendar.DAY_OF_WEEK) == weekDayIndex) x--;
        if(x <= 0) return c.get(c.DAY_OF_MONTH);    // reached?
        c.add(Calendar.DATE, 1);    // go next day
        if(c.get(Calendar.MONTH) != monthIndex) break;  // month shift -> not suitable
    }

    return -1;
}

