package skistarassignment.tobias.home.com.skistar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void showListActivity(View v) {
        Intent showNextView = new Intent(this, ListActivity.class);
        startActivity(showNextView);
    }

}
