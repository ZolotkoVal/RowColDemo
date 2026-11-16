# Матрица требований и аудит RowColDemo

## Закрытие замечаний

Ниже сохранён исторический аудит состояния `a6f817e`, а не актуальный список блокеров. Все 29 исторических APK позднее запущены на Pixel_API_34 (`device-results.json`, 29 PASS). Замечания 26–28 закрыты новыми коммитами `69c5edf`, `59d63f7`, `3e871b0`: Small Text явно 32.sp, проверены фактические First/LastBaseline и отступ 80.dp. `d5895b4` возвращает финальный весовой MainScreen. Сборка и все 8 Android-тестов успешны; доказательства и ограничения — `VERIFICATION.md`. Старые коммиты и manifest намеренно не переписаны.

## Срез и метод проверки

Аудит 16 ноября 2026 года для `a6f817efd4a7f0f182d59b53687d26185d082922`, ветка master: **30 коммитов**. Прочитаны AGENTS.md, TASK_02.md, LAB_02_PLAN.md, полный текст и растровые страницы 1–13 `C:/AndroidProjects/_course_materials/Row and Column.pdf`, исходники каждого исторического дизайна и оба файла Android-тестов. Сопоставлены содержательные изменения всех коммитов, а не только их названия.

Новых сборок/запусков устройства этот аудит не выполнял. Ниже «архив PASS» означает существующий stage-лог с `BUILD SUCCESSFUL`, отсутствие `BUILD FAILED`, `build_exit_code = 0` в manifest и совпавший пересчитанный SHA-256 APK. Это НЕ результат UI-проверки и не повторная сборка текущего дерева.

Корень доказательств: `C:/AndroidProjects/_lab02_evidence/RowColDemo/`. Для этапа NN используются `apks/NN.apk`, `logs/NN-assembleDebug.log` и запись NN в `manifest.json`. Все 29 записей, 29 хешей APK и 29 commit/title проверены; все совпали. В manifest **0 из 29** имеют `ui_verified = true`. Для нового UI-прогона сохранять коммит, SHA-256 установленного APK, устройство/размер/density/fontScale, действие, результат и путь реального скриншота; не менять старые результаты задним числом.

## Все этапы и дизайны

Реализация всех макетов: `app/src/main/java/com/example/rowcoldemo/MainActivity.kt` в указанном коммите. Package/minSdk дополнительно: `app/build.gradle.kts`; запуск: `app/src/main/AndroidManifest.xml`. Все строки имеют архив PASS по правилу выше; **UI каждой строки остаётся неподтверждённым в обследованном manifest**. Названия коммитов приведены точно.

