# Итоговая проверка RowColDemo

## Исправленные замечания

| Требование | Реализация | Коммит | Проверка |
|---|---|---|---|
| Рисунок 18: Small Text 32.sp, LastBaseline | BaselineDesigns.kt / LastBaselineScreen | `69c5edf` | runtime RED на 16.sp, затем GREEN; проверены реальный размер и совпадение baseline |
| Рисунок 19: Small Text 32.sp, FirstBaseline | BaselineDesigns.kt / FirstBaselineScreen | `59d63f7` | сборка, 2 baseline-теста PASS, реальный скриншот |
| Рисунок 20: Small Text 32.sp, paddingFrom | BaselineDesigns.kt / PaddingFromScreen | `3e871b0` | сборка, 3 baseline-теста PASS, baseline 80.dp, реальный скриншот |
| Финальный весовой экран 0.2/0.4/0.3 | MainActivity.kt / MainScreen | `d5895b4` | сборка app/test APK, lint, 8 Android-тестов PASS |

Каждое исправление сохранено новым содержательным коммитом; исходные коммиты не изменены. Три исправленных функции доступны и в финальном исходнике, у каждой отдельный Preview. Для этапов 27/28 до реализации зафиксированы ошибки компиляции отсутствующего нового API, а не runtime RED; runtime RED ошибки 16.sp сохранён для этапа 26.

## Финальные результаты

- `:app:assembleDebug` — BUILD SUCCESSFUL.
- `:app:assembleDebugAndroidTest` — BUILD SUCCESSFUL.
- `:app:lintDebug` — успешно; предупреждения не подавлялись.
- На Pixel_API_34 / API 34: **OK (8 tests)** через прямой `adb shell am instrument -w -r com.example.rowcoldemo.test/androidx.test.runner.AndroidJUnitRunner`.
- Пять исходных тестов проверяют финальный UI, размеры весовых слотов, входные отступы и системный inset; три новых — реальный 32.sp и положение baseline.
- После тестов Activity снова запущена, финальный весовой экран снят с эмулятора.
- JVM-задача ранее дала NO-SOURCE; отсутствие JVM-тестов не выдаётся за успешный тестовый набор.

Доказательства вне Git: `C:/AndroidProjects/_lab02_evidence/resume/row-corrections/`. В `stage26-red`, `stage26-green`, `stage27-green`, `stage28-green`, `final` находятся реальные логи, APK и доступные скриншоты. `final/build.log` и `final/instrumentation.log` подтверждают итог; manifest связывает APK/исходники и commit. Исторические 29 APK, их SHA-256, сборки и запуски находятся в `_lab02_evidence/RowColDemo`.

## Ограничения

Обычный Gradle connectedDebugAndroidTest на этом Windows-хосте не стартовал из-за кодировки кириллического пути в Java @argfile. Прохождение тестов подтверждено прямым AndroidJUnitRunner, не Gradle connected. Изолированный ASCII Gradle home доказал исправление запуска worker, но connected через него не повторялся ради экономии повторных прогонов. Системные настройки и SDK не менялись.

Wide Preview 1000 dp объявлен, но отдельно не отрендерен. На Pixel ширина ограничивается родительскими constraints. Реальные скриншоты подтверждают телефонные дизайны; попиксельное совпадение с широкими рисунками PDF не заявляется.

## Подготовка публикации

Пользователь разрешил отдельный публичный репозиторий `ZolotkoVal/RowColDemo`. Публикуются исходники, тесты, Gradle wrapper и документация; кэши, APK, local.properties, исходные PDF и ключи не включены. Финальный коммит: `Завершение лабораторной работы №2`. Фактическая публикация проверяется по удалённому HEAD отдельно, после получения авторизованного доступа.
