package furhatos.app.cookingbot.flow

import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.state

val GreetState: State = state {

    init {
        furhat.say("I am happy to help you with cooking dinner")
        goto(Start)
    }
}