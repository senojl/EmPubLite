package com.senojl.empublite.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;


import com.actionbarsherlock.app.SherlockFragmentActivity;

public class EmPubLiteActivity extends SherlockFragmentActivity {

    private ViewPager pager=null;
    private ContentsAdapter adapter=null;
    private static final String MODEL = "model";

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if (getSupportFragmentManager().findFragmentByTag(MODEL) == null) {
                getSupportFragmentManager().beginTransaction()
                                           .add(new ModelFragment(), MODEL)
                                           .commit();
            }

            setContentView(R.layout.activity_main);

            pager=(ViewPager)findViewById(R.id.pager);


        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            new MenuInflater(this).inflate(R.menu.options, menu);

            return(super.onCreateOptionsMenu(menu));
        }

        void setupPager(BookContents contents) {
            adapter=new ContentsAdapter(this, contents);
            pager.setAdapter(adapter);
            findViewById(R.id.progressBar1).setVisibility(View.GONE);
            findViewById(R.id.pager).setVisibility(View.VISIBLE);

            Toast.makeText(getApplicationContext(), "Scroll down for the next page, swipe left for the next chapter.",
                    Toast.LENGTH_LONG).show();


        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home:
                    return(true);

                case R.id.about:
                    Intent i=new Intent(this, SimpleContentActivity.class);

                    i.putExtra(SimpleContentActivity.EXTRA_FILE,
                            "file:///android_asset/misc/about.html");

                    startActivity(i);

                    return(true);

                case R.id.help:
                    i=new Intent(this, SimpleContentActivity.class);

                    i.putExtra(SimpleContentActivity.EXTRA_FILE,
                           "file:///android_asset/misc/help.html");

                    startActivity(i);

                    return(true);

            }

            return(super.onOptionsItemSelected(item));
        }
    }

