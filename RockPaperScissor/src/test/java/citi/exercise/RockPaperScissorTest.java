package citi.exercise;

import citi.exercise.players.Computer;
import citi.exercise.RockPaperScissor;
import citi.exercise.players.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Neelam on 01/11/2015.
 */
public class RockPaperScissorTest {

    @Mock
    User mockedUser;
    @Mock
    Computer mockedComputer;
    RockPaperScissor rockPaperScissor;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPlayerMoveMethodToGetComputerMove(){
        rockPaperScissor = new RockPaperScissor();
        RockPaperScissor.Move computerMove = rockPaperScissor.getPlayerMove(RockPaperScissor.PLAYER.COMPUTER);
        assertTrue(Arrays.asList(RockPaperScissor.Move.values()).contains(computerMove));
    }

    @Test
    public void testPlayerMoveMethodToGetUserMove(){
        rockPaperScissor = new RockPaperScissor();
        ByteArrayInputStream in = new ByteArrayInputStream("S".getBytes());
        System.setIn(in);
        RockPaperScissor.Move userMove = rockPaperScissor.getPlayerMove(RockPaperScissor.PLAYER.USER);
        assertTrue(Arrays.asList(RockPaperScissor.Move.values()).contains(userMove));
        System.setIn(System.in);
    }

    @Test
    public void testCompareSimilarMove(){
        rockPaperScissor = new RockPaperScissor();
        Mockito.when(mockedUser.getMove()).thenReturn(RockPaperScissor.Move.PAPER);
        Mockito.when(mockedComputer.getMove()).thenReturn(RockPaperScissor.Move.PAPER);
        RockPaperScissor.Move userMove = mockedUser.getMove();
        RockPaperScissor.Move computerMove = mockedComputer.getMove();
        assertEquals(rockPaperScissor.compareMoves(userMove, computerMove), 0);
    }

    @Test
    public void testCompareMethodWithDifferentMoveWhenPaperCutsScissors(){
        rockPaperScissor = new RockPaperScissor();
        Mockito.when(mockedUser.getMove()).thenReturn(RockPaperScissor.Move.SCISSORS);
        Mockito.when(mockedComputer.getMove()).thenReturn(RockPaperScissor.Move.PAPER);
        RockPaperScissor.Move userMove = mockedUser.getMove();
        RockPaperScissor.Move computerMove = mockedComputer.getMove();
        assertEquals(rockPaperScissor.compareMoves(userMove, computerMove), 1);
    }

    @Test
    public void testCompareMethodWithDifferentMoveWhenRockBreaksScissors(){
        rockPaperScissor = new RockPaperScissor();
        Mockito.when(mockedUser.getMove()).thenReturn(RockPaperScissor.Move.SCISSORS);
        Mockito.when(mockedComputer.getMove()).thenReturn(RockPaperScissor.Move.ROCK);
        RockPaperScissor.Move userMove = mockedUser.getMove();
        RockPaperScissor.Move computerMove = mockedComputer.getMove();
        assertEquals(rockPaperScissor.compareMoves(userMove, computerMove), -1);
    }

    @Test
    public void testCompareMethodWithDifferentMoveWhenPaperCoversRock(){
        rockPaperScissor = new RockPaperScissor();
        Mockito.when(mockedUser.getMove()).thenReturn(RockPaperScissor.Move.PAPER);
        Mockito.when(mockedComputer.getMove()).thenReturn(RockPaperScissor.Move.ROCK);
        RockPaperScissor.Move userMove = mockedUser.getMove();
        RockPaperScissor.Move computerMove = mockedComputer.getMove();
        assertEquals(rockPaperScissor.compareMoves(userMove, computerMove), 1);
    }

}
