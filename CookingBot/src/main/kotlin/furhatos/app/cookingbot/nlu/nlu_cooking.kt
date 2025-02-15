/**
 * This file contains cooking procedure level intents.
 */
package furhatos.app.cookingbot.nlu

import furhatos.app.cookingbot.knowledgebase.Step
import furhatos.nlu.ComplexEnumEntity
import furhatos.nlu.Intent
import furhatos.nlu.common.Number
import furhatos.util.Language

class PreviousStep() : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("previous step", "previous", "back", "backwards")
    }
}

class NextStep() : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("next step", "next", "forward")
    }
}

class OtherStep(
        var count : Number? = Number(1),
        var step : Step? = null) : ComplexEnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("step @count", "@count")
    }

}


class RequestFinished: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("I want to go",
                "finish", "finish it", "bye",
                "thank you", "Ok")
    }
}