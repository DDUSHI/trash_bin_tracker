// 플러그인 관리 및 리포지토리 설정
pluginManagement {
    repositories {
        google() // Google Maven 저장소
        mavenCentral() // Maven 중앙 저장소
        gradlePluginPortal() // Gradle 플러그인 포털
    }
}

// 의존성 관리 설정
dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS) // 설정 파일의 리포지토리 우선 사용
    repositories {
        google() // Google Maven 저장소
        mavenCentral() // Maven 중앙 저장소
    }
}

// 버전 카탈로그 기능 활성화
//enableFeaturePreview("VERSION_CATALOGS")

// 루트 프로젝트 이름 설정
rootProject.name = "trash_bin_tracker"
include(":app") // 앱 모듈 포함