| NN | PDF: страницы, рисунок / требование | Коммит и точное название | Сверено в исходнике / замечание |
|---|---|---|---|
| 01 | с. 1, новый Empty Activity, package, API 27 | `b0c971b` Create RowColDemo Empty Activity | Независимый проект, Greeting, Scaffold; minSdk 27 |
| 02 | с. 1–2, MainScreen + TextCell | `8565057` Introduce MainScreen and TextCell | Пустой Box(modifier); ячейка padding 4 dp, size 100×100 dp, border 4 dp, 80 sp Bold/Center |
| 03 | с. 2, рис. 1 | `9191223` Arrange cells in Row | Row: 1, 2, 3 |
| 04 | с. 2, рис. 2 | `77bbc27` Arrange cells in Column | Column: 1, 2, 3 |
| 05 | с. 2–3, рис. 3 | `0cb9b3b` Nest Row and Column into eleven-cell grid | Столбцы 1/2/3, 4/5/6, 7/8; нижний Row 9/10/11; пустота под 8 |
| 06 | с. 3–4, рис. 4 | `53484f7` Size Row container to 400 by 200 dp | Row 400×200 dp, default Top/Start |
| 07 | с. 4, рис. 5 | `06fd5a0` Center Row children vertically | CenterVertically, Row 400×200 dp |
| 08 | с. 4, список Alignment | `17479b7` Align Row children at bottom | Bottom, отдельная демонстрация альтернативы |
| 09 | с. 4–5, список Alignment | `b033a3c` Align Column children at start | Start, Column width 250 dp |
| 10 | с. 4–5, список Alignment | `144c5c2` Center Column children horizontally | CenterHorizontally, width 250 dp |
| 11 | с. 5, рис. 6 | `8dec1f5` Align Column children at end | End, width 250 dp |
| 12 | с. 5, схема 7 Start | `5052361` Arrange Row children at start | horizontalArrangement Start, 400×200 dp |
| 13 | с. 5, схема 7 Center | `9940a0b` Arrange Row children at center | horizontalArrangement Center, 400×200 dp |
| 14 | с. 5–6, схема 7 End / рис. 9 | `2f06b83` Arrange Row children at end | horizontalArrangement End, 400×200 dp |
| 15 | с. 6, схема 8 Top | `f178799` Arrange Column children at top | verticalArrangement Top, height 400 dp |
| 16 | с. 6, схема 8 Center | `419d570` Arrange Column children at center | verticalArrangement Center, height 400 dp |
| 17 | с. 6–7, схема 8 Bottom / рис. 10 | `50397de` Arrange Column children at bottom | verticalArrangement Bottom, height 400 dp |
| 18 | с. 7, рис. 11 | `11fdfd2` Space Row children evenly | SpaceEvenly, width 1000 dp |
| 19 | с. 7, рис. 12 | `e784f4b` Space Row children between edges | SpaceBetween, width 1000 dp |
| 20 | с. 7–8, рис. 13 | `1169eef` Space Row children around | SpaceAround, width 1000 dp |
| 21 | с. 8–9, scope / рис. 15 | `ae6da25` Align individual Row children with scoped modifiers | Row height 300 dp; Top/CenterVertically/Bottom для детей |
| 22 | с. 8, список ColumnScope | `8dde83a` Align individual Column children | Дополнительная демонстрация align Start/CenterHorizontally/End, width 300 dp |
| 23 | с. 9–10, рис. 16 | `2b4b85a` Show mixed-size text without baseline alignment | Large Text 40 sp, Small Text 32 sp, оба Bold, без baseline |
| 24 | с. 10, рис. 17 | `870e9c0` Align text by baseline | Оба alignByBaseline, 40/32 sp |
| 25 | с. 10, альтернативная запись | `6c7ab7b` Use explicit FirstBaseline alignment | Оба alignBy(FirstBaseline), 40/32 sp |
| 26 | с. 10–11, рис. 18 | `401c9f8` Align multiline text by LastBaseline | Большой текст с двумя \n, LastBaseline; малый alignByBaseline; **отсутствует 32.sp — отклонение D1** |
| 27 | с. 11, рис. 19 | `1ddccd6` Align multiline text by FirstBaseline | Большой FirstBaseline; малый alignByBaseline; **D1 сохраняется** |
| 28 | с. 11–12, рис. 20 | `6490d4e` Offset text using paddingFrom FirstBaseline | Малый paddingFrom(FirstBaseline, before=80.dp, after=0.dp), без alignByBaseline; **D1 сохраняется** |
| 29 | с. 12, рис. 21 | `475157c` Distribute Row width using weights | Row, веса 0.2f/0.4f/0.3f, fill=true; добавлены Android-тесты |

Рисунок 14 (с. 8) показывает подсказку `this: RowScope` в редакторе, а не отдельный runtime-дизайн. Применение scope видно в этапах 21/24/29; наличие IDE-подсказки в текущей Android Studio отдельно не проверялось. С. 13 — резюме, новых дизайнов нет. Перечисленные в тексте ColumnScope.alignBy/weight объяснены в THEORY.md; лекция не задаёт для них отдельного кодового дизайна, дополнительных обязательных скриншотов не выдумываем.

