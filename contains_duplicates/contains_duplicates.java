// https://app.codesignal.com/challenge/jXX8NyuBoHJ4Cyypr

boolean containsDuplicates(int[] a) {
    return IntStream.of(a).distinct().count() != a.length;
}
