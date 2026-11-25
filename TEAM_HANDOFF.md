# Group handoff: Administrator account module (partial project)

This zip keeps the original starter files, with only the duplicate placeholder declarations
at the end of `Student.java` commented out so Java can compile.

## Completed here (Person 1)
- `UserAccount.java`: user account fields, constructors, getters, password check, safe display.
- `AccountManager.java`: array of account objects; load `data/users.txt` automatically;
  login; create/view faculty login accounts; update faculty passwords; save changes;
  reject invalid data, duplicate usernames and faculty IDs.
- `AdministratorConsole.java`: console menus to test the module; administrator login.
- `Main.java`: temporary two-line handoff to the account menu, so running Main works now.
  Person 3 can expand it later.
- `data/users.txt`: fictional sample accounts. Username `admin`, password `admin123`.
  Faculty sample: username `profjones`, password `demo123`, faculty ID `F001`.

Passwords are plain text for this classroom demo only. Never use real passwords or real student records.

## How to run from the project root
```
javac -d out src/project1/*.java
java -cp out project1.Main
```
In IntelliJ, open the project root and run `Main.main()`.
The working directory must be the project root so `data/users.txt` can be found.

## Intentionally left for teammates
- **Person 2**: actual faculty profiles, advisee lists, advising forms, access restrictions;
  implement remaining abstract faculty/advising types.
- **Person 3**: courses, rosters, transcripts, main integrated console UI, shared academic
  record file loading/saving and overall integration/testing.
- **Person 1 later**: connect account faculty IDs to actual faculty records; implement
  add/view/update student and faculty records and advisor assignments once peers agree
  on their class fields and method names.

## How to integrate later
- The team's `Main.java` should create a single `AccountManager("data/users.txt")`.
- Use `manager.login(username, password)`; it returns `UserAccount` or `null`.
- Call `AdministratorConsole.runAdminMenu(scanner, manager)` only after confirming
  `account.getRole().equals("ADMIN")`.
- Faculty menu can be routed after a successful `FACULTY` login and must enforce
  the assigned-advisor rule. Do not treat the placeholder faculty login message
  as completed authorization for academic records.
- Faculty IDs in `users.txt` must eventually be checked against faculty records.
- Do not replace another teammate's updated `Student.java` with this older starter copy.
