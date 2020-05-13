package view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import Presenter.KontakPresenter;
import model.Kontak;
import android.widget.Button;
import android.widget.EditText;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import com.example.uts_akb_10117205.MyOpenHelper;
import com.example.uts_akb_10117205.TableKontak;
import com.melnykov.fab.FloatingActionButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.uts_akb_10117205.R;

public class DaftarFragment extends Fragment{
    FloatingActionButton actionButton;
    ListView listView;
    ArrayList<Kontak> kontaks = new ArrayList<>();
    public DaftarFragment(){
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daftar, container, false);
        /*actionButton = (FloatingActionButton) view.findViewById(R.id.tambah);
        listView = (ListView) view.findViewById(R.id.listView);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(null);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Kontak kontak = kontaks.get(position);
                Bundle bundle = new Bundle();
                bundle.putInt(TableKontak.FIELD_ID, kontak.getId());
                replaceFragment(bundle);
            }
        });*/

        return view;
    }
   /* @Override
    public void onResume() {
        //populate list
        KontakPresenter kontakPresenter = new KontakPresenter(getActivity());
        kontaks = kontakPresenter.select(null, null);
        listView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,kontaks));
        super.onResume();
    }
    private void replaceFragment(Bundle args) {
        KontakFragment fragment = new KontakFragment();
        if (args != null) {
            fragment.setArguments(args);
        }
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(this.getClass().getName())
                .replace(R.id.fragment, fragment)
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }*/
}
