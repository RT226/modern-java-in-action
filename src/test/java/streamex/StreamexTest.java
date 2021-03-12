package streamex;

import chapter06.Dish;
import one.util.streamex.StreamEx;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static chapter06.DishFactory.menu;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamexTest {

    @Test
    public void testMap(){
        List<String> expected = List.of("pork", "beef", "chicken", "french fries", "rice", "season fruit", "pizza", "prawns", "salmon");
        List<String> dishNames = StreamEx.of(menu).map(Dish::getName).toList();
        assertThat(dishNames).isEqualTo(expected);
    }

    @Test
    public void testGroupingBy(){
        Set<String> expected = Set.of("season fruit", "chicken", "pizza", "salmon", "beef", "rice", "pork", "prawns", "french fries");
        Map<String, List<Dish>> name2Dish = StreamEx.of(menu).groupingBy(Dish::getName);
        assertThat(name2Dish.keySet()).isEqualTo(expected);
    }
}
