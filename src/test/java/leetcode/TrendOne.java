package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TrendOne {

    @Test
    public void testOne() {
        String a = solutionOne("eeaahhllo");
        System.out.println(a);
    }

    @Test
    public void testTwo() {
        //sample
        int[] one = {1, 3, 6, 1, 6, 6, 9, 9};
        System.out.println(solutionTwo(one));

        int[] two = {5, 1, 4, 3};
        System.out.println(solutionTwo(two));

        int[] three = {2, 2, 2, 3, 2, 3};
        System.out.println(solutionTwo(three));
    }

    @Test
    public void testThree() {
        String[] b = {".##.#", "#.#..", "#...#", "#.##."};
        solution(b);
    }

    public int[] solution(String[] B) {
        String width = B[0];
        char[][] graph = new char[B.length][width.length()];

        for (int i = 0; i < B.length; i++) {
            String s = B[i];
            for (int j = 0; j < s.length(); j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        Set<Integer> set = new HashSet<>();
        int one = 0;
        int two = 0;
        int three = 0;
        for (int i = 0; i < B.length; i++) {
            String s = B[i];
            for (int j = 0; j < s.length(); j++) {
                if (graph[i][j] == '#') {
                    int location = i * 10 + j;
                    if (set.contains(location)) {
                        continue;
                    }

                    // 判斷是不是3的
                    boolean a = check(graph, i, B.length, j, s.length(), set);
                }
            }
        }

        return null;
    }

    private boolean check(char[][] graph, int i, int maxI, int j, int maxJ, Set<Integer> set) {

        // 直
        if (i + 1 < maxI) {
            if (i + 2 < maxI) {
                boolean three = graph[i + 1][j] == '#' && graph[i + 2][j] == '#';
                if (three) {
                    set.add(i * 10 + j);
                    set.add((i + 1) * 10 + j);
                    set.add((i + 2) * 10 + j);
                    return true;
                }
            }

            boolean two = graph[i+1][j] == '#';
            if (two) {
                set.add(i * 10 + j);
                set.add((i + 1) * 10 + j);
                return true;
            }
        }

        // 橫
        if (j + 1 < maxJ) {
            if (j + 2 < maxJ) {
                boolean three = graph[i][j+1] == '#' && graph[i][j+2] == '#';
                if (three) {
                    set.add(i * 10 + j);
                    set.add(i * 10 + j+1);
                    set.add(i * 10 + j+2);
                    return true;
                }
            }

            boolean two = graph[i][j+1] == '#';
            if (two) {
                set.add(i * 10 + j);
                set.add(i * 10 + j+1);
                return true;
            }
        }

        // 左上 右上
        if (i != maxI - 1 && j != maxJ - 1) {
            boolean left = graph[i][j + i] == '#' && graph[i + 1][j] == '#';
            if (left) {
                set.add(i * 10 + j);
                set.add(i * 10 + j + 1);
                set.add((i + 1) * 10 + j);
                return true;
            }

            boolean right = graph[i][j + i] == '#' && graph[i + 1][j + 1] == '#';
            if (right) {
                set.add(i * 10 + j);
                set.add(i * 10 + j + 1);
                set.add((i + 1) * 10 + j + 1);
                return true;
            }
        }

        // 左下 右下
        if (j != maxJ) {

        }

        return false;
    }


    private int solutionTwo(int[] A) {
        int result = -1;
        for (int i = 0; i < A.length - 1; i++) {
            int j = A.length - 1;
            while (j > i + 1 && A[i] != A[j]) {
                j--;
            }

            if (A[i] == A[j]) {
                result = Math.max(result, sum(A, i, j));
            }
        }

        return result;
    }

    private int sum(int[] A, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += A[i];
        }
        return sum;
    }

    private String solutionOne(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int best_res = 0;

        for (int i = 0; i < 26; i++) {
            if (occurrences[i] > best_res) {
                best_char = (char) ((int) 'a' + i);
                best_res = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }
}
