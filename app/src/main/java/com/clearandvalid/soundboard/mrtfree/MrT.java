package com.clearandvalid.soundboard.mrtfree;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MrT extends Activity implements OnClickListener {
    private MediaPlayer a, b, c, d, e, f, g, h, i, j, k, l;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        a = MediaPlayer.create(this, R.raw.a);
        b = MediaPlayer.create(this, R.raw.b);
        c = MediaPlayer.create(this, R.raw.c);
        d = MediaPlayer.create(this, R.raw.d);
        e = MediaPlayer.create(this, R.raw.e);
        f = MediaPlayer.create(this, R.raw.f);
        g = MediaPlayer.create(this, R.raw.g);
        h = MediaPlayer.create(this, R.raw.h);
        i = MediaPlayer.create(this, R.raw.i);
        j = MediaPlayer.create(this, R.raw.j);
        k = MediaPlayer.create(this, R.raw.k);
        l = MediaPlayer.create(this, R.raw.l);

        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button10).setOnClickListener(this);
        findViewById(R.id.button11).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MediaPlayer mp = null;
        int id = v.getId();

        if (id == R.id.button0) {
            mp = a;
        } else if (id == R.id.button1) {
            mp = b;
        } else if (id == R.id.button2) {
            mp = c;
        } else if (id == R.id.button3) {
            mp = d;
        } else if (id == R.id.button4) {
            mp = e;
        } else if (id == R.id.button5) {
            mp = f;
        } else if (id == R.id.button6) {
            mp = g;
        } else if (id == R.id.button7) {
            mp = h;
        } else if (id == R.id.button8) {
            mp = i;
        } else if (id == R.id.button9) {
            mp = j;
        } else if (id == R.id.button10) {
            mp = k;
        } else if (id == R.id.button11) {
            mp = l;
        }

        if (mp != null) {
            mp.seekTo(0);
            mp.start();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.about) {
            startActivity(new Intent(this, About.class));
            return true;
        } else if (id == R.id.quit) {
            finish();
            return true;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MediaPlayer[] players = {a, b, c, d, e, f, g, h, i, j, k, l};
        for (MediaPlayer mp : players) {
            if (mp != null) {
                mp.release();
            }
        }
    }
}
