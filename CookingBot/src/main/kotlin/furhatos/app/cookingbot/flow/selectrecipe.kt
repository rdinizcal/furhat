

package furhatos.app.cookingbot.flow

import furhatos.app.cookingbot.knowledgebase.*
import furhatos.flow.kotlin.*
import furhatos.app.cookingbot.nlu.*
import furhatos.nlu.common.*
import furhatos.snippets.noRepeat

val Start = state(Interaction) {
    onEntry {
        random(
                {   furhat.say("Hi there") },
                {   furhat.say("Oh, hello there") }
        )

        goto(TakingOrder)
    }
}

val Options = state(Interaction) {
    onResponse<orderrecipe> {
        val recipes = it.intent.recipes
        if (recipes != null) {
            goto(orderReceived(recipes))
        }
        else {
            propagate()
        }
    }

    onResponse<RequestOptions> {
        //furhat.ask("Would you like some?")
//        furhat.say("I would suggest Spaghetti) // ${Recipe3().optionsToText()}")
        furhat.say("I would suggest Spaghetti")
        furhat.ask("What do you prefer?")
    }

    onResponse<Yes> {
        //furhat.say("We have ${Recipesr().optionsToText()} recipes.")
        //furhat.say("${Recipe1().optionsToText()}.")
        //furhat.say("${Recipe2().optionsToText()}.")
        random(
                { furhat.say("We have Chilli con, Spaghetti, Baked falafel, scrambled eggs, and French toast.")},
                { furhat.say("We have 5 recipes") }
        )
        random(
                { furhat.ask("Which of these foods would you make?") },
                { furhat.ask("What is your choice?") }
        )
    }
    onResponseFailed { random(
            { furhat.ask("Which of these foods would you make?") },
            { furhat.ask("What is your choice?") }
    )
    }
}

val TakingOrder = state(Options) {
    onEntry {
        random(
                { furhat.ask("Would you like to cook") },
                { furhat.ask("Do you want recipe?") }
        )
    }


    onResponse<No> {
        furhat.say("Okay. Good luck!")
        goto(Idle)
    }
}

fun orderReceived(recipes: recipeList1) : State = state(Options) {
    onEntry {
        furhat.say("Great! Selecting the ${recipes.toText()} Recipe")
        if("${recipes.toText()}"=="Chilli con"){
            goto(CookState(chilliConCarneRecipe))}
        if ("${recipes.toText()}"=="Baked falafel"){
            goto(CookState(BakedfalafelRecipe))}
        if ("${recipes.toText()}"=="scrambled eggs"){
            goto(CookState(PerfectscrambledeggsRecipe))}
        if ("${recipes.toText()}"=="Spaghetti"){
            goto(CookState(spaghettiRecipe))}
        if ("${recipes.toText()}"=="French toast"){
            goto(CookState(FrenchToastRecipe))}

    }

    onReentry {
        furhat.ask("Do you want something else?")
    }

    onResponse<No> {
        furhat.say("Thanks for your attention. Have a nice cooking")
    }

}
