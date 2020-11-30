package furhatos.app.cookingbot.flow

import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onUserLeave
import furhatos.flow.kotlin.state

import furhatos.flow.kotlin.*
import furhatos.nlu.common.Goodbye
import furhatos.skills.UserManager
import furhatos.util.Language

import furhatos.nlu.common.*
import furhatos.flow.kotlin.*
import furhatos.app.cookingbot.nlu.*

val Start = state(Interaction) {
    onEntry {
        random(
                {   furhat.say("Hi there") },
                {   furhat.say("Oh, hello there") }
        )

        goto(AskForPlans)
    }
}

val Options = state(Interaction) {
    onResponse<FindRecipe> {
        val recipe = it.intent.recipe
        if (recipe != null) {
            //furhat.ask("Nice, let's make $recipe")
            goto(RecipeDecided(recipe))
        } else {
            propagate()
        }
        //if (fruits != null) {
        //    goto(OrderReceived(fruits))
        //} else {
        //    propagate()
        //}
    }

    onResponse<RequestOptions> {
        furhat.say("We can make ${Recipe().optionsToText()}")
        furhat.ask("What would you like to make?")
    }
}
/*
    onResponse<RequestOptions> {
        furhat.say("We have ${Fruit().optionsToText()}")
        furhat.ask("Do you want some?")
    }

    onResponse<Yes> {
        random(
                { furhat.ask("What kind of fruit do you want?") },
                { furhat.ask("What type of fruit?") }
        )
    }
}
*/

val AskForPlans = state(Options) {
    onEntry {
        random(
                { furhat.ask("Do you need help with cooking tonight?") },
                { furhat.ask("Would you like to make dinner plans?") }
        )
    }
    onResponse<Yes> {

        goto(LookForRecipe)
    }

    onResponse<No> {
        furhat.say("Okay, that's a shame. Maybe tomorrow then!")
        goto(Idle)
    }
}


val LookForRecipe = state(Options) {
    onEntry {
        random(
                { furhat.ask("What recipe do you want to use?") },
                { furhat.ask("What are we having for dinner?") }
        )
    }

    onResponse<Yes> {
        random(
                { furhat.ask("What recipe do you want to use?") },
                { furhat.ask("What are we having for dinner?") }
        )
    }

    onResponse<No> {
        furhat.say("Okay, that's a shame. Maybe tomorrow then!")
        goto(Idle)
    }
}

/*
val TakingOrder = state {
    onEntry {
        random(
                { furhat.ask("How about some fruits?") },
                { furhat.ask("Do you want some fruits?") }
        )
    }

    onResponse<Yes> {
        random(
                { furhat.ask("What kind of fruit do you want?") },
                { furhat.ask("What type of fruit?") }
        )
    }

    onResponse<No> {
        furhat.say("Okay, that's a shame. Have a splendid day!")
        goto(Idle)
    }
}
*/

fun RecipeDecided(recipe: Recipe) : State = state(Options) {
    onEntry {
        furhat.say("${recipe.text}, what a nice dish?")
        furhat.ask("Do you want to make ${recipe.text} tonight?")
    }
    onReentry {
        furhat.ask("Do you want to make ${recipe.text} tonight?")
    }
    onResponse<No> {
        furhat.say("That makes me sad, see you another time!")
        goto(Idle)
    }
    onResponse<Yes> {
        furhat.say("Let's check that we have all of the ingredients")
    }
}

/*
fun OrderReceived(fruits: FruitList) : State = state(Options) {
    onEntry {
        furhat.say("${fruits.text}, what a lovely choice!")
        fruits.list.forEach {
            users.current.order.fruits.list.add(it)
        }
        furhat.ask("Anything else?")
    }

    onReentry {
        furhat.ask("Did you want something else?")
    }

    onResponse<No> {
        furhat.say("Okay, here is your order of ${users.current.order.fruits}. Have a great day!")
    }
}
*/


