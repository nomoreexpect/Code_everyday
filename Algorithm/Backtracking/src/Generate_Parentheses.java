/**
 * @Author:PanYa
 * @Date 2024/5/10-下午6:28
 * @Description:数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        /*
        *@Param [ans, cur, open, close, max]
        *@return void
        *@Description: 回溯
        */
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    public static void main(String[] args) {
        Generate_Parentheses generator = new Generate_Parentheses();
        int n = 2;
        List<String> results = generator.generateParenthesis(n);
        System.out.println("All combinations of balanced parentheses for n = " + n + ":");
        for (String combination : results) {
            System.out.println(combination);
        }
    }
}
