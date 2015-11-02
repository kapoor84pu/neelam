package citi.exercise.game;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

import citi.exercise.RockPaperScissor;

/**
 * Created by Neelam on 01/11/2015.
 */
public class PlayerTest {
	
	@Test
    public void testGamePlayers() throws IOException{
        Player player = new Player();
        ByteArrayInputStream in = null;
        try{
        	in = new ByteArrayInputStream("2".getBytes());
        	System.setIn(in);
        	RockPaperScissor.GAME_PLAYERS gamePlayers = player.getGamePlayers();
        	assertTrue(Arrays.asList(RockPaperScissor.GAME_PLAYERS.values()).contains(gamePlayers));        	
        	System.setIn(System.in);
        }finally{
        	if(in != null){
        		in.close();
        	}
        }

    }
}
