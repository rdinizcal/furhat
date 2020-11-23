package furhatos.app.cookingbot

import furhatos.app.cookingbot.flow.*
import furhatos.skills.Skill
import furhatos.flow.kotlin.*

class CookingbotSkill : Skill() {
    override fun start() {
        Flow().run(Idle)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
