import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import day06.Day06

class App : CliktCommand() {
    val verbose by option().flag("--no-verbose")
    override fun run() {
        echo("Verbose mode is ${if (verbose) "on" else "off"}")
    }
}

fun main(args: Array<String>) {
    App().subcommands(
        Day06()
    ).main(args)
}
