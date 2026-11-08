# 🍎 Fruit Vision AI
### AI-Powered Fruit Detection Android Application

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-green?style=for-the-badge&logo=android" />
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/AI-TensorFlow%20Lite-FF6F00?style=for-the-badge&logo=tensorflow" />
  <img src="https://img.shields.io/badge/UI-XML-blue?style=for-the-badge" />
</p>

## 📌 Project Overview

**Fruit Vision AI** is an AI-powered Android application developed to identify fruits from images using a pre-trained TensorFlow Lite model.

The application allows users to capture a fruit image using their phone camera or select an image from the gallery. The AI model processes the image and predicts the fruit name along with a confidence score.

The application features a clean and modern blue-and-white user interface designed to provide a simple and user-friendly experience.

## ✨ Features

- Splash Screen with application branding.
- Login Screen with email and password fields.
- Guest Mode for users who want to continue without signing in.
- Camera Integration to capture fruit images.
- Gallery Integration to select images.
- AI-Based Fruit Classification.
- Quick Sample Testing.
- Fruit Detection Results with confidence scores.
- Additional fruit health and freshness information displayed in the interface.
- Simple and attractive blue-and-white design.

## 🍊 Supported Fruits

The application currently displays five supported fruit classes:

1. Apple 🍎
2. Banana 🍌
3. Orange 🍊
4. Strawberry 🍓
5. Mango 🥭

## 📱 Application Screenshots

### 1. Splash Screen

The splash screen introduces Fruit Vision AI with its application logo, name, subtitle, and loading animation.

<img width="720" height="1640" alt="image" src="https://github.com/user-attachments/assets/db3715bb-7905-4458-bc41-02af5bfa0e10" />


### 2. Login Screen

The login screen provides email/username and password fields. Users can also continue as a guest.

<img width="720" height="1640" alt="image" src="https://github.com/user-attachments/assets/e6339b08-bf26-4d80-9c15-1f05dcdf9d9f" />


### 3. Home Screen

The home screen provides two main options: Take Photo and Choose from Gallery. It also includes quick sample testing and a list of supported fruits.

<img width="702" height="1600" alt="image" src="https://github.com/user-attachments/assets/ed36a711-bfc2-4b82-baba-5bd39142b114" />


### 4. Fruit Detection Result

After processing an image, the result screen displays the predicted fruit name, AI confidence score, and additional fruit information.

**Example Result:**
- Detected Fruit: Apple
- AI Confidence: 92%
- Health & Freshness: 98% (displayed example value)

<img width="702" height="1600" alt="image" src="https://github.com/user-attachments/assets/df01cf44-a9a6-4f8f-91f2-46f72cec68e6" />


*Note: The confidence and freshness values shown above are example application outputs. They should not be considered independently verified model accuracy or scientifically validated freshness measurements.*

## 🧠 AI Model Integration

Fruit Vision AI uses a pre-trained TensorFlow Lite model (`model.tflite`) for image classification.

The model is included in the Android application's assets folder and is used to process fruit images and generate predictions.

The application uses a class-label file (`labels.txt`) to associate model outputs with fruit names.

**AI Technologies:**
- TensorFlow Lite
- Pre-trained Image Classification Model
- Image Processing
- On-device AI Inference

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Android Studio | Android App Development |
| Java | Application Programming |
| XML | User Interface Design |
| TensorFlow Lite | AI Model Integration |
| model.tflite | Pre-trained AI Model |
| labels.txt | Fruit Class Labels |
| Android SDK | Android Application Development |

## 📂 Android Studio Project Structure

```text
Fruit_detection_app/
│
├── app/
│   ├── manifests/
│   │   └── AndroidManifest.xml
│   │
│   ├── kotlin+java/
│   │   └── com.example.fruit_detection_app/
│   │       ├── FruitClassifier
│   │       ├── FruitData
│   │       ├── HomeActivity
│   │       ├── LoginActivity
│   │       ├── MainActivity
│   │       ├── ResultActivity
│   │       ├── SampleFruitHelper
│   │       └── SplashActivity
│   │
│   ├── assets/
│   │   ├── model.tflite
│   │   └── labels.txt
│   │
│   └── res/
│       ├── drawable/
│       ├── layout/
│       │   ├── activity_home.xml
│       │   ├── activity_login.xml
│       │   ├── activity_main.xml
│       │   ├── activity_result.xml
│       │   └── activity_splash.xml
│       ├── mipmap/
│       ├── values/
│       └── xml/
│
└── README.md
```

## ⚙️ How the Application Works

1. The user opens the application.
2. The splash screen appears.
3. The user signs in or continues as a guest.
4. The home screen provides camera and gallery options.
5. The user selects or captures a fruit image.
6. The image is processed by the TensorFlow Lite model.
7. The model generates a fruit classification prediction.
8. The application displays the detected fruit name and confidence score.

## 🚀 Future Improvements

- Add more fruit categories.
- Improve AI model performance.
- Add fruit freshness detection with a validated dataset.
- Add scan history.
- Improve image processing.
- Support multiple languages.
- Improve prediction accuracy through further model evaluation.

## 🎯 Project Objective

The main objective of Fruit Vision AI is to demonstrate how Artificial Intelligence and Machine Learning can be integrated into an Android application to identify fruits from images.

This project provides practical experience in Android development, AI model integration, image classification, and mobile application design.

## 👨‍💻 Developer

**Talha Aamir**

BSCS – 5A

KICSIT

## 📚 References

- [TensorFlow Lite](https://www.tensorflow.org/lite)
- [Android Developers](https://developer.android.com/)
- Android Studio

---

<p align="center">
  <b>Fruit Vision AI</b><br/>
  AI-Powered Fruit Detection Android Application<br/>
  Developed by Talha Aamir
</p>
