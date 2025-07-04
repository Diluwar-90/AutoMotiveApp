# 🚗 Speed Monitoring System for Car Rental - RLE Automotive Assignment

This project simulates a backend architecture for a **car rental company** that wants to monitor and alert when customers exceed their **maximum allowed driving speed**.

> 🛠️ Developed as part of an RLE Android Developer assignment in the Automotive Domain.

---

## 📌 Use Case

- Each rental customer is assigned a **custom speed limit** by the rental company before the rental begins.
- If a customer exceeds that speed during the trip:
  - The **renter** is given a warning alert.
  - The **company** is notified via **Firebase**, and a fallback to **AWS** is provided if needed.

---

## 🧠 Assumptions

- Speed data is received from car hardware or simulators.
- Communication channels (Firebase, AWS) are mocked through interfaces.
- No UI is required — logic and alerting are simulated via logging.
- Each customer has a unique speed limit.

---

## 🧱 Architecture

com.example.assignmentrle
│
├── data/ # Simulated repositories and providers
├── domain/ # Models and use case
├── notification/ # Notification interfaces (Firebase/AWS, Alert)
├── viewmodel/ # ViewModel simulating Android architecture
└── Main.kt # Entry point to simulate speed update scenario


---

## ⚙️ Technologies Used

- **Kotlin** (can be ported to Java if needed)
- **MVVM principles**
- **Interface-based communication** (Firebase/AWS mock logic)
- **No 3rd-party dependencies**
- **No UI — command-line simulation only**

---

## 🚀 How It Works

1. Customer and speed limit registered before the trip.
2. A simulated speed reading is compared against the limit.
3. If exceeded:
   - An alert is sent to the driver.
   - Notification is sent to the company via Firebase (with fallback to AWS).

---

## 🧪 Example Output

```bash
⚠️ Warning sent to driver cust001 for exceeding speed: 95 km/h
🚨 Firebase: Notifying company that cust001 drove at 95 km/h

🧰 How to Run
Clone this repo.

Open in IntelliJ / Android Studio (Kotlin JVM project).

Run Main.kt.

🗂️ Future Extensions (Optional)
Add Firebase Cloud Messaging (FCM) integration.

Connect with real-time speed APIs or car sensors.

Build a simple UI to visualize speed logs and alerts.

Store alert history in Room/SQLite or Firebase Firestore.

👤 Developed By
Diluwar Hossain
Senior Android Developer — Automotive Domain


---

### 🧾 Next Steps (Optional But Recommended for GitHub Repo)

1. Create your repo (e.g., `rle-automotive-speed-monitor`).
2. Place the project files and `README.md` in the root.
3. Add a `.gitignore` (Kotlin/Java or IntelliJ preset).
4. Push to GitHub with:

```bash
git init
git add .
git commit -m "Initial commit: Speed Monitor System for RLE automotive use case"
git remote add origin https://github.com/<your-username>/<your-repo>.git
git push -u origin main


