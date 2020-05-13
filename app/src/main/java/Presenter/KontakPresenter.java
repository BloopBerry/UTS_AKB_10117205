package Presenter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import com.example.uts_akb_10117205.MyOpenHelper;
import com.example.uts_akb_10117205.TableKontak;
import model.Kontak;

public class KontakPresenter {
    MyOpenHelper myOpenHelper;


    public KontakPresenter(Context context){
        myOpenHelper = new MyOpenHelper(context);
    }

    public ArrayList<Kontak> select(String where, String[] whereArgs){
        ArrayList<Kontak> kontaks = new ArrayList<>();
        SQLiteDatabase database = myOpenHelper.getReadableDatabase();
        try{
            Cursor c = database.query(TableKontak.TABLE_NAME, new String[]{"*"}, where, whereArgs, null, null, TableKontak.FIELD_NAMA);
            if(c.getCount() > 0 && c.moveToFirst()) {
                while (!c.isAfterLast()) {
                    kontaks.add(new Kontak().fromCursor(c));
                    c.moveToNext();
                }
                c.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        database.close();
        return kontaks;
    }


    public long insert(Kontak c){
        long id = -1;
        SQLiteDatabase database = myOpenHelper.getWritableDatabase();
        try {
            id = database.insert(TableKontak.TABLE_NAME, null, c.toValues());
        }catch (Exception e){
            e.printStackTrace();
        }
        database.close();
        return id;
    }


    public int update(Kontak c){
        int rows = -1;
        SQLiteDatabase database = myOpenHelper.getWritableDatabase();
        try {
            ContentValues cv = c.toValues();

            rows = database.update(TableKontak.TABLE_NAME, cv, TableKontak.FIELD_ID + " = ?", new String[]{String.valueOf(cv.getAsInteger(TableKontak.FIELD_ID))});
        }catch (Exception e){
            e.printStackTrace();
        }
        database.close();
        return rows;
    }


    public int delete(int id){
        int rows = -1;
        SQLiteDatabase database = myOpenHelper.getWritableDatabase();
        try {
            rows = database.delete(TableKontak.TABLE_NAME, TableKontak.FIELD_ID + " = ?", new String[]{String.valueOf(id)});
        }catch (Exception e){
            e.printStackTrace();
        }
        database.close();
        return rows;
    }

}
