import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;


public class MainReduction {

    public static int reduce(
            List<Integer> values,
            int valueIfEmpty,
            BinaryOperator<Integer> reduction) {

        int result = valueIfEmpty;
        for (int value : values) {
            result = reduction.apply(result, value);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> ints= Arrays.asList(1,2,3,4,5,6,7,8,9,0);

        List<Integer> ints1=Arrays.asList(1,2,3,4,5);
        List<Integer> ints2=Arrays.asList(6,7,8,9,0);

        BinaryOperator<Integer> op=(i1, i2) -> (i1+i2);

        int reduction1= reduce(ints1,0,op);
        int reduction2= reduce(ints2,0,op);
        float reduction = reduce(Arrays.asList(reduction1, reduction2), 0, op);
        System.out.println("Reduction: "+reduction);


        List<Integer> intsa = Arrays.asList(0, 1, 2, 3, 4, -1, -2, -3, -4);

        List<Integer> ints1a = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> ints2a = Arrays.asList(-1, -2, -3, -4);

        BinaryOperator<Integer> opa = (i3, i4) -> Integer.max(i3, i4) ;

        int reduction1a = reduce(ints1a, 0, opa);
        int reduction2a = reduce(ints2a, 0, opa);
        int reductiona= reduce(Arrays.asList(reduction1a, reduction2a), 0, opa);
        // int reductiona = reduce(ints, 0, op);

        System.out.println("Reduction A: " + reductiona);
        System.out.println("Reduction 2A: " + reduction2a);
    }
}
