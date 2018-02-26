package com.challenges.slaxzor.rootchallenge1;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] binstring = {"01100101","00110110","00110010","00100101",
            "00110011","00110100","01010100","01110010","01101111","01110000"
            ,"01101000","01111001"};
    private Button challengeButton;
    private TextView ansBox;
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;
        challengeButton = findViewById(R.id.ChBTN);
        ansBox = findViewById(R.id.answerBox);

        challengeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(DoBasicIsR00tCheck())
                {
                    ansBox.setVisibility(View.VISIBLE);
                    ansBox.append(Util.deobfuscate(binstring));
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                    builder.setMessage(R.string.r00t_detect)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                            }
                    });
                    builder.create().show();
                }
            }
        });
    }
    private boolean DoBasicIsR00tCheck() {
        String buildTags = android.os.Build.TAGS;
        return buildTags != null && buildTags.contains("test-keys");
    }

}
