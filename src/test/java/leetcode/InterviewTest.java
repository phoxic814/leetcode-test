package leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class InterviewTest {

    @Test
    public void test() {
        int[] one = {1, 2, 3, 4};
        int[] two = {2, 4, 6, 8};
        int[] three = {3, 4, 5};

        List<Integer> result = intersection(Arrays.stream(one).boxed().collect(Collectors.toList()),
                Arrays.stream(two).boxed().collect(Collectors.toList()),
                Arrays.stream(three).boxed().collect(Collectors.toList()));

        result.forEach(System.out::println);
    }

    // Given a list of strings, find the list of characters that appear in all strings. eg
    // input:  'google', 'facebook', 'youtube'
    // output: ['e' , 'o']
    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("google");
        list.add("facebook");
        list.add("youtube");

        List<Character> result = commonCharacters(list);
        result.forEach(System.out::println);
    }

    // Given three list of integer, find the list of integer that appear in all list. eg
    // input:  {1, 2, 3, 4}, {2, 4, 6, 8}, {3, 4, 5}
    // output: [4]
    private List<Integer> intersection(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        List<Integer> result = new ArrayList<>();

        list3.forEach(i -> {
            if (set1.contains(i) && set2.contains(i)) {
                result.add(i);
            }
        });

        return result;
    }

    @Test
    public void test3() {
        int[] one = {1, 2, 3, 4};
        int[] two = {2, 4, 6, 8};
        int[] three = {3, 4, 5};

        List<List<Integer>> input = Arrays.asList(
                Arrays.stream(one).boxed().collect(Collectors.toList()),
                Arrays.stream(two).boxed().collect(Collectors.toList()),
                Arrays.stream(three).boxed().collect(Collectors.toList())
        );

        List<Integer> result = common(input);
        result.forEach(System.out::println);

        String a = "google";
        String b = "facebook";
        String c = "youtube";
        List<List<Character>> input1 = Arrays.asList(
                a.chars().mapToObj(e -> (char) e) .collect(Collectors.toList()),
                b.chars().mapToObj(e -> (char) e) .collect(Collectors.toList()),
                c.chars().mapToObj(e -> (char) e) .collect(Collectors.toList())
        );
        List<Character> result1 = common(input1);
        result1.forEach(System.out::println);
    }

    private <T> List<T> common(List<List<T>> listList) {
        Map<T, Integer> map = new HashMap<>();
        List<T> result = new ArrayList<>();

        for (List<T> list : listList) {
            Set<T> set = new HashSet<>();

            for (T t : list) {
                if (set.contains(t)) {
                    continue;
                } else {
                    set.add(t);
                }

                if (map.containsKey(t)) {
                    Integer count = map.get(t);
                    count++;
                    map.put(t, count);
                } else {
                    map.put(t, 1);
                }
            }
        }

        map.forEach((k, v) -> {
            if (v == listList.size()) {
                result.add(k);
            }
        });

        return result;
    }

    private List<Character> commonCharacters(List<String> strings) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> result = new ArrayList<>();

        for (String s : strings) {
            Set<Character> set = new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (set.contains(c)) {
                    continue;
                } else {
                    set.add(c);
                }

                if (map.containsKey(c)) {
                    Integer count = map.get(c);
                    count++;
                    map.put(c, count);
                } else {
                    map.put(c, 1);
                }
            }
        }

        map.forEach((k, v) -> {
            if (v == strings.size()) {
                result.add(k);
            }
        });

        return result;
    }
}
