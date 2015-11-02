package citi.exercise.players;


import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import org.junit.Test;

import citi.exercise.RockPaperScissor;

/**
 * Created by Neelam on 01/11/2015.
 */
public class UserTest {

    @Test
    public void testUserMove(){
        User user = new User();
        ByteArrayInputStream in = new ByteArrayInputStream("S".getBytes());
        System.setIn(in);
        RockPaperScissor.Move move = user.getMove();
        assertTrue(Arrays.asList(RockPaperScissor.Move.values()).contains(move));

        System.setIn(System.in);
    }
}
