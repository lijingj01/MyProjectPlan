package as.lijingj.com.myprojectplan.feature;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = (Button) findViewById(R.id.btnAddPlan);
        btnAdd.setOnClickListener(new Button.OnClickListener() {//创建监听
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddPlanActivity.class);
                startActivity(intent);
            }

        });

        Button btnView = (Button) findViewById(R.id.btnViewPlanList);
        btnView.setOnClickListener(new Button.OnClickListener() {//创建监听
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlanListActivity.class);
                startActivity(intent);
            }

        });
    }
}
