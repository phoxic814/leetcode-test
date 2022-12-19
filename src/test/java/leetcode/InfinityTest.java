package leetcode;

import org.junit.Test;

import java.util.Stack;

public class InfinityTest {

    @Test
    public void test() {
        int[] one = {2, 4, 1, 6, 5, 9, 7};
//        System.out.println(solution(one));

        int[] two = {4, 3, 2, 6, 1};
//        System.out.println(solution(two));

        int[] three = {2, 1, 6, 4, 3, 7};
        System.out.println(solution(three));
    }

    public int solution(int[] A) {
        Stack<Integer> stack = new Stack<>();
        if (A.length < 2) return 1;
        stack.push(A[0]);

        for (int i = 1; i < A.length; i++) {
            if (A[i] >= stack.peek()) {
                stack.push(A[i]);
            }
            else {
                int last = stack.pop(); // 最大
                while (stack.size() > 0 && A[i] < stack.peek()) {
                    stack.pop();
                }
                stack.push(last);
            }
        }

        return stack.size();
    }

}
