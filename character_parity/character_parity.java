// https://app.codesignal.com/challenge/uPqSkpeduyJpHH6n6

String characterParity(char symbol) {
    try {
        int i = Integer.parseInt(String.valueOf(symbol));
        return i % 2 == 0 ? "even" : "odd";
    } catch(NumberFormatException e) {
        return "not a digit";
    }
}

