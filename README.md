# BendingOnly Plugin

## Overview
**BendingOnly** is a custom Minecraft Bukkit/Spigot plugin developed to enhance in-game mechanics by preventing or allowing certain actions with ProjectKorras system. The plugin provides configurable gameplay options, such as managing allowed and denied blocks, enabling or disabling certain events, and offering features for administrators to customize the bending experience.

## Features
- Customizable configuration for bending mechanics (e.g., blocking certain in-game actions).
- Easy-to-use commands for managing the plugin in-game.
- Reload support to update the configuration without restarting the server.

## Requirements
- **Minecraft Server**: Bukkit or Spigot
- **Java 8 or higher**
- **Bukkit/Spigot API**: Version compatible with the Minecraft server

## Installation
1. Download the plugin's latest `.jar` file from the releases.
2. Place the `.jar` file into your server's `/plugins/` folder.
3. Start the Minecraft server. The plugin will generate a default `config.yml` file.
4. Customize the `config.yml` file to fit your server's needs.

## Commands
- `/boreload` - Reloads the plugin configuration.

## Configuration
The configuration file (`config.yml`) allows server admins to control various aspects of the plugin:
- **deniedBlocks**: A list of blocks where bending abilities are restricted.
- **allowedWorlds**: A list of worlds where bending is allowed or restricted.

## Contributing
Feel free to fork this project and submit pull requests if you would like to contribute! Please ensure that your changes are thoroughly tested before submitting.

