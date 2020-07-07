// https://app.codesignal.com/challenge/udAmj5NKfnnBjsvur

int dayOfWeek(String birthdayDate) {
    Calendar c = Calendar.getInstance();
    
    String[] bdStr = birthdayDate.split("-");
    
    Integer[] bdNums = Stream.of(bdStr).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
    
    c.set(c.DAY_OF_MONTH, bdNums[1]);
    c.set(c.MONTH, bdNums[0]-1);
    c.set(c.YEAR, bdNums[2]);
    
    int dow = c.get(c.DAY_OF_WEEK);
    
    // offset
    int daysInMonth = c.getActualMaximum(c.DAY_OF_MONTH);
    int o = bdNums[1] == 29 && bdNums[0] == 2 ? 4 : 1;    // offset
    int y = bdNums[2]+o;
    
    while(true) {
        c.set(c.DAY_OF_MONTH, bdNums[1]);
        c.set(c.MONTH, bdNums[0]-1);
        c.set(c.YEAR, y);
        
        // "lenient" check
        if(c.get(c.MONTH) == bdNums[0]-1 && c.get(c.DAY_OF_WEEK) == dow) break;
        y += o;
    }
    
    return y-bdNums[2];
}

