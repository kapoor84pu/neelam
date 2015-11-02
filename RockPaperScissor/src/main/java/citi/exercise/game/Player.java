package citi.exercise.game;

import citi.exercise.RockPaperScissor;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Neelam on 01/11/2015.
 */
public class Player {
	
	private static final Logger logger = LoggerFactory.getLogger(Player.class);

    public RockPaperScissor.GAME_PLAYERS getGamePlayers() {
        char gameType = getUserInput();
        logger.debug("User input :: {}", gameType);
        if (gameType == '1' || gameType == '2') {
            switch (gameType){
                case '1': return RockPaperScissor.GAME_PLAYERS.USER_COMPUTER;
                case '2': return RockPaperScissor.GAME_PLAYERS.COMPUTER_COMPUTER;
            }
        }
        return getGamePlayers();
    }

    @SuppressWarnings("resource")
    public char getUserInput(){

        logger.debug("\n1. User vs Computer \n2. Computer vs Computer\n Please enter an option >>  ");
		Scanner scanner = new Scanner(System.in);
        String move = scanner.nextLine();
        char gameType = move.toUpperCase().charAt(0);

        return gameType;
    }

}
