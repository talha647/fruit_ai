package com.example.fruit_detection_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.io.File;

public class ResultActivity extends AppCompatActivity {

    public static final String EXTRA_FRUIT_DATA = "extra_fruit_data";
    public static final String EXTRA_IMAGE_PATH = "extra_image_path";
    public static Bitmap currentResultBitmap = null;

    private ImageView imgFruit;
    private TextView tvFruitName, tvConfidence, tvHealthPercentage, tvHealthStatus, tvNutritionDetails;
    private ProgressBar progressBarHealth;
    private MaterialButton btnScanAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imgFruit = findViewById(R.id.imgFruit);
        tvFruitName = findViewById(R.id.tvFruitName);
        tvConfidence = findViewById(R.id.tvConfidence);
        tvHealthPercentage = findViewById(R.id.tvHealthPercentage);
        tvHealthStatus = findViewById(R.id.tvHealthStatus);
        tvNutritionDetails = findViewById(R.id.tvNutritionDetails);
        progressBarHealth = findViewById(R.id.progressBarHealth);
        btnScanAgain = findViewById(R.id.btnScanAgain);

        FruitData fruitData = (FruitData) getIntent().getSerializableExtra(EXTRA_FRUIT_DATA);
        String imagePath = getIntent().getStringExtra(EXTRA_IMAGE_PATH);

        if (currentResultBitmap != null) {
            imgFruit.setImageBitmap(currentResultBitmap);
        } else if (imagePath != null && new File(imagePath).exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            imgFruit.setImageBitmap(bitmap);
        }

        if (fruitData != null) {
            tvFruitName.setText(fruitData.getFruitName() + " " + fruitData.getEmoji());
            int confPercent = (int) (fruitData.getConfidence() * 100);
            tvConfidence.setText("AI Confidence: " + confPercent + "%");

            int healthScore = fruitData.getHealthPercentage();
            tvHealthPercentage.setText(healthScore + "%");
            progressBarHealth.setProgress(healthScore);

            tvHealthStatus.setText(fruitData.getHealthStatus());
            tvNutritionDetails.setText(fruitData.getNutritionDetails());

            // Dynamic color tint for health score
            if (healthScore >= 80) {
                tvHealthPercentage.setTextColor(Color.parseColor("#2E7D32"));
                tvHealthStatus.setBackgroundColor(Color.parseColor("#E8F5E9"));
                tvHealthStatus.setTextColor(Color.parseColor("#2E7D32"));
            } else if (healthScore >= 60) {
                tvHealthPercentage.setTextColor(Color.parseColor("#EF6C00"));
                tvHealthStatus.setBackgroundColor(Color.parseColor("#FFF3E0"));
                tvHealthStatus.setTextColor(Color.parseColor("#EF6C00"));
            } else {
                tvHealthPercentage.setTextColor(Color.parseColor("#C62828"));
                tvHealthStatus.setBackgroundColor(Color.parseColor("#FFEBEE"));
                tvHealthStatus.setTextColor(Color.parseColor("#C62828"));
            }
        }

        btnScanAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        currentResultBitmap = null;
    }
}
