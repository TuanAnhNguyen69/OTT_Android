package vizion.com.ott.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import vizion.com.ott.R;

public class MenuActivity extends AppCompatActivity {

    private Button btnSignOut;
    private Button btnPlay;
    private Button btnProfile;
    private Button btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        addControls();
        addEvents();
    }

    private void signOut() {
            Intent intent = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
    }

    private void aboutActivity() {
        Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    private void profileActivity() {
        Intent intent = new Intent(MenuActivity.this, AboutActivity.class);
        startActivity(intent);
    }

    private void addEvents() {
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileActivity();
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutActivity();
            }
        });
    }

    private void addControls() {
        btnSignOut = (Button) findViewById(R.id.btnSignOut);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnProfile = (Button) findViewById(R.id.btnProfile);
        btnAbout = (Button) findViewById(R.id.btnAbout);
    }
}
