package sortLinkedList;

import utility.ListNode;

public class solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return Merge(sortList(head), sortList(head2));
    }
    
    ListNode Merge(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(0);
        ListNode pt = dummy;
        
        while(h1 != null && h2 != null){
            if(h1.val > h2.val){
                pt.next = h2;
                pt = pt.next;
                h2 = h2.next;
            }else{
                pt.next = h1;
                pt = pt.next;
                h1 = h1.next;
            }
        }
        if(h1 != null) pt.next = h1;
        if(h2 != null) pt.next = h2;
        return dummy.next;
    }
    
    public static void main(String[] args){
    	solution sln = new solution();
    	ListNode head = new ListNode(2);
    	head.next = new ListNode(1);
    	ListNode ret = sln.sortList(head);
    	System.out.println(ret.toSring());
    }
}
