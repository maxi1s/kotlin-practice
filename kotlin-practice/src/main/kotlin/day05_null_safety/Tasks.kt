package day05_null_safety

/*
 * ДЕНЬ 05 — Null safety (11.10, Вс, 3–4 ч)
 *
 * Тема №1 на любом собеседовании по Kotlin. Операторы: ?.  ?:  !!  as?  let  requireNotNull.
 * ЖЁСТКОЕ ПРАВИЛО ДНЯ: ни одного `!!` в этом файле. Тест проверит это (да, он читает исходник).
 * Запуск:  ./gradlew test --tests "day05_null_safety.*"
 */

data class Address(val city: String?, val street: String?)
data class User(val name: String, val address: Address?, val age: Int?)

/** Длина строки или 0, если null. Одна строка кода. */
fun lengthOrZero(s: String?): Int = TODO()

/** Первый не-null аргумент или null, если все null. */
fun firstNonNull(vararg items: String?): String? = TODO()

/** Город пользователя через цепочку безопасных вызовов. Любой null по пути -> "unknown". */
fun cityOf(user: User?): String = TODO()

/** Преобразовать в Int, если строка — корректное целое; иначе null. "42" -> 42, " 42" -> null, null -> null. */
fun parseIntOrNull(s: String?): Int? = TODO()

/** Сумма только не-null значений. [1, null, 3] -> 4. */
fun sumNotNull(numbers: List<Int?>): Int = TODO()

/**
 * Вернуть имя без null-а, или бросить IllegalArgumentException с сообщением "name is required",
 * если name == null или пустое/пробельное.
 */
fun requireName(name: String?): String = TODO()

/**
 * Описать значение через безопасный каст / smart cast:
 * String -> "String of length N", Int -> "Int: N", null -> "null", всё остальное -> "unknown".
 */
fun describe(value: Any?): String = TODO()

/**
 * Средний возраст пользователей, у которых возраст известен; если таких нет -> null.
 * [User(age=20), User(age=null), User(age=30)] -> 25.0
 */
fun averageAge(users: List<User>): Double? = TODO()

/**
 * Применить блок к значению, только если оно не null (аналог `value?.let { ... }`), вернуть
 * результат или default. Реализуй через let, не через if — цель дня освоить идиому.
 */
fun <T, R> mapOrDefault(value: T?, default: R, block: (T) -> R): R = TODO()
