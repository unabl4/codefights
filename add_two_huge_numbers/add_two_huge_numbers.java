// https://app.codesignal.com/challenge/64oZFoKh9FR4j4oH7

// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
    int L = 10000;
    Stack<Integer> U = new Stack<Integer>(); 
    Stack<Integer> V = new Stack<Integer>(); 

    while(a != null) {
        U.push(a.value);
        a = a.next;
    }

    while(b != null) {
        V.push(b.value);
        b = b.next;
    }

    // compose the nodes backwards
    int C = 0;
    ListNode<Integer> prevNode = null;
    while(C > 0 || (!U.isEmpty() || !V.isEmpty())) {
        int X = U.isEmpty() ? 0 : U.pop();
        int Y = V.isEmpty() ? 0 : V.pop();

        int Z = X+Y+C;  // opA + opB + carry
        C = Z / L;
        ListNode<Integer> currentNode = new ListNode<>(Z % L);
        currentNode.next = prevNode;
        prevNode = currentNode;
    }

    return prevNode;
}

