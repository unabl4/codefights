// https://app.codesignal.com/challenge/pkxSnMPmogvpaKiwJ
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
Tree<Integer> constructSumTree(Tree<Integer> t) {
    getSums(t);
    zeroLeafs(t);

    return t;
}

// ---

void getSums(Tree<Integer> t) {
    if(t == null) return;

    if(t.left != null)  {
        getSums(t.left);
        t.value += t.left.value;
    }

    if(t.right != null) {
        getSums(t.right);
        t.value += t.right.value;
    }
}

void zeroLeafs(Tree<Integer> t) {
    if(t == null) return;

    if(t.left == null && t.right == null) { // leaf node?
        t.value = 0;    // reset
        return;
    }

    zeroLeafs(t.left);
    zeroLeafs(t.right);
}
