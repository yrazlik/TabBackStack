package com.yrazlik.tabstacks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    Stack<String> backstack = new Stack<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AFragment aFragment = new AFragment();
        backstack.push(aFragment.getID());
        getSupportFragmentManager().beginTransaction().add(R.id.container, aFragment, aFragment.getID()).commit();
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
       if(backstack.size() > 1){
           String tag = backstack.pop();
           Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(tag);
           getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
           String popTag = backstack.peek();
           Fragment f = getSupportFragmentManager().findFragmentByTag(popTag);
           getSupportFragmentManager().beginTransaction().attach(f).commit();
       }else{
           Toast.makeText(getApplicationContext(), "EXIT?", Toast.LENGTH_SHORT).show();
       }
    }

    public void replace(String fr){
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container);
        getSupportFragmentManager().beginTransaction().detach(currentFragment).commit();
        if(fr.equalsIgnoreCase("a")){
            AFragment aFragment = new AFragment();
            backstack.push(aFragment.getID());
            getSupportFragmentManager().beginTransaction().add(R.id.container, aFragment, aFragment.getID()).commit();
        }else if(fr.equalsIgnoreCase("b")){
            BFragment bFragment = new BFragment();
            backstack.push(bFragment.getID());
            getSupportFragmentManager().beginTransaction().add(R.id.container, bFragment, bFragment.getID()).commit();
        }
    }
}
