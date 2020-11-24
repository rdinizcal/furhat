package furhatos.app.cookingbot.flow

import furhatos.app.cookingbot.knowledgebase.chilliConCarneRecipe
import furhatos.flow.kotlin.*

val SelectRecipeState: State = state {

    init {
        furhat.say("This is a stub! Selecting the Chilli con Carne Recipe")
        goto(CookState(chilliConCarneRecipe))
    }
}