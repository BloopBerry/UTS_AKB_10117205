package model;
import android.content.ContentValues;
import android.database.Cursor;
import com.example.uts_akb_10117205.TableKontak;
public class Kontak {
    private int id;
    private String NIM;
    private String Nama;
    private String Kelas;
    private String Telepon;
    private String Email;
    private String Social;

    public int getId() {
        return id;
    }

    public  String getNIM(){
        return NIM;
    }
    public String getNama(){
        return Nama;
    }

    public String getEmail() {
        return Email;
    }

    public String getKelas() {
        return Kelas;
    }

    public String getSocial() {
        return Social;
    }

    public String getTelepon() {
        return Telepon;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setKelas(String kelas) {
        Kelas = kelas;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public void setSocial(String social) {
        Social = social;
    }

    public void setTelepon(String telepon) {
        Telepon = telepon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kontak fromCursor(Cursor c){
        this.setId(c.getInt(c.getColumnIndex(TableKontak.FIELD_ID)));
        this.setNIM(c.getString(c.getColumnIndex(TableKontak.FIELD_NIM)));
        this.setNama(c.getString(c.getColumnIndex(TableKontak.FIELD_NAMA)));
        this.setKelas(c.getString(c.getColumnIndex(TableKontak.FIELD_KELAS)));
        this.setEmail(c.getString(c.getColumnIndex(TableKontak.FIELD_KELAS)));
        this.setSocial(c.getString(c.getColumnIndex(TableKontak.FIELD_SOCIAL)));
        this.setTelepon(c.getString(c.getColumnIndex(TableKontak.FIELD_SOCIAL)));
        return this;
    }
    public ContentValues toValues(){
        ContentValues cv = new ContentValues();
        if(this.getId() > 0 ){
            cv.put(TableKontak.FIELD_ID,this.getId());
        }
        cv.put(TableKontak.FIELD_NIM,this.getNIM());
        cv.put(TableKontak.FIELD_NAMA,this.getNama());
        cv.put(TableKontak.FIELD_KELAS,this.getKelas());
        cv.put(TableKontak.FIELD_EMAIL,this.getEmail());
        cv.put(TableKontak.FIELD_TELEPON,this.getTelepon());
        cv.put(TableKontak.FIELD_SOCIAL,this.getSocial());
        return cv;
    }
        public String toString(){
            return this.getNama();
        }

}
