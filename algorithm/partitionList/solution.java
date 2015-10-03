package partitionList;

public class solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode end, pt, pre, start;
        pre = new ListNode(0);
        start = pre;
        end = head;
        while(end.next != null){
            end = end.next;
        }
        pt = end;
        pre.next = head;
        while(head != end){
            if (head.val >= x){
                pre.next = head.next;
                pt.next = head;
                pt = pt.next;
                head = head.next;
            }else{
                pre = head;
                head = head.next;
            }
        }
        //last node
        if (pt != end && head.val >= x){
            pre.next = head.next;
            pt.next = head;
            pt = pt.next;
        }
        pt.next = null;
        return start.next;
    }

     public class ListNode {
         public int val;
         public ListNode next;
         public ListNode(int x) { val = x; }
         public String toSring(){
        	 StringBuffer sbuf = new StringBuffer();
        	 ListNode t = this;
        	 sbuf.append("[");
        	 while (t != null){
        		 sbuf.append(val + " ");
        		 t = t.next;
        	 }
        	 int len = sbuf.length();
        	 sbuf.delete(len - 1, len);
        	 sbuf.append("]");
        	 return sbuf.toString();
         }
     }
     
     public static void main(String[] args){
    	 
    	 solution sln = new solution();
    	 ListNode input = sln.new ListNode(0), input1;
    	 input1 = input;
    	 int[] arr = {1, 4, 3, 2, 5, 2};
    	 for (int i = 0; i < arr.length; i++){
    		 input.next = sln.new ListNode(arr[i]);
    		 input = input.next;
    	 }
    	 System.out.println(sln.partition(input1.next, 3).toSring());
     }
}
