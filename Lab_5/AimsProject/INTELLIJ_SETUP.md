# IntelliJ IDEA Setup Guide for Lab_5 JavaFX Project

## 🔧 Classpath Issues Solution

Các warning về "not on the classpath" xảy ra vì IntelliJ chưa nhận diện project structure đúng cách.

## 📋 Steps to Fix:

### 1. **Import Maven Project**
```
File → Open → Select Lab_5/AimsProject/pom.xml
```
- Chọn "Open as Project"
- IntelliJ sẽ tự động nhận diện Maven structure

### 2. **Configure JavaFX SDK**
Nếu JDK > 8, cần add JavaFX SDK:

#### Option A: Maven Dependencies (Recommended)
- `pom.xml` đã có JavaFX dependencies
- IntelliJ sẽ tự động download

#### Option B: Manual JavaFX SDK
1. Download JavaFX SDK: https://gluonhq.com/products/javafx/
2. Add VM Arguments:
```
--module-path "path/to/javafx-sdk-17/lib" 
--add-modules javafx.controls,javafx.fxml
```

### 3. **Verify Project Structure**
Kiểm tra trong Project Explorer:
```
AimsProject
├── src/main/java/hust/soict/dsai/aims/
├── src/main/resources/hust/soict/dsai/aims/fxml/
└── pom.xml
```

### 4. **Refresh Maven**
```
View → Tool Windows → Maven
→ Click Reload All Maven Projects
```

### 5. **Build Project**
```
Build → Build Project (Ctrl+F9)
```

## 🚀 Run Configuration

### Create Run Configuration:
1. `Run → Edit Configurations`
2. Click `+` → `Application`
3. Settings:
   - **Main class**: `hust.soict.dsai.aims.Aims`
   - **Module**: `aims-project-javafx.main`
   - **VM options** (nếu cần):
     ```
     --module-path "path/to/javafx-sdk-17/lib" 
     --add-modules javafx.controls,javafx.fxml
     ```

## 🔍 Troubleshooting

### Issue: "Cannot resolve symbol 'javafx'"
**Solution:**
1. Kiểm tra Maven dependencies
2. Reload Maven project
3. Rebuild project

### Issue: "FXML file not found"
**Solution:**
1. Kiểm tra file path trong resources
2. Verify `target/classes` có FXML files
3. Run `mvn clean compile`

### Issue: "ClassNotFoundException"
**Solution:**
1. Kiểm tra main class path
2. Verify module settings
3. Clean và rebuild project

## ✅ Verification

Sau khi setup, kiểm tra:
- [ ] Không còn red underline errors
- [ ] Có thể run `Aims.java`
- [ ] FXML files được load thành công
- [ ] JavaFX components hoạt động

## 📞 Additional Help

Nếu vẫn có issues:
1. `File → Invalidate Caches / Restart`
2. Delete `.idea` folder và re-import
3. Check IntelliJ version (recommend 2023.x+)

## 🎯 Success Indicators

Khi setup thành công:
- ✅ Maven dependencies resolved
- ✅ JavaFX imports working
- ✅ FXML loading successful
- ✅ Application runs without errors
