package com.example.fruit_detection_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class HomeActivity extends AppCompatActivity {

    private FruitClassifier classifier;
    private MaterialCardView cardCamera, cardGallery;
    private MaterialCardView sampleApple, sampleBanana, sampleOrange, sampleStrawberry, sampleMango;
    private ImageView btnLogout;

    private ActivityResultLauncher<String> galleryLauncher;
    private ActivityResultLauncher<Void> cameraLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        classifier = new FruitClassifier(this);

        cardCamera = findViewById(R.id.cardCamera);
        cardGallery = findViewById(R.id.cardGallery);

        sampleApple = findViewById(R.id.sampleApple);
        sampleBanana = findViewById(R.id.sampleBanana);
        sampleOrange = findViewById(R.id.sampleOrange);
        sampleStrawberry = findViewById(R.id.sampleStrawberry);
        sampleMango = findViewById(R.id.sampleMango);
        btnLogout = findViewById(R.id.btnLogout);

        setupLaunchers();

        cardGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryLauncher.launch("image/*");
            }
        });

        cardCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraLauncher.launch(null);
            }
        });

        sampleApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processSampleFruit("Apple");
            }
        });

        sampleBanana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processSampleFruit("Banana");
            }
        });

        sampleOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processSampleFruit("Orange");
            }
        });

        sampleStrawberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processSampleFruit("Strawberry");
            }
        });

        sampleMango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processSampleFruit("Mango");
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void setupLaunchers() {
        galleryLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri uri) {
                if (uri != null) {
                    try {
                        Bitmap bitmap;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                            bitmap = ImageDecoder.decodeBitmap(ImageDecoder.createSource(getContentResolver(), uri));
                        } else {
                            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        }
                        processImage(bitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(HomeActivity.this, "Failed to load gallery image", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        cameraLauncher = registerForActivityResult(new ActivityResultContracts.TakePicturePreview(), new ActivityResultCallback<Bitmap>() {
            @Override
            public void onActivityResult(Bitmap bitmap) {
                if (bitmap != null) {
                    processImage(bitmap);
                } else {
                    Toast.makeText(HomeActivity.this, "No image captured", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void processSampleFruit(String fruitName) {
        Bitmap sampleBitmap = SampleFruitHelper.createSampleFruitBitmap(fruitName);
        processImage(sampleBitmap);
    }

    private void processImage(Bitmap bitmap) {
        if (bitmap == null) return;
        FruitData fruitData = classifier.classify(bitmap);

        ResultActivity.currentResultBitmap = bitmap;
        Intent intent = new Intent(HomeActivity.this, ResultActivity.class);
        intent.putExtra(ResultActivity.EXTRA_FRUIT_DATA, fruitData);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (classifier != null) {
            classifier.close();
        }
    }
}
