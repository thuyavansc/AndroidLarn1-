package au.com.softclient.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private Fragment currentFragment;
    //Button btn1 =(Button) findViewById(R.id.btnMy);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        currentFragment = firstFragment; // Set the initial fragment.

        Button btn1 = findViewById(R.id.btnF1);
        Button btn2 = findViewById(R.id.btnF2);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, currentFragment).commit();

        btn1.setOnClickListener(v -> {
            if (currentFragment != firstFragment) {
                switchFragment(firstFragment);
            }
        });

        btn2.setOnClickListener(v -> {
            if (currentFragment != secondFragment) {
                switchFragment(secondFragment);
            }
        });
    }

    private void switchFragment(Fragment newFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, newFragment);
        transaction.commit();
        currentFragment = newFragment;

    }

}