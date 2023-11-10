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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // TODO should check for null case here;
        // if one is valid and the other 0 can just return the valid list.
        
        ListNode sum = new ListNode();
        ListNode returnList = sum;
        int addAmount = 0;
        while (l1 != null || l2 != null){
            int digitSum = 0;
            //Replace this if block with a function
            if (l1 != null){
                digitSum += l1.val;
            }
            if (l2 != null){
                digitSum += l2.val;
            }
            
            if (addAmount > 0) {
                digitSum += addAmount;
                addAmount = 0;
            }
            
            if (digitSum < 10){
                sum.val = digitSum;
            } else {
                addAmount = digitSum / 10; //Get the left most digit as the amount that will carry over
                sum.val = digitSum % 10; //Get the right most digit as the remaining value
            }
            
            if (addAmount > 0 || hasValidNext(l2) || hasValidNext(l1)){
                sum.next = new ListNode();
            }
            
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            sum = sum.next;
        }

        if (addAmount > 0){
            sum.val = addAmount;
        }
        return returnList;
    }
    
    public boolean hasValidNext(ListNode head){
        if (head == null){
            return false;
        } else if (head.next == null) {
            return false;
        }
        return true;
    }
    
    /*
    * Computes the length of a linked list without cycles
    */
    public int length(ListNode head){
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }
}