package code.kata.domain;


import code.kata.rockPaperScissors.Hand;
import code.kata.rockPaperScissors.Paper;
import code.kata.rockPaperScissors.Rock;
import code.kata.rockPaperScissors.Scissors;

public interface Player {
     Hand getHand();

     static Hand init(int number) {
          if(number == 1)
               return new Scissors();
          if (number == 2)
               return new Rock();
          return new Paper();
     }

     void updateHand(Hand hand);
}
