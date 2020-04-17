// https://app.codesignal.com/challenge/uH8LDmezpYbqWkG84

String NSC = "No such cell";

String htmlTable(String table, int row, int col) {
    Pattern htmlTableRegexp = Pattern.compile("<table>(.*)</table>");
    Pattern rowRegexp = Pattern.compile("<tr>(.*?)</tr>");
    Pattern colRegexp = Pattern.compile("<td>(.*?)</td>");

    Matcher tableMatcher = htmlTableRegexp.matcher(table);

    if(!tableMatcher.find()) return NSC;  // no table -> no entry

    String tableInner = tableMatcher.group(1); // tr, td
    Matcher rowMatcher = rowRegexp.matcher(tableInner);

    while(rowMatcher.find() && row >= 0) {
        // individual rows
        if(row-- > 0) continue;

        String targetRow = rowMatcher.group(1);
        Matcher colMatcher = colRegexp.matcher(targetRow);

        while(colMatcher.find() && col >= 0) {
            if(col-- > 0) continue;
            return colMatcher.group(1); // final output
        }
    }

    return NSC;
}

