// https://app.codesignal.com/challenge/JmBbRo2WAqFRgvZMo

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
int binaryTreeDiameter(Tree<Integer> t) {
    int[] d = btDiameter(t);
    return d[1];
}

int[] btDiameter(Tree<Integer> t) {
    // base case
    if(t == null) return new int[] { 0,0 };
    
    // left and right children
    int[] L = btDiameter(t.left);
    int[] R = btDiameter(t.right);
    
    // merge
    
    // at each recursion we (re-)calculate the MAX linear length
    // and keep track of max diameter we've seen so far vs the diameter that can be constructed
    // using left and right lengths - as this is the maximum "reach" (or diameter)
    int ML = 1+Math.max(L[0],R[0]);   // max length
    int MD = Math.max(1+L[0]+R[0], Math.max(L[1],R[1]));
    return new int[] { ML, MD };
}

