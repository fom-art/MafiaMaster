@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package mafiamaster.shared.core.resources.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.StringResource

private object CommonMainString0 {
  public val about_description: StringResource by 
      lazy { init_about_description() }

  public val about_title: StringResource by 
      lazy { init_about_title() }

  public val app_name: StringResource by 
      lazy { init_app_name() }

  public val confirm_exit_message: StringResource by 
      lazy { init_confirm_exit_message() }

  public val confirm_exit_title: StringResource by 
      lazy { init_confirm_exit_title() }

  public val confirm_no: StringResource by 
      lazy { init_confirm_no() }

  public val confirm_yes: StringResource by 
      lazy { init_confirm_yes() }

  public val connection_lost: StringResource by 
      lazy { init_connection_lost() }

  public val error_generic: StringResource by 
      lazy { init_error_generic() }

  public val game_end: StringResource by 
      lazy { init_game_end() }

  public val game_pause: StringResource by 
      lazy { init_game_pause() }

  public val game_resume: StringResource by 
      lazy { init_game_resume() }

  public val game_start: StringResource by 
      lazy { init_game_start() }

  public val game_winner: StringResource by 
      lazy { init_game_winner() }

  public val loading: StringResource by 
      lazy { init_loading() }

  public val menu_about: StringResource by 
      lazy { init_menu_about() }

  public val menu_exit: StringResource by 
      lazy { init_menu_exit() }

  public val menu_go_back: StringResource by 
      lazy { init_menu_go_back() }

  public val menu_play: StringResource by 
      lazy { init_menu_play() }

  public val menu_rules: StringResource by 
      lazy { init_menu_rules() }

  public val menu_settings: StringResource by 
      lazy { init_menu_settings() }

  public val notification_day_phase: StringResource by 
      lazy { init_notification_day_phase() }

  public val notification_defeat: StringResource by 
      lazy { init_notification_defeat() }

  public val notification_eliminated: StringResource by 
      lazy { init_notification_eliminated() }

  public val notification_night_phase: StringResource by 
      lazy { init_notification_night_phase() }

  public val notification_victory: StringResource by 
      lazy { init_notification_victory() }

  public val role_assignment_title: StringResource by 
      lazy { init_role_assignment_title() }

  public val role_citizen: StringResource by 
      lazy { init_role_citizen() }

  public val role_commissar: StringResource by 
      lazy { init_role_commissar() }

  public val role_doctor: StringResource by 
      lazy { init_role_doctor() }

  public val role_don: StringResource by 
      lazy { init_role_don() }

  public val role_mafia: StringResource by 
      lazy { init_role_mafia() }

  public val role_maniac: StringResource by 
      lazy { init_role_maniac() }

  public val role_mistress: StringResource by 
      lazy { init_role_mistress() }

  public val role_player_number: StringResource by 
      lazy { init_role_player_number() }

  public val settings_language: StringResource by 
      lazy { init_settings_language() }

  public val settings_music: StringResource by 
      lazy { init_settings_music() }

  public val settings_save: StringResource by 
      lazy { init_settings_save() }

  public val settings_sound: StringResource by 
      lazy { init_settings_sound() }

  public val settings_title: StringResource by 
      lazy { init_settings_title() }

  public val settings_vibration: StringResource by 
      lazy { init_settings_vibration() }

  public val setup_title: StringResource by 
      lazy { init_setup_title() }
}

@InternalResourceApi
internal fun _collectCommonMainString0Resources(map: MutableMap<String, StringResource>) {
  map.put("about_description", CommonMainString0.about_description)
  map.put("about_title", CommonMainString0.about_title)
  map.put("app_name", CommonMainString0.app_name)
  map.put("confirm_exit_message", CommonMainString0.confirm_exit_message)
  map.put("confirm_exit_title", CommonMainString0.confirm_exit_title)
  map.put("confirm_no", CommonMainString0.confirm_no)
  map.put("confirm_yes", CommonMainString0.confirm_yes)
  map.put("connection_lost", CommonMainString0.connection_lost)
  map.put("error_generic", CommonMainString0.error_generic)
  map.put("game_end", CommonMainString0.game_end)
  map.put("game_pause", CommonMainString0.game_pause)
  map.put("game_resume", CommonMainString0.game_resume)
  map.put("game_start", CommonMainString0.game_start)
  map.put("game_winner", CommonMainString0.game_winner)
  map.put("loading", CommonMainString0.loading)
  map.put("menu_about", CommonMainString0.menu_about)
  map.put("menu_exit", CommonMainString0.menu_exit)
  map.put("menu_go_back", CommonMainString0.menu_go_back)
  map.put("menu_play", CommonMainString0.menu_play)
  map.put("menu_rules", CommonMainString0.menu_rules)
  map.put("menu_settings", CommonMainString0.menu_settings)
  map.put("notification_day_phase", CommonMainString0.notification_day_phase)
  map.put("notification_defeat", CommonMainString0.notification_defeat)
  map.put("notification_eliminated", CommonMainString0.notification_eliminated)
  map.put("notification_night_phase", CommonMainString0.notification_night_phase)
  map.put("notification_victory", CommonMainString0.notification_victory)
  map.put("role_assignment_title", CommonMainString0.role_assignment_title)
  map.put("role_citizen", CommonMainString0.role_citizen)
  map.put("role_commissar", CommonMainString0.role_commissar)
  map.put("role_doctor", CommonMainString0.role_doctor)
  map.put("role_don", CommonMainString0.role_don)
  map.put("role_mafia", CommonMainString0.role_mafia)
  map.put("role_maniac", CommonMainString0.role_maniac)
  map.put("role_mistress", CommonMainString0.role_mistress)
  map.put("role_player_number", CommonMainString0.role_player_number)
  map.put("settings_language", CommonMainString0.settings_language)
  map.put("settings_music", CommonMainString0.settings_music)
  map.put("settings_save", CommonMainString0.settings_save)
  map.put("settings_sound", CommonMainString0.settings_sound)
  map.put("settings_title", CommonMainString0.settings_title)
  map.put("settings_vibration", CommonMainString0.settings_vibration)
  map.put("setup_title", CommonMainString0.setup_title)
}

