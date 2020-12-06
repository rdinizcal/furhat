package furhatos.app.cookingbot.flow

import furhatos.app.cookingbot.nlu.*
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

val GreetState=state(Interaction) {
    onEntry {
        furhat.say("Hey, I'm an awesome cooking bot. I can help you find a recipe," +
                " help you cook, and also keep your meal scores." )
        furhat.ask( "Does this sound good to you?")
    }

    onResponse<Yes> {
        goto(GreetState2)
    }
    onResponse<No> {
        random(
                {furhat.say("I guess you don't need my help today then, have a nice day!")},
                {furhat.say("Have a lovely day then!")}
        )
    }
}

/*Todo
Implement these methods to move on faster.
 */
val GreetOptions = state(Interaction) {

    onResponse<CookingDesire>{
        furhat.say("hello, so you want to cook!")
        goto(Idle)
    }

    onResponse<FindRecipeDesire>{
        furhat.say("Ah, so you want to make dinner plans! Let's do it")
        goto(Idle)
    }

    onResponse<GiveRateDesire>{
        furhat.say("Okay, let's give a rating")
        goto(Idle)
    }
    onResponse<GeneralOptions> {
        furhat.say("I can do the following things: 1. Help you find a recipe. 2. Help you with cooking or 3. Rate your last meal. ")
        furhat.ask("What do you want to do?")
    }
}

val GreetState2 = state(GreetOptions) {
    onEntry {
        furhat.say("I suggest we start by looking for a recipe to you.")
        furhat.ask("Do you agree?")
    }

    onReentry {
        furhat.say("There are also other options, to hear them just say: options.")
        furhat.ask("Do you want to find a recipe?")
    }
    onResponse<Yes> {
        random(
                {furhat.say("Then let's start by finding a delicious recipe")},
                { furhat.say("I'm sure we will find a nice recipe")}
        )
        goto(Start)
    }
    onResponse<No>{
        random(
            {furhat.say("I guess I'll see you another time then!")},
            {furhat.say("Okay, have nice day!")}
        )
        goto(Idle)
    }
}








