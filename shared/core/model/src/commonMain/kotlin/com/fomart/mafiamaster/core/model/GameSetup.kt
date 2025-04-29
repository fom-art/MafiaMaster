package com.fomart.mafiamaster.core.model

import com.fomart.mafiamaster.core.model.setup.RoleItem
import com.fomart.mafiamaster.core.utils.UiText
import mafiamaster.shared.core.model.generated.resources.Res
import mafiamaster.shared.core.model.generated.resources.ic_commissar
import mafiamaster.shared.core.model.generated.resources.ic_doctor
import mafiamaster.shared.core.model.generated.resources.ic_don
import mafiamaster.shared.core.model.generated.resources.ic_mafia
import mafiamaster.shared.core.model.generated.resources.ic_maniac
import mafiamaster.shared.core.model.generated.resources.ic_mistress
import mafiamaster.shared.core.model.generated.resources.role_commissar
import mafiamaster.shared.core.model.generated.resources.role_doctor
import mafiamaster.shared.core.model.generated.resources.role_don
import mafiamaster.shared.core.model.generated.resources.role_mafia
import mafiamaster.shared.core.model.generated.resources.role_maniac
import mafiamaster.shared.core.model.generated.resources.role_mistress


data class GameSetup(
    val totalPlayers: Int = 0,
    val hasDon: Boolean = false,
    val mafiaCount: Int = 0,
    val hasMistress: Boolean = false,
    val hasDoctor: Boolean = false,
    val hasManiac: Boolean = false,
    val hasCommissar: Boolean = false
) {
    fun toRoleItems(
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
}