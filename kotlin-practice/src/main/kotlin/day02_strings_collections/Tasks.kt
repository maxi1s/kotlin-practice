package day02_strings_collections

/*
 * ДЕНЬ 02 — Строки и базовые коллекции (07.10, Ср, 1,5–2 ч)
 *
 * Из твоих заметок: путал MutableList (ТИП) и mutableListOf() (ФУНКЦИЯ-фабрика),
 * Pair и Array. Сегодня это проверяем в бою.
 * Запуск:  ./gradlew test --tests "day02_strings_collections.*"
 */

/** Палиндром без учёта регистра и всего, что не буква/цифра: "A man, a plan, a canal: Panama" -> true. */
fun isPalindrome(s: String): Boolean = TODO()

/**
 * Подсчёт слов. Слова разделены пробелами (любым количеством), регистр не важен.
 * "the cat and The dog" -> {"the"=2, "cat"=1, "and"=1, "dog"=1}
 */
fun countWords(text: String): Map<String, Int> = TODO()

/** Второе по величине УНИКАЛЬНОЕ число. [5, 5, 3] -> 3; [7] -> null; [] -> null. */
fun secondLargest(numbers: List<Int>): Int? = TODO()

/** Каждое слово с заглавной: "hello  big world" -> "Hello  Big World" (пробелы сохранить как есть). */
fun capitalizeWords(s: String): String = TODO()

/**
 * Слить два ОТСОРТИРОВАННЫХ списка в один отсортированный за один проход (два указателя).
 * Без sorted() — это проверка на алгоритм, а не на знание библиотеки.
 */
fun mergeSorted(a: List<Int>, b: List<Int>): List<Int> = TODO()

/** RLE-сжатие: "aaabbc" -> "a3b2c1", "" -> "". */
fun compress(s: String): String = TODO()

/**
 * Вернуть НОВЫЙ список: элементы исходного без дубликатов, порядок первого появления сохранён.
 * Исходный список менять нельзя (тест это проверит).
 */
fun distinctPreservingOrder(items: List<String>): List<String> = TODO()

/**
 * Разбить список на пары (первый, последний), (второй, предпоследний)...
 * [1,2,3,4] -> [(1,4), (2,3)]; при нечётной длине средний элемент отбрасывается: [1,2,3] -> [(1,3)].
 */
fun pairEnds(items: List<Int>): List<Pair<Int, Int>> = TODO()
