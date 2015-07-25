package pe.test.myfragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by macmini14 on 7/25/15.
 */
public class ListFragment extends Fragment {

    private ListView listView;
    private ListFragmentInterface listfragmentinterface;

    final private Note[] notes = new Note[]{
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
        listView = (ListView) getView().findViewById(R.id.fragment_list_listview_list);
        listView.setAdapter(new NoteListViewAdapter(this, notes));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listfragmentinterface != null) {
                    listfragmentinterface.onNoteSelected((Note) parent.getItemAtPosition(position));
                }
            }
        });

    }

    public void setListfragmentinterface(final ListFragmentInterface listfragmentinterface) {
        this.listfragmentinterface = listfragmentinterface;
    }

    private static class NoteListViewAdapter extends ArrayAdapter<Note> {

        private final Fragment fragment;

        public NoteListViewAdapter(final Fragment fragment, final Note[] notes) {
            super(fragment.getActivity(), 0, notes);
            this.fragment = fragment;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final View listElement = fragment.getActivity().getLayoutInflater().inflate(R.layout.fragment_list_listview_element, null);
            final TextView titleTextView = (TextView) listElement.findViewById(R.id.fragmen_list_listview_element_title);
            titleTextView.setText(getItem(position).getTitle());

            return listElement;
        }


    }

    public interface ListFragmentInterface {
        public void onNoteSelected(final Note note);

    }
}
