package citi.exercise.players;

import citi.exercise.RockPaperScissor.Move;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Neelam on 31/10/2015.
 */
public class Computer{

	private static final Logger logger = LoggerFactory.getLogger(Computer.class);
    public Move getMove() {
        Move[] moves = Move.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        logger.debug("Computer selected :{} ", moves[index]);
        return moves[index];
    }
}
