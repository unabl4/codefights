// https://app.codesignal.com/challenge/oGgxZDFgpJfxxMuwC

int newYearCelebrations(String takeOffTime, int[] minutes) {
    int n = minutes.length;
    int c = 0;  // celebrations counter
    int M = 24 * 60;    // 31st midnights in minutes
    int time = timeToMin(takeOffTime);   // real run time
    //  The "00:00" time corresponds to the midnight of 31st of December / 1st of January.
    time = (time == 0) ? M : time;  // reset
    int currentTime = time;  // converted
 
    
    for(int i=0; i < n; i++) {
        int timeDelta = (i == 0) ? minutes[i] : minutes[i]-minutes[i-1];
        // ---
        int timeBefore = currentTime;
        int timeNew = currentTime + timeDelta;
        int timeAfter = timeNew - 60;    // after return

        // System.out.print(timeBefore);
        // System.out.print(" -> ");
        // System.out.print(timeNew);
        // System.out.print(" -> ");
        // System.out.print(timeAfter);
        // System.out.println();

        if(timeBefore <= M && timeNew >= M) c++; // transition?

        currentTime = timeAfter; // update
    }

    // System.out.println();
    // System.out.println(currentTime);

    if(currentTime <= M) c++;   // current time -> infinity

    // System.out.print("Answer: ");
    // System.out.println(c);
    return c;
}

int timeToMin(String time) {
    String[] s = time.split("\\:");
    return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
}

