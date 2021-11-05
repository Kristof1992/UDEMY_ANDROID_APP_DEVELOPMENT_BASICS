package com.kristofselecz.robinhood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CardView startersCard;
    CardView mainsCard;
    CardView dessertsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Finding ids
        startersCard = findViewById(R.id.card_view_starters);
        mainsCard = findViewById(R.id.card_view_main);
        dessertsCard = findViewById(R.id.card_view_deserts);

        startersCard.setOnClickListener(view -> {
            Intent startersActivityIntent = new Intent(MainActivity.this, StartersActivity.class);
            startActivity(startersActivityIntent);
        });

        mainsCard.setOnClickListener(view -> {
            Intent mainsActivityIntent = new Intent(MainActivity.this, MainCoursesActivity.class);
            startActivity(mainsActivityIntent);
        });

        TextView emailTextView = findViewById(R.id.text_view_email_address);
        emailTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchEmailAppIntent = new Intent(Intent.ACTION_SENDTO);
                launchEmailAppIntent.setData(Uri.parse("mailto:robinhoodpub@gmail.com")); // only email apps should handle this
//                launchEmailAppIntent.putExtra(Intent.EXTRA_EMAIL, addresses);
//                launchEmailAppIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                if (launchEmailAppIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(launchEmailAppIntent);
                }

            }
        });

        dessertsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dessertsActivityIntent = new Intent(MainActivity.this, DessertsActivity.class);
                startActivity(dessertsActivityIntent);
            }
        });



    }
}