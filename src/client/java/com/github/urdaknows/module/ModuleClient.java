package com.github.urdaknows.module;

import net.minecraft.client.MinecraftClient;

public abstract class ModuleClient {

	public MinecraftClient mc = MinecraftClient.getInstance();

	private String name;
	private Category category;
	private boolean enabled;

	public ModuleClient(String name, Category category) {
		this.name = name;
		this.category = category;
		this.enabled = false;
	}

	public void onUpdate(MinecraftClient client) {
	}

	public String getName() {
		return name;
	}
	
	public Category getCategory() {
		return category;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void toggle() {
		enabled = !enabled;
	}

}
