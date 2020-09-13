package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 0 for 1st 1 for 2nd 2 for empty
    int player=0;
    int[] position={2,2,2,2,2,2,2,2,2};
    int[][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean game=true;
    int count=0;

    public void put(View view){

        ImageView tile=(ImageView) view;
        int tag=Integer.parseInt(tile.getTag().toString());
        String s;
        if(game && position[tag]==2) {
            if (player == 0) {
                tile.setImageResource(R.drawable.circle);
                position[tag] = player;
                player = 1;
                count++;

            } else {
                tile.setImageResource(R.drawable.cross);
                position[tag] = player;
                player = 0;
                count++;
            }

            for (int[] i : win) {
                if (position[i[0]] == position[i[1]] && position[i[1]] == position[i[2]] && position[i[1]] != 2) {
                    game = false;
                    if (player == 0) {
                        s = "Red Wins";
                    } else {
                        s = "Blue Wins";
                    }
                    TextView text=(TextView) findViewById(R.id.textView);
                    Button button=(Button) findViewById(R.id.button);
                    text.setText(s);
                    text.setVisibility(View.VISIBLE);
                    button.setVisibility(View.VISIBLE);

                }
            }
        }

        if(count==9 && game){
                TextView text=(TextView) findViewById(R.id.textView);
                Button button=(Button) findViewById(R.id.button);
                text.setText("Draw");
                text.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                game=false;
        }

    }

    public void playAgain(View view){
        TextView text=(TextView) findViewById(R.id.textView);
        Button button=(Button) findViewById(R.id.button);
        text.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);


        GridLayout grid = (GridLayout) findViewById(R.id.gridLayout);

        for(int i=0;i<grid.getChildCount();i++){
            ImageView img=(ImageView) grid.getChildAt(i);
            img.setImageDrawable(null);
        }
        player=0;
        for(int j=0;j<position.length;j++){
            position[j]=2;
        }
        game=true;
        count=0;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}