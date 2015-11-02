package citi.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import citi.exercise.players.Computer;
import citi.exercise.game.Player;
import citi.exercise.players.User;

/**
 * Created by Neelam on 31/10/2015.
 */
public class RockPaperScissor {
	private static final Logger logger = LoggerFactory.getLogger(RockPaperScissor.class);
	
    public enum Move {
        ROCK,  PAPER, SCISSORS;
    }

    public enum PLAYER {
        USER, COMPUTER
    }

    public enum GAME_PLAYERS{
        USER_COMPUTER, COMPUTER_COMPUTER
    }

    public int compareMoves(Move userMove, Move computerMove){
        if (userMove == computerMove){
            return 0;
        }
        switch (userMove){
            case ROCK:
                return (computerMove == Move.SCISSORS ? 1 : -1);
            case PAPER:
                return (computerMove == Move.ROCK ? 1 : -1);
            case SCISSORS:
                return (computerMove == Move.PAPER ? 1 : -1);
        }
        return 0;
    }


    public static void main(String[] args){
        new RockPaperScissor().playGameWithPlayerOptions();
    }

    public Move getPlayerMove(PLAYER playerType){
        Move playerMove = null;
        if (playerType.equals(PLAYER.USER)){
            User user = new User();
            playerMove = user.getMove();
        }else if (playerType.equals(PLAYER.COMPUTER)){
            Computer computer = new Computer();
            playerMove = computer.getMove();
        }else{
            // TODO ::
        }
        return  playerMove;
    }

    public void playGame(){
        Move userMove = getPlayerMove(PLAYER.USER);
        Move computerMove = getPlayerMove(PLAYER.COMPUTER);
        logger.debug("User move : [" + userMove + "], Computer Move : [" + computerMove + "]");

        int result = new RockPaperScissor().compareMoves(userMove, computerMove);
        logger.debug(result == 1 ? "You win" : (result == 0 ? "Draw" : "You Lose"));
    }

    public void playGameWithPlayerOptions(){
        Move move1 = null;
        Move move2 = null;
        Player player = new Player();
        GAME_PLAYERS gamePlayers = player.getGamePlayers();
        if (gamePlayers.equals(GAME_PLAYERS.USER_COMPUTER)){
            move1 = getPlayerMove(PLAYER.USER);
            move2 = getPlayerMove(PLAYER.COMPUTER);
        }else if (gamePlayers.equals(GAME_PLAYERS.COMPUTER_COMPUTER)){
            move1 = getPlayerMove(PLAYER.COMPUTER);
            move2 = getPlayerMove(PLAYER.COMPUTER);
        }
        logger.debug("Move 1 : [" + move1 + "], Move 2 : [" + move2 + "]");

        int result = new RockPaperScissor().compareMoves(move1, move2);
        logger.debug(result == 1 ? "Move 1 wins" : (result == 0 ? "Draw" : "Move 2 wins"));
    }
}
