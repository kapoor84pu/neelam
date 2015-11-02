package citi.exercise.players;

import citi.exercise.players.Computer;
import citi.exercise.RockPaperScissor;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by Neelam on 01/11/2015.
 */
public class ComputerTest {


    @Test
    public void testComputerMove(){
        Computer computer = new Computer();
        RockPaperScissor.Move move = computer.getMove();
        assertTrue(Arrays.asList(RockPaperScissor.Move.values()).contains(move));
    }
}
