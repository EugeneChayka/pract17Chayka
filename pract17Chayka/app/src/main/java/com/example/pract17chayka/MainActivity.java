package com.example.pract17chayka;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    dbHelper = newDBHelper(this);
    ContentValues cv = newContentValues();
    String name = etName.getText().toString();
    String email = etEmail.getText().toString();
    SQLiteDatabasedb = dbHelper.getWritableDatabase();
    cv.put("name", name);
    cv.put("email", email);
    longrowID = db.insert("mytable", null, cv);
    Log.d(LOG_TAG, "row inserted, ID = "+ rowID);
     break;
     caseR.id.btnRead:
            Log.d(LOG_TAG, "--- Rows in mytable: ---");

        Cursor c = db.query("mytable", null, null, null, null, null, null);
        if(c.moveToFirst()) {

intidColIndex = c.getColumnIndex("id");
intnameColIndex = c.getColumnIndex("name");
intemailColIndex = c.getColumnIndex("email");

do{

Log.d(LOG_TAG, "ID = "+ c.getInt(idColIndex) + ", name = "+ c.getString(nameColIndex) + ", email = "+ c.getString(emailColIndex));
 while(c.moveToNext());
else
            Log.d(LOG_TAG, "0 rows");
c.close();
break;
caseR.id.btnClear:
            Log.d(LOG_TAG, "--- Clear mytable: ---");

        intclearCount = db.delete("mytable", null, null);
Log.d(LOG_TAG, "deleted rows count = "+ clearCount);
break;
    dbHelper.close();
    classDBHelper extendsSQLiteOpenHelper {

publicDBHelper(Context context) {
    super(context, "myDB", null, 1);}
        @Override
publicvoidonCreate(SQLiteDatabasedb) {
Log.d(LOG_TAG, "--- onCreate database ---");

db.execSQL("create table mytable (" + "id integer primary key autoincrement," + "name text," + "email text"+ ");");
}
@Override
publicvoidonUpgrade(SQLiteDatabasedb, intoldVersion, intnewVersion)
    {
}
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}