// https://app.codesignal.com/challenge/cwzMet47MyDRj4xF4

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
int leftLeavesSum(Tree<Integer> t) {
    if(t == null) return 0;

    int s = 0;
    Tree<Integer> L = t.left;
    if(L != null) {
        if(L.left == null && L.right == null) s += L.value; // leaf!
        s += leftLeavesSum(L);
    }

    if(t.right != null) s += leftLeavesSum(t.right);
    return s;
}

