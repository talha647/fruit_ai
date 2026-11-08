package com.example.fruit_detection_app;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

public class SampleFruitHelper {

    public static Bitmap createSampleFruitBitmap(String fruitName) {
        int width = 400;
        int height = 400;
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        // Soft clean background
        canvas.drawColor(Color.parseColor("#F8FAFC"));

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        float centerX = width / 2.0f;
        float centerY = height / 2.0f;

        switch (fruitName.toLowerCase()) {
            case "apple":
                // Draw Red Apple
                paint.setColor(Color.parseColor("#E53935"));
                canvas.drawCircle(centerX - 35, centerY, 80, paint);
                canvas.drawCircle(centerX + 35, centerY, 80, paint);

                // Stem
                paint.setColor(Color.parseColor("#5D4037"));
                paint.setStrokeWidth(12);
                canvas.drawLine(centerX, centerY - 80, centerX, centerY - 120, paint);

                // Leaf
                paint.setColor(Color.parseColor("#43A047"));
                paint.setStyle(Paint.Style.FILL);
                RectF leafRect = new RectF(centerX, centerY - 130, centerX + 40, centerY - 100);
                canvas.drawOval(leafRect, paint);
                break;

            case "banana":
                // Draw Yellow Banana Curve
                paint.setColor(Color.parseColor("#FDD835"));
                paint.setStyle(Paint.Style.FILL);

                Path path = new Path();
                path.moveTo(centerX - 100, centerY - 60);
                path.cubicTo(centerX - 20, centerY + 120, centerX + 100, centerY + 80, centerX + 110, centerY - 40);
                path.cubicTo(centerX + 80, centerY + 40, centerX - 10, centerY + 60, centerX - 100, centerY - 60);
                canvas.drawPath(path, paint);

                // Banana Stem tip
                paint.setColor(Color.parseColor("#3E2723"));
                canvas.drawCircle(centerX - 100, centerY - 60, 10, paint);
                break;

            case "orange":
                // Draw Orange Sphere
                paint.setColor(Color.parseColor("#FB8C00"));
                canvas.drawCircle(centerX, centerY, 100, paint);

                // Texture dots
                paint.setColor(Color.parseColor("#EF6C00"));
                for (int i = 0; i < 16; i++) {
                    double angle = i * Math.PI / 8;
                    float rx = centerX + (float) (Math.cos(angle) * 50);
                    float ry = centerY + (float) (Math.sin(angle) * 50);
                    canvas.drawCircle(rx, ry, 4, paint);
                }

                // Small Leaf
                paint.setColor(Color.parseColor("#2E7D32"));
                canvas.drawOval(new RectF(centerX - 15, centerY - 120, centerX + 15, centerY - 95), paint);
                break;

            case "strawberry":
                // Draw Red Strawberry Heart/Triangle Body
                paint.setColor(Color.parseColor("#E53935"));
                paint.setStyle(Paint.Style.FILL);

                Path strawPath = new Path();
                strawPath.moveTo(centerX - 80, centerY - 40);
                strawPath.lineTo(centerX + 80, centerY - 40);
                strawPath.lineTo(centerX, centerY + 110);
                strawPath.close();
                canvas.drawPath(strawPath, paint);

                // Yellow seeds
                paint.setColor(Color.parseColor("#FFF176"));
                canvas.drawCircle(centerX - 30, centerY - 10, 5, paint);
                canvas.drawCircle(centerX + 30, centerY - 10, 5, paint);
                canvas.drawCircle(centerX, centerY + 30, 5, paint);
                canvas.drawCircle(centerX - 15, centerY + 60, 5, paint);
                canvas.drawCircle(centerX + 15, centerY + 60, 5, paint);

                // Green Cap
                paint.setColor(Color.parseColor("#388E3C"));
                canvas.drawRect(centerX - 60, centerY - 60, centerX + 60, centerY - 40, paint);
                break;

            case "mango":
                // Draw Oval Mango
                paint.setColor(Color.parseColor("#FFB300"));
                RectF mangoRect = new RectF(centerX - 75, centerY - 105, centerX + 75, centerY + 105);
                canvas.drawOval(mangoRect, paint);

                // Red/Orange Blush
                paint.setColor(Color.parseColor("#F4511E"));
                canvas.drawCircle(centerX - 30, centerY - 30, 45, paint);

                // Small stem
                paint.setColor(Color.parseColor("#4E342E"));
                paint.setStrokeWidth(10);
                canvas.drawLine(centerX, centerY - 105, centerX, centerY - 125, paint);
                break;

            default:
                paint.setColor(Color.parseColor("#1E88E5"));
                canvas.drawCircle(centerX, centerY, 90, paint);
                break;
        }

        return bitmap;
    }
}