internal val Res.string.about_description: StringResource
  get() = CommonMainString0.about_description

private fun init_about_description(): StringResource =
    org.jetbrains.compose.resources.StringResource(
  "string:about_description", "about_description",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    10, 237),
    )
)

internal val Res.string.about_title: StringResource
  get() = CommonMainString0.about_title

private fun init_about_title(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:about_title", "about_title",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    248, 43),
    )
)

internal val Res.string.app_name: StringResource
  get() = CommonMainString0.app_name

private fun init_app_name(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:app_name", "app_name",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    292, 32),
    )
)

internal val Res.string.confirm_exit_message: StringResource
  get() = CommonMainString0.confirm_exit_message

private fun init_confirm_exit_message(): StringResource =
    org.jetbrains.compose.resources.StringResource(
  "string:confirm_exit_message", "confirm_exit_message",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    325, 68),
    )
)

internal val Res.string.confirm_exit_title: StringResource
  get() = CommonMainString0.confirm_exit_title

private fun init_confirm_exit_title(): StringResource =
    org.jetbrains.compose.resources.StringResource(
  "string:confirm_exit_title", "confirm_exit_title",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    394, 38),
    )
)

internal val Res.string.confirm_no: StringResource
  get() = CommonMainString0.confirm_no

private fun init_confirm_no(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:confirm_no", "confirm_no",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    433, 22),
    )
)

internal val Res.string.confirm_yes: StringResource
  get() = CommonMainString0.confirm_yes

private fun init_confirm_yes(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:confirm_yes", "confirm_yes",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    456, 23),
    )
)

internal val Res.string.connection_lost: StringResource
  get() = CommonMainString0.connection_lost

private fun init_connection_lost(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:connection_lost", "connection_lost",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    480, 83),
    )
)

internal val Res.string.error_generic: StringResource
  get() = CommonMainString0.error_generic

private fun init_error_generic(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:error_generic", "error_generic",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    564, 73),
    )
)

internal val Res.string.game_end: StringResource
  get() = CommonMainString0.game_end

private fun init_game_end(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:game_end", "game_end",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    638, 28),
    )
)

internal val Res.string.game_pause: StringResource
  get() = CommonMainString0.game_pause

private fun init_game_pause(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:game_pause", "game_pause",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    667, 26),
    )
)

internal val Res.string.game_resume: StringResource
  get() = CommonMainString0.game_resume

private fun init_game_resume(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:game_resume", "game_resume",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    694, 27),
    )
)

internal val Res.string.game_start: StringResource
  get() = CommonMainString0.game_start

private fun init_game_start(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:game_start", "game_start",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    722, 34),
    )
)

internal val Res.string.game_winner: StringResource
  get() = CommonMainString0.game_winner

private fun init_game_winner(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:game_winner", "game_winner",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    757, 39),
    )
)

internal val Res.string.loading: StringResource
  get() = CommonMainString0.loading

private fun init_loading(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:loading", "loading",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    797, 31),
    )
)

internal val Res.string.menu_about: StringResource
  get() = CommonMainString0.menu_about

private fun init_menu_about(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:menu_about", "menu_about",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    829, 26),
    )
)

internal val Res.string.menu_exit: StringResource
  get() = CommonMainString0.menu_exit

private fun init_menu_exit(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:menu_exit", "menu_exit",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    856, 25),
    )
)

internal val Res.string.menu_go_back: StringResource
  get() = CommonMainString0.menu_go_back

private fun init_menu_go_back(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:menu_go_back", "menu_go_back",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    882, 32),
    )
)

internal val Res.string.menu_play: StringResource
  get() = CommonMainString0.menu_play

private fun init_menu_play(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:menu_play", "menu_play",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    915, 25),
    )
)

internal val Res.string.menu_rules: StringResource
  get() = CommonMainString0.menu_rules

private fun init_menu_rules(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:menu_rules", "menu_rules",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    941, 26),
    )
)

