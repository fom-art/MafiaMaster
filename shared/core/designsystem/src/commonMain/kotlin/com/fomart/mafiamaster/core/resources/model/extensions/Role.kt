package com.fomart.mafiamaster.core.resources.model.extensions

import com.fomart.mafiamaster.core.model.Role
import com.fomart.mafiamaster.core.model.Role.Civilian
import com.fomart.mafiamaster.core.model.Role.Commissar
import com.fomart.mafiamaster.core.model.Role.Doctor
import com.fomart.mafiamaster.core.model.Role.Don
import com.fomart.mafiamaster.core.model.Role.Mafia
import com.fomart.mafiamaster.core.model.Role.Maniac
import com.fomart.mafiamaster.core.model.Role.Mistress
import com.fomart.mafiamaster.core.utils.UiText
import mafiamaster.shared.core.designsystem.generated.resources.Res
import mafiamaster.shared.core.designsystem.generated.resources.ic_civillian
import mafiamaster.shared.core.designsystem.generated.resources.ic_commissar
import mafiamaster.shared.core.designsystem.generated.resources.ic_doctor
import mafiamaster.shared.core.designsystem.generated.resources.ic_don
import mafiamaster.shared.core.designsystem.generated.resources.ic_mafia
import mafiamaster.shared.core.designsystem.generated.resources.ic_maniac
import mafiamaster.shared.core.designsystem.generated.resources.ic_mistress
import mafiamaster.shared.core.designsystem.generated.resources.role_citizen
import mafiamaster.shared.core.designsystem.generated.resources.role_commissar
import mafiamaster.shared.core.designsystem.generated.resources.role_doctor
import mafiamaster.shared.core.designsystem.generated.resources.role_don
import mafiamaster.shared.core.designsystem.generated.resources.role_mafia
import mafiamaster.shared.core.designsystem.generated.resources.role_maniac
import mafiamaster.shared.core.designsystem.generated.resources.role_mistress

import org.jetbrains.compose.resources.DrawableResource

fun Role.getName(): UiText {
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

fun Role.getImage(): DrawableResource {
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