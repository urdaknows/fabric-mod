package com.github.urdaknows.module.movement;

import com.github.urdaknows.module.Category;

import net.minecraft.client.MinecraftClient;

public class AutoSprint extends com.github.urdaknows.module.ModuleClient {

	public AutoSprint() {
		super("AutoSprint", Category.MOVEMENT);
	}

	public void onUpdate(MinecraftClient client) {
		if (this.isEnabled()) {
			client.player.setSprinting(true);
		}
	}
	
}