internal val Res.string.menu_settings: StringResource
  get() = CommonMainString0.menu_settings

private fun init_menu_settings(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:menu_settings", "menu_settings",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    968, 33),
    )
)

internal val Res.string.notification_day_phase: StringResource
  get() = CommonMainString0.notification_day_phase

private fun init_notification_day_phase(): StringResource =
    org.jetbrains.compose.resources.StringResource(
  "string:notification_day_phase", "notification_day_phase",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1002, 42),
    )
)

internal val Res.string.notification_defeat: StringResource
  get() = CommonMainString0.notification_defeat

private fun init_notification_defeat(): StringResource =
    org.jetbrains.compose.resources.StringResource(
  "string:notification_defeat", "notification_defeat",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1045, 39),
    )
)

internal val Res.string.notification_eliminated: StringResource
  get() = CommonMainString0.notification_eliminated

private fun init_notification_eliminated(): StringResource =
    org.jetbrains.compose.resources.StringResource(
  "string:notification_eliminated", "notification_eliminated",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1085, 67),
    )
)

internal val Res.string.notification_night_phase: StringResource
  get() = CommonMainString0.notification_night_phase

private fun init_notification_night_phase(): StringResource =
    org.jetbrains.compose.resources.StringResource(
  "string:notification_night_phase", "notification_night_phase",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1153, 48),
    )
)

internal val Res.string.notification_victory: StringResource
  get() = CommonMainString0.notification_victory

private fun init_notification_victory(): StringResource =
    org.jetbrains.compose.resources.StringResource(
  "string:notification_victory", "notification_victory",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1202, 40),
    )
)

internal val Res.string.role_assignment_title: StringResource
  get() = CommonMainString0.role_assignment_title

private fun init_role_assignment_title(): StringResource =
    org.jetbrains.compose.resources.StringResource(
  "string:role_assignment_title", "role_assignment_title",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1243, 45),
    )
)

internal val Res.string.role_citizen: StringResource
  get() = CommonMainString0.role_citizen

private fun init_role_citizen(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:role_citizen", "role_citizen",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1289, 32),
    )
)

internal val Res.string.role_commissar: StringResource
  get() = CommonMainString0.role_commissar

private fun init_role_commissar(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:role_commissar", "role_commissar",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1322, 34),
    )
)

internal val Res.string.role_doctor: StringResource
  get() = CommonMainString0.role_doctor

private fun init_role_doctor(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:role_doctor", "role_doctor",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1357, 27),
    )
)

internal val Res.string.role_don: StringResource
  get() = CommonMainString0.role_don

private fun init_role_don(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:role_don", "role_don",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1385, 20),
    )
)

internal val Res.string.role_mafia: StringResource
  get() = CommonMainString0.role_mafia

private fun init_role_mafia(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:role_mafia", "role_mafia",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1406, 26),
    )
)

internal val Res.string.role_maniac: StringResource
  get() = CommonMainString0.role_maniac

private fun init_role_maniac(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:role_maniac", "role_maniac",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1433, 27),
    )
)

internal val Res.string.role_mistress: StringResource
  get() = CommonMainString0.role_mistress

private fun init_role_mistress(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:role_mistress", "role_mistress",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1461, 33),
    )
)

internal val Res.string.role_player_number: StringResource
  get() = CommonMainString0.role_player_number

private fun init_role_player_number(): StringResource =
    org.jetbrains.compose.resources.StringResource(
  "string:role_player_number", "role_player_number",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1495, 38),
    )
)

internal val Res.string.settings_language: StringResource
  get() = CommonMainString0.settings_language

private fun init_settings_language(): StringResource =
    org.jetbrains.compose.resources.StringResource(
  "string:settings_language", "settings_language",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1534, 37),
    )
)

internal val Res.string.settings_music: StringResource
  get() = CommonMainString0.settings_music

private fun init_settings_music(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:settings_music", "settings_music",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1572, 30),
    )
)

internal val Res.string.settings_save: StringResource
  get() = CommonMainString0.settings_save

private fun init_settings_save(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:settings_save", "settings_save",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1603, 41),
    )
)

internal val Res.string.settings_sound: StringResource
  get() = CommonMainString0.settings_sound

private fun init_settings_sound(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:settings_sound", "settings_sound",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1645, 42),
    )
)

internal val Res.string.settings_title: StringResource
  get() = CommonMainString0.settings_title

private fun init_settings_title(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:settings_title", "settings_title",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1688, 34),
    )
)

internal val Res.string.settings_vibration: StringResource
  get() = CommonMainString0.settings_vibration

private fun init_settings_vibration(): StringResource =
    org.jetbrains.compose.resources.StringResource(
  "string:settings_vibration", "settings_vibration",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1723, 38),
    )
)

internal val Res.string.setup_title: StringResource
  get() = CommonMainString0.setup_title

private fun init_setup_title(): StringResource = org.jetbrains.compose.resources.StringResource(
  "string:setup_title", "setup_title",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/mafiamaster.shared.core.resources.generated.resources/values/string.commonMain.cvr",
    1762, 27),
    )
)
