package android.example.com.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreHome;
    int outsHome;
    int scoreAway;
    int outsAway;
    int gameOver;
    int gameTracker = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Add a run for Home Team.
     */
    public void addRunHome(View v) {
        if (gameOver != 1) {
            if (gameTracker % 2 == 0) { /* is even number */
                scoreHome = scoreHome + 1;
                displayRunsForHomeTeam(scoreHome);
                if (gameTracker == 18 && scoreHome > scoreAway) { /* game over */
                    gameOver = 1;
                    updateGameStatus();
                }
            }
        }
    }
 
    /**
     * Displays the given score for Home Team.
     */
    public void displayRunsForHomeTeam(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_score);
        scoreView.setText(String.valueOf(score));
    }
    
    /**
     * Add a out for Home Team.
     */
    public void addOutHome(View v) {
        if (gameOver != 1) {
            if (gameTracker % 2 == 0) { /* is even number */

                outsHome = outsHome + 1;
                displayOutsForHomeTeam(outsHome);
                if (outsHome == 3) {
                    gameTracker = gameTracker + 1;
                    outsHome = 0;
                    displayOutsForHomeTeam(outsHome);
                    updateGameStatus();
                }
            }
        }
    }

    /**
     * Displays the given outs for Home Team.
     */
    public void displayOutsForHomeTeam(int outs) {
        TextView outsView = (TextView) findViewById(R.id.home_outs);
        outsView.setText(String.valueOf(outs));
    }
    

    /**
     * Add a run for Away Team.
     */
    public void addRunAway(View v) {
        if (gameOver != 1) {
            if (gameTracker % 2 != 0) { /* is odd number */
                scoreAway = scoreAway + 1;
                displayForAwayTeam(scoreAway);
            }
        }
    }

    /**
     * Displays the given score for Away Team.
     */
    public void displayForAwayTeam(int score) {
        TextView scoreView = (TextView) findViewById(R.id.away_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Add a out for away Team.
     */
    public void addOutAway(View v) {
        if (gameOver != 1){
            if (gameTracker % 2 != 0) { /* is odd number */
                outsAway = outsAway + 1;
                displayOutsForAwayTeam(outsAway);
                if (outsAway == 3) {
                    gameTracker = gameTracker + 1;
                    outsAway = 0;
                    displayOutsForAwayTeam(outsAway);
                    updateGameStatus();
                }
            }
        }
    }

    /**
     * Displays the given outs for away Team.
     */
    public void displayOutsForAwayTeam(int outs) {
        TextView outsView = (TextView) findViewById(R.id.away_outs);
        outsView.setText(String.valueOf(outs));
    }

    /**
     * updates the game status
     */
    public void updateGameStatus() {
        TextView statusView = (TextView) findViewById(R.id.game_status);
        switch (gameTracker) {
            case 1:
                statusView.setText("Top of the first");
                break;
            case 2:
                statusView.setText("Bottom of the first");
                break;
            case 3:
                statusView.setText("Top of the second");
                break;
            case 4:
                statusView.setText("Bottom of the second");
                break;
            case 5:
                statusView.setText("Top of the third");
                break;
            case 6:
                statusView.setText("Bottom of the third");
                break;
            case 7:
                statusView.setText("Top of the fourth");
                break;
            case 8:
                statusView.setText("Bottom of the fourth");
                break;
            case 9:
                statusView.setText("Top of the fifth");
                break;
            case 10:
                statusView.setText("Bottom of the fifth");
                break;
            case 11:
                statusView.setText("Top of the sixth");
                break;
            case 12:
                statusView.setText("Bottom of the sixth");
                break;
            case 13:
                statusView.setText("Top of the seventh");
                break;
            case 14:
                statusView.setText("Bottom of the seventh");
                break;
            case 15:
                statusView.setText("Top of the eighth");
                break;
            case 16:
                statusView.setText("Bottom of the eighth");
                break;
            case 17:
                statusView.setText("Top of the ninth");
                break;
            case 18:
                statusView.setText("Bottom of the ninth");
                if (scoreHome > scoreAway){
                    gameOver = 1;
                    statusView.setText("Game Over");
                }
                break;
            case 19:
                gameOver = 1;
                statusView.setText("Game Over");
                break;
        }
    }



    /**
     * Reset the game
     */
    public void resetGame(View v) {
        scoreHome =0;
        scoreAway =0;
        outsHome = 0;
        outsAway = 0;
        gameTracker = 1;
        gameOver=0;
        displayRunsForHomeTeam(scoreHome);
        displayOutsForHomeTeam(scoreHome);
        displayForAwayTeam(scoreAway);
        displayOutsForAwayTeam(outsAway);
        updateGameStatus();
    }
}

