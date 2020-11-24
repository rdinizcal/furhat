package furhatos.app.cookingbot.flow

import furhatos.app.cookingbot.knowledgebase.chilliConCarneRecipe
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.state

val GreetState: State = state {

    init {
        furhat.say("Hi! This is a stub for greeting state.")
        goto(SelectRecipeState)
    }
}