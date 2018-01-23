//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode pre1 = null, pre2 = null, cur1 = l1, cur2 = l2, next1 = null, next2 = null;
       
       while(cur1 != null){
    	   next1 = cur1.next;
    	   cur1.next = pre1;
    	   pre1 = cur1;
    	   cur1 = next1;
       }
       
       ListNode l1Head = pre1;
       
       while(cur2 != null){
    	   next2 = cur2.next;
    	   cur2.next = pre2;
    	   pre2 = cur2;
    	   cur2 = next2;
       }
       
       ListNode l2Head = pre2;
       
       int carry = 0;
       ListNode tail = new ListNode(0);
       ListNode res = tail;
       
       while(l1Head != null || l2Head != null){
    	   int val1 = 0;
    	   int val2 = 0;
    	   if(l1Head != null){
    		   val1 = l1Head.val;
    		   l1Head = l1Head.next;
    	   }
    	   
    	   if(l2Head != null){
    		   val2 = l2Head.val;
    		   l2Head = l2Head.next;
    	   }
    	   
    	   int tmp = val1 + val2 + carry;
    	   res.next = new ListNode(tmp % 10);
    	   carry = tmp / 10;
    	   res = res.next;
       }
       
       if(carry == 1)
    	   res.next = new ListNode(carry);
       
       ListNode pre = null;
       ListNode cur = tail.next;
       ListNode next = null;
       
       while(cur != null){
    	   next = cur.next;
    	   cur.next = pre;
    	   pre = cur;
    	   cur = next;
       }
       
       return pre;
    }
}
