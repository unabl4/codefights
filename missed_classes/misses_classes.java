// https://app.codesignal.com/challenge/qAYye4nduWhC6dDhR

int missedClasses(int year, int[] daysOfTheWeek, String[] holidays) {
    int c = 0;
    Calendar cal = Calendar.getInstance();

    // 2 years span
    for(String h: holidays) {
        String[] hs = h.split("-");
        int hDate = Integer.parseInt(hs[1]);
        int hMonth = Integer.parseInt(hs[0]);

        int y;
        if(hMonth >= 9 && hMonth <= 12) {
            y = year;
        } else {    // 1..5
            y = year+1;
        }

    
        cal.set(Calendar.YEAR, y);
        cal.set(Calendar.MONTH, hMonth-1);  // 1..12 -> 0..11
        cal.set(Calendar.DATE, hDate);

        System.out.println(cal.getTime().toString());

        int targetDow = cal.get(cal.DAY_OF_WEEK)-1;
        for(int dow: daysOfTheWeek) {
            if(dow == ((targetDow == 0) ? 7 : targetDow)) {
                c++;
            }
        }
    }

    return c;
}
