# GUILib

**GUILib** is a custom Minecraft plugin designed to provide a versatile and efficient GUI library for use in my personal Minecraft projects. While primarily developed for my own needs, it is possible for others to use or adapt this library for their own projects.

## Features

- **Paginated Chest GUI**: Easily create multi-page inventories with automatic pagination controls.
- **Dynamic Item Handling**: Add items to your GUI with associated click actions, seamlessly handling dynamic content.
- **Customizable Button Actions**: Define custom behaviors for inventory interactions, including pagination controls and item-specific actions.
- **Player-Specific GUIs**: Open GUIs targeted to specific players, maintaining context and control across multiple pages.

## Usage

This library is designed for personal use, but feel free to explore and adapt it for your own projects. Contributions and issues are not the primary focus, but suggestions are welcome.

## Installation

To use GUILib in your project:

1. Clone the repository.
2. Include the library in your Minecraft plugin's build path.
3. Follow the provided examples to implement custom GUIs in your plugin.

## Example

```java
PaginatedChestGUI gui = new PaginatedChestGUI("My Custom GUI", 54, 5);

ItemStack item = new ItemStack(Material.DIAMOND);
gui.addItem(item, () -> {
    // Define what happens when the item is clicked
});

gui.open(player);
```

## License

This project is licensed under the MIT License. Feel free to modify and use it as you wish.
