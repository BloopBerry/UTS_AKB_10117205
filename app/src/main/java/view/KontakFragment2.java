package view;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import com.example.uts_akb_10117205.MyOpenHelper;
import com.example.uts_akb_10117205.R;
import com.example.uts_akb_10117205.TableKontak;

import Presenter.KontakPresenter;
import model.Kontak;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class KontakFragment2 extends Fragment {
    EditText tNim,tNama,tKelas,tEmail,tSocialMedia,tTelepon;
    public KontakFragment2(){}
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.tambah_kontak, container, false);
            tNim = (EditText)view.findViewById(R.id.tNIM);
            tNama = (EditText)view.findViewById(R.id.tNIM);
            tKelas = (EditText)view.findViewById(R.id.tNIM);
            tEmail = (EditText)view.findViewById(R.id.tNIM);
            tTelepon = (EditText)view.findViewById(R.id.tTelepon);
            tSocialMedia = (EditText)view.findViewById(R.id.tSocialMedia);
            if(getArguments() != null){
                recoveyCharacter();
            }
            setHasOptionsMenu(true);
            return view;
        }
    private void recoveyCharacter(){
        Bundle args = getArguments();
        KontakPresenter kontakPresenter = new KontakPresenter(getActivity());
        ArrayList<Kontak> kontaks = kontakPresenter.select(TableKontak.FIELD_ID + " = ?", new String[]{String.valueOf(args.getInt(TableKontak.FIELD_ID))});
        if(kontaks.size() > 0){
            Kontak kontak = kontaks.get(0);
            tNim.setText(kontak.getNIM());
            tNama.setText(kontak.getNama());
            tKelas.setText(kontak.getKelas());
            tEmail.setText(kontak.getEmail());
            tTelepon.setText(kontak.getTelepon());
            tSocialMedia.setText(kontak.getSocial());
        }
    }
    private void saveCharacter(){
        KontakPresenter kontakPresenter = new KontakPresenter(getActivity());
        if(checkFields()) {
            Kontak kontak = new Kontak();
            kontak.setNIM(tNim.getText().toString().trim());
            kontak.setNama(tNama.getText().toString().trim());
            kontak.setKelas(tKelas.getText().toString().trim());
            kontak.setEmail(tEmail.getText().toString().trim());
            kontak.setTelepon(tTelepon.getText().toString().trim());
            kontak.setSocial(tSocialMedia.getText().toString().trim());
            if(getArguments() != null){
                kontak.setId(getArguments().getInt(TableKontak.FIELD_ID));
                kontakPresenter.update(kontak);
            }else{
                kontakPresenter.insert(kontak);
            }
            popThisFragment();
        }
    }
    private void deleteCharacter(){
        KontakPresenter  kontakPresenter= new KontakPresenter(getActivity());
        kontakPresenter.delete(getArguments().getInt(TableKontak.FIELD_ID));
        popThisFragment();
    }
    private boolean checkFields(){
        String error = "";
        if(tNim.getText().toString().trim().length() < 1){
            error += "- Nim required\n";
        }
        if(tNama.getText().toString().trim().length() < 1){
            error += "- Nama required\n";
        }
        if(tKelas.getText().toString().trim().length() < 1){
            error += "- Kelas required\n";
        }
        if(tEmail.getText().toString().trim().length() < 1){
            error += "- E-mail required\n";
        }
        if(tTelepon.getText().toString().trim().length() < 1){
            error += "- Telepon required\n";
        }
        if(tSocialMedia.getText().toString().trim().length() < 1){
            error += "- Social Media required\n";
        }

        if(error.equals("")){
            return true;
        }
        Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
        return false;
    }
    private void popThisFragment(){
        getActivity().getSupportFragmentManager().popBackStack();
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_daftar, menu);
        if(getArguments() == null){
            menu.findItem(R.id.action_delete).setVisible(false);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save:
                saveCharacter();
                break;
            case R.id.action_delete:
                deleteCharacter();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
