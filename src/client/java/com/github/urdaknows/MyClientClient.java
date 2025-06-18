package com.github.urdaknows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.glfw.GLFW;

import com.github.urdaknows.gui.GuiIngameHook;
import com.github.urdaknows.module.ModuleClient;
import com.github.urdaknows.module.movement.AutoSprint;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.option.KeyBinding;

public class MyClientClient implements ClientModInitializer {
	
    private static final List<ModuleClient> moduleClients = new ArrayList<>();
    private static final Map<String, KeyBinding> keyBindings = new HashMap<>();

	@Override
	public void onInitializeClient() {

		moduleClients.add(new AutoSprint());
		registerModuleKey(new AutoSprint(), GLFW.GLFW_KEY_F);
		
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			
			for (ModuleClient moduleClient : moduleClients) {
                KeyBinding key = keyBindings.get(moduleClient.getName());
                while (key != null && key.wasPressed()) {
                    moduleClient.toggle();
                }

                moduleClient.onUpdate(client);
			}
			
		});
		
        HudRenderCallback.EVENT.register(new GuiIngameHook(moduleClients));
	}
	
    private void registerModuleKey(ModuleClient moduleClient, int keyCode) {
        KeyBinding key = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key." + moduleClient.getName().toLowerCase() + ".",
            keyCode,
            "category." + moduleClient.getCategory().name().toLowerCase()
        ));
        keyBindings.put(moduleClient.getName(), key);
    }
}