package ma.ens.hellotoast;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int mCurrentValue = 0;
    private TextView mScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreView = findViewById(R.id.display_value);
        Button triggerToast = findViewById(R.id.btn_toast);
        Button triggerIncrement = findViewById(R.id.btn_count);

        triggerToast.setOnClickListener(view -> {
            String welcomeMsg = "HELLOOOOO!!!";
            Toast.makeText(this, welcomeMsg, Toast.LENGTH_SHORT).show();
        });

        triggerIncrement.setOnClickListener(view -> {
            incrementScore();
        });
    }

    private void incrementScore() {
        mCurrentValue++;
        if (mScoreView != null) {
            mScoreView.setText(String.format("%d", mCurrentValue));
        }
    }
}