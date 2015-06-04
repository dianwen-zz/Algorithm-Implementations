package test.java;

import main.java.LeastNumberOfCoins;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dianwen on 4/30/15.
 */
public class LeastNumberOfCoinsTest {
    @Test
    public void testLeastNumberOfCoins() {
        int[] coins = {1, 5, 10, 25};
        assertEquals(8, LeastNumberOfCoins.findLeastNumberOfCoins(117, coins));
    }
}
