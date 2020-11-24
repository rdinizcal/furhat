package furhatos.app.cookingbot.flow

import furhatos.app.cookingbot.knowledgebase.*
import furhatos.app.cookingbot.nlu.*
import furhatos.nlu.common.*
import furhatos.flow.kotlin.*

var currentStep : Step = Step(0,"")

fun CookState(recipeDesc: RecipeDesc): State = state {

    init {
        furhat.say("Lets cook!")
        currentStep = recipeDesc.steps[0]
        call(ReadStepState(currentStep))
        furhat.ask("", timeout = 99999999)
    }

    // Can you repeat?
    onResponse<RequestRepeat>{
        furhat.say("Yes, sure!")
        call(ReadStepState(currentStep))
        furhat.ask("", timeout = 99999999)
    }

    // Can you go to Step X?

    // Previous Step
    onResponse<PreviousStep>{
        currentStep = recipeDesc.steps[currentStep.id-1]
        call(ReadStepState(currentStep))
        furhat.ask("", timeout = 99999999)
    }

    // Next Step
    onResponse<NextStep>{
        currentStep = recipeDesc.steps[currentStep.id+1]
        call(ReadStepState(currentStep))
        furhat.ask("", timeout = 99999999)
    }
    // Do something when the user steps back in, ask if the user wants to read the step again
    /*
    onResponse<Done>{
        goto(RateState)
    }
    */
}

fun ReadStepState(step:Step): State = state {

    onEntry {
        furhat.say("Step " + (currentStep.id+1).toString() )
        furhat.say(currentStep.body)
        // Shall we include the tips here? Furhat offers tips for specific step
        terminate()
    }

}