package tk.pshub.random.command

import com.github.noonmaru.tap.command.ArgumentList
import com.github.noonmaru.tap.command.CommandComponent
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import java.lang.NumberFormatException
import javax.print.attribute.IntegerSyntax
import kotlin.random.Random

class RandomCommand:CommandComponent {
    override fun onCommand(sender: CommandSender, label: String, componentLabel: String, arg: ArgumentList): Boolean {
        var argsCount = 0
        var min: Int
        var max: Int
        var cmd: String
        var args = arg.joinToString(" ").split(" ")
        if (args.size >= 3) {
            if (isNumber(args[0]) && isNumber(args[1])) {
                min = Integer.parseInt(args[0])
                max = Integer.parseInt(args[1])
                var cmdArray = ArrayList<String>()
                var idx = 0
                args.forEach {
                    idx++
                    if (idx > 2) {
                        cmdArray.add(it)
                    }
                }
                cmd = cmdArray.joinToString(" ")
                var rand = Random.nextInt(max - min + 1) + min
                Bukkit.getServer().dispatchCommand(sender, cmd.replace("%rand%", rand.toString()))
            } else {
                sender.sendMessage("min과 max가 숫자가 아닙니다.")
            }
        } else {
            sender.sendMessage("명령어 사용법: /random random <min> <max> <command> - %rand%를 붙이면 랜덤으로 생성된 숫자로 치환되어 실행됩니다.")
        }
        return true
    }
    private fun isNumber(str:String): Boolean {
        return try {
            Integer.parseInt(str)
            true
        } catch (e:NumberFormatException) {
            false
        }
    }
}