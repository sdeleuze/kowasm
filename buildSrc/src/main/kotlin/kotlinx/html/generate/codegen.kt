package kotlinx.html.generate

import java.util.*

interface Const<T>
data class StringConst(val value: String) : Const<String>
data class ReferenceConst(val propertyName: String) : Const<Any>

val Const<*>.asFieldPart: String
    get() = when (this) {
        is StringConst -> value.humanize()
        is ReferenceConst -> propertyName
        else -> throw UnsupportedOperationException("Value $this of type ${javaClass.name} is not supported")
    }

val Const<*>.asValue: String
    get() = when (this) {
        is StringConst -> value.quote()
        is ReferenceConst -> propertyName
        else -> throw UnsupportedOperationException("Value $this of type ${javaClass.name} is not supported")
    }

fun Appendable.packg(name: String) {
    append("package ")
    append(name)
    append("\n")
}

fun Appendable.import(name: String) {
    append("import ")
    append(name)
    append("\n")
}

fun Appendable.doNotEditWarning() {
    append("/")
    append("*".repeat(79))
    appendLine()
    append("    DO NOT EDIT")
    appendLine()
    append("    This file was generated by module generate")
    appendLine()
    append("*".repeat(79))
    append("/")
}

fun Appendable.const(value: Const<*>) {
    append(value.asValue)
}

data class Var(
    val name: String,
    val type: String,
    val mutable: Boolean = false,
    val override: Boolean = false,
    val forceOmitValVar: Boolean = false,
    val defaultValue: String = ""
)

data class Clazz(
    val name: String,
    val parameters: List<String> = listOf(),
    val variables: List<Var> = listOf(),
    val parents: List<String> = listOf(),
    val isPublic: Boolean = true,
    val isAbstract: Boolean = false,
    val isOpen: Boolean = false,
    val isObject: Boolean = false,
    val isInterface: Boolean = false
)

fun Appendable.variable(variable: Var, omitValVar: Boolean = false, receiver: String = "") {
    if (!omitValVar && !variable.forceOmitValVar) {
        if (variable.override) {
            append("override ")
        }
        append(if (variable.mutable) "var " else "val ")
    }

    if (receiver.isNotEmpty()) {
        receiverDot(receiver)
    }
    append(variable.name)
    append(" : ")
    append(variable.type)

    if (variable.defaultValue.isNotEmpty()) {
        append(" = ")
        append(variable.defaultValue)
    }
}

fun Appendable.enumEntry(name: String, deprecated: String?, arguments: List<String>) {
    if (deprecated != null) {
        append("@")
        functionCall("Deprecated", listOf(deprecated.quote()))
        append(" ")
    }
    append(name)
    if (arguments.isNotEmpty()) {
        arguments.joinTo(this, ", ", "(", ")")
    }
}

fun Appendable.delegateBy(expression: String) {
    append(" by ")
    append(expression)
    emptyLine()
}

fun <O : Appendable> O.getter(): O {
    append("    get() ")
    return this
}

fun <O : Appendable> O.setter(block: O.() -> Unit): O {
    append("    set(newValue) {")
    block()
    append("}\n")

    return this
}

fun <O : Appendable> O.clazz(clazz: Clazz, block: O.() -> Unit): O {
    val tokens = ArrayList<String>()
    if (clazz.isPublic) {
        //tokens.add("public") // TODO we need to check !isPublic
    }
    if (clazz.isAbstract) {
        tokens.add("abstract")
    }
    if (clazz.isOpen) {
        tokens.add("open")
    }

    tokens.add(
        when {
            clazz.isObject -> "object"
            clazz.isInterface -> "interface"
            else -> "class"
        }
    )
    tokens.add(clazz.name)
    tokens.joinTo(this, " ")

    if (clazz.parameters.isNotEmpty()) {
        clazz.parameters.joinTo(this, ", ", "<", ">")
    }
    if (clazz.variables.isNotEmpty()) {
        append("(")
        clazz.variables.forEachIndexed { i, p ->
            if (i != 0) {
                append(", ")
            }
            variable(p)
        }
        append(")")
    }

    if (clazz.parents.isNotEmpty()) {
        clazz.parents.joinTo(this, ", ", " : ")
    }

    append(" {\n")
    block()
    append("}\n")

    return this
}

fun Appendable.functionCall(name: String, arguments: List<CharSequence>) {
    append(name)
    arguments.joinTo(this, ", ", "(", ")")
}

fun Appendable.functionCallConsts(name: String, arguments: List<Const<*>>) {
    functionCall(name, arguments.map { it.asValue })
}

fun Appendable.function(
    name: String,
    arguments: List<Var> = emptyList(),
    returnType: String = "Unit",
    generics: List<String> = emptyList(),
    receiver: String = "",
    modifiers: List<String> = emptyList()
) {
    (modifiers + "fun").joinTo(this, separator = " ", postfix = " ")

    if (generics.isNotEmpty()) {
        generics.joinTo(this, ", ", "<", "> ")
    }

    if (receiver.isNotEmpty()) {
        receiverDot(receiver)
    }

    append(name)
    append("(")
    arguments.forEachIndexed { i, p ->
        if (i != 0) {
            append(", ")
        }
        variable(p, true)
    }
    append(")")

    if (returnType.isNotEmpty()) {
        append(" : ")
        append(returnType)
    }
}

fun Appendable.receiverDot(receiver: String) {
    append(receiver)
    append('.')
}

fun <O : Appendable> O.blockShort(block: O.() -> Unit): O = with {
    append("{ ")
    block()
    append(" }\n")
}

fun <O : Appendable> O.block(block: O.() -> Unit): O {
    append(" {\n")
    block()
    append("}\n")

    return this
}

fun <O : Appendable> O.defineIs(expression: CharSequence): O {
    append(" = ")
    append(expression)
    append("\n")

    return this
}

fun Appendable.emptyLine() {
    appendLine()
}

fun <T> T.with(block: T.() -> Unit): T {
    block()
    return this
}

fun Appendable.deprecated(message: String) {
    append("@")
    functionCall("Deprecated", listOf(message.quote()))
    append("\n")
}

fun Appendable.suppress(vararg warnings: String) {
    append("@")
    functionCall("Suppress", warnings.map { it.quote() })
    append("\n")
}