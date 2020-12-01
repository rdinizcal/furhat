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
        furhat.say("Step " + (currentStep.id+1).toString() )
        furhat.say(currentStep.body)
        furhat.ask("Can we proceed?")
    }

    // Can you repeat?
    onResponse<RequestRepeat> {
        furhat.say("Yes, sure!")
        furhat.say("Step " + (currentStep.id + 1).toString())
        furhat.say(currentStep.body)
        random(
                { furhat.ask("Can we proceed?") },
                { furhat.ask("Shall we continue?") }
        )
    }

    onResponse<RequestFinished> {
        random(
                { furhat.ask("Of course! Good bye") },
                { furhat.ask("OK! Good night") }
        )
        goto(Idle)
    }

    onResponse<No>{
        random(
                { furhat.ask("Do you want me to repeat, go to previous or next step? ") },
                { furhat.ask("Should I repeat, go to next or previous step?") }
        )
    }

    // Can you go to Step X?
    onResponse<OtherStep> {
        var intCount : Int = it.intent.count?.value!!

        if (intCount-1 == recipeDesc.steps.size) {
            goto(CookingDone)
        } else if (intCount-1 > recipeDesc.steps.size){
            goto(CheckDone(recipeDesc))
        } else {
            currentStep = recipeDesc.steps[intCount-1]
            furhat.say("Step " + (currentStep.id+1).toString() )
            furhat.say(currentStep.body)
            random(
                    { furhat.ask("Can we proceed?") },
                    { furhat.ask("Shall we continue?") }
            )
        }
    }

    // Previous Step
    onResponse<PreviousStep>{
        if (currentStep.id-1 > 0) {
            currentStep = recipeDesc.steps[currentStep.id-1]
        }
        furhat.say("Step " + (currentStep.id+1).toString() )
        furhat.say(currentStep.body)
//        furhat.ask("Can we proceed?")
        random(
                { furhat.ask("Can we proceed?") },
                { furhat.ask("Shall we continue?") }
        )
    }

    onResponse<Yes>{
        if (currentStep.id+1 == recipeDesc.steps.size) {
            goto(CookingDone)

        } else if (currentStep.id+1 > recipeDesc.steps.size){
            goto(CheckDone(recipeDesc))
        } else {
            currentStep = recipeDesc.steps[currentStep.id + 1]
            furhat.say("Step " + (currentStep.id + 1).toString())
            furhat.say(currentStep.body)
//            furhat.ask("Can we proceed?")
            random(
                    { furhat.ask("Can we proceed?") },
                    { furhat.ask("Shall we continue?") }
            )
        }
    }

    // Next Step
    onResponse<NextStep>{
        if (currentStep.id+1 == recipeDesc.steps.size) {
            goto(CookingDone)
        } else if (currentStep.id+1 > recipeDesc.steps.size){
            goto(CheckDone(recipeDesc))
        } else {
            currentStep = recipeDesc.steps[currentStep.id + 1]
            furhat.say("Step " + (currentStep.id + 1).toString())
            furhat.say(currentStep.body)
//            furhat.ask("Can we proceed?")
            random(
                    { furhat.ask("Can we proceed?") },
                    { furhat.ask("Shall we continue?") }
            )
        }
    }
    // Do something when the user steps back in, ask if the user wants to read the step again
    /*
    onResponse<Done>{
        goto(RateState)
    }
    */
}

fun CheckDone(recipeDesc:RecipeDesc): State = state {

    onEntry{
        furhat.ask("The last step is ${recipeDesc.steps.size}. Are you done with cooking?")
    }

    onResponse<Yes> {
        goto(CookingDone)
    }
}