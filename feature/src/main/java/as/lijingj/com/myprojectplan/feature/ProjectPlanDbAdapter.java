package as.lijingj.com.myprojectplan.feature;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ProjectPlanDbAdapter {

    public static final String COL_ID = "_id";
    public static final String COL_Title = "title";
    public static final String COL_Content = "content";
    public static final String COL_BeginDate = "begindate";
    public static final String COL_EndDate = "enddate";

    private static final String TAG = "ProjectPlanDbAdapter";

    private DatabaseHelper mDbHelper;
    private  SQLiteDatabase mDb;

    private final Context mCtx;

    private static final String DATABASE_NAME = "dba_plan";
    private static final String TABLE_NAME = "tbl_plan";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE ="CREATE TABLE if not exists " + TABLE_NAME + "(" +
                        COL_ID + " INTEGER PRIMARY KEY autoincrement, " +
                        COL_Title + " TEXT," +
                        COL_Content + " TEXT," +
                        COL_BeginDate + " TEXT," +
                        COL_EndDate + " TEXT);";

    //region 内部数据库操作类
    private class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME,null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.w(TAG,DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG,"Upgrading database from version" + oldVersion + " to "+ newVersion + ".");
//            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//            onCreate(db);
            // 使用for实现跨版本升级数据库
            for (int i = oldVersion; i < newVersion; i++) {
                switch (i) {

                    default:
                        break;
                }
            }
        }
    }
    //endregion

    //region 数据库相关操作方法
    public ProjectPlanDbAdapter(Context ctx){
        this.mCtx = ctx;
    }

    public void open() throws SQLException{
        mDbHelper =new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
    }

    public void close(){
        if(mDbHelper != null){
            mDbHelper.close();
        }
    }

    //endregion

    //region 数据的CRUD操作
    public void createProjectPlan(ProjectPlanEntity item){
        ContentValues values = new ContentValues();
        values.put(COL_Title,item.getPlanTitle());
        values.put(COL_Content, item.getPlanContent());
        values.put(COL_BeginDate, item.GetBeginDateString());
        values.put(COL_EndDate, item.GetEndDateString());
        mDb.insert(TABLE_NAME,null,values);
    }
    //endregion
}
