package com.fomart.mafiamaster.core.model

import com.fomart.mafiamaster.core.utils.UiText
import mafiamaster.shared.core.model.generated.resources.Res
import mafiamaster.shared.core.model.generated.resources.role_citizen
import mafiamaster.shared.core.model.generated.resources.role_commissar
import mafiamaster.shared.core.model.generated.resources.role_doctor
import mafiamaster.shared.core.model.generated.resources.role_don
import mafiamaster.shared.core.model.generated.resources.role_mafia
import mafiamaster.shared.core.model.generated.resources.role_maniac
import mafiamaster.shared.core.model.generated.resources.role_mistress
import org.jetbrains.compose.resources.DrawableResource

sealed class Role {
    open class Civilian : Role()
    abstract class ActiveCivilian : Civilian() {
        open fun makeAction() {}
    }
    open class Mafia : Role()
    class Commissar() : ActiveCivilian() {
        override fun makeAction() {
            TODO("Not yet implemented")
        }
    }
    class Doctor() : ActiveCivilian() {
        override fun makeAction() {
            TODO("Not yet implemented")
        }
    }
    class Maniac() : ActiveCivilian() {
        override fun makeAction() {
            TODO("Not yet implemented")
        }
    }
    class Don() : Mafia()
    class Mistress() : Mafia()
}
