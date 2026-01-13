# OOP 261200 Project – K0MBAT
## Design Document

### 1. ภาพรวมของโปรแกรม
โปรแกรมนี้เป็นเกมแบบ turn-based บนกระดานสองมิติ (grid board)  
พัฒนาโดยใช้แนวคิด Object-Oriented Programming (OOP) ตามรายวิชา 261200  
โดยมีเป้าหมายเพื่อสาธิตการใช้งาน abstraction, encapsulation, inheritance, polymorphism  
รวมถึงการประยุกต์ใช้ Design Patterns และแนวคิดเรื่อง Grammars และ Parsing

ตัวเกมสามารถควบคุมตัวละคร (Minion) ผ่านภาษาสคริปต์ที่ออกแบบขึ้นเอง  
ซึ่งจะถูกแปลงเป็น Abstract Syntax Tree (AST) และนำไปประมวลผลใน runtime

---

### 2. โครงสร้างระบบ (Architecture)
โปรแกรมถูกออกแบบตามแนวคิด **Model–View–Controller (MVC)** เพื่อแยกหน้าที่ของแต่ละส่วนอย่างชัดเจน

controller/ → ควบคุมลำดับการทำงานของโปรแกรม
model/ → เก็บ state และ logic หลักของเกม
parser/ → ภาษาสคริปต์, tokenizer, parser และ AST
strategy/ → พฤติกรรมของตัวละคร (AI behavior)

yaml
คัดลอกโค้ด

การแยกโครงสร้างเช่นนี้ช่วยให้ระบบมีความ modular และง่ายต่อการขยายในอนาคต

---

### 3. Model Layer
#### 3.1 Game
คลาส `Game` ทำหน้าที่เป็นศูนย์กลางของ state ของเกม ประกอบด้วย:
- กระดาน (`Board`)
- ตัวละคร (`Minion`)
- หมายเลขรอบการเล่น (turn)

เมธอด `nextTurn()` จะเป็นตัวควบคุมลำดับของเกมในแต่ละรอบ

---

#### 3.2 Board
`Board` แทนกระดานของเกม มีหน้าที่:
- เก็บขนาดของกระดาน
- แสดงผลกระดานและตำแหน่งของ Minion
- เป็นผู้กำหนดขอบเขต (boundary) ของเกม

Board ไม่เปลี่ยนตำแหน่ง Minion โดยตรง แต่ทำหน้าที่ตรวจสอบและแสดงผลเท่านั้น  
สอดคล้องกับหลัก **single responsibility principle**

---

#### 3.3 Minion และ Soldier
`Minion` เป็น abstract representation ของตัวละครในเกม โดยมี:
- ตำแหน่ง (row, col)
- พฤติกรรม (Strategy)

`Soldier` เป็น subclass ของ Minion ที่กำหนดค่าเริ่มต้นของพลังชีวิตและตำแหน่ง  
แสดงการใช้ **inheritance** อย่างชัดเจน

---

### 4. Strategy Pattern
พฤติกรรมของ Minion ถูกออกแบบด้วย **Strategy Pattern**

Strategy (interface)
├── IdleStrategy
└── AggressiveStrategy

yaml
คัดลอกโค้ด

Minion จะไม่ผูกกับพฤติกรรมใดพฤติกรรมหนึ่งโดยตรง  
แต่สามารถเปลี่ยน Strategy ได้ใน runtime  
แสดงการใช้ **polymorphism** และ **composition over inheritance**

---

### 5. ภาษาสคริปต์ (Scripting Language)
เกมรองรับภาษาสคริปต์แบบง่ายสำหรับควบคุมพฤติกรรมของ Minion เช่น:

idle
aggressive
move right
repeat 2 {
move down
}

nginx
คัดลอกโค้ด

Grammar โดยย่อ:
statement ::= idle
| aggressive
| move direction
| repeat NUMBER { statement* }

yaml
คัดลอกโค้ด

---

### 6. Parser และ AST
ระบบ parsing ถูกพัฒนาเองทั้งหมดโดยไม่ใช้ library ภายนอก ประกอบด้วย:

- `Tokenizer` แยก input เป็น token
- `Parser` แปลง token เป็น AST
- AST nodes เช่น `IdleStmt`, `MoveStmt`, `RepeatStmt`

AST แต่ละ node มีเมธอด `execute()`  
ซึ่งทำหน้าที่เป็น **interpreter** ของภาษา

---

### 7. Error Handling
มีการแยก error ของผู้ใช้ (syntax error) ออกจาก error ของโปรแกรม  
ผ่านคลาส `ParseException`

หากสคริปต์ผิดพลาด:
- เกมจะไม่ crash
- แสดงข้อความ error ที่เข้าใจง่าย

แนวคิดนี้สอดคล้องกับบทเรียน **Exceptions vs Errors**

---

### 8. Representation Invariant
มีการกำหนด invariant สำคัญของระบบ เช่น:
- Minion ต้องไม่อยู่นอกขอบกระดาน
- ตำแหน่งของ Minion ต้องเป็นค่าที่ถูกต้องเสมอ

การตรวจสอบ invariant ถูกจัดการในระดับ model เพื่อความถูกต้องของ state

---

### 9. สรุป
โปรเจคนี้แสดงให้เห็นการประยุกต์ใช้แนวคิด OOP อย่างครบถ้วน:
- Encapsulation ผ่านการแยก responsibility
- Inheritance และ polymorphism ในระบบตัวละคร
- Design Patterns (Strategy)
- Grammar, Parsing และ AST
- Robust error handling

โครงสร้างของระบบเอื้อต่อการขยายในอนาคต เช่น
- เพิ่มตัวละครหลายตัว
- เพิ่มคำสั่งใหม่ในภาษา
- พัฒนาเป็นเกมที่ซับซ้อนขึ้น