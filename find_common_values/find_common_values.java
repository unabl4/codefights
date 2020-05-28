// https://app.codesignal.com/challenge/6ZAh6MgWdxTMKhACH

//
// Binary trees are already defined with this interface:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }
int[] findCommonValues(Tree<Integer> t1, Tree<Integer> t2) {
    Set<Integer> s1 = new HashSet<>();
    Set<Integer> s2 = new HashSet<>();

    getNums(t1, s1, null);
    getNums(t2, s2, s1);

    return s2.stream().sorted().mapToInt(Number::intValue).toArray();
}

void getNums(Tree<Integer> t, Set<Integer> s, Set<Integer> ref) {
    if(t == null) return;
    
    if(ref == null || ref.contains(t.value)) s.add(t.value);
    getNums(t.left, s, ref);
    getNums(t.right, s, ref);
}
