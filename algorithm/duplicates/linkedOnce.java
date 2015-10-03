package duplicates;
import utility.ListNode;

public class linkedOnce {
    public ListNode deleteDuplicates(ListNode head) {
        int k = 1;
        int freq = 0;
        if(head == null || head.next == null) return head;
        int curNum = head.val;
        ListNode cur = head.next;
        ListNode pt = head;

        while (cur != null){
        	if(cur.val == curNum) {
        		cur = cur.next;
        	}else{
        		pt.next.val = cur.val;
        		curNum = cur.val;
        		cur = cur.next;
    			pt = pt.next;
        	}
        }
        
        pt.next = null;
        return head;
    }
}
