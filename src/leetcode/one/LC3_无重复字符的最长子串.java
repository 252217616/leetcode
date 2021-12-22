package leetcode.one;

import java.util.HashMap;
import java.util.Map;

/**
 * LC3_无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @author lujun
 * @date 2021/12/21
 */
public class LC3_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int result = 0;
        //记录最后一次重复的末尾节点
        int start = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            //当前字符
            final char c = s.charAt(i);
            if(map.containsKey(c)){
                start = Math.max(map.get(c),start);
            }
            //+1 为了防止 0-0 其实长度是1
            result = Math.max(result,i-start+1);
            map.put(c,i+1);
        }
        return result;

    }
}