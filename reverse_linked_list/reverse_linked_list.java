// https://app.codesignal.com/challenge/ZrGJuXjhrD9odEuY3

// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> reverseLinkedList(ListNode<Integer> l) {
    ListNode<Integer> p = null; // previous
    ListNode<Integer> c = l;    // current

    while(c != null) {
        ListNode<Integer> n = c.next;   // n

        c.next = p; // previous
        p = c;
        c = n;  // move next
    }

    return p;
}