**Коммит 30:** `a6f817e` — `Document lecture stages and prepare UI acceptance tests`: README, дополнение STAGES, усиление проверки inset в MainActivityTest. Основной экран не изменён относительно этапа 29. Отдельного APK в stage-manifest для него нет; текущий тестовый код нельзя считать проверенным только по этапу 29. `handoff-checks.log` подтверждает архивную сборку тестового APK, но не его выполнение.

## Журналы финальных проверок

| Файл в каталоге logs | Фактическое содержимое | Вывод |
|---|---|---|
| `01-assembleDebug.log` … `29-assembleDebug.log` | Каждый BUILD SUCCESSFUL; соответствующий manifest exit 0 | Все учебные этапы ранее собирались; UI не доказан |
| `final-checks.log` | test APK собран; testDebugUnitTest NO-SOURCE; lint PropertyEscape; BUILD FAILED | Неуспешный общий прогон |
| `final-checks-pass.log` | lintDebug FAILED, PropertyEscape; BUILD FAILED | Название «pass» вводит в заблуждение; НЕ PASS |
| `lint-rerun.log` | lintDebug; BUILD SUCCESSFUL; 27 executed | Архивный повтор lint успешен |
| `history-detached-build.log` | assembleDebug; BUILD SUCCESSFUL | Архивная сборка раннего дизайна |
| `history-restored-build.log` | app/test APK; testDebugUnitTest NO-SOURCE; BUILD SUCCESSFUL | Архивная сборка после возврата |
| `handoff-checks.log` | assembleDebug, assembleDebugAndroidTest, lintDebug; BUILD SUCCESSFUL; JVM NO-SOURCE | Сборка/статический анализ, НЕ прохождение Android-тестов |

Существующий `app/build/reports/lint-results-debug.txt`: **0 errors, 7 warnings** — пять GradleDependency, один DataExtractionRules, один MissingApplicationIcon. Это состояние отчёта на чтение, не свежий lint аудита; папка build может обновляться последующими сборками родителя. Первый PropertyEscape относится к исключённому из Git local.properties, не к ошибке Row/Column.

Reflog подтверждает прежний переход `master → 9191223 → master`: восстановленный HEAD был `475157c`, затем появился `a6f817e`. Нового checkout не было. На входе аудита status был чистым; документальные правки сознательно оставлены незакоммиченными. Remote отсутствует. История не переписывалась.

## Замечания и ограничения

### D1 — несоответствие трёх лекционных дизайнов (блокирует заявление «всё совпадает»)

На изображении страницы 10 в примере LastBaseline у Small Text есть **`fontSize = 32.sp`**; на странице 11 это есть и в paddingFrom. Строка светлее соседнего выделенного кода, но не зачёркнута и не является комментарием. Вариант FirstBaseline изменяет только линию большого текста и сохраняет размер малого. Извлечение PDF через read_file пропустило эту строку, поэтому одного текстового слоя недостаточно.

В `401c9f8`, `1ddccd6`, `6490d4e` размер не указан. Архивные APK этих коммитов нельзя объявить точными повторениями рисунков 18–20. Документальное объяснение исправлено; исходники по поручению не изменялись. Родителю нужно исправить/согласовать отклонение, сохранить содержательную корректирующую историю и отдельные новые build/UI-доказательства без подмены старых APK/хешей. Финальный weight-дизайн не содержит Small Text и сам по себе D1 не устраняет.

### Остальные границы доказательств

