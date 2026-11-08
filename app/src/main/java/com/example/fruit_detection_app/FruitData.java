package com.example.fruit_detection_app;

import java.io.Serializable;

public class FruitData implements Serializable {
    private String fruitName;
    private String emoji;
    private float confidence;
    private int healthPercentage;
    private String healthStatus;
    private String nutritionDetails;

    public FruitData(String fruitName, String emoji, float confidence, int healthPercentage, String healthStatus, String nutritionDetails) {
        this.fruitName = fruitName;
        this.emoji = emoji;
        this.confidence = confidence;
        this.healthPercentage = healthPercentage;
        this.healthStatus = healthStatus;
        this.nutritionDetails = nutritionDetails;
    }

    public String getFruitName() {
        return fruitName;
    }

    public String getEmoji() {
        return emoji;
    }

    public float getConfidence() {
        return confidence;
    }

    public int getHealthPercentage() {
        return healthPercentage;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public String getNutritionDetails() {
        return nutritionDetails;
    }
}
