package leetcode;

public class ConvertBinaryListToNumber {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        Solution sln = new Solution();
        int v = sln.getDecimalValue(head);
        System.out.println(v);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    static class Solution {
        public int getDecimalValue(ListNode head) {
            int sizeOfList = getSize(head);
            int decimalNumber = 0;
            while (head != null) {
                int v = head.val;
                if (v == 1) {
                    decimalNumber += Math.pow(2, sizeOfList - 1);
                }
                head = head.next;
                sizeOfList -= 1;
            }
            return decimalNumber;
        }

        public int getSize(ListNode head) {

            if (head == null) return 0;

            int c = 0;
            while (head != null) {
                c += 1;
                head = head.next;
            }

            return c;
        }
    }
}
