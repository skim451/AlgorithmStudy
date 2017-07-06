/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carryOver) {
        if (l1 == null && l2 == null){
            if(carryOver > 0) {
                ListNode newNode = new ListNode(carryOver); 
                return newNode;
            }
            else {
                return null; 
            }
        }
        else if(l1 == null && l2 != null) {
            int digitSum = l2.val + carryOver;
            int carryOverNext = digitSum / 10; 
            digitSum = digitSum % 10; 
            
            ListNode newNode = new ListNode(digitSum);
            newNode.next = addTwoNumbers(l1, l2.next, carryOverNext);
            
            return newNode;
        }
        else if(l1 != null && l2 == null) {
            int digitSum = l1.val + carryOver;
            int carryOverNext = digitSum / 10; 
            digitSum = digitSum % 10; 
            
            ListNode newNode = new ListNode(digitSum);
            newNode.next = addTwoNumbers(l1.next, l2, carryOverNext);
            
            return newNode;
        }
        else {
            int digitSum = l1.val + l2.val + carryOver;
            int carryOverNext = digitSum / 10; 
            digitSum = digitSum % 10; 
            
            ListNode newNode = new ListNode(digitSum);
            newNode.next = addTwoNumbers(l1.next, l2.next, carryOverNext);
            
            return newNode;
        }
    }
    
}