# RowColDemo — лабораторная №2

**Статус: все 29 учебных этапов реализованы и собраны; окончательная UI-приёмка ожидается. Коммит `Finish project` намеренно отсутствует.**

## Тема и цель

Изучить Row, Column, вложенность, Alignment, Arrangement, scoped modifiers и относительный вес в Jetpack Compose. Источники — `../TASK_02.md`, `../LAB_02_PLAN.md` и полный текст/рисунки `../_course_materials/Row and Column.pdf`. Все варианты последовательно заменяют MainScreen и сохранены в истории, а не имитируются одной галереей.

## Технологии и структура

- Kotlin, Jetpack Compose / Material 3; package `com.example.rowcoldemo`, minSdk 27, compileSdk/targetSdk 37.
- AGP 9.4.1, Gradle 9.6.0, Compose compiler plugin 2.2.10, Compose BOM 2026.02.01. Использованы совместимые версии доступного локального эталона; реальная сборка проверена. Автоматическое обновление зависимостей не выполнялось.
- `app/src/main/java/com/example/rowcoldemo/MainActivity.kt` — Activity, тема, MainScreen, TextCell и Preview. Финальный MainScreen содержит веса 0.2f/0.4f/0.3f.
- `app/src/androidTest/java/com/example/rowcoldemo/` — пять инструментальных тестов.
- `docs/STAGES.md` — 2–4 предложения для каждого этапа: что сделано, почему и как проверить.
- Проект независим, ветка `master`, удалённый репозиторий не настроен; GitHub-публикации нет.

## Сборка и запуск

Открыть эту папку в Android Studio. В `local.properties` задать `sdk.dir=C\:/Android/Sdk` (файл исключён из Git). JBR задавать только для процесса, не менять PATH/Windows:

```bash
JAVA_HOME="C:/Program Files/Android/Android Studio/jbr" bash ./gradlew :app:assembleDebug
JAVA_HOME="C:/Program Files/Android/Android Studio/jbr" bash ./gradlew :app:assembleDebugAndroidTest :app:lintDebug
```

Из Windows shell аналогичная сборка: `gradlew.bat :app:assembleDebug` при локально заданном JAVA_HOME.

- APK: `app/build/outputs/apk/debug/app-debug.apk`.
- Test APK: `app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk`.
- Activity: `com.example.rowcoldemo/.MainActivity` (проверено aapt).
- После согласования доступа к эмулятору: `gradlew.bat :app:connectedDebugAndroidTest`. Эмулятором управляет родительский агент; этот проект самостоятельно его не запускает и настройки устройства не меняет.

## Матрица «требование → коммит → проверка»

Во всех строках реализация расположена в MainActivity.kt; пояснения и соответствие рисункам находятся в docs/STAGES.md. Названия коммитов сохранены точно.

