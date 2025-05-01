package com.fomart.mafiamaster.core.resources.model.extensions

import com.fomart.mafiamaster.core.model.GameSetup
import com.fomart.mafiamaster.core.resources.model.RoleItem
import com.fomart.mafiamaster.core.utils.UiText
import mafiamaster.shared.core.designsystem.generated.resources.Res
import mafiamaster.shared.core.designsystem.generated.resources.ic_commissar
import mafiamaster.shared.core.designsystem.generated.resources.ic_doctor
import mafiamaster.shared.core.designsystem.generated.resources.ic_don
import mafiamaster.shared.core.designsystem.generated.resources.ic_mafia
import mafiamaster.shared.core.designsystem.generated.resources.ic_maniac
import mafiamaster.shared.core.designsystem.generated.resources.ic_mistress
import mafiamaster.shared.core.designsystem.generated.resources.role_commissar
import mafiamaster.shared.core.designsystem.generated.resources.role_doctor
import mafiamaster.shared.core.designsystem.generated.resources.role_don
import mafiamaster.shared.core.designsystem.generated.resources.role_mafia
import mafiamaster.shared.core.designsystem.generated.resources.role_maniac
import mafiamaster.shared.core.designsystem.generated.resources.role_mistress

fun GameSetup.toRoleItems(
    onMistressClicked: () -> Unit,
    onDoctorClicked: () -> Unit,
    onManiacClicked: () -> Unit,
    onCommissarClicked: () -> Unit,
): List<RoleItem> {
    return listOf(
        RoleItem(
            title = UiText.StringResourceId(Res.string.role_mafia),
            icon = Res.drawable.ic_mafia,
            count = this.mafiaCount,
            isSelected = true,
        ),
        RoleItem(
            title = UiText.StringResourceId(Res.string.role_don),
            icon = Res.drawable.ic_don,
            isSelected = this.hasDon,
        ),
        RoleItem(
            title = UiText.StringResourceId(Res.string.role_mistress),
            icon = Res.drawable.ic_mistress,
            isSelected = hasMistress,
            onClick = onMistressClicked,
        ),
        RoleItem(
            title = UiText.StringResourceId(Res.string.role_doctor),
            icon = Res.drawable.ic_doctor,
            isSelected = hasDoctor,
            onClick = onDoctorClicked,
        ),
        RoleItem(
            title = UiText.StringResourceId(Res.string.role_maniac),
            icon = Res.drawable.ic_maniac,
            isSelected = hasManiac,
            onClick = onManiacClicked,
        ),
        RoleItem(
            title = UiText.StringResourceId(Res.string.role_commissar),
            icon = Res.drawable.ic_commissar,
            isSelected = hasCommissar,
            onClick = onCommissarClicked,
        ),
    )
}