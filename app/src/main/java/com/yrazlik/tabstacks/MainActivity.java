package com.yrazlik.tabstacks;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static AFragment aFragment;
    public static BFragment bFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        aFragment = new AFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, aFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
       if(getSupportFragmentManager().getBackStackEntryCount() > 0){
           getSupportFragmentManager().popBackStack();
       }else{
           Toast.makeText(getApplicationContext(), "EXIT?", Toast.LENGTH_SHORT).show();
       }
    }

    public void replace(String fr){
        if(fr.equalsIgnoreCase("a")){
            if(aFragment == null){
                aFragment = new AFragment();
            }
            getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container, aFragment).commit();
        }else if(fr.equalsIgnoreCase("b")){
            if(bFragment == null){
                bFragment = new BFragment();
            }
            getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.container,bFragment ).commit();
        }
    }
}
