package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
        TextView mstoryTextView;
        Button mBtnTop, mBtnButtom;
        int mStoryIndex = 0;
        final int []mStoryArray = {R.string.T1_Story,R.string.T2_Story,R.string.T3_Story,R.string.T4_End};
        int mStory = mStoryArray[mStoryIndex];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mstoryTextView = (TextView)findViewById(R.id.storyTextView);
        mBtnTop = (Button)findViewById(R.id.buttonTop);
        mBtnButtom = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mBtnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upDateStoryTopBtn();
                
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mBtnButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  upDateStoryBottomBtn();

            }
        });

    }

       public void upDateStoryBottomBtn(){
        if(mStoryIndex==0 ) {

            mStory = R.string.T2_Story;
            mstoryTextView.setText(mStory);
            mBtnTop.setText(R.string.T2_Ans1);
            mBtnButtom.setText(R.string.T2_Ans2);

        }
        if((mStoryIndex==1 || mStoryIndex==2) &&  mBtnButtom.getText().toString().trim().equals("It's him or me! You take the knife and stab him.")){
            mStory = R.string.T5_End;
            mstoryTextView.setText(R.string.T5_End);
            mBtnTop.setVisibility(View.GONE);
            mBtnButtom.setVisibility(View.GONE);
        }
        if(mStoryIndex ==1 && mBtnButtom.getText().toString().equals("Wait, I know how to change a tire.")){
            mStory = R.string.T4_End;
            mstoryTextView.setText(mStory);
            mBtnTop.setVisibility(View.GONE);
            mBtnButtom.setVisibility(View.GONE);

        }

           mStoryIndex+=1;
    }

    public void upDateStoryTopBtn() {
      //  mStoryResource = R.string.T3_Story;
        if (mStoryIndex == 0 ) {

            mStory = R.string.T3_Story;
            mstoryTextView.setText(mStory);
            mBtnTop.setText(R.string.T3_Ans1);
            mBtnButtom.setText(R.string.T3_Ans2);


        }

        if( (mStoryIndex==1 || mStoryIndex==2) && mBtnTop.getText().toString().trim().equals("I love Elton John! Hand him the cassette tape.")) {

                mStory = R.string.T6_End;
                mstoryTextView.setText(mStory);
                mBtnTop.setVisibility(View.GONE);
                mBtnButtom.setVisibility(View.GONE);
            }
        //Final branch
        if(mStoryIndex==1 && mBtnTop.getText().toString().trim().equals("At least he's honest. I'll climb in.")){
            mStory = R.string.T3_Story;
            mstoryTextView.setText(mStory);
            mBtnTop.setText(R.string.T3_Ans1);
            mBtnButtom.setText(R.string.T3_Ans2);

        }


        mStoryIndex+=1;
    }


}