| Этап | Дизайн / действие | Коммит | Проверка |
|---|---|---|---|
| 01 | Create RowColDemo Empty Activity | `b0c971b` | assembleDebug: PASS; UI ожидает проверки |
| 02 | Introduce MainScreen and TextCell | `8565057` | assembleDebug: PASS; UI ожидает проверки |
| 03 | Arrange cells in Row | `9191223` | assembleDebug: PASS; UI ожидает проверки |
| 04 | Arrange cells in Column | `77bbc27` | assembleDebug: PASS; UI ожидает проверки |
| 05 | Nest Row and Column into eleven-cell grid | `0cb9b3b` | assembleDebug: PASS; UI ожидает проверки |
| 06 | Size Row container to 400 by 200 dp | `53484f7` | assembleDebug: PASS; UI ожидает проверки |
| 07 | Center Row children vertically | `06fd5a0` | assembleDebug: PASS; UI ожидает проверки |
| 08 | Align Row children at bottom | `17479b7` | assembleDebug: PASS; UI ожидает проверки |
| 09 | Align Column children at start | `b033a3c` | assembleDebug: PASS; UI ожидает проверки |
| 10 | Center Column children horizontally | `144c5c2` | assembleDebug: PASS; UI ожидает проверки |
| 11 | Align Column children at end | `8dec1f5` | assembleDebug: PASS; UI ожидает проверки |
| 12 | Arrange Row children at start | `5052361` | assembleDebug: PASS; UI ожидает проверки |
| 13 | Arrange Row children at center | `9940a0b` | assembleDebug: PASS; UI ожидает проверки |
| 14 | Arrange Row children at end | `2f06b83` | assembleDebug: PASS; UI ожидает проверки |
| 15 | Arrange Column children at top | `f178799` | assembleDebug: PASS; UI ожидает проверки |
| 16 | Arrange Column children at center | `419d570` | assembleDebug: PASS; UI ожидает проверки |
| 17 | Arrange Column children at bottom | `50397de` | assembleDebug: PASS; UI ожидает проверки |
| 18 | Space Row children evenly | `11fdfd2` | assembleDebug: PASS; UI ожидает проверки |
| 19 | Space Row children between edges | `e784f4b` | assembleDebug: PASS; UI ожидает проверки |
| 20 | Space Row children around | `1169eef` | assembleDebug: PASS; UI ожидает проверки |
| 21 | Align individual Row children with scoped modifiers | `ae6da25` | assembleDebug: PASS; UI ожидает проверки |
| 22 | Align individual Column children | `8dde83a` | assembleDebug: PASS; UI ожидает проверки |
| 23 | Show mixed-size text without baseline alignment | `2b4b85a` | assembleDebug: PASS; UI ожидает проверки |
| 24 | Align text by baseline | `870e9c0` | assembleDebug: PASS; UI ожидает проверки |
| 25 | Use explicit FirstBaseline alignment | `6c7ab7b` | assembleDebug: PASS; UI ожидает проверки |
| 26 | Align multiline text by LastBaseline | `401c9f8` | assembleDebug: PASS; UI ожидает проверки |
| 27 | Align multiline text by FirstBaseline | `1ddccd6` | assembleDebug: PASS; UI ожидает проверки |
| 28 | Offset text using paddingFrom FirstBaseline | `6490d4e` | assembleDebug: PASS; UI ожидает проверки |
| 29 | Distribute Row width using weights | `475157c` | assembleDebug: PASS; UI ожидает проверки |

Рисунки 1–6: этапы 03–07/11; схемы 7–8 и результаты 9–10: 12–17; рисунки 11–13: 18–20; рисунок 14 объясняет RowScope в редакторе, а не новый макет; рисунки 15–21: 21, 23–24, 26–29. Этапы 08–10, 12–13, 15–16, 22 и 25 отдельно проверяют перечисленные в тексте альтернативы.

## Доказательства и фактические результаты

Вне Git, в `C:/AndroidProjects/_lab02_evidence/RowColDemo/`:

- `manifest.json` — этап, точный commit hash/title, путь APK, SHA-256, лог и код завершения сборки; `ui_verified` пока false.
- `apks/01.apk` … `apks/29.apk` — сохранённые APK каждого учебного дизайна; исходные APK не перезаписываются последующими дизайнами.
- `logs/01-assembleDebug.log` … `logs/29-assembleDebug.log` — успешная реальная сборка каждого этапа.
- `logs/final-checks.log` — первый прогон: test APK собран, lint выявил неэкранированное двоеточие в local.properties. Исправлено на `C\:/...`; повтор без сброса задач использовал старый lint-report (`final-checks-pass.log`, несмотря на имя этот файл содержит FAILURE).
- `logs/lint-rerun.log` — успешный `lintDebug --rerun-tasks` после исправления. Остаются предупреждения об устаревших закреплённых зависимостях, backup rules и отсутствующем значке: они не скрыты baseline/suppress.
- `logs/history-detached-build.log`, `logs/history-restored-build.log` — реальный безопасный переход к `9191223`, сборка раннего Row, возврат в master и сборка финальных app/test APK. Исходный HEAD и чистота рабочего дерева восстановлены.
- `testDebugUnitTest` завершает задачу как NO-SOURCE: JVM-тестов нет, это не считается прохождением тестов UI.

