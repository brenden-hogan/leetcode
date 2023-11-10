/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1, n2) -> n1.val - n2.val);

        // put the root of each list in the min heap
        for (ListNode root : lists)
          if (root != null)
            minHeap.add(root);

        // take the smallest (top) element form the min-heap and add it to the result; 
        // if the top element has a next element add it to the heap
        ListNode resultHead = null, resultTail = null;
        while (!minHeap.isEmpty()) {
          ListNode node = minHeap.poll();
          if (resultHead == null) {
            resultHead = resultTail = node;
          } else {
            resultTail.next = node;
            resultTail = resultTail.next;
          }
          if (node.next != null)
            minHeap.add(node.next);
        }

        return resultHead;
        
    }
}