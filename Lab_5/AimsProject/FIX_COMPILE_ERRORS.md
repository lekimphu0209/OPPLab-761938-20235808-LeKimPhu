# 🚨 Fix Compile Errors - Lab_5

## **Vấn đề hiện tại:**
```
ERROR: CD length is invalid
Project 'OPPLab-761938-20235808-LeKimPhu_4e55cf9e' is missing required source folder
Aims.java is not on the classpath
```

## **Nguyên nhân:**
1. **IDE đang chạy Lab_4 project** nhưng tìm kiếm Lab_5 files
2. **CompactDisc không có tracks** → length = 0 → PlayerException
3. **Classpath sai** → không tìm thấy Lab_5 files

---

## **🔧 Giải pháp nhanh:**

### **Option 1: Chỉ chạy Lab_4 (Swing)**
```bash
# Chạy file Lab_4
cd d:\OOP\Lab\OPPLab-761938-20235808-LeKimPhu\Lab_4\AimsProject\src\hust\soict\dsai\aims\screen
javac -cp . TestStoreScreen.java
java hust.soict.dsai.aims.screen.TestStoreScreen
```

### **Option 2: Chạy Lab_5 (JavaFX) đúng cách**
1. **Mở IntelliJ mới**
2. **Open Maven Project**: `Lab_5/AimsProject/pom.xml`
3. **Wait for Maven sync**
4. **Run**: `hust.soict.dsai.aims.Aims`

---

## **📝 Steps chi tiết:**

### **Step 1: Đóng project hiện tại**
- `File → Close Project`

### **Step 2: Mở Lab_5 đúng cách**
```
File → Open → Chọn: d:\OOP\Lab\OPPLab-761938-20235808-LeKimPhu\Lab_5\AimsProject\pom.xml
```
- Chọn "Open as Project"
- Đợi Maven download dependencies

### **Step 3: Verify setup**
- Project structure: `src/main/java/` và `src/main/resources/`
- Không có lỗi classpath
- Maven dependencies resolved

### **Step 4: Run application**
- Right-click `Aims.java` → Run
- Hoặc tạo Run Configuration cho `TestStoreScreen.java`

---

## **🔍 Debug từng bước:**

### **Nếu vẫn lỗi CD length:**
```java
// Đã fix trong TestStoreScreen.java
CompactDisc cd = new CompactDisc(2, "Thriller", "Pop", 15.99f, "Michael Jackson", 42, "Michael Jackson");
Track track1 = new Track("Billie Jean", 180);
Track track2 = new Track("Beat It", 200);
cd.addTrack(track1);
cd.addTrack(track2);
```

### **Nếu vẫn classpath error:**
1. `File → Project Structure → Modules`
2. Add `src/main/java` as Source Folder
3. Add `src/main/resources` as Source Folder

### **Nếu vẫn build path error:**
1. `Project → Clean`
2. `Project → Build All`
3. Restart IntelliJ

---

## **✅ Success indicators:**
- [ ] Không còn red underline errors
- [ ] Maven dependencies loaded
- [ ] Có thể run `Aims.java`
- [ ] JavaFX window opens
- [ ] Không còn "CD length invalid" error

---

## **🚀 Quick Test:**
```bash
# Test Lab_4 (nếu muốn)
cd Lab_4/AimsProject/src
javac hust/soict/dsai/aims/screen/TestStoreScreen.java
java hust.soict.dsai.aims.screen.TestStoreScreen

# Test Lab_5 (sau khi setup IntelliJ)
# Chạy Aims.java trong IntelliJ
```

**Chọn 1 trong 2 option trên, đừng trộn lẫn!**
