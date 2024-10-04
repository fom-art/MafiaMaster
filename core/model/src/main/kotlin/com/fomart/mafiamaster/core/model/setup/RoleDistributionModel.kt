package com.fomart.mafiamaster.core.model.setup

import com.fomart.mafiamaster.core.resources.R

data class RoleDistributionModel(
    val totalPlayers: Int = 6,
    val mafiaCount: Int = totalPlayers / 3,
    val hasDon: Boolean = false,
    val hasMistress: Boolean = false,
    val hasDoctor: Boolean = false,
    val hasManiac: Boolean = false,
    val hasCommissar: Boolean = false,
) {
    fun toRoleItems(
        onMistressClicked: () -> Unit,
        onDoctorClicked: () -> Unit,
        onManiacClicked: () -> Unit,
        onCommissarClicked: () -> Unit,
    ): List<RoleItem> {
        return listOf(
            RoleItem(
                title = R.string.role_mafia,
                icon = R.drawable.ic_mafia,
                count = this.mafiaCount,
                isSelected = true,
            ),
            RoleItem(
                title = R.string.role_don,
                icon = R.drawable.ic_don,
                isSelected = this.hasDon,
            ),
            RoleItem(
                title = R.string.role_mistress,
                icon = R.drawable.ic_mistress,
                isSelected = hasMistress,
                onClick = onMistressClicked,
            ),
            RoleItem(
                title = R.string.role_doctor,
                icon = R.drawable.ic_doctor,
                isSelected = hasDoctor,
                onClick = onDoctorClicked,
            ),
            RoleItem(
                title = R.string.role_maniac,
                icon = R.drawable.ic_maniac,
                isSelected = hasManiac,
                onClick = onManiacClicked,

                ),
            RoleItem(
                title = R.string.role_commissar,
                icon = R.drawable.ic_sheriff,
                isSelected = hasCommissar,
                onClick = onCommissarClicked,
            ),
        )
    }
}