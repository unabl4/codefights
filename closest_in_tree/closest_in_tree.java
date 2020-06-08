// https://app.codesignal.com/challenge/vEA6MQdn8BuKrEaaT

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
int closestInTree(Tree<Integer> t, int n) {
    return traverse(t, n, null);
}

int traverse(Tree<Integer> t, int n, Integer closestValue) {
    if(t == null) return closestValue;    // fallback
    
    int v = t.value;
    if(closestValue == null || Math.abs(n-v) < Math.abs(n-closestValue)) {
        closestValue = v;
    }
    
    if(n > v) {
        // right
        return traverse(t.right, n, closestValue);
    } else if(n < v) {
        // left  
        return traverse(t.left, n, closestValue);    
    } else {    // ==
        return v;
    }
}

