package utility;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public String toSring(){
   	 StringBuffer sbuf = new StringBuffer();
   	 ListNode t = this;
   	 sbuf.append("[");
   	 while (t != null){
   		 sbuf.append(t.val + " ");
   		 t = t.next;
   	 }
   	 int len = sbuf.length();
   	 sbuf.delete(len - 1, len);
   	 sbuf.append("]");
   	 return sbuf.toString();
    }
}