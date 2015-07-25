package pe.test.myfragmentapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//no es necesario utilizar el API de soporte para fragment ya que aparecen en API 3
//Los cards views estan en el API de soporte. El API de soporte es parte del proyrecto base de android
//asimismo, se suele agregar cosas nuevas al API de soporte.

//fragments de forma estatica ya que es la mas simple.
public class MainActivity extends Activity implements ListFragment.ListFragmentInterface {

    public static final String EXTRA_NOTE_TITLE = "note_title";
    public static final String EXTRA_NOTE_CONTENT = "note_content";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((ListFragment) getFragmentManager().findFragmentById(R.id.activity_main_fragment_list)).setListfragmentinterface(this);

    }

    @Override
    public void onNoteSelected(Note note) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ((ContentFragment) getFragmentManager().findFragmentById(R.id.activity_main_fragment_list)).showNote(note);
        } else {
            startActivity(new Intent(this, ContentActivity.class)
                    .putExtra(EXTRA_NOTE_TITLE, note.getTitle())
                    .putExtra(EXTRA_NOTE_CONTENT, note.getContent()));

        }
    }
}
