import java.util.ArrayList;

public class Gradebook
{
   private double[] scores;
   private int scoresSize;

   /**
      Constructs a gradebook with no scores and a given capacity.
      @capacity the maximum number of scores in this gradebook
   */
   public Gradebook(int capacity)
   {
      scores = new double[capacity];
      scoresSize = 0;
   }

   /**
      Adds a score to this gradebook.
      @param score the score to add
      @return true if the score was added, false if the gradebook is full
   */
   public boolean addScore(double score)
   {
      if (scoresSize < scores.length)
      {
         scores[scoresSize] = score;
         scoresSize++;
         return true;
      }
      else
         return false;      
   }

   /**
      Computes the sum of the scores in this gradebook.
      @return the sum of the scores
   */
   public double sum()
   {
      double total = 0;
      for (int i = 0; i < scoresSize; i++)
      {
         total = total + scores[i];
      }
      return total;
   }
      
   /**
      Gets the minimum score in this gradebook.
      @return the minimum score, or 0 if there are no scores.
   */
   public double minimum()
   {
      if (scoresSize == 0) return 0;
      double smallest = scores[0];
      for (int i = 1; i < scoresSize; i++)
      {
         if (scores[i] < smallest)
         {
            smallest = scores[i];
         }
      }
      return smallest;
   }

   /**
      Gets the final score for this gradebook.
      @return the sum of the scores, with the lowest score dropped if 
      there are at least two scores, or 0 if there are no scores.
   */
   public double finalScore() 
   {
      if (scoresSize == 0)
         return 0;
      else if (scoresSize == 1)
         return scores[0];
      else
         return sum() - minimum();
   }
   
   // *********************** Adding the two methods required by the lab assignment ***********************
   
   // getScoresSize method that returns score size
   
   public int getScoresSize() 
   {
	   return scoresSize;
   }
   
   // toString method that will return each score in the array separated by a space.
   
   public String toString()
   {
	   // Creating a string builder type to hold all the scores 
	   
	   StringBuilder allScores = new StringBuilder();
	   
	   // Looping through the array
	   
	   for(int i = 0; i < scoresSize; i++)
	   {
		   // Adding the score at the current index of the array and adding a space to separate it from the next socre at the next index
		   
		   allScores.append(scores[i]).append(" ");
	   }
	   
	   // Returning all the scores in the array separated by a space.
	   
	   return allScores.toString().trim();
   }
   
   
}