Инструментальные тесты проверяют наличие 1/2/3 и горизонтальные координаты, измеренные `boundsInRoot` и веса 2:4:3 (с учётом 4 dp отступов), передачу offset/padding в MainScreen, отсутствие двойного modifier в TextCell, однократный системный верхний inset в Activity. Тесты финального веса написаны до замены MainScreen, но RED/GREEN на устройстве не подтверждён — выполнение отложено по координации с родителем. Не заявляется полное TDD.

## Как изучать историю

Сначала убедиться, что `git status --short` пуст. Сохранить имя ветки и HEAD, выполнить `git switch --detach <hash>`, собрать и изучить нужный дизайн, затем `git switch master`. Не использовать reset/rebase для просмотра. Безопасный цикл уже выполнен для этапа 03 и завершён возвратом к финальному весу.

## Теория и исправления опечаток лекции

1. Row размещает детей горизонтально, Column — вертикально. Вложенность создаёт сетку, но сама по себе не делает её адаптивной.
2. Alignment работает по поперечной оси: вертикально в Row и горизонтально в Column. Arrangement работает вдоль основной оси и требует свободного пространства.
3. SpaceEvenly делает все промежутки равными; SpaceBetween не добавляет свободное место по краям; SpaceAround даёт краевые промежутки вдвое меньше внутренних.
4. RowScope/ColumnScope ограничивают применимость align/weight. alignByBaseline эквивалентен alignBy(FirstBaseline), LastBaseline выбирает последнюю строку. paddingFrom задаёт отступ относительно линии, а не равен обычному padding сверху.
5. Weight — положительный относительный коэффициент; сумма не обязана быть 1. В Row он распределяет ширину, в Column — высоту. Веса 0.2/0.4/0.3 нормируются общей суммой, то есть дают доли 2/9, 4/9, 3/9 выделенного пространства.
6. dp — единица размера с учётом плотности, sp — размера текста с учётом масштаба шрифта. `width(1000.dp)` подчиняется constraints родителя: на телефоне это не экран шириной 1000 dp. Wide Preview объявлен, но его фактический рендеринг не подтверждён.
7. В TextCell входной modifier включён в цепочку один раз; ошибочное `cellModifier.then(modifier)` из лекции не повторяется. Scaffold innerPadding применяется к корню MainScreen один раз даже в примерах baseline/weight, где лекция его потеряла. Используется RowColDemoTheme вместо опечатки StringsDemoTheme.

## Контроль приёмки

- [x] Все 29 действий/дизайнов имеют собственный содержательный commit и успешный assembleDebug.
- [x] Сохранены APK, SHA-256, журналы и таблица истории.
- [x] Безопасный просмотр раннего коммита и возврат проверены.
- [x] Test APK собирается; lint после исправления проходит, предупреждения описаны.
- [ ] Родитель выполнил connectedDebugAndroidTest и внёс фактический результат.
- [ ] Родитель проверил все исторические APK и сохранил реальные скриншоты.
- [ ] Широкий Preview или эквивалентный широкий рендер проверен отдельно от телефона.
- [ ] После устранения замечаний обновлён README и сделан `Finish project`.

## Вопросы для защиты

1. Чем отличаются оси Alignment и Arrangement? Первая поперечная, вторая основная.
2. Почему Center может ничего не изменить? Контейнер не имеет свободного места.
3. Чем SpaceEvenly отличается от SpaceAround? У Around краевой промежуток вдвое меньше внутреннего.
4. Почему align доступен только внутри определённого scope? Его данные интерпретирует соответствующий родитель Row/Column.
5. Зачем baseline вместо выравнивания рамок текста? Разные размеры шрифта имеют разное положение основания букв.
6. Обязательно ли суммировать веса до 1? Нет, учитывается отношение положительных весов.
7. Почему нельзя повторять входной modifier? Повторяются отступы и другие эффекты цепочки, искажается контракт composable.
