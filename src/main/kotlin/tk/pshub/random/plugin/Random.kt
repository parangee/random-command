package tk.pshub.random.plugin

import com.github.noonmaru.tap.command.command
import org.bukkit.plugin.java.JavaPlugin
import tk.pshub.random.command.RandomCommand

class Random:JavaPlugin() {
    override fun onEnable() {
        registerCommand()
    }
    private fun registerCommand() {
        command("random") {
            help("help")
            component("random") {
                description = "랜덤 값을 커맨드에 포함해서 명령어를 실행합니다. %rand%는 랜덤으로 생성된 숫자로 치환되어 실행됩니다"
                usage = "<min> <max> <command>"
                RandomCommand()
            }
        }
    }
}