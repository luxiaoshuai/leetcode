package com.leetcode.cn.bruce;

/**
 * 
 * @author bruce
 * 
 *         给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 *         如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 *         您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 *         示例：
 * 
 *         输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 *
 */
public class L002 {

	public static void main(String[] args) {
		ListNode num1 = new ListNode(2);
		num1.next = new ListNode(4);
		num1.next.next = new ListNode(3);
		ListNode num2 = new ListNode((byte) 5);
		num2.next = new ListNode(6);
		num2.next.next = new ListNode(4);
		
		ListNode result = new L002().addTwoNumbers(num2, num1);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public ListNode addTwoNumbers(ListNode num1, ListNode num2) {
		   
				ListNode result = null;
				ListNode rtn = null;
				int num1Value = 0;
				int num2Value = 0;
				int plus = 0;
				
				while (num1 != null || num2 != null) {
					if (result !=null) {
						if (result.next ==null)
							result.next = new ListNode(0);
						result = result.next;
					} else {
						result = new ListNode(0);
						rtn = result;
					}
					num1Value = 0;;
					num2Value = 0;
					if (num1 != null) {
						num1Value = num1.val;
						num1 = num1.next;
					}
					if (num2 != null) {
						num2Value = num2.val;
						num2 = num2.next;
					}
					plus = (result.val + num1Value + num2Value);
					result.val = plus % 10;
					if (plus >= 10) {
						result.next = new ListNode(plus / 10);
					}
				}
				return rtn;
	}
}

class ListNode {
	
	int val = 0;
	ListNode next;
	
	public ListNode(int value) {
		this.val = value;
	}
}