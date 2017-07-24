package com.example.phuwarin.grand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.phuwarin.grand.model.MessageDao;
import com.example.phuwarin.grand.service.ApiService;
import com.example.phuwarin.grand.service.HttpManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportActivity extends AppCompatActivity {

    AppCompatTextView textOutput;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        textOutput = (AppCompatTextView) findViewById(R.id.text_output_report);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        progressBar.setIndeterminate(true);

        final SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        ApiService service = HttpManager.getInstance().getService();
        Call<List<MessageDao>> call = service.pushNotification();

        call.enqueue(new Callback<List<MessageDao>>() {
            @Override
            public void onResponse(Call<List<MessageDao>> call,
                                   Response<List<MessageDao>> response) {
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    List<MessageDao> output = response.body();
                    for (MessageDao aMessage : output) {
                        try {
                            textOutput.append(aMessage.getBehavior() + "\t" +
                                    isoFormat.parse(aMessage.getTimeStamp()) + "\n");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<MessageDao>> call,
                                  Throwable t) {
                makeToast(t.getMessage());
            }
        });
    }

    private void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
