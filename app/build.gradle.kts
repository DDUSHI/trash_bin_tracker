plugins {
    id("com.android.application") // Android 애플리케이션 플러그인
    id("kotlin-android") // Kotlin Android 플러그인
}

android {
    namespace = "com.example.trash_bin_tracker"
    compileSdk = 35 // 컴파일 SDK 버전

    defaultConfig {
        applicationId = "com.example.trash_bin_tracker" // 애플리케이션 ID
        minSdk = 26 // 최소 SDK 버전
        targetSdk = 35 // 타겟 SDK 버전
        versionCode = 1 // 버전 코드
        versionName = "1.0" // 버전 이름
    }

    buildTypes {
        release {
            isMinifyEnabled = false // 코드 난독화 비활성화
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro") // ProGuard 설정 파일
        }
    }
}

dependencies {
    implementation("com.google.android.gms:play-services-maps:18.0.0") // Google Maps 서비스
    implementation("org.apache.poi:poi:5.2.3") // Apache POI 라이브러리
    implementation("org.apache.poi:poi-ooxml:5.2.3") // Apache POI OOXML 라이브러리
    implementation("androidx.appcompat:appcompat:1.3.1") // AndroidX AppCompat 라이브러리
    implementation("com.google.android.material:material:1.4.0") // Material 디자인 라이브러리
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.21") // Kotlin 표준 라이브러리
}
