package com.fomart.mafiamaster.core.model

import com.fomart.mafiamaster.core.utils.UiText
import mafiamaster.shared.core.model.generated.resources.Res
import mafiamaster.shared.core.model.generated.resources.ic_civillian
import mafiamaster.shared.core.model.generated.resources.ic_commissar
import mafiamaster.shared.core.model.generated.resources.ic_doctor
import mafiamaster.shared.core.model.generated.resources.ic_don
import mafiamaster.shared.core.model.generated.resources.ic_mafia
import mafiamaster.shared.core.model.generated.resources.ic_maniac
import mafiamaster.shared.core.model.generated.resources.ic_mistress
import mafiamaster.shared.core.model.generated.resources.role_citizen
import mafiamaster.shared.core.model.generated.resources.role_commissar
import mafiamaster.shared.core.model.generated.resources.role_doctor
import mafiamaster.shared.core.model.generated.resources.role_don
import mafiamaster.shared.core.model.generated.resources.role_mafia
import mafiamaster.shared.core.model.generated.resources.role_maniac
import mafiamaster.shared.core.model.generated.resources.role_mistress
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

//sealed class Role {
//    object Civilian: Role()
//    data object Mafia(val ): Role()
//    object Don: Role()
//    object Civilian: Role()
//    object Civilian: Role()
//    object Civilian: Role()
//    object Civilian: Role()
//    object Civilian: Role()
//    MAFIA,
//    DON,
//    MISTRESS,
//    DOCTOR,
//    COMMISSAR,
//    MANIAC;
//
//
//
//
//}
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

    fun getNameFromRole(): UiText {
        return when (this) {
            is Don -> UiText.StringResourceId(Res.string.role_don)
            is Mistress -> UiText.StringResourceId(Res.string.role_mistress)
            is Doctor -> UiText.StringResourceId(Res.string.role_doctor)
            is Commissar -> UiText.StringResourceId(Res.string.role_commissar)
            is Maniac -> UiText.StringResourceId(Res.string.role_maniac)
            is Mafia -> UiText.StringResourceId(Res.string.role_mafia)
            is Civilian -> UiText.StringResourceId(Res.string.role_citizen)
        }
    }

    fun getImageFromRole(): DrawableResource {
        return when (this) {
            is Don -> Res.drawable.ic_don
            is Mistress -> Res.drawable.ic_mistress
            is Doctor -> Res.drawable.ic_doctor
            is Commissar -> Res.drawable.ic_commissar
            is Maniac -> Res.drawable.ic_maniac
            is Mafia ->Res.drawable.ic_mafia
            is Civilian -> Res.drawable.ic_civillian
        }
    }
}
