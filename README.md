# Organic Boost Pro — Android Studio source project

This is a starter Android app project with a green/black Compose UI and demo screens for login/register, dashboard, organic service categories, bKash top-up submission, orders, and an admin dashboard placeholder.

## Open the project
1. Extract the ZIP.
2. Open the `OrganicBoostPro` folder in Android Studio (recent version).
3. Allow Gradle sync, then run on an Android device or emulator.

## Before production
- Login/register are demo UI only; connect Firebase Authentication or another secure auth provider.
- Set your verified bKash Personal receiving number in `app/src/main/java/com/organicboostpro/app/config/AppConfig.kt`.
- Implement a trusted backend/database, Firestore/database security rules, transaction verification, order processing, and server-side admin roles.
- Never collect a bKash PIN, OTP, or password. Do not credit balances based only on a client-side form.
- The admin username shown is a label only; there is no real admin authentication in this starter.

This ZIP contains source code, not a compiled APK or a deployed backend. Organic services should comply with each platform's terms and avoid fake engagement or bots.
