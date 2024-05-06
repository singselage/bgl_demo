import org.example.ConwayGameOfLife;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConwayGameOfLifeTest {

    @Test
    void testSimulate() {
        // Test Scenario 1
        List<int[]> initialLiveCells1 = List.of(new int[]{1, 1});
        List<List<int[]>> states1 = ConwayGameOfLife.simulate(initialLiveCells1);
        assertEquals(0, states1.size());
        print(states1);


        // Test Scenario 2
        List<int[]> initialLiveCells2 = List.of(
                new int[]{5, 5},
                new int[]{6, 5},
                new int[]{7, 5},
                new int[]{5, 6},
                new int[]{6, 6},
                new int[]{7, 6}
        );
        List<List<int[]>> states2 = ConwayGameOfLife.simulate(initialLiveCells2);
        assertEquals(100, states2.size());
        print(states2);

    }
    void  print(List<List<int[]>> states){
        if (!states.isEmpty()) {
            int iteration = 1;
            for (List<int[]> liveCells : states){
                StringBuilder output = new StringBuilder(iteration + ":[");
                for (int[] liveCell : liveCells){
                    output.append("[" + liveCell[0] + "," + liveCell[1] + "]");
                }
                output.append("]");
                System.out.println(output);
                iteration ++;
            }
        }
        else System.out.println("[]");
        System.out.println("--------------------------------------------");
    }
}
