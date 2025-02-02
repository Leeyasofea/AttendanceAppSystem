public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "attendance.db";
    private static final int DATABASE_VERSION = 1;

    // Users Table
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FULLNAME = "fullname";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_USER_TYPE = "user_type";

    // Attendance Table
    private static final String TABLE_ATTENDANCE = "attendance";
    private static final String COLUMN_STUDENT_ID = "student_id";
    private static final String COLUMN_CLASS = "class";
    private static final String COLUMN_SUBJECT = "subject";
    private static final String COLUMN_STATUS = "status";
    private static final String COLUMN_REASON = "reason";
    private static final String COLUMN_DATE = "date";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUsersTable = "CREATE TABLE " + TABLE_USERS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_FULLNAME + " TEXT, "
                + COLUMN_EMAIL + " TEXT UNIQUE, "
                + COLUMN_PASSWORD + " TEXT, "
                + COLUMN_USER_TYPE + " TEXT)";
        db.execSQL(createUsersTable);

        String createAttendanceTable = "CREATE TABLE " + TABLE_ATTENDANCE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_STUDENT_ID + " INTEGER, "
                + COLUMN_CLASS + " TEXT, "
                + COLUMN_SUBJECT + " TEXT, "
                + COLUMN_STATUS + " TEXT, "
                + COLUMN_REASON + " TEXT, "
                + COLUMN_DATE + " TEXT)";
        db.execSQL(createAttendanceTable);
    }

    // Implement CRUD operations...
}

