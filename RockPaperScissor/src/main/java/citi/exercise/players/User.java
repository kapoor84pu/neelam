package citi.exercise.players;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import citi.exercise.RockPaperScissor.Move;

/**
 * Created by Neelam on 31/10/2015.
 */
public class User{

	private static final Logger logger = LoggerFactory.getLogger(User.class);

    public Move getMove() {
        char initialLetter = getUserInput();
        logger.debug("User input :: {}" , initialLetter);
        if (initialLetter == 'R' || initialLetter == 'P' || initialLetter == 'S') {
            switch (initialLetter){
                case 'R': return Move.ROCK;
                case 'P': return Move.PAPER;
                case 'S': return Move.SCISSORS;
            }
        }
        return getMove();
    }

    @SuppressWarnings("resource")
	public char getUserInput(){
    	
        Scanner scanner = null;
        scanner = new Scanner(System.in);
        logger.debug("\nRock(R), paper(P), or scissors(S) \n Please enter an option >>  ");
        String move = scanner.nextLine();
        char initialLetter = move.toUpperCase().charAt(0);
        return initialLetter;
    }

}

