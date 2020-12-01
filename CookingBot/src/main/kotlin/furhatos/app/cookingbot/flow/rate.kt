/**
 * @author: shamisa.shoja@liu.se
 */
package furhatos.app.cookingbot.flow

import furhatos.app.cookingbot.knowledgebase.chilliConCarneRecipe
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.gestures.Gestures
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes


val CookingDone: State = state {
    onEntry {
        furhat.say("Your dinner is ready!")
        furhat.ask("Do you want to rate your food?")
    }


    onResponse<No> {
        furhat.gesture(Gestures.Smile)
        furhat.say("Okay. Enjoy your dinner!")
    }

    onResponse <Yes> {
        furhat.gesture(Gestures.Nod)
        goto(RateState1)
    }
}


val RateState1: State = state {

    init {
        furhat.ask("Did you like your dinner?")
    }

    onResponse<No> {
        furhat.gesture(Gestures.Shake)
        random(
                {furhat.say("Oh, sorry to hear. Hope you enjoy your dinner next time!")},
                {furhat.say("hmm, sad to hear")}
        )
        goto(Idle)
    }

    onResponse<Yes> {
        furhat.gesture(Gestures.Smile)
        random(
                {furhat.say("Great, glad to hear!")},
                {furhat.say("Happy to hear!")},
                {furhat.say("Cool!")}
        )
        goto(Idle)
    }

}