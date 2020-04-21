// https://app.codesignal.com/challenge/DasEACJNsgiqskwZh

boolean isMAC48Address(String s) {
    return Pattern.matches("^[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}-[0-9A-F]{2}$", s);
}

