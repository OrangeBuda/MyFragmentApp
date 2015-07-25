package pe.test.myfragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by macmini14 on 7/25/15.
 */
public class ListFragment extends Fragment {

    private ListView listView;

    final private Note[] notes= new Note[]{
            new Note("Title 1", "Content1"),
            new Note("Title 2", "Content2"),
            new Note("Title 3", "Content3"),
            new Note("Title 4", "Content4"),
            new Note("Title 5", "Content5")
    };


    @Nullable
    @Override

    //se duvuelve la vista a mostrar
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    //muestra la vista creada
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
            //Este metodo solo puede ser invocado despues del onCreateview, sino saldra nulo

            //contenedor de vistas
            //crar adapter para el list view.
            listView= (ListView)getView().findViewById(R.id.fragment_list_listview_list);
    }

    private class NoteListViewAdapter extends ArrayAdapter<Note>{
        
    }
}
