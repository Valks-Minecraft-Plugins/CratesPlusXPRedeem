# CratesPlusXPRedeem

## About
Plugin Request from anonymous.

Configurable crate xp key plugin using the source from [CratesPlus](https://www.spigotmc.org/resources/cratesplus-free-crates-plugin-1-7-1-14-2.5018/) plugin. Convert XP levels into crate keys! If the crate key you specify is non existant, this plugin will detect that!

### Commands
```yml
/cratesplusredeem <amount>
/cpr <amount>
```

### Config
```yml
keys:
  crate_type: mysterybox
  required_xp_levels: 65
  show_crate_key_message: true
```

## Compiling
1. Clone the repository directly into your IDE.
2. Build Spigot with [Spigot's Build Tools](https://www.spigotmc.org/wiki/buildtools/) then add the JAR to the projects build path.
3. Fix any outdated code in the project depending on what version of Spigot you installed.
4. Compile the plugin by exporting it to a JAR file.
