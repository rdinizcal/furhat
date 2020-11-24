package furhatos.app.cookingbot.flow

import furhatos.app.cookingbot.knowledgebase.chilliConCarneRecipe
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.state

val RateState: State = state {

    init {
        furhat.say("This is a Stub for rate state")
    }
}