- UI: manifest содержит только false; в обследованном каталоге RowColDemo были APK/логи/manifest, но не UI-скриншоты. Новые проверки родителя не включены в данный срез.
- Пять Android-тестов существуют, но нет подтверждённого запуска в обследованных логах. NO-SOURCE — отсутствие JVM-тестов. Сборка test APK не равна выполнению тестов.
- Тесты покрывают только финальные веса, modifier и inset; не сетку 1–11, интервалы, baseline, цвет/толщину рамки или соответствие всех рисунков. assertIsDisplayed не гарантирует отсутствие обрезанного глифа; проверка границ не заменяет скриншот.
- «Тесты написаны раньше кода» нельзя доказать общим коммитом; документально RED/GREEN не подтверждён.
- Размеры 400/1000 dp ограничиваются родителем. На телефоне нельзя требовать пиксельного совпадения широких рисунков; Wide Preview объявлен, но факт рендера отдельно не подтверждён.
- Входной modifier применяется один раз вместо повторного then(modifier) из PDF; Scaffold innerPadding сохранён. Это осмысленные исправления ошибок лекции, а не пропущенные дизайны. Box на этапе 02 сохраняет входной modifier при пустом экране. Тема RowColDemoTheme исправляет опечатку StringsDemoTheme.
- Отдельные этапы из перечислений Alignment/Arrangement и ColumnScope.align расширяют минимальные иллюстрации; они не подменяют обязательные дизайны.

## Важные UI-проверки для родителя

Проверить все архивные этапы, сохраняя фактические результаты; приоритетные группы:

1. **01–02:** Activity стартует без падения; приветствие на 01 и ожидаемо пустой MainScreen на 02. Пустоту не считать потерей ячеек.
2. **03–05 / рисунки 1–3:** порядок Row/Column; сетка по строкам `1 4 7 / 2 5 8 / 3 6 [пусто] / 9 10 11`. Проверить целиком двузначные 10/11, рамки и отсутствие переноса/обрезки.
3. **06–11 / рисунки 4–6:** выделенная область 400×200 и Column 250 dp; Top/Center/Bottom, Start/Center/End. Сравнивать положение относительно контейнера, не экрана; проверить доступную ширину телефона.
4. **12–17 / схемы 7–8, рисунки 9–10:** группа из трёх ячеек перемещается целиком; размеры/внутренние зазоры не меняются. Column высотой 400 dp.
5. **18–20 / рисунки 11–13:** широкий рендер 1000 dp и телефон отдельно. Сравнить свободные интервалы между внешними слотами: Evenly — все равны, Between — крайних нет, Around — края вдвое меньше внутренних. Не путать 4 dp padding ячейки со свободным интервалом Arrangement.
6. **21–22 / рисунок 15:** индивидуальное выравнивание 1/2/3 ступенькой; Row высотой 300 dp и Column шириной 300 dp. Различать направление потока и ось align.
7. **23–25 / рисунки 16–17:** 40/32 sp; сначала несовпадающие основания букв, затем совпадающие первые baseline; alignByBaseline и FirstBaseline визуально эквивалентны. Нужна достаточная ширина, чтобы случайный перенос не изменил сравнение.
8. **26–28 / рисунки 18–20, D1:** Small Text должен иметь 32 sp в исправленных вариантах. В 26 baseline рядом с More Text, в 27 рядом с Large Text, в 28 отступ от верхней границы малого элемента до первой линии 80 dp при достаточных constraints. after=0 не означает отсутствие нижней части глифа. Сравнить архивные и исправленные варианты, не помечать старые как исправленные.
9. **29 / рисунок 21:** все цифры целиком; отношение выделенных слотов 2:4:3, а не 20/40/30% экрана. Учитывать padding при измерении рамки. Запустить пять Android-тестов текущего состояния; сохранить отчёт с числом выполненных/упавших/пропущенных.
10. **Общее:** inset сверху применяется однократно, контент не перекрывает системные панели. Зафиксировать доступный размер, density/fontScale; широкий рендер не заменяет реальный запуск телефона. Изменять системные настройки не требуется и не разрешено этим аудитом.

Завершение возможно только после решения D1 и документированной приёмки. Разрешённое название будущего финального коммита: `Завершение лабораторной работы №2`; этот аудит коммитов не создаёт.
