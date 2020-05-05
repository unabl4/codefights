// https://app.codesignal.com/challenge/fuDmXhoN5e8uFxdnJ

// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
    if(l == null) return l;

    ListNode<Integer> t = l;    // tmp
    ListNode<Integer> first = l;
    ListNode<Integer> last = null;

    int nodeCount = 0;
    while(t.next != null) { 
        t = t.next;    // -> last
        nodeCount++;
    }

    nodeCount++;
    if(nodeCount <= n) return l;

    last = t;
    last.next = first;

    t = first;
    while(nodeCount-n-1 > 0) {
        t = t.next;
        nodeCount--;
    }

    l = t.next;
    t.next = null;  // remove the link
    return l;
}

