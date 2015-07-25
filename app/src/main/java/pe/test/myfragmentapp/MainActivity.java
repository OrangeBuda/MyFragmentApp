package pe.test.myfragmentapp;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//no es necesario utilizar el API de soporte para fragment ya que aparecen en API 3
//Los cards views estan en el API de soporte. El API de soporte es parte del proyrecto base de android
//asimismo, se suele agregar cosas nuevas al API de soporte.
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




}
