package pe.test.myfragmentapp;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by macmini14 on 7/25/15.
 */
public class ContentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        final Note note = new Note(getIntent().getStringExtra(MainActivity.EXTRA_NOTE_TITLE), getIntent().getStringExtra(MainActivity.EXTRA_NOTE_CONTENT));
        ((ContentFragment) getFragmentManager().findFragmentById(R.id.activity_content_fragment_content)).showNote(note);
    }
}
