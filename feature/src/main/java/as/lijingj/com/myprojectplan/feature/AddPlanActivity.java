package as.lijingj.com.myprojectplan.feature;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddPlanActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplan);

        //region 日期操作方法
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.addTextChangedListener(watcher);
        editText.setInputType(InputType.TYPE_NULL);
        editText.setFocusable(false);

        EditText editEndText = (EditText) findViewById(R.id.editEndText);
        editEndText.setInputType(InputType.TYPE_NULL);
        editEndText.setFocusable(false);

        //开始日期
        Button btnDate = (Button) findViewById(R.id.btnDate);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editBeginText = (EditText) findViewById(R.id.editText);
                Date dt = new Date();
                onCreateDialog(editBeginText, dt).show();
            }
        });

        //结束日期
        Button btnEndDate = (Button) findViewById(R.id.btnEndDate);
        btnEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //结束日期要获取开始日期的时间来定义下限
                EditText editText = (EditText) findViewById(R.id.editText);
                EditText editEndText = (EditText) findViewById(R.id.editEndText);
                Date dt = new Date();
                String beginDate = editText.getText().toString();
                if (!(beginDate == null || beginDate.isEmpty())) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                    try {
                        dt = dateFormat.parse(beginDate);

                    } catch (Exception ex) {
                    }
                }

                onCreateDialog(editEndText, dt).show();
            }
        });
        //endregion
    }

    //region 日期选择的相关方法
    private TextWatcher watcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // TODO Auto-generated method stub

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub

        }

        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            //一旦开始日期发生了改变，就需要将结束日期设置成空日期
            EditText editEndText = (EditText) findViewById(R.id.editEndText);
            editEndText.setText("");
        }
    };

    protected Dialog onCreateDialog(EditText editText, Date minDate) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = null;
        DatePickerDialog.OnDateSetListener dateListener =
                new MyOnDateSetListener(editText);

        String txt = editText.getText().toString();

        if (!(txt == null || txt.isEmpty())) {
            //设置日期控件当前定位的时间
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = new Date();
            try {
                dt = dateFormat.parse(txt);

            } catch (Exception ex) {
            }
            calendar.setTime(dt);
        }

        dialog = new DatePickerDialog(this,
                dateListener,
                calendar.get(calendar.YEAR),
                calendar.get(calendar.MONTH),
                calendar.get(calendar.DATE));

        DatePicker dp = dialog.getDatePicker();
        dp.setMinDate(minDate.getTime());

        return dialog;
    }

    private static class MyOnDateSetListener implements DatePickerDialog.OnDateSetListener {
        private final EditText editText;

        public MyOnDateSetListener(EditText editText) {
            this.editText = editText;
        }

        @Override
        public void onDateSet(DatePicker datePicker,
                              int year, int month, int dayOfMonth) {
            //Calendar月份是从0开始,所以month要加1
            editText.setText(year + "-" +
                    (month + 1) + "-" + dayOfMonth);
        }
    }
    //endregion
}
