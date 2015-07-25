package pe.test.myfragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by macmini14 on 7/25/15.
 */
public class ContentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);

    }

    public void showNote(final Note note) {
        ((TextView) getView().findViewById(R.id.fragment_Content_Textview_content)).setText(note.getContent());

    }
}
