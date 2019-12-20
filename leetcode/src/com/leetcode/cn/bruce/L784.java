package com.leetcode.cn.bruce;

import java.util.ArrayList;
import java.util.List;

/**
 * tag: 回溯算法 tag: 位运算
 * 
 * @author bruce
 * 
 *         给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * 
 *         示例: 输入: S = "a1b2" 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 *         输入: S = "3z4" 输出: ["3z4", "3Z4"]
 * 
 *         输入: S = "12345" 输出: ["12345"] 注意：
 * 
 *         S 的长度不超过12。 S 仅由数字和字母组成。
 *
 */
public class L784 {

	public static void main(String[] args) {
		String str = "a1b2c3";
//		List<String> letterCasePermutation = new L784().letterCasePermutation(str);
//		letterCasePermutation.forEach(System.out::println);
//		List<String>  letterCasePermutation2 = new L784().letterCasePermutation2(str);
//		letterCasePermutation2.forEach(System.out::println);
		List<String>  letterCasePermutation3 = new L784().letterCasePermutation3(str);
		letterCasePermutation3.forEach(System.out::println);

	}

	/**
	 * @author bruce
	 */
	public List<String> letterCasePermutation(String str) {
		List<String> partList = new ArrayList<>();
		partList.add("");
		for (int i = 0; i < str.length(); i++) {
			int size = partList.size();
			char originChar = str.charAt(i);
			if (originChar < 65) {
				for (int k = 0; k < size; k++) {
					partList.set(k, partList.get(k) + String.valueOf(originChar));
				}
				continue;
			}
			for (int j = 0; j < size; j++) {
				if (originChar < 97) {
					partList.add(partList.get(j) + String.valueOf((char) (originChar + 32)));
				} else {
					partList.add(partList.get(j) + String.valueOf((char) (originChar - 32)));
				}
				partList.set(j, partList.get(j) + String.valueOf(originChar));
			}
		}
		return partList;
	}
	
	/**
	 * @author others
	 */
	public List<String> letterCasePermutation2(String S) {
        List<String> ans = new ArrayList<String>();
        dg(S.toCharArray(),0,ans);
        return ans;
    }
    public void dg(char[] s,int i,List<String> ans){
        if(i==s.length){
            ans.add(String.valueOf(s));
            return;
        }
        dg(s,i+1,ans);
        if(s[i]<'0'||s[i]>'9'){
            s[i]^=(1<<5);
            dg(s,i+1,ans);
        }
        
    }

	private List<String> letterCasePermutation3(String str) {
		List<String> rtnList = new ArrayList<>();
		recursion(str.toCharArray(), 0, rtnList);
		return rtnList;
	}
	private void recursion(char[] chars, int index, List<String> rtnList) {
		if (index == chars.length) {
			rtnList.add(String.valueOf(chars));
			return;
		}
		int nextIndex = index + 1;
		recursion(chars, nextIndex, rtnList);
		if(chars[index] < '0' || chars[index] > '9') {
			chars[index] ^=  (1<<5);
			recursion(chars, nextIndex, rtnList);
		}
	}
}
