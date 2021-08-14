import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class reorderList {

    /**HashMap solution 
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        Map<ListNode, ListNode> previousMap = new HashMap<>();//hashmap for nodes
        
        ListNode temp = head;
        ListNode prev = null;
        ListNode last = new ListNode();
        while(temp != null){
            if(prev == null) {
                prev = temp;
                temp = temp.next;
                continue;
            }
            
            previousMap.put(temp, prev);
            prev = temp;
            last = temp;
            temp = temp.next;
        }
        ListNode p = head;
        ListNode connect = null;
        while(p != null){
            if(connect!= null) connect.next = p;
            ListNode next = p.next;
            p.next = last;
            connect = last;
            if(previousMap.get(last) == p) return;
            if(previousMap.get(last) == next ){
                connect.next = next;
                next.next = null;
                return;
            }
            last = previousMap.get(last);
            last.next = null;
            
            p = next;
        }
    }
    */

    // find mid point
    public void reorderList(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //now slow points to the middle node
        ListNode prev = null, curr = slow, tmp;
        while(curr != null){
            tmp = curr.next;
            curr.next = prev;
            prev = curr;

            curr = tmp;
        }
        //Now merge two linked list
        ListNode first = head, second = prev;

        while(second.next!= null){
            tmp = first.next;
            first.next = second;
            

            first = tmp;

            tmp = second.next;
            second.next = first;
    
            second = tmp;

        }

    }
    
}
