package skistarassignment.tobias.home.com.skistar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ListActivity extends AppCompatActivity {

    private static final String ENDPOINT = "https://www.skistar.com/myskistar/api/v2/views/statisticspage.json?entityId=3206&seasonId=11";

    private RequestQueue requestQueue;

    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        requestQueue = Volley.newRequestQueue(this);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("M/d/yy hh:mm a");
        gson = gsonBuilder.create();

        fetchRuns();
    }

    private void fetchRuns() {
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT, onRunsLoaded, onRunsError);

        requestQueue.add(request);
    }

    private final Response.Listener<String> onRunsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.i("PostActivity", response);
        }
    };

    private final Response.ErrorListener onRunsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("PostActivity", error.toString());
        }
    };

    public void showAlert(View v) {
        AlertDialog.Builder showAlert = new AlertDialog.Builder(this);

        showAlert.setTitle("Choose filters:");

        showAlert.setMessage("AlertDialog to filter information inside ListView!");
        showAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        showAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        showAlert.create();
        showAlert.show();
    }
}
