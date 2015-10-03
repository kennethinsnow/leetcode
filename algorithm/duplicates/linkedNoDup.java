package duplicates;
import utility.ListNode;

public class linkedNoDup {
    public ListNode deleteDuplicates(ListNode head) {
        int freq = 1;
        if(head == null || head.next == null) return head;
        int curNum = head.val;
        ListNode cur = head.next;
        ListNode pt = new ListNode(0);
        pt.next = head;
        
        while (cur != null){
        	if(cur.val == curNum) {
        		cur = cur.next;
        		freq++;
        	}else{
        		if(freq == 1){
        			pt.next.val = curNum;
        			pt = pt.next;
        		}
        		curNum = cur.val;
        		cur = cur.next;
    			freq = 1;
        	}
        }
        if(freq == 1) {
        	pt.next.val = curNum;
        	pt.next.next = null;
        }else{
        	if(pt.next == head) head = null;
        	else pt.next = null;
        }
        return head;
    }
}
