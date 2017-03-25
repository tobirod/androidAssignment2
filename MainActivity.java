package skistarassignment.tobias.home.com.skistar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginCheck(View v) {

        EditText userEmail = (EditText)findViewById(R.id.loginEmail);
        EditText userPass = (EditText)findViewById(R.id.loginPassword);

        if (userEmail.getText().toString().equals("admin") && userPass.getText().toString().equals("admin")) {

            Intent showNextView = new Intent(this, MenuActivity.class);
            startActivity(showNextView);
            Log.i("TEST", "Working as intended.");

        } else {
            Context context = getApplicationContext();
            CharSequence text = "Invalid email or password. Please try again.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
