# Build the APK using GitHub Actions (Android phone is enough)

1. Create a GitHub repository and upload the contents of this project folder (the files inside `OrganicBoostPro`, not the outer folder).
2. Make sure the default branch is named `main`.
3. Open the repository's **Actions** tab.
4. Select **Build Android APK** and tap **Run workflow** (or push a commit to `main`).
5. Wait for the run to finish successfully.
6. Open the completed run, scroll to **Artifacts**, and download `OrganicBoostPro-debug-apk`.
7. Extract the downloaded artifact ZIP. Install `app-debug.apk` on your Android phone. If Android asks, allow installation from that browser/file manager for this one install.

This produces a debug/testing APK, not a signed Play Store release.

## Important before accepting real payments or orders
This project is a starter UI. Login/register and bKash top-up are demo screens; there is no live payment verification, secure user database, or real admin authorization. Do not accept customer payments or promise services until a trusted backend, server-side transaction verification, and proper admin access controls are implemented. Never ask users for bKash PINs or OTPs. Use only legitimate, platform-compliant promotion methods.
