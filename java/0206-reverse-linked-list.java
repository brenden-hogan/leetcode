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
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        ListNode prev = null;
        
        while (cur != null) { // Stop when cur has hit the end of the old list
            next = cur.next; //set next equal to the old 2 // set next equal to old 3
            cur.next = prev; // set 1 equal to null // set 2 equal to new 1
            prev = cur; //set prev equal to new 1 // set prev equal to new 2
            cur = next ; //set cur equal to old 2 // set cur equal to old 3
        }
        
        return prev;
    }
}