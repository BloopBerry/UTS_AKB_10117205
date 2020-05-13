package com.example.uts_akb_10117205;

public class TableKontak {
    public static String TABLE_NAME = "kontak";


    public static String FIELD_ID = "_id";
    public static String FIELD_NIM = "nim";
    public static String FIELD_NAMA = "nama";
    public static String FIELD_KELAS = "kelas";
    public static String FIELD_EMAIL = "email";
    public static String FIELD_TELEPON = "telepon";
    public static String FIELD_SOCIAL = "social";

    public static String CREATE_STATEMENT =
            "CREATE TABLE `" + TABLE_NAME + "` (" +
                    " `" + FIELD_ID + "` INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " `" + FIELD_NIM + "` TEXT NOT NULL," +
                    " `" + FIELD_NAMA + "` TEXT NOT NULL," +
                    " `" + FIELD_KELAS + "` TEXT NOT NULL" +
                    " `" + FIELD_EMAIL + "` TEXT NOT NULL," +
                    " `" + FIELD_TELEPON + "` TEXT NOT NULL," +
                    " `" + FIELD_SOCIAL + "` TEXT NOT NULL," +
                            ")";

}
