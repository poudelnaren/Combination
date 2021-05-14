import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {

    public static List<List<Integer>> combinationSum(int[] numbers) {
        Arrays.sort(numbers);
        int target = 10;
        List<List<Integer>> res = new ArrayList<>();
        if (numbers.length == 0 || numbers[0] > target) {
            return res;
        }
        res = recursive(numbers, target, 0);
        return res;
    }

    public static List<List<Integer>> recursive(int[] arr, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();

        if (start >= arr.length || arr[start] > target) {
            return res;
        }
        if (target == arr[start]) {
            List<Integer> t = new ArrayList<>();
            t.add(arr[start]);
            res.add(t);
            return res;
        }

        for (int j = start; j < arr.length; j++) {
            if (target == arr[j]) {
                List<Integer> t = new ArrayList<>();
                t.add(arr[j]);
                res.add(t);
                break;
            }
            List<List<Integer>> temp = recursive(arr, target - arr[j], j);
            if (!temp.isEmpty()) {
                for (List<Integer> t : temp) {
                    t.add(0, arr[j]);
                    res.add(t);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){

        int[] numbers = {2,4,6,5,11,3};
        List<List<Integer>> result = combinationSum(numbers);
        System.out.println(result);

    }
}
